public class zigzagconvert {
    public String convert(String s, int numRows) {
        // Edge case: If 1 row or string shorter than rows, no conversion needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create an array of StringBuilders, one for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Flip direction at the top (0) or bottom (numRows - 1)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move the pointer
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}