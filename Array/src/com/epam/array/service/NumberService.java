package com.epam.array.service;

import com.epam.array.entity.Array;
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

    protected boolean isThreeDigitNumber(int value) {
        int divResult = Math.floorDiv(value, 100);
        return (divResult > 0) && (divResult < 10);
    }

    protected boolean hasIdenticalDigits(int value) throws NumberServiceException, ArrayServiceException {
        if (value < 10 && value > -10) {
            throw new NumberServiceException("value is one-digit");
        }

        Array digits = new Array();
        int i = 1;
        int digit;
        do {
            digit = Math.floorDiv(value, i) % 10;
            digits.add(digit);
            i *= 10;
        } while (i < value);

        ArrayService arrayService = new ArrayService();
        return arrayService.hasIdenticalElements(digits);
    }
}
