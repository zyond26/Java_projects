package BTTH;

//Bai Tap 2
//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal substring consisting of non-space characters only.
//Example 1:
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//
//Example 2:
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//
//Example 3:
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.

import java.util.Scanner;

public class Count_the_last_word {
    public static int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        int lastIndex = s.length() - 1;

        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            length++;
            lastIndex--;
        }

        return length;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int length = lengthOfLastWord(input);
        System.out.println("Length of the last word: " + length);
    }
}






//-----------------------------cachs 2 --------------------------

/*class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        // Find the last space in the string after trimming
        int lastSpaceIndex = s.lastIndexOf(' ');
        // The length of the last word is the difference between the string's length
        // and the index of the last space
        return s.length() - lastSpaceIndex - 1;
    }
}
*/



