//package day_3.part2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class d3p2{

        public static final int input_size = 1000;
        public static final int digit_length = 12;


    public static String recur_eval_co2(ArrayList<String> list, int[] bit_criteria_sums , int digit){            


            if((list.size() > 1) && (digit < digit_length)){
                
                ArrayList<String> keep = new ArrayList<String>();   
                bit_criteria_sums = bit_criteria(list, bit_criteria_sums, digit);
                System.out.println("o2: " + bit_criteria_sums[0] + ", co2: " + bit_criteria_sums[1]);


                if(bit_criteria_sums[0] <= bit_criteria_sums[1]){ 

                    for(int i = 0; i < list.size(); i++){
                        if(bit_criteria_sums[0] < bit_criteria_sums[1]){
                            if(list.get(i).charAt(digit)  == '1' ){
                                keep.add(list.get(i));
                            }
                        }
                        else if(bit_criteria_sums[0] == bit_criteria_sums[1]){
                            keep.add(list.get(i));
                        }
                }
                //System.out.println("List size: " + list.size());
                return recur_eval_o2(keep, bit_criteria_sums, ++digit);
            }
            else if(bit_criteria_sums[1] <= bit_criteria_sums[0]) {

                for(int i = 0; i < list.size(); i++){

                    if(bit_criteria_sums[1] < bit_criteria_sums[0]){
                        if(list.get(i).charAt(digit)  == '0' ){
                            keep.add(list.get(i));
                        }
                        else if(bit_criteria_sums[0] == bit_criteria_sums[1]){
                            keep.add(list.get(i));
                        }
                    }
                }
                //System.out.println("List size: " + list.size());
                return recur_eval_o2(keep, bit_criteria_sums, ++digit);
            }             
                
            }
            
            
            //System.out.println("List size: " + list.size());
            return list.get(0);
        }
    //-------------------------------------------------------------------
    public static String recur_eval_o2(ArrayList<String> list, int[] bit_criteria_sums , int digit){     
        
        //System.out.println("Digit: " + digit);

        if((list.size() > 1) && (digit < digit_length)){
            
            
            ArrayList<String> keep = new ArrayList<String>();   
            bit_criteria_sums = bit_criteria(list, bit_criteria_sums, digit);
            System.out.println("o2: " + bit_criteria_sums[0] + ", co2: " + bit_criteria_sums[1]);


            if(bit_criteria_sums[0] >= bit_criteria_sums[1]){ 

                for(int i = 0; i < list.size(); i++){
                    if(bit_criteria_sums[0] > bit_criteria_sums[1]){
                        if(list.get(i).charAt(digit)  == '1' ){
                            keep.add(list.get(i));
                        }
                    }
                    else if(bit_criteria_sums[0] == bit_criteria_sums[1]){
                        keep.add(list.get(i));
                    }
                }
                //System.out.println("List size: " + list.size());
                return recur_eval_o2(keep, bit_criteria_sums, ++digit);
            }
            else if(bit_criteria_sums[1] >= bit_criteria_sums[0]) {

                for(int i = 0; i < list.size(); i++){

                    if(bit_criteria_sums[1] > bit_criteria_sums[0]){
                        if(list.get(i).charAt(digit)  == '0' ){
                            keep.add(list.get(i));
                        }
                        else if(bit_criteria_sums[0] == bit_criteria_sums[1]){
                            keep.add(list.get(i));
                        }
                    }
                }
                //System.out.println("List size: " + list.size());
                return recur_eval_o2(keep, bit_criteria_sums, ++digit);
            }          
            
        }
        
        
        //System.out.println("List size: " + list.size());
        return list.get(0);
    }
    //----------------------------------------------------------------------
    public static int base2_to_10(String n){

         int base10 = Integer.parseInt(n, 2);
         return base10;
    } 
    //----------------------------------------------------------------------
    public static int[] bit_criteria(ArrayList<String> input, int[] bit_criteria, int digit){

        int o2_sum = 0;
        int co2_sum = 0;

        for(int i = 0; i < input.size(); i++){

            if(  input.get(i).charAt(digit) == '1'){
                o2_sum++;
            }
            else if (input.get(i).charAt(digit) == '0'){
                co2_sum++;
            }
        }

        bit_criteria[0] = o2_sum;
        bit_criteria[1] = co2_sum;

        return bit_criteria;
    }
    //----------------------------------------------------------------------
    public static void main(String[] args) throws FileNotFoundException {

        
        int[] bit_criteria_sums = new int[2];   //array[0] = o2sum, array[1] = co2sum
        

        File fp = new File("input.txt");
        Scanner scan = new Scanner(fp);

        ArrayList<String> binary_input = new ArrayList<String>();

        while(scan.hasNextLine()){

            binary_input.add( scan.nextLine());
        }  


        ArrayList<String> input_co2 = new ArrayList<String>(binary_input);        
        
        String o2 = recur_eval_o2(binary_input, bit_criteria_sums, 0);
        String co2 = recur_eval_co2(input_co2, bit_criteria_sums, 0);
        
        System.out.println("o2: " + o2 + ", " + base2_to_10(o2));
        System.out.println("co2: " + co2 + ", " + base2_to_10(co2));

        System.out.println("o2 * co2: " + base2_to_10(o2) * base2_to_10(co2) );

        scan.close();
    }
}