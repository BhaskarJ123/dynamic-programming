package DynamicProg;
public class minCostStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int dest = cost.length;
        int ans = Math.min(minCost(cost,0,dest),minCost(cost,1,dest));
        System.out.println(ans);
    }
    static int minCost(int[] cost,int src,int dest){
        if(src>=dest)
            return 0;
        int cost1 = cost[src] + minCost(cost,src+1,dest);
        int cost2 = cost[src] + minCost(cost,src+2,dest);
        int answer = Math.min(cost1,cost2);
        return answer;
    }
}
