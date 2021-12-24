# Origin Insurance Advisor

API Rest Origin

Java Spring Boot using Hexagon Architecture, Strategy and Template Method Pattern

The solution was built to be decoupled, testable and easy to maintain :)

### Prerequisites

* [Java 11](https://www.java.com/pt_BR/download/) - Development Kit 
* [Git](https://git-scm.com/downloads) - Open source distributed version control system
* [IntelliJ](https://www.jetbrains.com/idea/) - Powerful source code editor (Not mandatory)

### Installing

Checkout the code from Github repository
```
$ git clone https://github.com/lordssa/origin-insurance-advisor.git
```

Once you have maven installed on your environment, install the project dependencies via:

```
mvn clean install
```

To run unit tests, you can also execute:
```
mvn clean test
```

## Running

Once you have installed dependencies, this can be run from the `FinancialApplication.java` main method directly,
or from a command line:
```
mvn spring-boot:run
```

The API will be available at http://localhost:8080/

```
curl --location --request POST 'http://localhost:8080/' \
--header 'Content-Type: application/json' \
--data-raw '{
"age": 61,
"dependents": 2,
"house": {"ownership_status": "owned"},
"income": 0,
"marital_status": "married",
"risk_questions": [0, 1, 0],
"vehicle": {"year": 2018}
}'
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Cid Soares** - *Initial work* 
