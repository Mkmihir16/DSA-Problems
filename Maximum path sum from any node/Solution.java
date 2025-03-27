class Solution {
    int maxSum=Integer.MIN_VALUE;
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here
        findMaxUtil(node);
        return maxSum;
    }
    int findMaxUtil(Node node){
        if(node==null) return 0;
        
        int left=Math.max(0,findMaxUtil(node.left));
        int right=Math.max(0,findMaxUtil(node.right));
        
        int currentMax=left+right+node.data;
        maxSum=Math.max(maxSum,currentMax);
        return node.data+Math.max(left,right);
    }
}