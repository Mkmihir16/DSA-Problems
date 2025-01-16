class Solution {
    public int maxScore(int[] arr, int k) {
        int total=0;
        for(int i=0;i<k;i++){
            total+=arr[i];
        }
       int n=arr.length;
        int maxScore=total;
        int right=0;
        for(int i=0;i<k;i++){
            right=arr[n-i-1];
            maxScore-=arr[k-i-1];
            maxScore+=right;
            total=Math.max(maxScore,total);
        }
        return total;
    }
}
