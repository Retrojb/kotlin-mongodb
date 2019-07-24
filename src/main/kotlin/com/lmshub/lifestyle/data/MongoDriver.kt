package com.lmshub.lifestyle.data

import com.lmshub.lifestyle.data_classes.Person
import com.mongodb.MongoClient
import org.bson.BsonDocument
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import java.rmi.server.ObjID

const val host = "127.0.0.1"
const val port = 27017
const val defaultDb = "lms-users"

class MongoDriver {
    val mongoClient = MongoClient(host, port)
    val db = mongoClient.getDatabase(defaultDb)
    val personCollection = db.getCollection("person").toString()
    val personOne =  "{userName: 'Retrojb', firstName: 'John', age: 30, email: 'email@email.com', relationshipstatus: false}"
    val name = "name"
//    val keysVals

    fun allFromCollection(collection: String): ArrayList<Map<String, Any>> {
        val mongoResult = db.getCollection(collection, Document::class.java)
        println("test response $mongoResult")
        val result = ArrayList<Map<String, Any>>()
        mongoResult.find()
                .forEach{
                    val collectionToMap: Map<String, Any> = dbDocToMap(it)
                    result.add(collectionToMap)
                }
        return result
    }

    fun dbDocToMap(document: Document): Map<String, Any> {
        val collectionToMap: MutableMap<String, Any> = document.toMutableMap()
        if (collectionToMap.containsKey("_id")) {
            val id = collectionToMap.getValue("_id")
            if (id is ObjectId) {
                collectionToMap.set("_id", id.toHexString())
            }
        }
        return collectionToMap
    }


}