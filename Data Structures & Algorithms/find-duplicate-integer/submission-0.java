class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
    
    // Phase 1: Find where slow and fast meet (they're in the cycle)
    while (true) {
        slow = nums[slow];
        fast = nums[nums[fast]];
        if (slow == fast) break;
    }
    
    // Phase 2: Find cycle start (the duplicate)
    int slow2 = 0;
    while (slow != slow2) {
        slow = nums[slow];
        slow2 = nums[slow2];
    }
    return slow;
    }
}
