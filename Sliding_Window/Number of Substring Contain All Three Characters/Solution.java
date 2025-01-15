class Solution {
    public boolean check(String s,int arr[]){
        if(arr[0]>0 && arr[1]>0 ){
            if(arr[2]>0){
                return true;
            }        
        } 
        return false;
    }

    public int numberOfSubstrings(String s) {
        int arr[]=new int[3];
        int count=0;
        int l=0,r=0;
        while(r<s.length() && l<s.length()){
        arr[s.charAt(r)-'a']++;

        while(check(s,arr)){
            count+=s.length()-r;
            arr[s.charAt(l)-'a']--;
            l++;
        }
        r++;
        }
        return count;
    }
}