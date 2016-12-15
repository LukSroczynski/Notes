# Asynchronous vs Synchronous

When you execute something synchronously, you wait for it to finish before moving on to another task. When you execute something asynchronously, you can move on to another task before it finishes.

That being, said, in the context of computers this translates into executing a process or task on another "thread." A thread is a series of commands--a block of code--that exists as a unit of work. The operating system can manage multiple threads and assign a thread a piece ("slice") of processor time before switching to another thread to give it a turn to do some work. At its core (pardon the pun), a processor can simply execute a command--it has no concept of doing two things at one time. The operating system simulates this by allocating slices of time to different threads.

- [STACKOVERFLOW - Asynchronous vs synchronous execution, what does it really mean?](http://stackoverflow.com/questions/748175/asynchronous-vs-synchronous-execution-what-does-it-really-mean) <br>

- [QUORA - What is the difference between synchronous vs asynchronous and blocking vs non-blocking?](https://www.quora.com/What-is-the-difference-between-synchronous-vs-asynchronous-and-blocking-vs-non-blocking)

# Web Application - Tutorial
- [Java Web Application Tutorial ](http://www.journaldev.com/1854/java-web-application-tutorial-for-beginners)



# Here's How to Prepare for Tech Interviews
- [Here's How to Prepare for Tech Interviews](https://www.reddit.com/r/cscareerquestions/comments/1jov24/heres_how_to_prepare_for_tech_interviews)

# 5 things to know before job search
- [5 things to know before job search](https://medium.freecodecamp.com/5-key-learnings-from-the-post-bootcamp-job-search-9a07468d2331#.ekvtx4ur0)

# CORS - HTTP access control 

Overview
<br>
The Cross-Origin Resource Sharing standard works by adding new HTTP headers that allow servers to describe the set of origins that are permitted to read that information using a web browser.  Additionally, for HTTP request methods that can cause side-effects on user data (in particular, for HTTP methods other than GET, or for POST usage with certain MIME types), the specification mandates that browsers "preflight" the request, soliciting supported methods from the server with an HTTP OPTIONS request method, and then, upon "approval" from the server, sending the actual request with the actual HTTP request method. Servers can also notify clients whether "credentials" (including Cookies and HTTP Authentication data) should be sent with requests.

Subsequent sections discuss scenarios, as well as provide a breakdown of the HTTP headers used. 

- [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS)
