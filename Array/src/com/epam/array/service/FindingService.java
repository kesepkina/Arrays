package com.epam.array.service;

import com.epam.array.creator.ArrayFilling;
import com.epam.array.entity.Array;
import com.epam.array.exception.ArrayServiceException;
import com.epam.array.exception.NumberServiceException;

import java.util.NoSuchElementException;
import java.util.OptionalInt;

public class FindingService {

    public int findFirstIndexOfElement(Array array, int searchingFor) throws ArrayServiceException {
        int[] arrayForSearch = array.getValues();

        int length = arrayForSearch.length;
        if (length == 0) {
            throw new ArrayServiceException("array is empty");
        }

        int i = 0;
        do{
            if (arrayForSearch[i] > arrayForSearch[i+1]) {
                throw new ArrayServiceException("array isn't sorted");
            }
            i++;
        } while(i < arrayForSearch.length - 1);

        return (binarySearch(arrayForSearch, searchingFor, 0, length - 1)).getAsInt();
    }

    private OptionalInt binarySearch(int[] array, int searchingFor, int first, int last) {

        if (last < first) {
            return OptionalInt.empty();
        }

        int middle = (first + last) / 2;

        if (searchingFor == array[middle]) {
            return OptionalInt.of(middle);
        } else if (searchingFor < array[middle]) {
            return binarySearch(array, searchingFor, first, middle - 1);
        } else {
            return binarySearch(array, searchingFor, middle + 1, last);
        }
    }

    public int findMaxElement(Array array) throws ArrayServiceException {
        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        int max = values[0];
        for (int i = 1; i < length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public int findMinElement(Array array) throws ArrayServiceException {
        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        int min = values[0];
        for (int i = 1; i < length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public Array findAllPrimes(Array array) throws ArrayServiceException {
        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        NumberService numberService = new NumberService();
        Array primes = new Array();
        for (int value : values) {
            if (numberService.isPrime(value)) {
                primes.add(value);
            }
        }

        if (primes.getValues().length == 0) {
            throw new NoSuchElementException("array hasn't any prime number");
        }

        return primes;
    }

    public Array findFibonacciNumbers(Array array) throws ArrayServiceException {

        ArrayFilling arrayFilling = new ArrayFilling();

        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        Array fibonacciNumbers = new Array();
        int maxElement = findMaxElement(array);
        Array fibonacciSequence = arrayFilling.createFibonacciSequence(maxElement);

        for (int value : values) {
            if (contains(fibonacciSequence, value)) {
                fibonacciNumbers.add(value);
            }
        }

        if (fibonacciNumbers.getValues().length == 0) {
            throw new NoSuchElementException("array hasn't any numbers from Fibonacci sequence");
        }

        return fibonacciNumbers;
    }

    public boolean contains(Array sortedArray, int value) {
        int[] arrayForSearch = sortedArray.getValues();

        return (binarySearch(arrayForSearch, value, 0, arrayForSearch.length - 1)).isPresent();
    }



    public Array findThreeDigitNumbersWithoutIdenticalDigits(Array array) throws ArrayServiceException, NumberServiceException {
        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        Array finalArray = new Array();
        NumberService numberService = new NumberService();
        for (int value : values) {
            if (numberService.isThreeDigitNumber(value) && !numberService.hasIdenticalDigits(value)) {
                finalArray.add(value);
            }
        }

        if (finalArray.getValues().length == 0) {
            throw new NoSuchElementException("array hasn't any three-digit numbers without identical digits");
        }

        return finalArray;
    }
}
