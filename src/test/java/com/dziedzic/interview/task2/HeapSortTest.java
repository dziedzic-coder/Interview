package com.dziedzic.interview.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {

    @Test
    public void sort_shouldReturnSortedArray() {
        int[] simpleArray = {2, 1, 4, 0};
        int[] expectedArray = {0, 1, 2, 4};
        HeapSort.sort(simpleArray);
        assertArrayEquals(expectedArray, simpleArray);
    }
}
