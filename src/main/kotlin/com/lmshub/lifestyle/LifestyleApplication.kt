package com.lmshub.lifestyle

import com.lmshub.lifestyle.data.returnDbResources
import com.lmshub.lifestyle.data.returnTheOtherThings
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LifestyleApplication

fun main(args: Array<String>) {
	runApplication<LifestyleApplication>(*args)
	returnDbResources()
	returnTheOtherThings()
}
