class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // No non-empty subarray exists.
        if (n == 0) {
            return 0;
        }

        long currentMax = nums[0];
        long currentMin = nums[0];
        long maxProduct = nums[0];

        for (int index = 1; index < n; index++) {
            long currentValue = nums[index];

            /*
             * Preserve both previous states because
             * a negative value can swap their roles.
             */
            long previousMax = currentMax;
            long previousMin = currentMin;

            /*
             * Either start fresh or extend one of
             * the previous product subarrays.
             */
            currentMax = Math.max(
                currentValue,
                Math.max(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );

            currentMin = Math.min(
                currentValue,
                Math.min(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );

            // Record the best product found anywhere so far.
            if (currentMax > maxProduct) {
                maxProduct = currentMax;
            }
        }

        return (int)maxProduct;
    }
}