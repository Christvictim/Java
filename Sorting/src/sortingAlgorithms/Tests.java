package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Morpheus on 2016-03-09.
 */
public class Tests {

    public static void main(String[] args) {
        Random rand = new Random();

        int method = 3;             // 0: merge, 1: heap, 2: bubblesort, 3: insertionssort
        int nbrTest = 3;          // amount of testarrays
        int span = 30;              //random length of the arrays from 0 -> span
        int idxSpan = 10;         //random values in the array from 0 -> idxSpan

        /*
        for (int i = 0; i < nbrTest; i++) {
            int[] arr1 = new int[rand.nextInt(span)];
            int[] arr2 = insertRandomValues(arr1, idxSpan);
            System.out.println(Tests.print(arr2));
            switch (method) {
                case 0:
                    arr2 = mergeSort(arr2, arr2.length);            //mergesort
                    break;
                case 1:
                    //arr2 = heapSort(arr2, arr2.length);           //heap
                    break;
                case 2:
                    arr2 = bubbleSort(arr2);                        //bubblesort
                    break;
                case 3:
                    arr2 = insertionSort(arr2);                     //insertionSort
                    break;
                case 4:
                    arr2 = selectionSort(arr2);                     //selectionSort
                    break;
            }
            System.out.println(Tests.print(arr2));
            System.out.println();

        }
        */

        int[] arr1 = new int[rand.nextInt(span)];
        int[] arr2 = insertRandomValues(arr1, idxSpan);
        System.out.println(Tests.print(arr2));
        arr2 = heapSort(arr2, "max");
        System.out.println(Tests.print(arr2));
        System.out.println();
    }

    //********** Easy Playa Metoder ***************

    private static int[] insertRandomValues(int[] arr, int idxSpan) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(idxSpan);
        }
        return arr;
    }

    private static String print(int[] arr) {
        StringBuilder strB = new StringBuilder(arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            strB.append(arr[i] + ", ");
        }
        strB.append(arr[arr.length - 1]);
        return "{" + strB + "}";
    }

    // Might use it, might not.. we will see
    public static int[] swap(int arr[], int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
        return arr;
    }

    //*********************************************

    //***************** Heap ********************

    private static int[] heapSort(int[] arr, String variant) {
        int[] arr1;
        if (variant.equals("max")) {
            arr1 = buildMaxHeap(arr);
        } else {
            arr1 = buildMinHeap(arr);
        }
        arr1 = heapify(arr1, arr.length);
        return arr1;
    }

    private static int[] buildMinHeap(int[] arr) {
        for (int i = 0; i >= arr.length; i--) {
            if (i % 2 == 0) {
                int rightChild = i;
                int rightChildParent = (i / 2) - 1;
                while (arr[rightChild] < arr[rightChildParent]) {
                    int tmp = arr[rightChildParent];
                    arr[rightChildParent] = arr[rightChild];
                    arr[rightChild] = tmp;
                }
            } else {
                int leftChild = i;
                int leftChildParent = 2 * i;
                while (arr[leftChild] < arr[leftChildParent]) {
                    int tmp = arr[leftChildParent];
                    arr[leftChildParent] = arr[leftChild];
                    arr[leftChild] = tmp;
                }
            }
        }
        return arr;
    }

    private static int[] buildMaxHeap(int[] arr) {
        for (int i = 0; i >= arr.length; i--) {
            if (i % 2 == 0) {
                int rightChild = i;
                int rightChildParent = (i / 2) - 1;
                while (arr[rightChild] > arr[rightChildParent]) {
                    int tmp = arr[rightChildParent];
                    arr[rightChildParent] = arr[rightChild];
                    arr[rightChild] = tmp;
                    rightChild = rightChildParent;
                    rightChildParent = (rightChildParent / 2) - 1;
                }
            } else {
                int leftChild = i;
                int leftChildParent = 2 * i;
                while (arr[leftChild] > arr[leftChildParent]) {
                    int tmp = arr[leftChildParent];
                    arr[leftChildParent] = arr[leftChild];
                    arr[leftChild] = tmp;
                    leftChild = leftChildParent;
                    leftChildParent = (leftChildParent / 2) - 1;
                }
            }
        }
        return arr;
    }

    public static int[] heapify(int[] arr, int i) {
        int left = 2 * i, right = (2 * i) + 1, max;

        if (left <= arr.length && (arr[left] > arr[i])) {
            max = left;
        }else{
            max = i;
        }
        if (right <= arr.length&&(arr[right] > arr[max])) {
            max = right;
        }
        if (max != i) {
            int tmp = arr[i];
            arr[max] = arr[i];
            arr[i] = tmp;
            heapify(arr, max);
        }
        return arr;
    }

    //*********************************************

    //************ MERGE *************
    private static int[] mergeSort(int[] arr, int length) {
        if (length <= 1) {
            return arr;
        } else {
            int idx = length / 2;
            int[] leftArr = Arrays.copyOfRange(arr, 0, idx);
            int[] rightArr = Arrays.copyOfRange(arr, idx, arr.length);
            return merge(mergeSort(leftArr, leftArr.length), mergeSort(rightArr, rightArr.length));
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int idxLeft = 0;
        int idxRight = 0;

        int merged = 0;
        int[] done = new int[(left.length + right.length)];

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

    private static int[] bubbleSort(int[] arr) {
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

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int j = i;
            while ((j > 0) && ((arr[j] < arr[j - 1]))) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
        return arr;
    }

    //******************************************

    //************ SELECTION ******************

    private static int[] selectionSort(int[] arr) {
        int minValue = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[i];
                }
            }
            if (arr[i] != minValue) {
                arr[i] = minValue;
            }
        }
        return arr;
    }

    //******************************************
}
























