class Solution {
    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,HashMap<Integer,Integer> hm){
        if(inStart>inEnd || postStart>postEnd) return null;
        int n=postorder.length;
        TreeNode root=new TreeNode(postorder[postEnd]);
        int index=hm.get(root.val);
        int rem=index-inStart;

        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + rem - 1, hm);
root.right = build(inorder, index + 1, inEnd, postorder, postStart + rem, postEnd - 1, hm);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
    }
}