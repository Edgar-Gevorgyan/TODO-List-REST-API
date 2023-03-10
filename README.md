# TODO-List-rest-api

This project implements a CRUD API that handles a simple in-memory todo list.

## API

<table>
<tr>
<td>

**Method**
</td> 
<td> 

**URN**
</td> 
<td> 

**Request Body**
</td> 
<td>

**Output**
</td> 
<td>

**Description**
</td>
</tr>

<tr>
<td>POST</td>
<td>/todos</td>
<td>

```json
{
  "data": "Playing soccer"
}
```
</td>
<td>-</td>
<td>Create a todo item</td>
</tr>

<tr>
<td>GET</td>
<td>/todos</td>
<td>-</td>
<td>

```json
[
  {
    "data": "Playing soccer"
  }
]
```
</td>
<td>Get all todos</td>
</tr>

<tr>
<td>GET</td>
<td>/todos/:id</td>
<td>-</td>
<td>

```json
{
  "data": "Playing soccer"
}
```
</td>
<td>Get a todo by id</td>
</tr>

<tr>
<td>PUT</td>
<td>/todos/:id</td>
<td>

```json
{
  "data": "Playing soccer"
}
```
</td>
<td>-</td>
<td>Update a todo by id</td>
</tr>

<tr>
<td>DELETE</td>
<td>/todos/:id</td>
<td>-</td>
<td>-</td>
<td>Delete a todo by id</td>
</tr>
</table>


## Licence

Code released under Apache License 2.0

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

The application is now runnable using `java -Dquarkus.config.locations=<PATH_TO_CONFIG_FILE> -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _uber-jar_, is now runnable using `java -Dquarkus.config.locations=<PATH_TO_CONFIG_FILE> -jar target/*-runner.jar`.