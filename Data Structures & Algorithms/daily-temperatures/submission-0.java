class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack is basically to store the indicies 
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++){
            // if the first part of the if statement is false; it does not even look at pt2
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int waiting = stack.pop();
                result[waiting] = i - waiting;
            }
            stack.push(i);
        }
        return result;
    }
}
