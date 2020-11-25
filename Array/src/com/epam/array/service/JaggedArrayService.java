package com.epam.array.service;

import com.epam.array.entity.JaggedArray;

public class JaggedArrayService {

    public void sortBySums(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] sums = calculateSums(sortingArray);

       bubbleSort(sortingArray, sums);
    }

    public void sortBySumsDesc(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] sums = calculateSums(sortingArray);

        bubbleSortDesc(sortingArray, sums);
    }

    public void sortByMaxes(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] maxes = findMaxes(sortingArray);

        bubbleSort(sortingArray, maxes);
    }

    public void sortByMaxesDesc(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] maxes = findMaxes(sortingArray);

        bubbleSortDesc(sortingArray, maxes);
    }

    public void sortByMins(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] mins = findMins(sortingArray);

        bubbleSort(sortingArray, mins);
    }

    public void sortByMinsDesc(JaggedArray jaggedArray) {
        int[][] sortingArray = jaggedArray.getValues();

        if (sortingArray.length == 0) return;

        int[] mins = findMins(sortingArray);

        bubbleSortDesc(sortingArray, mins);
    }

    private int[] findMins(int[][] array) {
        int[] mins = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            mins[i] = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] < mins[i]) {
                    mins[i] = array[i][j];
                }
            }
        }
        return mins;
    }

    private int[] findMaxes(int[][] array) {
        int[] maxes = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            maxes[i] = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > maxes[i]) {
                    maxes[i] = array[i][j];
                }
            }
        }
        return maxes;
    }

    private int[] calculateSums(int[][] array) {
        int[] sums = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sums[i] = 0;
            for (int value : array[i]) {
                sums[i] += value;
            }
        }
        return sums;
    }

    private void bubbleSort(int[][] sortingArray, int[] criteria) {
        boolean isSorted = false;
        int last = sortingArray.length - 1;

        while (!isSorted && last != 0) {
            isSorted = true;
            for (int i = 0; i < last; i++) {
                if (criteria[i] > criteria[i + 1]) {
                    switchSumsAndArrays(criteria, sortingArray, i);
                    isSorted = false;
                }
            }
            last--;
        }
    }

    private void bubbleSortDesc(int[][] sortingArray, int[] criteria) {
        boolean isSorted = false;
        int last = sortingArray.length - 1;

        while (!isSorted && last != 0) {
            isSorted = true;
            for (int i = 0; i < last; i++) {
                if (criteria[i] < criteria[i + 1]) {
                    switchSumsAndArrays(criteria, sortingArray, i);
                    isSorted = false;
                }
            }
            last--;
        }
    }

    private void switchSumsAndArrays(int[] sums, int[][] jaggedArray, int i) {
        int extra;
        int[] extraArray;

        extraArray = jaggedArray[i];
        jaggedArray[i] = jaggedArray[i + 1];
        jaggedArray[i + 1] = extraArray;
        extra = sums[i];
        sums[i] = sums[i + 1];
        sums[i + 1] = extra;
    }
}
