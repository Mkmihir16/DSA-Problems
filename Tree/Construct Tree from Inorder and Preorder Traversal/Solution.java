class Solution {
    public static Node build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> hm){
        
        if(preStart>preEnd || inStart>inEnd) return null;
        
        Node root=new Node(preorder[preStart]);
        int index=hm.get(root.data);
        int rem=index-inStart;
        
        root.left=build(preorder,preStart+1,preStart+rem,inorder,inStart,index-1,hm);
        root.right=build(preorder,preStart+rem+1,preEnd,inorder,index+1,inEnd,hm);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        
       Node root= build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
       return root;
    }
}
