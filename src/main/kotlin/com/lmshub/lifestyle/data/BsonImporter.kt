package com.lmshub.lifestyle.data

import java.nio.file.Path

object BsonImporter {

    fun resourcePathToString(resourcePath: Path) {
        val jsonPath = BsonImporter::class.java.getResource("") //

    }
}

//fun resourceToString(resourcePath : String) : String  {
//    val jsonPath = BsonImporter::class.java.getResource(resourcePath)
//    return fileToString(Paths.get(jsonPath.toURI()));
//}
//
//fun pathToJson(path : String) : BsonDocument {
//    val jsonAsText = fileToString(Paths.get(path))
//    return BsonDocument.parse(jsonAsText)
//}