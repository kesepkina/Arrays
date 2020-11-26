package com.epam.array.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] values;

    public CustomArray(int[] values) {
        this.values = values;
    }

    public CustomArray(int length) {
        this.values = new int[length];
    }

    public CustomArray() {
        this.values = new int[0];
    }

    public void add(int value) {
        int[] updatedArray = new int[this.values.length + 1];

        for (int i = 0; i < this.values.length; i++) {
            updatedArray[i] = this.values[i];
        }
        updatedArray[updatedArray.length - 1] = value;

        this.values = updatedArray;
    }

    public void add(int... values) {

        int[] updatedArray = new int[this.values.length + values.length];

        for (int i = 0; i < this.values.length; i++) {
            updatedArray[i] = this.values[i];
        }
        for (int i = this.values.length, j = 0; j < values.length; i++, j++) {
            updatedArray[i] = values[j];
        }

        this.values = updatedArray;
    }

    public int getValue(int i) {
        return values[i];
    }

    public int[] getValues() {

        int[] copiedValues = new int[this.values.length];

        for (int i = 0; i < values.length; i++) {
            copiedValues[i] = values[i];
        }
        return copiedValues;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray array = (CustomArray) o;
        if (values.length != array.values.length) return false;
        int i = 0;
        while (i < values.length) {
            if (values[i] != array.values[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("values=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }
}
