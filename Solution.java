/*
The problem, per se, is not difficult: it could be solves in many ways.
The code here is fast, clean and easy to read.
 */
public class Solution {

    public String addStrings(String num1, String num2) {

        char[] larger = num1.length() >= num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] smaller = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();

        int difference = larger.length - smaller.length;
        char carry = '0';

        for (int i = smaller.length - 1; i >= 0; i--) {
            int num = add(larger[i + difference], smaller[i], carry);
            larger[i + difference] = (char) ((num % 10) + '0');
            carry = (char) ((num / 10) + '0');
        }

        for (int i = difference - 1; i >= 0; i--) {
            int num = add(larger[i], '0', carry);
            larger[i] = (char) ((num % 10) + '0');
            carry = (char) ((num / 10) + '0');
        }

        String additionToFrontEnd = (carry != '0') ? "1" : "";
        return additionToFrontEnd + String.valueOf(larger);
    }

    public int add(char x, char y, char carry) {
        return (x - '0') + (y - '0') + (carry - '0');
    }
}
