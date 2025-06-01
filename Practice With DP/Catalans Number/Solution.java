public class Solution {
    public static int fun(int n){
        if(n==0 || n==1){
            return 1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=fun(i)*fun(n-i-1);
        }
        return sum;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(fun(3));
    }
}
