package com.mycompany.practice; // Ensure this matches your project's package structure

public class longcommonprefix {

    // This is your main method - this is required to make the "Run" button work
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Testing the code with an example
        String[] input = {"flower", "flow", "flight"};
        String result = sol.longestCommonPrefix(input);
        
        System.out.println("The Longest Common Prefix is: " + result);
    }
}

// Your Solution class remains the same
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix...
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}