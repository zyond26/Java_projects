package BTTH;

//Bai Tap 3
//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.

//Example 1:
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//
//Example 2:
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//
//Example 3:
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].


public class BT_plus_one {
    public int[] plusOne(int[] digits) {
        // Start from the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // Increment the digit
            digits[i]++;
            // If the digit is less than 10, we don't need to carry over
            if (digits[i] < 10) {
                return digits;
            }
            // Otherwise, set the current digit to 0 and continue to the next digit
            digits[i] = 0;
        }
        // If we reach here, it means we need to add an extra digit at the beginning
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the most significant digit to 1
        return result;
    }

    public static void main(String[] args) {
        BT_plus_one solution = new BT_plus_one();

        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.println("Example 1:");
        printArray(result1);

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("Example 2:");
        printArray(result2);

        int[] digits3 = {9};
        int[] result3 = solution.plusOne(digits3);
        System.out.println("Example 3:");
        printArray(result3);
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
