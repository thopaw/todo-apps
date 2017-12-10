/*
  Infos about the project
 */
organization := "name.pawlitzki"
name := "todo-app-scala-boot"
version := "1.0.0"
//maintainer := "Thomas Pawlitzki <thomas.pawlitzki@gmail.com>"
description := "Simple Todo App with Scala and Boot"

libraryDependencies ++= Seq(
//  "org.springframework.boot" % "spring-boot-starter-web" % "2.0.0.M6",
//  "org.springframework.boot" % "spring-boot-starter" % "2.0.0.M6",
//  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % "2.0.0.M6",
//  "org.springframework.boot" % "spring-boot-devtools" % "2.0.0.M6" % "runtime",
  "org.webjars" % "bootstrap" % "4.0.0-beta.2",
  "org.webjars" % "jquery" % "3.2.1",
  "org.thymeleaf" % "thymeleaf-spring4" % "2.1.2.RELEASE"
)


mainClass in Compile := Some("name.pawlitzki.name.todo.scalaboot.App")