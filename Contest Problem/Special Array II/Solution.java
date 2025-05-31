class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] arr=new int[nums.length];
        int prev=0;
        for(int i=1;i<nums.length;i++){
            int num1=nums[i-1]%2;
            int num2=nums[i]%2;
            if(num1==num2){
                arr[i]=prev+1;
            }
            else{
                arr[i]=prev;
            }
            prev=arr[i];
        }
        boolean[] res=new boolean[queries.length];
        int in=0;
        for(int[] temp:queries){
            int index1=temp[0];
            int index2=temp[1];
            if(arr[index2]-arr[index1]==0){
                res[in]=true;
            }
            in++;
        }
        return res;
    }
}
