# Useful terms

Shell - user interface for access operating system services. It can be a command-line interface or graphical user interface. (CLI or GUI)

# RAM memory - Random Access Memory

Stores currently running programs. 

CPU (Processor) - run all your programs on PC. It's doing all the processing.

In order for CPU to run a program, program has to exsist on RAM.

TIP: For example when you boot you PC, smartfon then operating system is taken from flash memory and puted inside of RAM. After that is 
executed by CPU.

When RAM is exceeded, when there is no room for another program that you want to run. Then we have to take something out of RAM
and put something that you want to use. That's why it's better to have more RAM because you don't have to go back to your flash drive and 
put it into RAM. Process that takes stuff in & out memory is called "Paging". 

So for example when you have a task killer or similar software on your smartfon then you just taking stuff from the 
memory-box RAM to make room for other stuff that you will run.

# CPU - Processor 

Instruction Set Architecture - list of instruction that PC understands. List contains all the things that PC can make like adding, 
multiplying etc. Processor makes simply things.

Most PC for the past decade run on x86 architecture instruction set.

Most devices like smartphones run have processors that implements ARM architecture instruction set. 

Different processors Can implement same architecture instruction set like x86. 

<h3> 1. Soo What the difference between old and new processors? </h3>

> Basically they do same instruction set but newer ones do it faster. 

<h3> 2. What is a Computer Program? </h3>

> It's a huge list of instructions that processor can understand.

<h3> 3. What is GHz means in processor? </h3>

> Hz - is how we measure speed of the processor. Also it is a measure of freqency. Frequency is simply how often something happens in 
particular amount of time.

> 1Hz - is one cycle per second

> 1GHz - is one bilon cycles per second 

> G - giga - 10^9

<h3> 4. What multicore multithread means? </h3>

> 1 Core - is like person It can do one thing at a time. 1 Core Can have 1 thread then It can do this one thing at a time.

BUT 

> 1 Core Can Also Have More threads like 4 threads and that means It can Do 4 things at the same a time. 

> Soo
1Core1Thread - one thing at same the time
1Core4Thread - four things at same the time

> Let's say we have:
4Cores4Threads - so there is four cores that can do 4 things at the same time

BUT 
> That doesn't means that speed is 4x times faster.
Each Core Can access a resource like particular part of memory RAM but then others can't

Software threads is how programmmer makes a program that uses architecture instruction set.

Hardware threads is when one processor can handle more than one thread at the same time. 

Simultaneous multi-threading - is the same as Hyper-threading that Intel made and implemets that is his processors. 

# Memory Hierarchy

On-chip
> L0: At the top the fastest: registers (they are the smallest memory and the fastest). Number of the registers is definied by architecture instruction set. 

On-chip
> L1: Cache - smaller than L2 Cache but again faster to access. It on Chip, included in processor. RAM is off-chip which means its
seperated.

Off-chip
> L2: Cache - smaller than RAM and Faster. For example it have 256MB. Frequently access data is store here. So the processor can 
access it very fast and don't have to look at RAM which is a bit slower. Almost 10 times slower than L1 Cache. 

Off-chip
> L4, L3: RAM - any program that you run must exsist on RAM for processor to execute it. Almost 100 times slower than L1. 

Off-chip
> L5: At the bottom the slowest: hard drives, flash drives, big types of memory, TB of data

Off-Chip: 
RAM, HardDrives

On-Chip:
L1: Cache

# GPU - Graphics Card

GPU - implments like the processor instruction set architecture but only specific ones that are focused on graphics. 

Video Card - it is not the same as GPU. There is two main ways that PC handles graphics: 
- integrated graphics
- dedicated graphics

Video Card - has its own RAM, has GPU, heat sinks, fans, also like CPU all that memory levels and cache layers to optimize performance.

# How code works? 
Source code -> machine code -> executable file

# Static and Shared libraries

When a lot of applications use common functionality like print() 
then that functionality is packaged up into library. So library is just 
a file, nothing more or less. Major difference is you cannot execute library. 
So when you open task manager then you can see processses (applications) that uses libraries but you are not gonna see there
any library running. 

Summarizing: processes, applications utilize libraries. 

<h3> Shared Libraries </h3> 

> So for example our application references a shared library and uses some functionality, but on itself 
doesn't have that library it just uses, reference that library functionality. References a library when it runs.
So you have to have a application and the shared libarary at the same time.

> Linux: *.so
> Windows: *.dll
> Mac: *.DYLIB

<h3> Static Libraries </h3>

> Our program is going to utilize a static library at compile time. Remember compile time is before run-time. Something must be compiled 
before you can even run it. So at that compilation time we take/copy all code that we need and move to our application. So thats
difference between Shared and Static library, that on static we copy libarary function to our application on shared we just use it. 
Static you don't need to have a libarary at run-time becasuse you have a copy of library.

> Unix: *.A
> Windows: *.LIB

<h3> What's the difference between two of them? </h3> 
Major difference is that static library copy all the things that you want to use and that can take a lot of time and space. 
Where shared library just uses some libararies that are out there. So Shared keeps application really small because you don't need
that copy/paste code. So major consideration when you develop application should be Size of your app and if that matters.

Static could be a little convenient when you gave program to client and he have full-pack of everything inside so he don't have
to worry about anything. 

# Pointers

Basic Overview:
Pointer itself is a variable. It stores an address of e.g. some other variable. Pointer is small size. Variable could be big.
Every variable has value & address. Every single variable has its own address. 

# Virtual Memory

programs == processes

So the operating system manages application memory. Manages all applications that are running on the system. All of this behind scenes. 

Operating system provides a blueprint of memeory for every single process. It's same blueprint for each program. 
Virtual memory is a map to diffrent physical addresses. Its purpose is that make sure that programs don't bump into each other. 
So if both application store data at address e.g. 500. Then this address actually address to different part of memeory. 

Soo for example 
> Facebook have virtual address 500 that points to real address 3000
> Instagram have virtual address 500 that points to real address 4500

Operating system makes sure that those addresses never collide in the physical memory. 

TIP: virtual memory takes coordination of hardware and software together. Both exsist together to make virtual memory work. 

# Instruction Level Parallelism

Instruction Level Parallelism - is a technique on the compilter and on the hardware. Kinda like virutal memeory where software and hardware coexsist. So if software is crappy then it's gonna take a long time to perform a task even when you have a good processor but you don't utilize all available resources.

So first of all for parallelism we need to have a good hardware to make it even possible.
Second thing we need a good software to utilize all available resources.

TL;TR
It's a collaborative hardware & software technique to increse efficiency of processor. So when there is limited CPU capabilities then 
it's only so much a CPU can do. But on the other hand when you have some big, strong CPU, and a crappy software then it's similar to first one there is only so much you can do. Your crappy software is not gonna use all the resources available. 

# Instruction pipelining

Concept that improves parallelism. 

Example: 

Let's say we have a laundry: 
1. Wash (washer)
2. Dry (dryer)

Each step takes 30min 
1. Make Wash1
2. Place Wash1 into Dryer1 and at the same time make Wash2
3. Place Wash2 into Dryer2
Result: 90min

Another example
We have a wash-dryer in one piece
1. Make Wash-dry 60min (wash 30min and dry 30min)
Result 120min and we can't jump over it

So it's better to do pipelining and broke problem into smaller pieces. 

So in the hardware some calculation is broken into smaller pieces. Like adding is broken into small pieces and because of that
pipelining is possible. 

# Computer Logic

1. Logic gates
![image](http://i.imgur.com/M59IOZQ.jpg)

2. Binary

3. Add Numbers












