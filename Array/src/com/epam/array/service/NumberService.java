package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayServiceException;
import com.epam.array.exception.NumberServiceException;

public class NumberService {

    protected boolean isPrime(int value) {
        if (value < 2) return false;
        boolean isPrime = true;

        int i = 2;
        while (i < value) {
            if (value % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }

        return isPrime;
    }

    protected boolean hasIdenticalDigits(int value) throws NumberServiceException, ArrayServiceException {
        if (value < 10 && value > -10) {
            throw new NumberServiceException("value is one-digit");
        }

        CustomArray digits = new CustomArray();
        int i = 1;
        int digit;
        do {
            digit = Math.floorDiv(value, i) % 10;
            digits.add(digit);
            i *= 10;
        } while (i < value);

        CustomArrayService arrayService = new CustomArrayService();
        return arrayService.hasIdenticalElements(digits);
    }
}
