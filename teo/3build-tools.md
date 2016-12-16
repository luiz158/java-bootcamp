# Ant y Maven

Build tools para Java.

A build tool is a tool that automates everything related to building the software project. Building a software project typically includes one or more of these activities:

- Generating source code (if auto-generated code is used in the project).
- Generating documentation from the source code.
- Compiling source code.
- Packaging compiled code into JAR files or ZIP files.
- Installing the packaged code on a server, in a repository or somewhere else.

##### Ant vs Maven

Maven uses a more declarative approach, meaning that you specify in the Maven POM file what to build, but now how to build it. The POM file describes your project resources - not how to build it. Contrarily, an Ant file describes how to build your project. In Maven, how to build your project is predefined in the Maven Build Life Cycles, Phases and Goals.

## Ant

Runs commands in sequence, previously specified in an XML file. Similar to a makefile. 

## Maven

[Maven in 5 minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
[Tutorial](http://tutorials.jenkov.com/maven/maven-tutorial.html#maven-build-life-cycles-phases-and-goals)
[Getting started](http://maven.apache.org/guides/getting-started/index.html)

Similar to Ant, but you don't tell exactly what you want, it figures it out. It's more stric about how you organized stuff.

It has a dependency management, so it can download, install and build new packages.

Permite "empaquetar" librerias para hacer deploy a un servidor con todas las dependencias.

Instruccions/descriptions are written on a pom.xml (Project Object Model) file.

Los proyectos se crean con la estructura habitual:

```
my-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- mycompany
    |               `-- app
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- mycompany
                    `-- app
                        `-- AppTest.java
```

Ubicado en el directorio, puedo _buildear_ el proyecto con

```
mvn package
```

Ejecutar .jar generado:

```
java -cp foo.jar full.package.name.ClassName
```

- groupId: company name
- artifactId: class name/name of the project I'm building
- versionId: num version
- packaging: indicar tipo de package JAR, WAR, EAR que producira. Por default es JAR.
- modelVersion
- url: URL del proyecto, sirve para _mvn site_
- name: sirve para docs
- descripcion: para docs


Maven reads pom.xml, downloads dependecies, executes life cycles, build phases and/or goals, executes plugins

- Plugins: add functionality to build tool
- Build profiles: profiles for development, testing, deployment

POMs can have parents and children. POM that inherited from another POM can override settings.

Effective POM: shows POM commands being executed, avoiding inheritance, super POMs, etc.:

```
mvn help:effective-pom
```

#### Build Life Cycles, Phases and Goals

The build process in Maven is split up into build life cycles, phases and goals. A build life cycle consists of a sequence of build phases, and each build phase consists of a sequence of goals. When you run Maven you pass a command to Maven. This command is the name of a build life cycle, phase or goal. If a life cycle is requested executed, all build phases in that life cycle are executed. If a build phase is requested executed, all build phases before it in the pre-defined sequence of build phases are executed too.

Hay tres life cycles fundamentales: **default** (compila y empaqueta proyecto), **clean** (borrra archivos temporales), **site** (genera site con documentacion).

```
mvn default
mvn clean
mvn site
```

Life Cycles esta compuesto de phases, compuestas de goals.

Phases de default:

- **validate**	Validates that the project is correct and all necessary information is available. This also makes sure the dependencies are downloaded.
- **compile**	Compiles the source code of the project.
- **test**	Runs the tests against the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
- **package**	Packs the compiled code in its distributable format, such as a JAR.
- **install**	Install the package into the local repository, for use as a dependency in other projects locally.
- **deploy**	Copies the final package to the remote repository for sharing with other developers and projects.

### Buenas practicas

- crear POM de dependencias comunes (ejemplo: Spring, Hibernate, jUnit, JDBC) y luego heredar de este _especificando que es type POM_

#### Crear

```
mvn -B archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DgroupId=com.mycompany.app \
  -DartifactId=my-app
```

#### Otros comandos utiles

```
mvn compile —- genera archivos .class
mvn test —- ejecuta tests
mvn test-compile —-  compila tests
mvn package — crea .jar
mvn install —- instala en el repo local
mvn site
mvn clean
mvn idea:idea —- descriptor para IntelliJ
mvn eclipse:eclipse — para Eclipse




