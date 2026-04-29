class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n];   // freq[i] = frequency of nums[i]
        
        // Step 1: Count frequency of each element (brute force)
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            freq[i] = count;
        }

        // Step 2: Pick the top k based on highest frequency
        int[] result = new int[k];
        boolean[] used = new boolean[n]; // avoid reusing same index

        for (int x = 0; x < k; x++) {
            int maxIndex = -1;

            for (int i = 0; i < n; i++) {
                // Skip indexes that represent the same number we already included
                if (used[i]) continue;

                // Also skip duplicates of earlier numbers
                boolean seenBefore = false;
                for (int t = 0; t < i; t++) {
                    if (nums[t] == nums[i]) {
                        seenBefore = true;
                        break;
                    }
                }
                if (seenBefore) continue;

                // Find max frequency index
                if (maxIndex == -1 || freq[i] > freq[maxIndex]) {
                    maxIndex = i;
                }
            }

            result[x] = nums[maxIndex];
            used[maxIndex] = true;
        }

        return result;
    }
}

