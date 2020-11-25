package com.epam.array.test.service;

import com.epam.array.entity.Array;
import com.epam.array.exception.ArrayServiceException;
import com.epam.array.exception.NumberServiceException;
import com.epam.array.service.ArrayService;
import com.epam.array.service.FindingService;
import com.epam.array.service.SortingService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class ArrayServiceTest {
    private static Logger logger = LogManager.getLogger();

    FindingService findingService = new FindingService();
    SortingService sortingService = new SortingService();
    Array array;

    @Test
    public void testBubbleSortTrue() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        Array expected = new Array(new int[]{-34, 1, 2, 2, 5, 22, 345, 555, 654});
        sortingService.bubbleSort(array);
        assertEquals(array, expected);
    }

    @Test
    public void testHeapSortTrue() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        Array expected = new Array(new int[]{-34, 1, 2, 2, 5, 22, 345, 555, 654});
        sortingService.heapSort(array);
        assertEquals(array, expected);
    }

    @Test
    public void testQuickSortTrue() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        Array expected = new Array(new int[]{-34, 1, 2, 2, 5, 22, 345, 555, 654});
        sortingService.quickSort(array);
        assertEquals(array, expected);
    }

    @Test
    public void testFindFirstIndexOfElementTrue() {
        array = new Array(new int[]{-34, 1, 2, 2, 5, 22, 345, 555, 654});
        int expected = 2;
        int actual = -1;
        try {
            sortingService.quickSort(array);
            actual = findingService.findFirstIndexOfElement(array, 2);
        } catch (ArrayServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);

    }

    @Test
    public void testFindFirstIndexOfElementException1() {
        assertThrows(ArrayServiceException.class, () -> findingService.findFirstIndexOfElement(new Array(), 3));

    }

    @Test
    public void testFindFirstIndexOfElementException2() {
        array = new Array(new int[]{-34, 1, 2, 2, 5, 22, 345, 555, 654});
        assertThrows(NoSuchElementException.class, () -> findingService.findFirstIndexOfElement(array, 3));

    }

    @Test
    public void testFindMaxElementTrue() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        int expected = 654;
        int actual = 0;
        try {
            actual = findingService.findMaxElement(array);
        } catch (ArrayServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMinElement() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        int expected = -34;
        int actual = 0;
        try {
            actual = findingService.findMinElement(array);
        } catch (ArrayServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllPrimesTrue() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555, 2, 5, 2});
        Array expected = new Array(new int[]{2, 5, 2});
        Array actual = null;
        try {
            actual = findingService.findAllPrimes(array);
        } catch (ArrayServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllPrimesException() {
        array = new Array(new int[]{1, 22, -34, 345, 654, 555});
        assertThrows(NoSuchElementException.class, () -> findingService.findAllPrimes(array));

    }

    @Test
    public void testFindFibonacciNumbersTrue() {
        array = new Array(new int[]{1, 22, 2, 6765, 17711, 654, 555});
        Array expected = new Array(new int[]{1, 2, 6765, 17711});
        Array actual = null;
        try {
            actual = findingService.findFibonacciNumbers(array);
        } catch (ArrayServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);
    }


    @Test
    public void testFindFibonacciNumbersException() {
        array = new Array(new int[]{4, 22, 654, 555});
        assertThrows(NoSuchElementException.class, () -> findingService.findFibonacciNumbers(array));
    }

    @Test
    public void testFindThreeDigitNumbersWithoutIdenticalDigitsTrue() {
        array = new Array(new int[]{1, 22, 2, 6765, 17711, 654, 555});
        Array expected = new Array(new int[]{654});
        Array actual = null;
        try {
            actual = findingService.findThreeDigitNumbersWithoutIdenticalDigits(array);
        } catch (ArrayServiceException | NumberServiceException e) {
            logger.log(Level.ERROR, e);
        }
        assertEquals(actual, expected);
    }

}