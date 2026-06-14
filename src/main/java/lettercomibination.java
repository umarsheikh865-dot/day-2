import java.util.*;

public class lettercomibination {
    // Mapping of digits to letters
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if the combination length matches input length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the string corresponding to the current digit
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

        // Loop through the letters and recurse
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        lettercomibination solver = new lettercomibination();
        String input = "23";
        List<String> output = solver.letterCombinations(input);
        
        System.out.println("Input: " + input);
        System.out.println("Combinations: " + output);
    }
}