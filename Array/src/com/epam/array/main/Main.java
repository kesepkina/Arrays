package com.epam.array.main;

import com.epam.array.creator.ArrayFilling;
import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayServiceException;
import com.epam.array.output.ConsoleOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        ArrayFilling arrayFilling = new ArrayFilling();
        ConsoleOutput output = new ConsoleOutput();

        CustomArray arrayFromFile = new CustomArray();
        CustomArray randomArray = new CustomArray();

        try {
            arrayFilling.fillArrayFromTxtFile(arrayFromFile);
        } catch (ArrayServiceException e) {
            logger.error(e);
        }

        output.printArray("Array, filled with elements from file:", arrayFromFile);

        arrayFilling.fillArrayWithRandom(randomArray, -200, 345, 5);
        output.printArray("Array, filled with random elements:", randomArray);
    }

}
