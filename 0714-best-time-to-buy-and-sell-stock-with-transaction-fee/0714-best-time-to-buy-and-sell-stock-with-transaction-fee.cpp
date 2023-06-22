class Solution {
public:
   int dp[50002][2];
   int solve(int id,int buy,vector<int>&p,int fee){
       if(id>=p.size())
       return 0;
       if(dp[id][buy]!=-1)
       return dp[id][buy];
      int mxprofit=-1e9;
       if(buy){
       mxprofit=max(-p[id]+solve(id+1,0,p,fee),solve(id+1,1,p,fee));
       }
       else
       mxprofit=max(p[id]+solve(id+1,1,p,fee)-fee,solve(id+1,0,p,fee));
       return dp[id][buy]=mxprofit;
   }
    int maxProfit(vector<int>& prices, int fee) {
        memset(dp,-1,sizeof(dp));
        return solve(0,1,prices,fee);
    }
};