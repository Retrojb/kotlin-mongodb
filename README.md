# kotlin-mongodb
Testing mongoDb with Kotlin

Key issues faced: 
application.conf causing `Main class` issues while trying to run it in IntelliJ
Make sure that you check that when you build and run any Kotlin project in IntelliJ that all of the enivormental variables
upon build Kotlin will generate a directory called `out` inside of out follow the route to the `out/prod/class/com.project.demo/<ApplicationKt.class>`
exists, also check in the resource folder in teh `out` directory that there is a file called `application.conf`


Basic `application.conf`

```
ktor {
  deployment {
    port = 8080
    port = ${?PORT}
  }
  application {
    modules = [ ]
  }
}
```

This is the basics for the file, giving it the deployment ports, and I left the application module blank to verify that it works
the really application module that works is still TBD as of 8/1/19 by me. 

Other add-ons to the `application.conf` file for mongo
```
mongo {
  connectionString = “mongodb://127.0.0.1:27017”
}
```

```
watch = [ “kotlin-ktor-mongo-db”]
```
