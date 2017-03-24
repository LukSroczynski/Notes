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
  class="spring.demo.coaches.HappyFortuneService"> // here is our dependency
</bean>

<bean id="myCoach"
  class="spring.demo.coaches.BaseballCoach">
    <constructor-arg ref="myFortuneService" /> // here we inject our dependency
</bean>

```
#### When Injection happens What Spring do? ( Constructor Injection )
Spring perform some operation based on information in your config file. It will create and inject object behind the scenes.

## Setter Injection. What it is?
Spring injects dependencies by calling setter methods

1. Create Setter in class for injection
2. Configure the dependency injection in Spring config file

...

# Bean Scopes

Scope - referes to the lifecycle of the bean
e.g.
1. How long does the bean live?
2. How many instances are created?
3. How is the beans shared?

Default scope: Singleton

What is Singleton?

- Spring Container creates only one instance of the bean, by Default
- It is cached in memory
- There is one bean and everyone will share it. So all requests for the bean will return SHARED reference to the SAME bean

Different scopes:
- Singleton - creates single shared instance if the bean. Default scope.
- prototype - creates new bean instance for each container request
- request - scoped to an HTTP web reqest
- session scoped to an HTTP web session
- global-session - scoped to a global HTTP web session

## Bean lifecycle
Container started -> bean instantiated -> dependecies injected -> internall Spring processing -> Your Custom Init Method -> bean ready to use, container is shutdown

You can call a method during inicialization or destruction of bean. It's called hooks.


TIP: For "prototype" scoped beans, Spring does not call the destroy method.

# Java Annotations
- they are special markers added to Java classes and it gives you meta data about class. Java Annotations is simply meta-data about a class.

> meta data - is a data about other data.

Annotations tells compiler that we are e.g. overriding a method.

## Why use Spring with Annotations?

- XML can be very verbose for LARGE projects. Imaginine you have 100 beans. It's very verbose (verbose - rozległe).
- You can: Configure your Spring beans with Annotations: They minimizes the XML configuration. Annotations are like meta-data

Once you add annotations to your class...
- Spring will scan your Java classes for special annotations, when Spring find class that has annotation it will automatically register bean in the Spring-Container.

#### Development process using annotations: (Step-By-Step)
1. Enable component scanning in Spring config file (.xml).
2. Add the @Component Annotation to you Java classes
3. Retrieve bean from Spring container.


TIP: Default @Component ID is name of the class (first letter lower-cases) e.g. public class Text -> ID: text
