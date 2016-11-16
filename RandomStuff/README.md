## Asynchronous vs synchronous

When you execute something synchronously, you wait for it to finish before moving on to another task. When you execute something asynchronously, you can move on to another task before it finishes.

That being, said, in the context of computers this translates into executing a process or task on another "thread." A thread is a series of commands--a block of code--that exists as a unit of work. The operating system can manage multiple threads and assign a thread a piece ("slice") of processor time before switching to another thread to give it a turn to do some work. At its core (pardon the pun), a processor can simply execute a command--it has no concept of doing two things at one time. The operating system simulates this by allocating slices of time to different threads.

Now, if you introduce multiple cores/processors into the mix, then things CAN actually happen at the same time. The operating system can allocate time to one thread on the first processor, then allocate the same block of time to another thread on a different processor.

All of this is about allowing the operating system to manage the completion of your task while you can go on in your code and do other things. Asynchronous programming is a complicated topic because of the semantics of how things tie together when you can do them at the same time. There are numerous articles and books on the subject; have a look!

source: [a link](http://stackoverflow.com/questions/748175/asynchronous-vs-synchronous-execution-what-does-it-really-mean)
