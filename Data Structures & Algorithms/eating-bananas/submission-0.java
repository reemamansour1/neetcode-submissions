class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int min = right; // declared OUTSIDE the loop so it persists across iterations

        while (left < right) {
            int mid = (right - left) / 2 + left;
            int sum = 0;

            for (int i = 0; i < piles.length; i++) {
                int hoursForPile = (piles[i] + mid - 1) / mid; // ceiling division
                sum = sum + hoursForPile;
            }

            if (sum <= h) {
                min = mid;
                right = mid;   // k worked, try smaller
            } else {
                left = mid + 1; // k too slow, try bigger
            }
        }

        return min;
    }
}