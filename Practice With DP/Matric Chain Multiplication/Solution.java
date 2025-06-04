
public class Solution {
    public static int fun(int[] arr,int i,int j){
        if(i==j){
            return 0;
        }

        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=fun(arr,i,k);
            int cost2=fun(arr,k+1,j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int total=cost1+cost2+cost3;
            min=Math.min(min,total);
        }
        return min;
    }
    public static void main(String[] args) {
        int[] num={1,2,3,4,3};
        System.out.println(fun(num,1,num.length-1));
    }
}
