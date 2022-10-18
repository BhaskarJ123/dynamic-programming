package DynamicProg;

public class fibo {
    public static void main(String[] args) {
        int n = 35;
        int[] dp = new int[n];
        System.out.println(fibo(n-1,dp));
    }
    static int fibo(int n,int[] dp){
        if(n<2)
            return n;
        if(dp[n] != 0)
            return dp[n];
        int fib1 = fibo(n-1,dp);
        int fib2 = fibo(n-2,dp);
        int res = fib1 + fib2;
        dp[n] = res;
        return res;
    }
}
