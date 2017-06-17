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
