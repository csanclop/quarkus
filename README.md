# code-with-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)


## Testing GraphQL with Quarkus
mvn compile quarkus:dev

http://localhost:8080/q/graphql-ui/


We can use following mutation in order to ingest sample Bank entity into in-memory H2:

```
mutation CREATE {
   createBank(bank:
      {name: "Santander", country:"Spain"}) {
        id
        name
        country
      }   
}
```

We would interested to know all Bank entities in the system:

```
{
 banks{
  id
  name
  country
 }
}
```

or probably query a single one (with id: 1):
```
{
 bank(id:1){
  id
  name
  country
 
 }
}
```

We can query only information we need:

```
{
 bank(id:1){
  id
 
 }
}
```


## Contract First
Generated types, used by GraphQL are accessible through:  http://localhost:8080/graphql/schema.graphq
and a way to work with GraphQL in Contract First approach will be analysed.