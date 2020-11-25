package com.epam.array.entity;

import java.util.Arrays;

public class JaggedArray {
    private int[][] values;

    public JaggedArray(int[][] values) {
        this.values = values;
    }

    public JaggedArray(int length) {
        this.values = new int[length][];
    }

    public JaggedArray() {
        this.values = new int[0][];
    }

    public void addArray(int i, int... values) {
        this.values[i] = values;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        if (values.length != that.values.length) return false;
        int i = 0, j = 0;
        while (i < values.length) {
            if (values[i].length != that.values[i].length) return false;
            while (j < values[i].length) {
                if (values[i][j] != that.values[i][j]) {
                    return false;
                }
                j++;
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
        final StringBuilder sb = new StringBuilder("JaggedArray{");
        sb.append("values=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }
}
