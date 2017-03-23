# Spring & Hibernate - Notes


Spring - initially a simpler and lightweight alternative to J2EE, provides a large number of helper classes..
make things easier

Dependency injection - specifi via config file or via annotations

Declarative programming with AOP (Aspect-Oriented-Programming)

Minimalize boilerplate code



## Core Container:
    Beans, Core, SpEL, Context
> Manages how beans are created, bean factory for creating a beans, holds beans (conteiner).
>> In a nutshell creates beans and making those beans available

## Infrastructure
    AOP, Aspects, Instrumentation, Messaging
> AOP - add functionalities like logging, security, transactions etc..
Instrumentation - remote you can monitor your app, JMX - Java managment extension

## Data Access Layer
    JDBC, ORM, transactions, OXM, JMS
> Communicating with DB, ORM - integration with Hibernate, JMS - Java Message Service (send message to message-queue asynchronous)
, Also transaction support

## Web Layer
    Servlet, WebSocket, Web, Portlet
> Home of MVC framework, All web related classes

## Test Layer
    Unit, Intergration, Mock
> supports TDD, Mock objects and out-of-container testing

# Spring-Projects:
- they are additional Spring modules build on top of the core Spring Framework

Use What You Need:
- Spring Cloud, Spring Data (DB integration)
- Spring Batch (for Batch interfaces),  Spring Security (you app security)
- Spring for Android, Spring for Web Flow
- Spring for Web Services (REST and SOAP services), Spring LDAP (to access LDAP servers)

## Inversion of Control (IoC)

The idea of (IoC):

Your Application will outsource management and creating of the objects
outsource is handled by object factory

Example:

Coding scenario:

App ----------getDailyWorkout()---------> Baseball Coach  

App:
- should be configurable to change coach for another sport

MyApp.java - main method
BaseballCoach.java - simple implementation
Coach.java - interface after refactoring
TrackCoach.java - switch coaches and see that app still works
