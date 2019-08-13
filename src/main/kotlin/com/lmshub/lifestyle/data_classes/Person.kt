package com.lmshub.lifestyle.data_classes

data class Person(var userName: String,
                  var email: String,
                  var firstName: String,
                  var lastName: String,
                  var age: Int,
                  var relationStatus: Boolean?) {

    companion object {
        private val personInfo = arrayOf(
                Person::userName,
                Person::firstName,
                Person::age,
                Person::email,
                Person::relationStatus)
        }

    override fun toString(): String = "User name: $userName, Email: $email, $firstName, $lastName, $age, $relationStatus"
}


data class Project(val projectName: String,
                   val projectType: String,
                   val teamName: String,
                   val members: List<Person>) {
    companion object {
        val teamMembers = arrayListOf<Person>()
    }

    override fun toString(): String = "$teamMembers"
}


