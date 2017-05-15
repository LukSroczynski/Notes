## Why wildcards shouldn't be used? Why explicit way is better? Why implicit way is bad?

Basically they shouldn't be used because they blend local namespaces. So better practice is to use imports in explicit way.
Let's say I would use something like that as a wildcard:

import java.util.Date;
import java.sql.Date;

If I would use a wildcard method (implicit way) then It could bring me a few downfalls, e.g.
1. Compiler would had no idea which one to use there would be a name collision, so basically application wouldn't be compiled.
2. It could bring me unconscious error where I used some function from e.g. 'text' but wanted to use something from 'sql' that have same name.
3. If wildcard will not bring any error It can also slow down compilation time of an application.

BUT also standard packages in Java, I guess may be used in a implicit way because most people that write those classes recognizes standard Java libraries.
So with third party libraries make sense to import in a explicit way.

Also using explicit way it gives us more readability to our code

What will happen if github starts to respond slower and this application is handling more than 200 requests?



