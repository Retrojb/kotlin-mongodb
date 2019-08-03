package com.lmshub.lifestyle.data

import com.mongodb.MongoClient
import org.bson.BsonDocument
import org.bson.BsonObjectId
import org.bson.Document
import org.bson.json.JsonParseException
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

    fun getDocumentById(collection: String, id: String?): Map<String, Any>? {
        if (!ObjectId.isValid(id)) {
            return null
        }
        val document = db.getCollection(collection)
                .find(Document("_id", ObjectId(id)))
        if (document != null && document.first() != null) {
            return dbDocToMap(document.first())
        }
        return null
    }

    //refactor build oid function as util
    fun addNewDocument(collection: String, document: String): String? {
        try {
            val bsonDocument = BsonDocument.parse(document)
            bsonDocument.remove("_id")
            val oid = ObjectId()
            bsonDocument.put("_id", BsonObjectId(oid))
            db.getCollection(collection, BsonDocument::class.java).insertOne(bsonDocument)
            return oid.toHexString()
        } catch(ex: JsonParseException) {
            return "This is not the JSON we were looking for ${ex.localizedMessage}"
        }
    }


    fun updateDocument( collection: String, id: String?, document: String): Pair<Int, String> {
        try {
            if (!ObjectId.isValid(id)) {
                return Pair(0, "Yo that ID ain't real!")
            }
            val bsonDocument = BsonDocument.parse(document)
            bsonDocument.remove("_id")
            val filter = BsonDocument("_id", BsonObjectId(ObjectId(id)))
            val updatedValues = db.getCollection(collection, BsonDocument::class.java)
                    .replaceOne(filter, bsonDocument)
                    .modifiedCount
            if(updatedValues > 1 ) {
                return Pair(0, "Dude where's my ID")
            } else {
                return Pair(1, "FERDA!!!")
            }
        } catch (ex: JsonParseException){
            return Pair(-1, "th JSON: ${ex.localizedMessage}")
        }
    }

    fun deleteCollection() {

    }
    fun readCollection() {

    }


}