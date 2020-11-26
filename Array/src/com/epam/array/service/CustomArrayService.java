package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayServiceException;

public class CustomArrayService {

    public boolean hasIdenticalElements(CustomArray array) throws ArrayServiceException {
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
