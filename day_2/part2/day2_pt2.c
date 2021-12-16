
/*
forward X increases the horizontal position by X units.
down X increases the depth by X units.
up X decreases the depth by X units.
    
down X increases your aim by X units.
up X decreases your aim by X units.
forward X does two things:
It increases your horizontal position by X units.
It increases your depth by your aim multiplied by X.
*/


#include <stdio.h>
#include <string.h>
#include <stdlib.h>



struct submarine{
    int horizontal;
    int depth;
    int aim;
};



int main(int argc, char const *argv[]){
    
    struct submarine my_sub;

    my_sub.horizontal = 0;
    my_sub.depth = 0;
    my_sub.aim = 0;    
    

    char buff[8];
    int x_unites;

    FILE *fp;
    fp = fopen("input.txt", "r");
    if(fp == NULL){
        printf("Error: unable to open file.\n");
        return EXIT_FAILURE;
    }
    
    while(fscanf(fp, "%s %d", buff, &x_unites) != EOF){
        
        if(strcmp(buff, "forward") == 0){          
            my_sub.depth += (my_sub.aim * x_unites);
            my_sub.horizontal += x_unites;            
        }
        else if(strcmp(buff, "up") == 0){
            my_sub.aim -= x_unites;
           
        }
        else if(strcmp(buff, "down") == 0){
            my_sub.aim += x_unites;
        }
    }

    printf("Horizontal * Depth = %d\n", my_sub.horizontal * my_sub.depth);
    
    fclose(fp);
    return 0;
}
