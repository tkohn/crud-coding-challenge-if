# Coding Challenge for IF

The Coding Challenge consists of a backend and a frontend part.
Springboot with Java is used for the backend.
Elasticsearch is used as data storage.

## Developer Notes

### How to start the whole Application?

### docker-compose

In the root folder there exists a compose file which can be used to start an Elasticsearch instance and the backend.

To do this you have to execute the command `docker-compose up` in a terminal window in the root directory.


### Backend

The backend uses Maven as a build tool.
To run the application, run the following command in a terminal window in the directory `crud-backend`.

```
./mvnw spring-boot:run
```

In order to get the backend running, an Elastichsearch instance must be reachable under `localhost:9200`.

#### Testing with curl

Add a new user
```
curl \
  -H "Content-Type: application/json" \
  -X POST \
  -d '{"forename":"Max","surname":"Mustermann","email":"max@mustermann.de"}' \
  http://localhost:8080/api/users
```

Get all user
```
curl -H "Content-Type: application/json" http://localhost:8080/api/users
```

Get a specific user by the id
```
# replace <id> with a valid id
curl -H "Content-Type: application/json" http://localhost:8080/api/users/<id>
```

Delete a user

```
# replace <id> with a valid id
curl -I -H "Content-Type: application/json" -X DELETE http://localhost:8080/api/users/<id>
```

### Frontend

N/A

### FAQ

#### Elasticsearch does not start

It is possible that Elasticsearch does not start.
If the following appears in the log files:
`max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]`
Then you have to change the setting `vm.max_map_count`.
After that Elasticsearch should start.

More about the setting can be found in the documentation -> [Set vm.max_map_count to at least 262144](https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html#_set_vm_max_map_count_to_at_least_262144)