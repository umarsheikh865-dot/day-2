public class container {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            // Distance between lines
            int width = right - left;

            // Smaller height
            int minHeight = Math.min(height[left], height[right]);

            // Water stored
            int area = width * minHeight;

            // Update maximum area
            if (area > maxArea) {
                maxArea = area;
            }

            // Move the smaller wall
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println("Maximum Water = " + result);
    }
}