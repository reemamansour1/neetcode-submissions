class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      // stack 
      // push to stack for every new fleet
      // what is a new fleet
      // a fleet is when two or more cars catch up to the same speed  
      // wym a single car can be considered a single fleet
      // let's look at how to calculate the time
      // time = target - currPos / speed
      // ex2: car 1 is at p4 and s 2. Time = 3
      // car 2 is at p1 and s2. Time =  4.5
      // car 3 is at p0 and s1. Time = 10
      // car 4 is at p7 and s1. Time = 3
      // 3 and 3 same fleet so 1
      // 4.5 another fleet
      // 10 is another fleet 
      // so total fleets is 3 booooom
      // different times does NOT MEAN new fleets
      // if a car is catching up to another car, that means, same fleet
      // if a car is going faster, that means a different fleet

      Stack<Double> stack = new Stack<>();
      int n = position.length;
      double[][] cars = new double[n][2];
      for(int i = 0; i<n; i++){
        cars[i][0] = position[i];
        cars[i][1] = speed[i];
      }
      Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
      // do i create a for loop here to go through the cars to calcule the time and then add it to the slack if it is a fleet?
      for(int i = 0; i<n; i++){
        double time = (target - cars[i][0])/cars[i][1];
        // if the new time is larger then we are adding a new fleet otherwise do nothing?
        // yes no poping in this question
        // alse we check if stack is empty or if the new time is larger than we is in the peek of the stack
        if(stack.isEmpty() || time > stack.peek()){
            stack.push(time);
        }
      }
     return stack.size();
    }
}
