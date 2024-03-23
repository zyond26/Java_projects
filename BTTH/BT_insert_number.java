package BTTH;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//
//Example 2:
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//
//Example 3:
//Input: nums = [1,3,5,6], target = 7
//Output: 4

import java.util.Scanner;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int insertIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                insertIndex = i;
                break;
            }
            insertIndex = i + 1;
        }

        return insertIndex;
    }
}

public class BT_insert_number {
    public static void main(String[] args) {
        Solution solution = new Solution();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int j = 0; j < size; j++) {
            nums[j] = scanner.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int index = solution.searchInsert(nums, target);
        System.out.println("Index: " + index);

        System.out.println();
    }

}
