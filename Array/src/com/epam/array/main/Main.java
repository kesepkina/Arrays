package com.epam.array.main;

import com.epam.array.creator.ArrayFilling;
import com.epam.array.entity.Array;
import com.epam.array.output.ConsoleOutput;

public class Main {

    public static void main(String... args) {
        ArrayFilling arrayFilling = new ArrayFilling();
        ConsoleOutput output = new ConsoleOutput();

        Array arrayFromFile = new Array();
        Array randomArray = new Array();

        arrayFilling.fillArrayFromTXTFile(arrayFromFile);
        output.printArray("Array, filled with elements from file:", arrayFromFile);

        arrayFilling.fillArrayWithRandom(randomArray, -200, 345, 5);
        output.printArray("Array, filled with random elements:", randomArray);
    }

}
