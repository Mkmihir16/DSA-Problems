
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return calc(nums,k)-calc(nums,k-1);
    }
    public static int calc(int[] nums,int k){
        HashMap<Integer, Integer> old = new HashMap<>();
        int l = 0, r = 0, count = 0;
        if(nums.length==k) return 1;
        
        while (r < nums.length) {
            old.put(nums[r], old.getOrDefault(nums[r], 0) + 1);

            while (old.size() > k) {
                old.put(nums[l], old.get(nums[l]) - 1);
                if (old.get(nums[l]) == 0) {
                    old.remove(nums[l]);
                }
                l++;
            }

            // if (old.size() == k) {
            //     int temp = l;
            //     HashMap<Integer, Integer> newmap = new HashMap<>(old);
            //     while (newmap.size() == k) {
            //         count++;
            //         newmap.put(nums[temp], newmap.get(nums[temp]) - 1);
            //         if (newmap.get(nums[temp]) == 0) {
            //             newmap.remove(nums[temp]);
            //         }
            //         temp++;
            //     }
            // }
            count+=r-l+1;
            r++;
        }
    return count;
    }
}
