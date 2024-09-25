package com.javaoop.java_dasar;

class urut{
    static void sorted(int[] input){
        int array[] = input;
        int indeks1= 0;
        int indeks2= 1;
        while(indeks1<=array.length){
            if(indeks2<array.length){
                if(array[indeks1]>array[indeks2]){
                    int a = array[indeks1];
                    int b = array[indeks2];
                    array[indeks2] = a;
                    array[indeks1] = b; 
                    indeks2++;
                } else{
                    indeks2++;
                }
            } else{
                indeks1++;
                indeks2=indeks1+1;
            }
        }
        System.out.print("[");
        for(int x=0;x<array.length-1;x++){
            System.out.print(array[x]+",");
        }
        System.out.print(array[array.length-1]+"]");
    }
}

public class bubbleSort {
    public static void main(String[] args) {
        int A[] = {5,4,3,2,1};
        urut.sorted(A);
    }
}
