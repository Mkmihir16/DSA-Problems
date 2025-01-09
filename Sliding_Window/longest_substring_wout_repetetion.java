import java.util.*;
class longest_substring_wout_repetetion {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int count=0,left=0,right=0;
        for(;right<s.length();right++){
                while(hs.contains(s.charAt(right)))
                {
                hs.remove(s.charAt(left));
                left++;
                }
                count=Math.max(right+1-left,count);
                hs.add(s.charAt(right));
        }
        return count;
    }
    public static void main(String[] args) {
        longest_substring_wout_repetetion obj=new longest_substring_wout_repetetion();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}