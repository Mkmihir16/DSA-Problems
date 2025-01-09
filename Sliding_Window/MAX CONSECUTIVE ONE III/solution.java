class Solution {
    public int longestOnes(int[] arr, int k) {
        int left=0,right=0;
        int count=0,maxcount=0;
        for(;right<arr.length;right++){
            if(arr[right]==0){
                    k--;
                }
                    while(k<0){
                        if(arr[left]==0){
                            k++;
                        }
                        left++;
                    }
            maxcount=Math.max(right-left+1,maxcount);
            }
        return maxcount;
        }
        
    }
