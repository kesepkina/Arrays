package com.epam.array.output;

import com.epam.array.entity.Array;
import com.epam.array.entity.JaggedArray;
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

    public void printJaggedArray(String message, JaggedArray jaggedArray) {
        int[][] values = jaggedArray.getValues();

        StringBuilder output = new StringBuilder();
        for (int[] array : values){
            output.append(Arrays.toString(array)).append("\n");
        }

        logger.log(Level.INFO, message + "\n" + output);
    }
}
