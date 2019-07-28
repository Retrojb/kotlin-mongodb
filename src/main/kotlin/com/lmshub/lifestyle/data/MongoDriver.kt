package com.lmshub.lifestyle.data

import com.mongodb.MongoClient
import org.bson.Document
import org.bson.types.ObjectId

const val defaultDb = "lms-users-dev"

class MongoDriver(mongoClient: MongoClient, db: String) {

    val db = mongoClient.getDatabase(defaultDb)

    fun allFromCollection(collection: String): ArrayList<Map<String, Any>> {
        val mongoResult = db.getCollection(collection, Document::class.java)
        val result = ArrayList<Map<String, Any>>()

        mongoResult.find()
                .forEach{
                    val collectionToMap: Map<String, Any> = dbDocToMap(it)
                    result.add(collectionToMap)
                }
        return result
    }

    //Transform the doc to a map and changes all of the ids to strings if they're of class ObjectId
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