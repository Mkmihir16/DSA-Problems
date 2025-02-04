class Solution {
    public int maxAscendingSum(int[] nums) {
        // int max=Integer.MIN_VALUE;
        // int sum=0;
        // Stack<Integer> s=new Stack<>();
        // for(int i=0;i<nums.length;i++){
        //    if(s.isEmpty()){
        //     s.push(nums[i]);
        //    }
        //    else{
        //     if(s.peek()>=nums[i]){
        //         int count=0;
        //         while(!s.isEmpty()){
        //             int n=s.pop();
        //             count+=n;
        //         }
        //         max=Math.max(count,max);
        //     }
        //     s.push(nums[i]);
        //    }
        // }
        // int count=0;
        //  while(!s.isEmpty()){
        //             int n=s.pop();
        //             count+=n;
        //         }
        //          max=Math.max(count,max);
        // return max;

    //More opitimized
        int sum=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }
            else{
                sum=nums[i];
            }
           max= Math.max(sum,max);
        }
        return max;
    }
}