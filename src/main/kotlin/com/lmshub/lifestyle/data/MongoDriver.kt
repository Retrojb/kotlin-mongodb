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
    
    fun allFromCollection(col: String): ArrayList<Map<String, Any>> {
        val mongoRes = db.getCollection(col, Document::class.java)
        val res = ArrayList<Map<String, Any>>()

        mongoRes.find()
                .forEach{
                    val collectionToMap: Map<String, Any> = dbDocToMap(it)
                    res.add(collectionToMap)
                }
        return res
    }

    //Transform the doc to a map and changes all of the ids to strings if they're of class ObjectId
    fun dbDocToMap(doc: Document): Map<String, Any> {
        val collectionToMap: MutableMap<String, Any> = doc.toMutableMap()

        if (collectionToMap.containsKey("_id")) {
            val id = collectionToMap.getValue("_id")
            if (id is ObjectId) {
                collectionToMap.set("_id", id.toHexString())
            }
        }
        return collectionToMap
    }

    fun getDocumentById(col: String, id: String?): Map<String, Any>? {
        if (!ObjectId.isValid(id)) {
            return null
        }
        val document = db.getCollection(col)
                .find(Document("_id", ObjectId(id)))
        if (document?.first() != null) {
            return dbDocToMap(document.first())
        }
        return null
    }


    fun addNewDocument(col: String, doc: String): String? {
        try {
            val bsonDoc = BsonDocument.parse(doc)
            bsonDoc.remove("_id")
            val oid = ObjectId()
            bsonDoc.put("_id", BsonObjectId(oid))
            db.getCollection(col, BsonDocument::class.java).insertOne(bsonDoc)
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

    fun deleteRemoveCollection(collection: String, id: String?): Pair<Int, String> {
        if (!ObjectId.isValid(id)) {
            return Pair(0, "Yo that ID ain't real!")
        }
        val filter = BsonDocument("_id", BsonObjectId(ObjectId(id)))
        val uv = db.getCollection(collection)
                .deleteOne(filter)
                .deletedCount
        if(uv < 1) {
            return Pair(0, "Dude where's my ID")
        } else {
            return Pair(1, "FERDA")
        }
    }


//    fun readCollection() {
//        if (!ObjectId.isValid(id)) {
//            return Pair(0, "Yo that ID ain't real!")
//        }
//    }


}