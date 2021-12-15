#include <stdio.h>
#include <stdlib.h>
#define N_INPUT 2000

void cmp_arrays(int* prev, int* current, int* count){

    int prev_sum = 0;
    int curr_sum = 0;

    for(int i = 0; i < 3; i++){
        prev_sum += prev[i];
        curr_sum += current[i];
    }

    if(prev_sum < curr_sum ){
        *count = *count + 1;
    }

    printf("P3_sum: %d, C3_sum: %d, Count: %d\n", prev_sum, curr_sum, *count);

    return;
}


void update_prev(int *prev, int *x){
    for(int i = 0; i < 3; i++){
        prev[i] = x[i];
    }
    return;
}


int main(int argc, char const *argv[])
{
    int depth_readings[N_INPUT];
    int data_in;
    int count = 0;
    int a[3];
    int b[3];
    int c[3];
    int d[3];

    FILE *fp;
    fp = fopen("sonar_sweep.txt", "r");

    int i = 0;
    while(fscanf(fp, "%d", &data_in) != EOF){
        depth_readings[i++] = data_in;
    }
    
    int prev[3];
    prev[0] = depth_readings[0];
    prev[1] = depth_readings[1];
    prev[2] = depth_readings[2];
    
    for(int i = 1; i < N_INPUT-1; i++){
        char char_array;

        switch(i%4){
            case 0:{
                //printf("A ");
                char_array = 'a';
                a[0] = depth_readings[i-1];
                a[1] = depth_readings[i];
                a[2] = depth_readings[i+1];

                cmp_arrays(prev, a, &count);                
                update_prev(prev, a);
                
                break;
            }
            case 1:{
                //printf("B ");
                char_array = 'b';
                b[0] = depth_readings[i-1];
                b[1] = depth_readings[i];
                b[2] = depth_readings[i+1];

                cmp_arrays(prev, b, &count);
                update_prev(prev, b);
                break;
            }
            case 2:{
                //printf("C ");
                char_array = 'c';
                c[0] = depth_readings[i-1];
                c[1] = depth_readings[i];
                c[2] = depth_readings[i+1];

                cmp_arrays(prev, c, &count);
                update_prev(prev, c);
                break;
            }
            case 3:{
                //printf("D ");
                char_array = 'd';
                d[0] = depth_readings[i-1];
                d[1] = depth_readings[i];
                d[2] = depth_readings[i+1];

                cmp_arrays(prev, d, &count);
                update_prev(prev, d);
                break;
            }
            
        }
    }

    printf("Count: %d\n", count);


    
    return EXIT_SUCCESS;
}
