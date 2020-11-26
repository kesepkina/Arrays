package com.epam.array.creator;

import com.epam.array.entity.CustomArray;
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
    private final static String FILE_PATH = "res/data/Array.txt";

    public CustomArray createFibonacciSequence(int max) {
        int firstSummand = 0;
        int secondSummand = 1;
        CustomArray fibonacciSequence = new CustomArray(new int[]{0, 1});

        int sum = secondSummand;
        while (sum < max) {
            sum = firstSummand + secondSummand;
            fibonacciSequence.add(sum);
            firstSummand = secondSummand;
            secondSummand = sum;
        }

        return fibonacciSequence;
    }

    public void fillArrayFromTxtFile(CustomArray array) throws IOException {

        Path path = Paths.get(FILE_PATH);
        try (Stream<String> stream = Files.lines(path)) {
            int[] numbersFromFile = stream.mapToInt(x -> Integer.valueOf(x)).toArray();
            array.add(numbersFromFile);
        }
    }

    public void fillArrayWithRandom(CustomArray array, int minValue, int maxValue, int length) {
        Random random = new Random();
        int nextValue;

        for (int i = 0; i < length; i++) {
            nextValue = (random.nextInt(Math.abs(maxValue - minValue) + 1)) + minValue;
            array.add(nextValue);
        }

    }
}
