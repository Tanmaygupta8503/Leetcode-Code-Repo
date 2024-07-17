class Solution1 {
    Integer dp[][];
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return solve(prices , 0 , 0);
    }
    public int solve(int prices[] , int idx , int count) {
        if(idx >= prices.length) return 0;
        if(count >= 2) return 0; 
        if(dp[idx][count] != null) return dp[idx][count];
        if(count == 0){
            int op1 = -prices[idx] + solve(prices , idx + 1 , count + 1); //buy
            int op2 = 0 + solve(prices , idx + 1 , count); // skip
            return dp[idx][count] = Math.max(op1, op2);
        }
        else {
            int op2 = prices[idx] + solve(prices , idx + 1 , count + 1); // notbuy
            int op1 = 0 + solve(prices , idx + 1 , count); // skip
            return dp[idx][count] = Math.max(op1 , op2);
        }
    } 
}
class Solution {
    public int maxProfit(int[] prices) {
       int buy = prices[0];
       int profit=0;
        for(int i = 0 ; i < prices.length ; i ++){
            if(prices[i] < buy)  //find better day to buy then update buy
                buy = prices[i];
            else  // if profit = buy - prices[i] > 0 then calculate profit
                profit = Math.max(profit , prices[i] - buy);
        } 
        return profit; 
    }
}
