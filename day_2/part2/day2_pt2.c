#include <stdio.h>
#include <string.h>

struct sub{
    int horizontal;
    int depth;
    int aim;
};


int main(int argc, char const *argv[])
{
    int horizontal = 0;
    int depth = 0;

    char buff[8];
    int x_unites;
    
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

    FILE *fp;
    fp = fopen("input.txt", "r");

    while(fscanf(fp, "%s %d", buff, &x_unites) != EOF){
        //printf("%s  %d\n", buff, x_unites);
        //printf("Hoz: %d, Depth: %d\n", horizontal, depth);

        if(strcmp(buff, "forward") == 0){
            horizontal += x_unites;
            //printf("horiz: %d\n", horizontal);
        }
        else if(strcmp(buff, "up") == 0){
            depth -= x_unites;
            //printf("Up: %d\n", depth);
        }
        else if(strcmp(buff, "down") == 0){
            depth += x_unites;
            //printf("Down: %d\n", depth);
        }
    }


    printf("Horiz * Depth = %d\n", horizontal*depth);


    
    fclose(fp);
    return 0;
}
