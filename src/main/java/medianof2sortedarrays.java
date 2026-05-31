public class medianof2sortedarrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // correct partition found
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY)
                          + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }

            // move left
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }

            // move right
            else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}