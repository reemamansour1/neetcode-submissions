class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        // order is add shrink check
        int left = 0;
        int count = 0;
        int sum = 0;
        // let's say k = 3
        // then sum will have the three elemets 

        for (int i = 0; i < k; i++) {
             sum += arr[i];
        }

        // right will be the kth element in the arr
        // so right = k-1


        // now
        for(int right = k -1; right < arr.length; right++){


            // if i do sum += sum[right]

            // that will add the kth element twice


            // that's no good

            //so, if right is >= k
            // then we can add it
            
           
           if(right >= k){
             sum = sum + arr[right];
           }


           // if # of elements in the window is larger than k, we need to subtract the left side of the window from sum and increae left


           if(right - left + 1 > k){
                sum -= arr[left];
                left++;
            }

            // then if both works, inc count
            if(right - left + 1 == k && sum/k >= threshold){
                count++;
            }
        }
        return count;
    }
}