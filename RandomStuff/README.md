## asynchronous vs synchronous

When you execute something synchronously, you wait for it to finish before moving on to another task. When you execute something asynchronously, you can move on to another task before it finishes.

That being, said, in the context of computers this translates into executing a process or task on another "thread." A thread is a series of commands--a block of code--that exists as a unit of work. The operating system can manage multiple threads and assign a thread a piece ("slice") of processor time before switching to another thread to give it a turn to do some work. At its core (pardon the pun), a processor can simply execute a command--it has no concept of doing two things at one time. The operating system simulates this by allocating slices of time to different threads.

- [STACKOVERFLOW - Asynchronous vs synchronous execution, what does it really mean?](http://stackoverflow.com/questions/748175/asynchronous-vs-synchronous-execution-what-does-it-really-mean) <br>
- [QUORA - What is the difference between synchronous vs asynchronous and blocking vs non-blocking?](https://www.quora.com/What-is-the-difference-between-synchronous-vs-asynchronous-and-blocking-vs-non-blocking)
