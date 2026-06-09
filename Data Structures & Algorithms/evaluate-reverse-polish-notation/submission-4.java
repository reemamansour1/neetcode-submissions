class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // stack first in last out
        // do i need to store every element in this array in the stack then loop through the stack? 
        // if(!stack.isEmpty){// here do the logic}
        // but do i create a stack of strings then convert the string to character or integers so it could read the result?
        int result = 0;
        for(String s : tokens){
            if(!s.equals("+") && !s.equals("/") && !s.equals("-") && !s.equals("*")){
                stack.push(Integer.parseInt(s));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("+")){
                    stack.push(a + b);
                }else if (s.equals("-")){
                    stack.push(b-a);
                }else if(s.equals("*")){
                    stack.push(a * b);
                }else{
                    stack.push(b/a);
                }

            }
        }
        return stack.pop();
    
    }
}
