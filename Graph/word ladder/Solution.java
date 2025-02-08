class Solution {
    public class Pair{
        String str;
        int dis;

        Pair(String str,int dis)
        {
        this.str=str;
        this.dis=dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();

        // q.add(new Pair(beginWord,0));
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        
        if(hs.contains(beginWord)){
            hs.remove(beginWord);
        }
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            hs.remove(p.str);
            String word=p.str;
            int dist=p.dis;

            for(int i=0;i<word.length();i++){
                char[] wordArray=word.toCharArray();
                for(char m='a';m<='z';m++){
                    wordArray[i]=m;
                    String newstr=new String(wordArray);
                    if(hs.contains(newstr) && newstr.equals(endWord))return dist+1;
                    if(hs.contains(newstr)){
                        hs.remove(newstr);
                        q.add(new Pair(newstr,dist+1));
                    }
                }
            }
        }
        return 0;
    }
}