package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{
                "Winter",
                "Spring",
                "Summer",
                "Autumn"
        };
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        var result = new int[length];
        for (var index = 1; index <= length; index++) {
            result[index - 1] = index;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] array) {
        var sum = 0;
        for (var element : array) {
            sum += element;
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] array, int number) {
        for (var index = 0; index < array.length; index++) {
            if (array[index] == number) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        var reversedArray = new String[arr.length];
        for (var index = 0; index < arr.length; index++) {
            reversedArray[index] = arr[arr.length - 1 - index];
        }
        return reversedArray;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        var positivesCount = countPositives(arr);
        var result = new int[positivesCount];
        var currentIndex = 0;
        for (var element : arr) {
            if (element > 0) {
                result[currentIndex] = element;
                currentIndex += 1;
            }
        }
        return result;
    }

    private int countPositives(int[] array) {
        var count = 0;
        for (var element : array) {
            if (element > 0) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        for (var innerArray : arr) {
            sort(innerArray);
        }

        sortBySizes(arr);
        return arr;
    }

    private void sortBySizes(int[][] arrays) {
        var sizes = new int[arrays.length];
        for (var index = 0; index < arrays.length; index++) {
            sizes[index] = arrays[index].length;
        }

        for (var startIndex = 0; startIndex < arrays.length; startIndex++) {
            var minimumIndex = findMinimumIndexSince(sizes, startIndex);
            swap(arrays, startIndex, minimumIndex);
            swap(sizes, startIndex, minimumIndex);
        }
    }

    private void sort(int[] array) {
        for (var startIndex = 0; startIndex < array.length; startIndex++) {
            var minimumIndex = findMinimumIndexSince(array, startIndex);
            swap(array, startIndex, minimumIndex);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void swap(int[][] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int findMinimumIndexSince(int[] array, int startPosition) {
        var minimum = Integer.MAX_VALUE;
        var minimumIndex = -1;

        for (var index = startPosition; index < array.length; index += 1) {
            var element = array[index];
            if (element < minimum) {
                minimumIndex = index;
                minimum = element;
            }
        }

        return minimumIndex;
    }
}
