package com.epam.array.output;

import com.epam.array.entity.Array;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ConsoleOutput {
    private static Logger logger = LogManager.getLogger();

    public void printArray(Array array) {
        logger.log(Level.INFO, Arrays.toString(array.getValues()));
    }

    public void printArray(String message, Array array) {
        logger.log(Level.INFO, message + " " + Arrays.toString(array.getValues()));
    }
}
