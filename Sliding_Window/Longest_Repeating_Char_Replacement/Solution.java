package Sliding_Window.Longest_Repeating_Char_Replacement;

public class Solution {
        public static int fun(String s,char c,int k){
            int left=0,right=0;
            int count=0,maxcount=0;
            for(;right<s.length();right++){
                if(s.charAt(right)!=c){
                    k--;
                }
                while(k<0){
                    if(s.charAt(left)!=c){
                        k++;
                    }
                    left++;
                }
                maxcount=Math.max(right-left+1,maxcount);
            }
            return maxcount;
        }
        public int characterReplacement(String s, int k) {
            int maxcount=0;
            int[] arr=new int[26];
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'A']++;
            }
    
            for(int i=0;i<arr.length;i++){
                if(arr[i]>0){
                    char c=(char)(i+65);
                    int count=fun(s,c,k);
                    maxcount=Math.max(count,maxcount);
                }
            }
            return maxcount;
        }
    }
