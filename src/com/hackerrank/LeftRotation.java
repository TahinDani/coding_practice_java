package com.hackerrank;

/*
Created by TahinDani on 2017.08.31..
*/

import java.util.*;

public class LeftRotation {

    public static int[] leftRotationInPlace(int[] a, int n, int k){

        // put the first k element in a list
        Queue<Integer> poppedElements= new LinkedList<>();
        for (int i = 0; i < k; i++) {
            poppedElements.add(a[i]);
        }

        // reposition the elements after k elements to the front of the array
        for (int i = 0; i < a.length-k; i++) {
            a[i] = a[i+k];
        }

        // put back the popped elements to the correct place
        Iterator<Integer> i = poppedElements.iterator();
        while (i.hasNext()){
            a[n-k] = i.next();
            n++;
        }


        return a;
    }

    public static int[] leftRotation(int[] a, int n, int k){
        int[] rotated = new int[n];

        //copy the end of the array to the front of new array
        System.arraycopy(a, k, rotated, 0, n-k);
        //copy the first k number to the end of the new array
        System.arraycopy(a, 0, rotated, n-k, k);
        return rotated;
    }


    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(leftRotation(arr, arr.length, 2)));

    }

}
