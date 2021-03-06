#include <stdlib.h>
#include <stdio.h>
#include <string.h>



#define BIT_LENGTH 13
#define N_INPUT 1000

//-------------------------------------------------------------------------------

void build_gamma_epsilon(char *gamma, char *epsilon, int *ones, int *zeros){

    for(int i = 0; i < BIT_LENGTH-1; i++){
        if (ones[i] > zeros[i]){
            gamma[i] = '1';
            epsilon[i] = '0';
        }
        else{
            gamma[i] = '0';
            epsilon[i] = '1';
        }
    }

    return;
}

//-------------------------------------------------------------------------------

int base10_to_binary(char *array){

    int n = 0;
    int c = 0;

    for(int i = BIT_LENGTH-2; i >= 0; i--){
        if(array[i] == '1'){
            n += (1 << c);
        }
        c++;
    }
    return n;
}

//-------------------------------------------------------------------------------

void print_binary_char_array(char *array){
    
    for(int i = 0; i < BIT_LENGTH-1; i++){
        printf("%c", array[i]);
    }
    printf("\n");

    return;
}

//-------------------------------------------------------------------------------

void print_binary_int_array(int *array){

    for(int i = 0; i < BIT_LENGTH-1; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
    
    return;
}   



//-------------------------------------------------------------------------------

int main(int argc, char const *argv[])
{
    
    char buff[BIT_LENGTH];

    char gamma[BIT_LENGTH];
    char epsilon[BIT_LENGTH];

    int ones[BIT_LENGTH];
    int zeros[BIT_LENGTH];

    char *o2_gen_array[N_INPUT];
    char *co2_scrub_array[N_INPUT];

    char input[N_INPUT][BIT_LENGTH];
    int k = 0;
    
    for(int i = 0; i < BIT_LENGTH-1; i++){
        ones[i] = 0;
        zeros[i] = 0;
    }
    
    FILE *fp;
    fp = fopen("input.txt", "r");
    if(fp == NULL){
        printf("Error: Unable to open file.\n");
        return EXIT_FAILURE;
    }

    while(fscanf(fp, "%s", buff) != EOF){
        
        strcpy(input[k++], buff);
                
        for(int i = 0; i < BIT_LENGTH-1; i++){
            if(buff[i] == '1'){
                ones[i] = ones[i]+1;
            }else if(buff[i] == '0'){
                zeros[i] = zeros[i]+1;
            }
        }
    }


    int c = 0;
    char **temp1;
    char **temp2;
    while(c < BIT_LENGTH-1){

        if(ones[c] >= zeros[c]){
            o2_gen_array[c] = malloc(sizeof(char *))
            for(int i = 0; i < N_INPUT; i++){
                if(input[i][c] == '1'){

                    }
                )
            }
            o2_gen_array
        }

        c++;
    }
    
         

    

    // build_gamma_epsilon(gamma, epsilon, ones, zeros);
    // printf("gamma base2: ");
    // print_binary_char_array(gamma);
    // printf("epsilon: base2: ");
    // print_binary_char_array(epsilon);

    // int gamma_int = base10_to_binary(gamma);
    // int epsilon_int = base10_to_binary(epsilon);

    // printf("gamma base10: %d\n", gamma_int);
    // printf("epsilon base10: %d\n", epsilon_int);

    // printf("gamma * epsilon = %d\n", gamma_int*epsilon_int);



    return EXIT_SUCCESS;
}

