# kotlin-mongodb
Testing mongoDb with Kotlin

Key issues faced: 
application.conf causing `Main class` issues while trying to run it in IntelliJ
Make sure that you check that when you build and run any Kotlin project in IntelliJ that all of the enivormental variables
upon build Kotlin will generate a directory called `out` inside of out follow the route to the `out/prod/class/com.project.demo/<ApplicationKt.class>`

https://ktor.io/servers/configuration

exists, also check in the resource folder in the `out` directory that there is a file called `application.conf`


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

Other add-ons to the `application.conf` file for mongo.
THIS WORKS
```
mongo {
  connectionString = “mongodb://127.0.0.1:27017”
}
```
## WHEN COPYING AND PASTING
MAKE SURE TO CHECK YOU `" "` as they will be skewed from the copying, even if it's direct from a code block.
```
watch = [ “kotlin-ktor-mongo-db”]
```



## IntelliJ: 
Get the mongo explorer plugin
To connect: 
    `+` --> `server url` --> `db` 
=======
## Gradle issues:

Added ext version_variables in build script
make sure to set you source set main set. This may be required when cloning the project
ktor requires `jcenter()` and a `mav {url 'https://kotlin.bintray.com/ktor'}`
