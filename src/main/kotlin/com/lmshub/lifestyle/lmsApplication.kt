package com.lmshub.lifestyle

import com.fasterxml.jackson.databind.SerializationFeature
import com.mongodb.MongoClient
import com.lmshub.lifestyle.data.MongoDriver
import com.mongodb.MongoClientOptions
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import io.ktor.features.ContentNegotiation
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.jackson.jackson
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)
//Local Environment
const val host = "127.0.0.1"
const val port = 27017
val mongoClientLocal = MongoClient(host, port)
const val defaultDb = "lms-users-playground"
const val devDb: String = "lms-dev-db"

//Dev Environment
const val devHost = " "
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

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    //add this routing for static files later
    routing {
        static("tbd") {
            resources("tbd")
        }
        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
        }
        route("/Users/johnbaltes/Desktop/mongodb") {
            get {
                call.respond(
                        mongoDataService.allFromCollection("col")
                )
            }
        }
        //insert routes later
        route(""){
            get{
                call.respond(
                        mongoDevDataService.allFromCollection("")
                )
            }
        }

    }
}
class AuthenticationException : RuntimeException()