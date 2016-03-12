package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Morpheus on 2016-03-09.
 */
public class ArrayTest {

    public static void main(String[] args) {
        Random rand = new Random();

        int test = 2;

        switch (test) {
            case 0: //Test merge
                for (int i = 0; i < 5; i++) {
                    int[] arr1 = new int[rand.nextInt(30)];
                    int[] arr2 = insertRandomValues(arr1);
                    System.out.println(ArrayTest.print(arr2));
                    arr2 = mergeSort(arr2, arr2.length);        //mergesort
                    System.out.println(ArrayTest.print(arr2));

                }
                break;
            case 1:
                for (int i = 0; i < 5; i++) {
                    int[] arr1 = new int[rand.nextInt(30)];
                    int[] arr2 = insertRandomValues(arr1);
                    System.out.println(ArrayTest.print(arr2));
                    //arr2 = heapSort(arr2, arr2.length);        //mergesort
                    System.out.println(ArrayTest.print(arr2));

                }
                break;
            case 2:
                for (int i = 0; i < 5; i++) {
                    int[] arr1 = new int[rand.nextInt(30)];
                    int[] arr2 = insertRandomValues(arr1);
                    System.out.println(ArrayTest.print(arr2));
                    arr2 = bubbleSort(arr2);                    //bubblesort
                    System.out.println(ArrayTest.print(arr2));

                }
                break;
        }
    }

    //********** Easy Playa Metoder ***************

    public static int[] insertRandomValues(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
        return arr;
    }

    public static String print(int[] arr) {
        String str = "";
        if (arr.length == 0) {
            return "{}";
        } else {
            str += "{";
            for (int i = 0; i < arr.length - 1; i++) {
                str += arr[i] + ", ";
            }
            str += arr[arr.length - 1] + "}";
        }
        return str;
    }
    //*********************************************

    //************ MERGE *************
    public static int[] mergeSort(int[] arr, int length) {
        if (length <= 1) {
            return arr;
        } else {
            int idx = length / 2;
            int[] leftArr = Arrays.copyOfRange(arr, 0, idx);
            //System.out.println(ArrayTest.print(leftArr));
            int[] rightArr = Arrays.copyOfRange(arr, idx, arr.length);
            //System.out.println(ArrayTest.print(rightArr));
            return merge(mergeSort(leftArr, leftArr.length), mergeSort(rightArr, rightArr.length));
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int idxLeft = 0;
        int idxRight = 0;

        int merged = 0;
        int[] done = new int[(left.length + right.length)];
        //System.out.println("Merge: " + ArrayTest.print(done));

        while (idxLeft < left.length && idxRight < right.length) {
            if (left[idxLeft] < right[idxRight]) {
                done[merged] = left[idxLeft];
                idxLeft++;
            } else {
                done[merged] = right[idxRight];
                idxRight++;
            }
            merged++;
        }
        while (idxRight < right.length) {
            done[merged] = right[idxRight];
            merged++;
            idxRight++;
        }
        while (idxLeft < left.length) {
            done[merged] = left[idxLeft];
            merged++;
            idxLeft++;
        }
        return done;
    }
    //*********************************************

    //***************** BUBBLE *******************

    public static int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
        return arr;
    }

    //*********************************************

    //*************** INSERTION *****************

    public static int[] insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] retArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = i;
        }
    }
}
























