class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int left=0,right=0;
        int count=0;
        int sum=0;

    while(right<nums.length){
        sum+=nums[right];

        while(sum>goal && left<right){
            sum-=nums[left];
            left++;
        }
         if (sum == goal) {
                count++;
                
                // Also count all subarrays ending at 'right' with this sum
                int temp = left;
                while (temp < right && nums[temp] == 0) {
                    count++;
                    temp++;
                }
            }
            
            // Move the right pointer to expand the window
            right++;
    }
       return count;
    }
    }
