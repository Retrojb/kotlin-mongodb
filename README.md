# Kotlin Mongo NOSQL back end for LSM
Template / connection test for intgration

### Continue to work with coroutines
### Key issues faced: 

   * application.conf stack error in `Main class` issues while trying to run it in IntelliJ
      *Make sure that you check that when you build and run any Kotlin project in IntelliJ that all of the enivormental variables upon build Kotlin will generate a directory called `out` inside of out follow the route to the `out/prod/class/com.project.demo/<ApplicationKt.class>` exists, also check in the resource folder in the `out` directory that there is a file called `application.conf` Define the deployment ports


Tempalte for `application.conf`

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


   * Other add-ons to the `application.conf` file for mongo configuration in local environment.

```
mongo {
  connectionString = “mongodb://127.0.0.1:27017”
}
```

#### WHEN COPYING AND PASTING
**CHECK QUOTATION MARKS**  `" "` as they will be skewed from the copying, even if it's direct from a code block. \
`watch = [ “kotlin-ktor-mongo-db”]`

---
#### IntelliJ: 
Get the mongo explorer plugin
To connect: 
    `+` --> `server url` --> `db` 
    
---
#### Gradle issues:

Added ext version_variables in build script
make sure to set you source set main set. This may be required when cloning the project
ktor requires `jcenter()` and a `mav {url 'https://kotlin.bintray.com/ktor'}`

---

## Documents:
[KTOR](https://ktor.io/servers/configuration)
