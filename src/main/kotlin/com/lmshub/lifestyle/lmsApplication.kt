package com.lmshub.lifestyle

import com.fasterxml.jackson.databind.SerializationFeature
import com.mongodb.MongoClient
import com.lmshub.lifestyle.data.MongoDriver
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
import org.bson.types.ObjectId

import java.lang.Compiler.enable

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)

const val host = "127.0.0.1"
const val port = 27017
val mongoClient = MongoClient(host, port)

private val mongoDataService = MongoDriver (
        mongoClient, "lms-users-db"
    )

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}
