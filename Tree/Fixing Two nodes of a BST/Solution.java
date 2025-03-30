class Solution {
    public int ind=0;
    void findInorder(Node root,List<Integer> ar){
        if(root==null){
            return;
        }
        findInorder(root.left,ar);
        ar.add(root.data);
        findInorder(root.right,ar);
    }
    void correctInorder(List<Integer> ar){
        int first=-1,second=-1;
        
        for(int i=0;i<ar.size()-1;i++){
            if(ar.get(i)>ar.get(i+1)){
                if(first==-1){
                first=i;
                }
             second=i+1;
            }
        }
        
        if(first!=-1 && second!=-1){
            int temp=ar.get(first);
            ar.set(first,ar.get(second));
            ar.set(second,temp);
        }
    }
    void correct(Node root,List<Integer> ar){
        if(root==null){
            return;
        }
        correct(root.left,ar);
        if(ar.get(ind)!=root.data){
            root.data=ar.get(ind);
        }
        ind++;
        correct(root.right,ar);
        
    }
    void correctBST(Node root) {
        // code here.
        List<Integer> ar=new ArrayList<>();
        findInorder(root,ar);
        correctInorder(ar);
        correct(root,ar);
    }
}
