class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
    
    // Phase 1: Find where slow and fast meet (they're in the cycle)
    // my question is what are we exactly doing for this for loop
    // like we are treating the array as a linked list 
    // ok got this part
    // so index 0 -> 1 -> go to index 1 -> 2 -> go to index 2 -> 3 -> go to index 3 -> 2 -> boom I detected a cycle 

    // so what does it mean that we found a cycle?
    // what does the cycle tells me?
    // now it breaks, so it means fast and slow are what 
    // i just do not understand the idea of the approach
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
