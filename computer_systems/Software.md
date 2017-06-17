# How Code Works? 

Aim: Run "Hello World" Application

- Program is a sequence of bytes.
- Everything is reprezented by bytes, files, music, all of it.
- Each byte has represents a text character. Binary files are not readable by human. 

1. Compilation is just translating a source code into machine code. After that you have translated code on your hard-drive. 

2. Next thing is to execute it. For example we can use a shell to execute a program. Shell it's a program command-line interpreter. Shell tells OS to switch into our program. Give resources to us and put out program to RAM which will be executed by processor.


# Concurrency vs Parallelism (Współbieżność vs Równoległość)

Concurrency - we as a human we are concurrent. It's like we have this pile up of things to do and it's up to us to figure out how to get that done. So for example we have a 100 thing to do and are gonna do it thoughut the day. For example we can't do it all of it in the moring. We can do few in the morning. 
Example: Single-Core CPU

Parallelism - it's executing two physical task at the same exact time. 
Example: Multi-Core CPU

# What we should understand about programming languages? 

From to Bottom to the Top

<b> Machine instructions </b>  - starts from the lowest level its just: 10100100101010010100001011100101. Which do for example adding. 

<b> Assembly languagage </b>  - It's just a wrapper of machine code. One level above machine code. 

<b> System languages (C/C++) </b>  - anything that we use to program operating system itself. How systems operates. We have more control over low level thing like memory. 

<b> Application / High level languages (Java, Python, Ruby, PHP, C#) </b>  - you use then to create consumer applications. 

# Compiled vs Interpreted

<b> Compilation </b> - there is that step where your source code is translated into machine code. Major difference is that here is explicit step that translates you code. 

<b> Interpreted </b> - there is no explicit compilation or translation step. Interpreter is some kinda of program that interpreters you code line by line and executes right thing. Only difference is that your program does not go throught compilation step.

Language as itself can't we defined as interpreted or compiled. It just a implmentation which he have defines if it's interpreted or compiled. Just like processors implements architecure set it's similar here. 

Python for example have a normally a interpreter, but there is also compilers for Python so you could just compile your code.

# Types of Software Developers:

- <b> Front-end </b> - those guys specialzed in code that runs inside your web browser. They works really close with designer and make they make pages responsive.
- <b> Mobile </b> - make games, Android, iOS, work closely with designers, they care for each pixel on the screen :) 
- <b> Gaming </b> - write code for games, they play with 3D graphics and other crazy stuff
- <b> Back-end </b> - system developers, those guys write what is behind the scenes. It stuff that powers website, api, sdk, manipulate DB.
- <b> Application </b> - any kind of software that is used by consumer
- <b> Data Science </b> - anyone who analize data, come up with any patterns, makes model organize data
- <b> QA / TEST </b> - they develop code that tests other code. Really important to test code. 
- <b> Algorithms </b> - academic types. Read a lot of science stuff. 
- <b> Embeded </b> - it's very low level of programming. Those guys can write up code that runs even before OS loads. Guys that makes you camera works, keyboard, mouse etc. 
- <b> OS </b> - Develop operating software, all files in system, services etc. very niche
- <b> Dev-ops </b> - developers operations, network or system administrator, they handle needs of company, what types of PC you need, how back DB everyday, how to fix errors, bugs etc. manage engineer workflow, they just manage in most cases BIG systems. 
- <b> Full-stack </b> - it can mean a lot of things. It's not a skillset. It's just a a idea you can do anything you know DB, web, back-end, front-end, basically you can make anything and you know anything.
- <b> Compiler - language </b> - creates languages, compilers multiple ways of implementations different languages

# Object Oriented Programming

Inheritance - when sub-class implements super-class. 
```
IS A

e.g. Cook IS A Person.
```

Role
```
BEHAVES LIKE A 

e.g. Chef BEHAVES LIKE A dishwasher and IS A Person
e.g. Cat BEHAVES LIKE A dishwasher but isn't a Person
```

Composition - you take different classes and combine then together. 
```
HAS A 

e.g. Kitchen HAS A sink. 
```

Encapsulation and public interfaces

```
Encapsulation - its idea of hiding details about classes.

public interface - is how you expose your class to the outside world. 
```

