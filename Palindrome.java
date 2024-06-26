package problems;

public class Palindrome {

    /*
    *
    * Given an integer x, return true if x is a palindrome, and false otherwise.
    *
    * */
    public boolean isPalindrome(int x) {
        char[] chars = (String.valueOf(x)).toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
}
