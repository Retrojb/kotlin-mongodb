package com.lmshub.lifestyle.data_classes

data class Person(var userName: String,
                  var firstName: String,
                  var age: Int,
                  var email: String,
                  var relationStatus: Boolean?) {

    companion object {
        private val personInfo = arrayOf(
                Person::userName,
                Person::firstName,
                Person::age,
                Person::email,
                Person::relationStatus)
        }

    override fun toString(): String = "$userName, $firstName, $age, $email, $relationStatus"
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


