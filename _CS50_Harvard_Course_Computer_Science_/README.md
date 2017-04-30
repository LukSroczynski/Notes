# Harvard - Computer Science 50 : CS50

Computer operates on simple switch ON / OFF

Transistor simple switch ON OFF, those works as bits (binary digit). 

A bit can have 0 or 1. 

Byte is 8 bits with representation of 2^n

| 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |

ASCII - we can have a letter representation, after that we can store colors RGB with that we can make pictures, gifs, movies... etc.. 
so using those simple primitives we can ultimately represent all forms of media. We abstract those things so we can go from this lowest level to the highest level. This gives us this general idea of abstraction.

C: 
source code -> compile -> machine code
INPUT    ->   compiler    ->   OUTPUT

compiler has some algorithms that converts our code to machine code

When Program run then uses your RAM.. 

headers file includes functions that are definied somewhere in the program 

You can do that or you can write print_name in different file
```C
// preprocessing - those thinks happens first 
#include <stdio.h>
#include <cs50.h>

// that's called prototype
void print_name(string s);

int main(void) 
{
    string s = get_string();
    print_name(s);
    
}

void print_name(string s) 
{
    printf("Hello, %s\n", s);
}
```

What happens when you run a program: 
1. Preprocessing - find and replace
2. Compiling - takes source code to assembly
3. Assembling - takes to 0 1 that CPU understands
4. Linking - takes all 0 1, from cs50, stdio and others... and combines it into our program
