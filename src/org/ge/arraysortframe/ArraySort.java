package org.ge.arraysortframe;

import java.util.Random;

/**
 * Created by Administrator on 11/11/2014.
 */
public class ArraySort {

    int[] A = new int[100];
    int[] B = new int[100];


    //get a random number;
    private int getRand(){
        Random in = new Random();
        return in.nextInt(100);
    }

    //fill an array with numbers from 0 to 99;
    void fillArray(int[] array){
        for (int i=0; i<array.length; i++)
            array[i] = i;
    }



    //copy an array to another;
    void copyArray(int[] aArray, int[] bArray){
        for (int i=0; i<aArray.length; i++)
            bArray[i]=aArray[i];
    }

    //swap two numbers in an array according to index;
    private void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //random select two numbers in an array and switch them;
    int disorderArray(int[] array){
        int i,j;
        i=getRand();
        j=getRand();
        swap(array,i,j);
        //System.out.println("the index of the 2 swapped numbers are " + i +  " " + j);
        //System.out.println("number " + i +" is "+ array[i]);
        //System.out.println("number " + j +" is "+ array[j]);
        //System.out.println();
        return i;
    }

    //print out the array;
    void printArray(int[] array, int col){
        for (int i=0; i<array.length-col+1; i+=col){
            for (int j=i; j<i+col; j++)
                System.out.print("number " + j + " is " + array[j] + ";  ");
            System.out.println();
        }
        for (int i= array.length-array.length%col; i<array.length; i++)
            System.out.print("number " + i + " is " + array[i] + ";  ");
        System.out.println();
        System.out.println();
    }

    //bubble sort;
    void bubbleSort(int[] array){
        for (int i=array.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (array[j]>array[j+1])
                    swap(array,j,j+1);
            }
        }
    }

    //selection sort;
    void selectionSort(int[] array){
        for (int i=0; i<array.length-1; i++){
            int p = i;
            for (int j=i+1; j<array.length; j++)
                if (array[p] > array[j])
                    p = j;
            if (i!=p)
                swap(array,i,p);
        }
    }

    //compare two arrays;
    boolean compareArrays(int[] aArray, int[] bArray){
        boolean s = true;
        int i = 0;
        if (aArray.length==bArray.length) {
            while (s && i < aArray.length) {
                if (aArray[i] != bArray[i])
                    s = false;
                i++;
            }
        }
        return s;
        //if (s)
        //    System.out.println("Array A and B are same.");
        //else
        //    System.out.println("Array A and B are different");
    }
}
