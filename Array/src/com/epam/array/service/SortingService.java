package com.epam.array.service;

import com.epam.array.entity.Array;

public class SortingService {

    public void bubbleSort(Array array) {
        int[] sortingArray = array.getValues();

        if (sortingArray.length == 0) return;

        boolean isSorted = false;
        int extra;
        int last = sortingArray.length - 1;

        while (!isSorted && last != 0) {
            isSorted = true;
            for (int i = 0; i < last; i++) {
                if (sortingArray[i] > sortingArray[i + 1]) {
                    extra = sortingArray[i];
                    sortingArray[i] = sortingArray[i + 1];
                    sortingArray[i + 1] = extra;
                    isSorted = false;
                }
            }
            last--;
        }

        array.setValues(sortingArray);
    }

    public void heapSort(Array array) {
        int[] sortingArray = array.getValues();

        if (sortingArray.length == 0) return;

        int length = sortingArray.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(sortingArray, length, i);
        }

        int extra;
        for (int i = length - 1; i >= 0; i--) {
            // swap first and last element
            extra = sortingArray[0];
            sortingArray[0] = sortingArray[i];
            sortingArray[i] = extra;

            heapify(sortingArray, i, 0);
        }
        array.setValues(sortingArray);
    }

    // creates a max heap
    private void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // if the leftChild is larger than parent
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // if the leftChild is larger than parent
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // if largest was changed
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public void quickSort(Array array) {
        int[] sortingArray = array.getValues();

        if (sortingArray.length == 0) return;

        int length = sortingArray.length;
        quickSort(sortingArray, 0, length - 1);

        array.setValues(sortingArray);
    }

    protected void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        int extra;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                extra = array[counter];
                array[counter] = array[i];
                array[i] = extra;
                counter++;
            }
        }
        extra = array[pivot];
        array[pivot] = array[counter];
        array[counter] = extra;

        return counter;
    }

}
