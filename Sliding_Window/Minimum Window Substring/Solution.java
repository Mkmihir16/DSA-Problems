class Solution {
    public boolean isCheck(HashMap<Character,Integer> hm){
        for(Map.Entry<Character,Integer> e:hm.entrySet()){
            if(e.getValue()!=0){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
    //    HashMap<Character,Integer> hm=new HashMap<>();
    //     if(t.length()>s.length()) return "";
    //     for(int i=0;i<t.length();i++){
    //         hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
    //     }

    //     int right=0,left=0;
    //     int minlength=Integer.MAX_VALUE;
    //     String str="";
    //     boolean first=false;
    //     while(right<s.length() && left<s.length()){

    //         if(hm.containsKey(s.charAt(right))){
    //             first=true;
    //             int freq=hm.get(s.charAt(right));
    //             hm.put(s.charAt(right),freq-1);
    //         }

    //         if(isCheck(hm)){
    //             int length=right-left;
    //             if(length<minlength){
    //                 str=s.substring(left,right+1);
    //                 minlength=length;
    //             }
    //             first=false;
    //             left=right;
    //         }
    //         // else{
    //             if(!first){
    //                 left++;
    //             }
    //                 right++;
               
    //         // }
    //     }
    //     return str;
    
        int l=0;
        int r=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        int cnt=0;
        int sindex=-1;
        int minlen=Integer.MAX_VALUE;
        String st="";
        for(int i=0;i<t.length();i++){
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }
        while(r<s.length()){
            char ch=s.charAt(r);
            if(mpp.containsKey(ch) && mpp.get(ch)>0){   
                cnt++;
            }
            mpp.put(ch,mpp.getOrDefault(ch,0)-1);            
            while(cnt==t.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sindex=l;
                }
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))+1);
                if(mpp.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
                }
            r++;
        }
        return sindex==-1?"":s.substring(sindex,sindex+minlen);
    }
} 