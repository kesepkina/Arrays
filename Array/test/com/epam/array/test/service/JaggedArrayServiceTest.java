package com.epam.array.test.service;

import com.epam.array.entity.JaggedArray;
import com.epam.array.service.JaggedArrayService;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayServiceTest {
    JaggedArray actual = new JaggedArray(6);
    {
        actual.addArray(0, 1, 2, -1);
        actual.addArray(1, 0, -45, -12, -2);
        actual.addArray(2, 12, 234, 654, 234);
        actual.addArray(3, -23456, -345678, 3, -5, -3, -67);
        actual.addArray(4, 7235896);
        actual.addArray(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
    }
    JaggedArrayService service = new JaggedArrayService();

    @Test
    public void sortBySumsTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(0, -23456, -345678, 3, -5, -3, -67);
            expected.addArray(1, 0, -45, -12, -2);
            expected.addArray(2, 1, 2, -1);
            expected.addArray(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(4, 12, 234, 654, 234);
            expected.addArray(5, 7235896);
        }

        service.sortBySums(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBySumsDescTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(0, 7235896);
            expected.addArray(1, 12, 234, 654, 234);
            expected.addArray(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(3, 1, 2, -1);
            expected.addArray(4, 0, -45, -12, -2);
            expected.addArray(5, -23456, -345678, 3, -5, -3, -67);
        }

        service.sortBySumsDesc(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortByMaxesTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(5, 7235896);
            expected.addArray(4, 12, 234, 654, 234);
            expected.addArray(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(2, -23456, -345678, 3, -5, -3, -67);
            expected.addArray(1, 1, 2, -1);
            expected.addArray(0, 0, -45, -12, -2);
        }

        service.sortByMaxes(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortByMaxesDescTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(0, 7235896);
            expected.addArray(1, 12, 234, 654, 234);
            expected.addArray(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(3, -23456, -345678, 3, -5, -3, -67);
            expected.addArray(4, 1, 2, -1);
            expected.addArray(5, 0, -45, -12, -2);
        }

        service.sortByMaxesDesc(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortByMinsTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(5, 7235896);
            expected.addArray(4, 12, 234, 654, 234);
            expected.addArray(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(2, 1, 2, -1);
            expected.addArray(1, 0, -45, -12, -2);
            expected.addArray(0, -23456, -345678, 3, -5, -3, -67);
        }

        service.sortByMins(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortByMinsDescTestTrue() {
        JaggedArray expected = new JaggedArray(6);
        {
            expected.addArray(0, 7235896);
            expected.addArray(1, 12, 234, 654, 234);
            expected.addArray(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
            expected.addArray(3, 1, 2, -1);
            expected.addArray(4, 0, -45, -12, -2);
            expected.addArray(5, -23456, -345678, 3, -5, -3, -67);
        }

        service.sortByMinsDesc(actual);
        assertEquals(actual, expected);
    }
}
