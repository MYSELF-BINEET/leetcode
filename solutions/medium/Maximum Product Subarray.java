// Title: Maximum Product Subarray
            // Difficulty: Medium
            // Language: Java
            // Link: https://leetcode.com/problems/maximum-product-subarray/


            currentMin = Math.min(
                currentValue,
                Math.min(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );

            // Record the best product found anywhere so far.
            if (currentMax > maxProduct) {
                maxProduct = currentMax;
            }
        }

        return (int)maxProduct;
    }
}
