![](https://github.com/bancolombia/scaffold-clean-architecture/workflows/gradle-actions/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bancolombia_scaffold-clean-architecture&metric=alert_status)](https://sonarcloud.io/dashboard?id=bancolombia_scaffold-clean-architecture)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=bancolombia_scaffold-clean-architecture&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=bancolombia_scaffold-clean-architecture)
[![codecov](https://codecov.io/gh/bancolombia/scaffold-clean-architecture/branch/master/graph/badge.svg)](https://codecov.io/gh/bancolombia/scaffold-clean-architecture)
[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/bancolombia/scaffold-clean-architecture/blob/master/LICENSE)
# Scaffolding of Clean Architecture
Gradle plugin to create a java application based on Clean Architecture following our best practices!


Plugin Implementation  
===================
To use the plugin you need Gradle version 5 or later, to start add the following section into your 
**build.gradle** file.

```groovy
plugins {
 id "co.com.bancolombia.cleanArchitecture" version "1.6.3"
}
```



Tasks
=====
The Scaffolding Clean Architecture plugin will allow you run 8 tasks  :

1 The ```cleanArchitecture | ca``` task will generate a clean architecture structure in your project, this task has three optional parameters; ```package``` , ```type``` and ```name```.

 ```package = <package.we.need>```: You can specify the main or default package of your project. ```Default Value = co.com.bancolombia```

- ```type = <imperative | reactive>```: With this parameter the task will generate a POO project. ```Default Value = imperative```

-  ```name = NameProject```: This parameter is going to specify the name of the project. ```Default Value = cleanArchitecture```

-  ```coverage = <jacoco | cobertura>```: This parameter is going to specify the coverage tool for the project. ```Default Value = jacoco```


```sh
gradle cleanArchitecture --package=co.com.bancolombia --type=imperative --name=NameProject --coverage=JACOCO
gradle ca --package=co.com.bancolombia --type=imperative --name=NameProject --coverage=JACOCO
```

2 The ```generateModel | gm``` task will generate a class and interface in model layer, this task has one required parameter ```name```.
```sh
gradle generateModel --name=[modelName]
gradle gm --name [modelName]
```
3 The ```generateUseCase | guc``` task will generate a class in model layer, this task has one required parameter ```name```.
```sh
gradle generateUseCase --name=[useCaseName]
gradle guc --name [useCaseName]
 ```
4 The ```generateDrivenAdapter | gda``` task will generate a class in Infrastructure layer, this task has one required parameter ```type```. 
Whether you'll use generic one also parameter ```name``` is required.
```sh
gradle generateDrivenAdapter --type=[drivenAdapterType]
gradle gda --type [drivenAdapterType]
 ```

|Reference for drivenAdapterType|Name                |Additional Options   |
|-------------------------------|--------------------|---------------------|
|GENERIC                        |Empty Driven Adapter|--name [name]        |
|JPA                            |JPA Repository      |--secret [true-false]|
|MONGODB                        |Mongo Repository    |--secret [true-false]|
|ASYNCEVENTBUS                  |Async Event Bus     |                     |

5 The ```generateEntryPoint | gep``` task will generate a class in Infrastructure layer, this task has one required parameter ```type```.
Whether you'll use generic one also parameter ```name``` is required.
```sh
gradle generateEntryPoint --type=[entryPointType]
gradle gep --type [entryPointType]
 ```

|Reference for entryPointType|Name                                  |Additional Options|
|----------------------------|--------------------------------------|------------------|
|GENERIC                     |Empty Entry Point                     |--name [name]     |
|RESTMVC                     |API REST (Spring Boot Starter Web)    |                  |
|WEBFLUX                     |API REST (Spring Boot Starter WebFlux)|                  |

6 The ```validateStructure | vs``` Validate that project references aren't violated.
```sh
gradle validateStructure  
gradle vs
```

7 The ```generatePipeline | gpl``` task will generate CI pipeline inside the folder "./deployment/", this task has one required parameter ```type```.
```sh
gradle generatePipeline --type=[pipelineType]
gradle gpl --type=[pipelineType]
````

|Reference for pipelineType|Name          |
|--------------------------|--------------|
|AZURE                     |Azure Pipeline|


8 The ```deleteModule | dm``` task will delete a sub project, this task has one required parameter ```module```.
```sh
gradle deleteModule --module=[name]
gradle dm --module=[name]
````

How I can help?
=============
Review the issues, we hear new ideas.

