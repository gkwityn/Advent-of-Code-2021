#include <stdlib.h>
#include <stdio.h>

#define BIT_LENGTH 13

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

    for(int i = BIT_LENGTH-2; i >= 0; i--){
        if(array[i] == '1'){
            n += (1 << i);
        }
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

    
    for(int i = 0; i < BIT_LENGTH-1; i++){
        ones[i] = 0;
        zeros[i] = 0;
    }
    
    FILE *fp;
    fp = fopen("input.txt", "r");

    while(fscanf(fp, "%s", buff) != EOF){
        
        for(int i = 0; i < BIT_LENGTH-1; i++){
            if(buff[i] == '1'){
                ones[i] = ones[i]+1;
            }else if(buff[i] == '0'){
                zeros[i] = zeros[i]+1;
            }
        }
    }

    
    /*    
    //print sum of occurances of 1 or 0 in
    //each index of corosponding arrays.

    printf("ones: ");
    print_binary_int_array(ones);
    printf("zeros: ");
    print_binary_int_array(zeros);
    */

    build_gamma_epsilon(gamma, epsilon, ones, zeros);
    printf("gamma base2: ");
    print_binary_char_array(gamma);
    printf("epsilon: base2: ");
    print_binary_char_array(epsilon);

    int gamma_int = base10_to_binary(gamma);
    int epsilon_int = base10_to_binary(epsilon);

    printf("gamma base10: %d\n", gamma_int);
    printf("epsilon base10: %d\n", epsilon_int);

    printf("gamma * epsilon = %d\n", gamma_int*epsilon_int);



    return 0;
}

