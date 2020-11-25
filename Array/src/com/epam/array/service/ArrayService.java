package com.epam.array.service;

import com.epam.array.entity.Array;
import com.epam.array.exception.ArrayServiceException;
import com.epam.array.exception.NumberServiceException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class ArrayService {

    public boolean hasIdenticalElements(Array array) throws ArrayServiceException {
        SortingService sortingService = new SortingService();
        int[] values = array.getValues();

        int length = values.length;
        if (length == 0) throw new ArrayServiceException("array is empty");

        boolean hasIdenticalElements = false;

        sortingService.quickSort(values, 0, length - 1);

        int i = 0;
        do {
            if (values[i] == values[i + 1]) {
                hasIdenticalElements = true;
                break;
            }
            i++;
        } while (i < length - 1);

        return hasIdenticalElements;
    }

}
