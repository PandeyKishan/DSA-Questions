
import java.util.Scanner;

// Solution class to check if a string is a palindrome
class Solution {
    // Function to check if a string is a palindrome
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        // Loop to check if the string is a palindrome
        while (left < right) {
            // Skip non-alphanumeric characters on the left side
            if (!Character.isLetterOrDigit(s.charAt(left))) 
                left++;
            // Skip non-alphanumeric characters on the right side
            else if (!Character.isLetterOrDigit(s.charAt(right))) 
                right--;
            // If characters are different, it's not a palindrome
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
                return false;
            else {
                // Move towards the middle if characters are the same
                left++; 
                right--;
            }
        }
        return true;  // The string is a palindrome if the loop completes
    }

    public boolean isPalindromeUsingRecursion(String s, int left, int right) {
        // If characters cross each other, this means half the string has been traversed, which means that the string is a palindrome.
        if (left >= right) {
            return true;
        }
        // If characters are different, it's not a palindrome
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
            return false;
        // Don't use post operators (left++, right--) since original value is passed and variables are changed only after the function call
        // which isn't possible in recursion ever, due to which it enters an infinite loop. So use pre operators (++left, --right) or +1, -1.
        return isPalindromeUsingRecursion(s, left + 1, right - 1);
    }

}

// Main class to test the Solution class
public class checkPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();

        boolean ans = solution.isPalindrome(str);

        // Output the result
        if (ans) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        ans = solution.isPalindromeUsingRecursion(str, 0, str.length() - 1);
        if (ans) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
