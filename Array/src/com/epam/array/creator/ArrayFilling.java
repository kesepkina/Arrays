package com.epam.array.creator;

import com.epam.array.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class ArrayFilling {
    private static Logger logger = LogManager.getLogger();

    public Array createFibonacciSequence(int max) {
        int firstSummand = 0;
        int secondSummand = 1;
        Array fibonacciSequence = new Array(new int[]{0, 1});

        int sum = secondSummand;
        while (sum < max) {
            sum = firstSummand + secondSummand;
            fibonacciSequence.add(sum);
            firstSummand = secondSummand;
            secondSummand = sum;
        }

        return fibonacciSequence;
    }

    public void fillArrayFromTXTFile(Array array) {

        Path path = Paths.get("Array.txt");
        try (Stream<String> stream = Files.lines(path)) {
            int[] numbersFromFile = stream.mapToInt(x -> Integer.valueOf(x)).toArray();
            array.add(numbersFromFile);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public void fillArrayWithRandom(Array array, int minValue, int maxValue, int length) {
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array.add((int) (random.nextInt(Math.abs(maxValue - minValue) + 1)) + minValue);
        }

    }
}
