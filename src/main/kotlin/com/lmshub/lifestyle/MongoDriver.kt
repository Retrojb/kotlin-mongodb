package com.lmshub.lifestyle

import com.mongodb.MongoClient

val mongoClient = MongoClient()
val db = mongoClient.getDatabase("lms-users")
val collection = db.getCollection("person")
