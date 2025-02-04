class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        Stack<Integer> s=new Stack<Integer>();
        int max=1;
        int min=1;
        for(int i=0;i<nums.length;i++){
            if(s.isEmpty()){
                s.push(nums[i]);
            }
            else{
            if(s.peek()>=nums[i]){
                int count=0;
                while(!s.isEmpty()){
                    s.pop();
                    count++;
                }
                max=Math.max(count,max);
            }
                s.push(nums[i]);
            }
        }
        int count=0;
        while(!s.isEmpty()){
            count++;
            s.pop();
        }
        max=Math.max(count,max);

        for(int i=0;i<nums.length;i++){
            if(s.isEmpty()){
                s.push(nums[i]);
            }
            else{
            if(s.peek()<=nums[i]){
                int newcount=0;
                while(!s.isEmpty()){
                    s.pop();
                    newcount++;
                }
                min=Math.max(newcount,min);
            }
                s.push(nums[i]);
            }
        }
        count=0;
        while(!s.isEmpty()){
            count++;
            s.pop();
        }
        min=Math.max(count,min);
        return Math.max(max,min);
    }
}