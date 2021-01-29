package com.dziedzic.interview.task2;

public class PairFinder {

    public void findPairsEqualToValue(int[] array, int value) {
        if (array.length < 2)
            return;
        HeapSort.sort(array);
        findPairs(array, value);
    }

    private void findPairs(int[] array, int value) {
        var stringBuilder = new StringBuilder();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == value) {
                int helper = right;
                while(left < helper && currentSum == value){
                    stringBuilder.append(array[left]).append(" ").append(array[helper]).append("\n");
                    helper--;
                    currentSum = array[left] + array[helper];
                }
                left++;
            } else if (array[left] + array[right] < value)
                left++;
            else
                right--;
        }
        System.out.println(stringBuilder.toString());
    }
}
