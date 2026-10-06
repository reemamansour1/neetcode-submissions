class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
             sum += arr[i];
        }

        for(int right = k -1; right < arr.length; right++){
            // what i am thinking here is to have sum the first three and then 
           
           // how am i supposed to put the value for sum?
           if(right >= k){
             sum = sum + arr[right];
           }

           if(right - left + 1 > k){
                sum -= arr[left];
                left++;
            }
            if(right - left + 1 == k && sum/k >= threshold){
                count++;
            }
        }
        return count;
    }
}