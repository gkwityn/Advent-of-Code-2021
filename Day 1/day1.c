#include <stdlib.h>
#include <stdio.h>

#define N_INPUT 2000

int main(int argc, char const *argv[])
{
    int depth_readings[N_INPUT];
    int data;
    int count = 0;



    FILE *fp;
    fp = fopen("sonar_sweep.txt", "r");
    if(fp == NULL){
        return EXIT_FAILURE;
    } 


    int i = 0;
    while( fscanf(fp, "%d", &data) != EOF ){
        depth_readings[i++] = data;  
    }


    
    int prev = depth_readings[0];

    for(int i = 1; i < N_INPUT; i++){
        if(depth_readings[i] > prev){
            count++;
        }
        prev = depth_readings[i];
    }

    printf("Number of depth increases: %d\n", count);

    return EXIT_SUCCESS;
}

