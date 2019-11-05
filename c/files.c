#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    //char C[30];
    char c;
    int id;
    //printf("Enter Name and Id\n");
    //scanf("%s%d",C,&id);
    FILE *Fpointer;
    Fpointer = fopen("file.txt","r");
    if(Fpointer==NULL) printf("Unable to create...\n");
    else
    {
        /*
        printf("Enter a String...\n");
        gets(C);
        fputs(C,Fpointer);
        */
        //fprintf(Fpointer,"%s\n%d",C,id);
        while(!feof(Fpointer))
        {
            c = fgetc(Fpointer);
            printf("%c",c);
        }
        printf("Successfull\n");
        fclose(Fpointer);
    }
    return 0;
}