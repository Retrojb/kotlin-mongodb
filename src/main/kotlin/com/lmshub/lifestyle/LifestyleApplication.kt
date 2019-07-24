package com.lmshub.lifestyle

import com.lmshub.lifestyle.data.MongoDriver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LifestyleApplication

fun main(args: Array<String>) {
	runApplication<LifestyleApplication>(*args)

	val mongoDriver = MongoDriver()


}
