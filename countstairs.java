// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int stairs = 35;
        int base = 0;
        // int[] dp = new int[stairs];
        int[] dp2 = new int[stairs+1];
        // System.out.println(findpaths(base,stairs));
        // System.out.println(findpathDP2(base,stairs,dp2));
        System.out.println(findpathDP3(base,stairs));
    }
    static int findpaths(int src,int dest){//Recursion
        if(src == dest)
            return 1;
        if(src > dest)
            return 0;
        int path1 = findpaths(src+1,dest);
        int path2 = findpaths(src+2,dest);
        int path3 = findpaths(src+3,dest);
        int ans = path1 + path2 + path3;
        return ans;
    }
    static int findpathsDP(int src,int dest,int[] dp){//Memoisation
        if(src == dest)
            return 1;
        if(src > dest)
            return 0;
        if(dp[src]!=0)
            return dp[src];
        int path1 = findpathsDP(src+1,dest,dp);
        int path2 = findpathsDP(src+2,dest,dp);
        int path3 = findpathsDP(src+3,dest,dp);
        int ans = path1 + path2 + path3;
        dp[src] = ans;
        return ans;
    }
    static int findpathDP2(int src,int dest,int[] dp){//Tabulation
        if(dest == 1 || dest == 0)
            return 1;    
        dp[dest] = 1;
        dp[dest-1] = 1;
        dp[dest-2] = 2;
        for(int i=dest-3;i>=0;i--)
            dp[i] = dp[i+1] + dp[i+2] + dp[i+3];
        return dp[0];
    }
    static int findpathDP3(int src,int dest){//Space Optimisation
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 2;
        if(dest<2)
            return 1;
        for(int i=dest-3;i>=src;i--){
            int curr = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        }
        return prev3;
    }
}