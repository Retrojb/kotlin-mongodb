package com.lmshub.lifestyle

import com.fasterxml.jackson.databind.SerializationFeature
import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.lmshub.lifestyle.data.MongoDriver
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.jackson.jackson
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import org.bson.types.ObjectId

//Local Environment
const val host = "127.0.0.1"
const val port = 27017
val mongoClientLocal = MongoClient(host, port)
const val defaultDb = "lms-users-playground"
const val devDb: String = "lms-dev-db"

//Dev Environment
const val devHost = ""
const val devPort = 27029
const val devUser = "lmsdbadm"
val devUserPass = "lmsadmpass".toCharArray()

private val mongoDataService = MongoDriver (
        mongoClientLocal, defaultDb
)

private val mongoDevDataService = MongoDriver (
        MongoClient (
            ServerAddress(devHost, devPort),
            MongoCredential.createCredential(devUser, devDb, devUserPass),
            MongoClientOptions.builder().build()
            ),
        "lms-dev-db"
        )

fun main(args: Array<String>) =
        io.ktor.server.netty.EngineMain.main(args)
@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    install(ConditionalHeaders)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(DataConversion)

    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
// added testing: Boolean to false in the Application Mod args
//    if (!testing) {
//        install(HttpsRedirect) {
//            // The port to redirect to. By default 443, the default HTTPS port.
//            sslPort = 443
//            // 301 Moved Permanently, or 302 Found redirect.
//            permanentRedirect = true
//        }
//    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

//    val client = HttpClient(Jetty) {
//    }
    //add this routing for static files later
    routing {
        static("/static") {
            resources("static")
        }
        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
        }
        route("/data/db") {
            get {
                call.respond(
                        mongoDataService.allFromCollection("col")
                )
            }
        }
//        insert routes later
        route(""){
            get{
                call.respond(
                        mongoDevDataService.allFromCollection("")
                )
            }
        }
        post {
            val documentAsString = call.receiveText()
            val oidOrErrorMessage =
                    mongoDataService.addToCollection("col", documentAsString)
            if (ObjectId.isValid(oidOrErrorMessage)) {
                call.respond(HttpStatusCode.Created, "201 - CREATED")
            } else {
                call.respond(HttpStatusCode.BadRequest, "400 - BAD REQUEST")
            }
        }

    }
}
class AuthenticationException : RuntimeException()