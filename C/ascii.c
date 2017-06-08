// library from harvard cs50 IDE
#include <cs50.h>
#include <stdio.h>

int main(void)
{
    // print all alphabet characters using number
    for(int i = 65; i < 65 + 26; i++)
    {
        printf("%c |int| %i \n", i, i);
    }
    printf("\n");
    
    // print all alphabet characters using character
    for(char i = 'A'; i <= 'Z'; i++)
    {
        printf("%c |char| %i \n", i, i);
    }
    printf("\n");
    
}
