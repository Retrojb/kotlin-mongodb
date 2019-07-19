package com.lmshub.lifestyle.data

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection

val host = "127.0.0.1"
val port = 27017
val defaultDb = "lms-users"


val mongoClient = MongoClient(host, port)
val db = mongoClient.getDatabase(defaultDb)
val collection = db.getCollection("person")

fun returnDbResources() {
    val collectionReturn = db.getCollection(defaultDb)
    return println("The Default Db collections: $collectionReturn")

}

fun returnTheOtherThings() {
    val theThingToReturn = mongoClient.listDatabaseNames()
    println("The Database names are $theThingToReturn")
    mongoClient.close()
}