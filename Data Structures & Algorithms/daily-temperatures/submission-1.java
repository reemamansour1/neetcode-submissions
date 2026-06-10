class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack stores indices of days still waiting for a warmer day
        // we use while not if because one warm day can resolve MULTIPLE waiting days at once
        // if would only resolve one waiting day per iteration and miss the rest
        // result[waiting] not result[i] because we are filling in the answer for the WAITING day, not today
        // time complexity: O(n) - each index is pushed and popped at most once
        // space complexity: O(n) - stack can hold up to n indices in worst case
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int waiting = stack.pop();
                result[waiting] = i - waiting;
            }
            stack.push(i);
        }
        return result;
    }
}