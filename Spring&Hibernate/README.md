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

### Inversion of Control - configuration

Spring (Inversion of Control) -

Object Factory (Spring) -> (give me object based on configuration file)
Configuration ->
- BaseballCoach, Hockeycoach, TrackCoach

### Spring Container - Primary Functions
- Create and manage objects (Inversion of Control)
- Inject object's dependencies (Dependency Injection)

### Configure Spring Conteiner - There is 3 ways to do that
- XML configuration file (legacy, but most legacy apps still use this). It was used when Spring first came out

- Java Annotations (Modern)

- Java Source Code (Modern)

## <b> Spring Development Process (Step-By-Step) </b>
1. Configure Spring beans.
2. Create Spring Container.
3. Retrieve beans from Spring Container

#### Step 1: Configure you Spring Beans

File: <b> applicationContext.xml </b>

```java

<beans ...>

  <bean id="myCoach"  //id is for Java Application to Retrieve a bean from spring container
    class="spring.demo.coaches.BaseballCoach">
  </bean>

</beans>

```

#### Step 2: Create a Spring Container
- Spring container is generically known as ApplicationContext

ApplicationContext - is a central interface that provide configuration information to the application.
It's a read-only at run time, but can be re-loaded if nessasery.

Application Context provide:
- beans factory methods to access application compoents
- ability to load file resources in generic fashion
- ability to publish events to registered listeners
- ability to resolve messages to support internationalization
- inheritance from parent context

Specialized implementations:
- ClassPathXmlApplicationContext
- - AnnotationConfigApplicationContext
- GenericWebApplicationContext
- Others...

```java
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
```

# Dependency injection
e.g. Car
Car Factory - you have there different parts of the car, e.g. engine, doors, tires, seats..
Then technicians made a car from those pieces for you and deliver you a completed Car.

In another words you just simply outsource construction and injection of your object to external entity (Car Factory).

So...
Spring have an object factory. When you retrive Coach object then that object can have additional dependencies and those are helper objects. So insted build all coach objects and his dependencies Spring0-Factory do this for you. You just simply get object that is ready to use.

#### There is many types of injection with Spring:

Most common ones are:
- Contructor injecion
- Setter Injection

#### Development process - construction injection
1. Define the dependency interface and class.
2. Create Contructor in your class for injections.
3. Configure the dependency injection in Spring config file.

```java

public interface FortuneService {

  public String getFortune();
}

public class HappyFortuneService implements FortuneService {

  public String getFortune() {
    return "This is your lucky day!";
  }
}

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
      fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Make FBW on gym. Also add running for 30min";
    }
}

```

File: applicationContext.xml
```xml

<bean id="myFortuneService"
  class="spring.demo.coaches.HappyFortuneService">
</bean>

<bean id="myCoach"
  class="spring.demo.coaches.BaseballCoach">
    <constructor-arg ref="myFortuneService" />
</bean>

```
