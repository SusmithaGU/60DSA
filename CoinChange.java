import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amt, int[] dp) {
        if (amt == 0) return 0;

        if (dp[amt] != -1)
            return dp[amt];
        int i;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < coins.length; i++) {

            if (amt >= coins[i]) {
                int sub_ans = coinChange(coins, amt - coins[i], dp);

                if (sub_ans != Integer.MAX_VALUE && sub_ans + 1 < ans) {
                    ans = sub_ans + 1;
                }
            }
        }

        return dp[amt] = ans;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] coins = { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 };
        int amount = 9864;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        System.out.println(coinChange(coins, amount, dp));

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}


/*
 * 
 * Execution time with memoization= 1 ms = O(coins*amount);
 * whereas with tabulation method it is 32 ms;
 * If you try to solve it using take or not_take approach it takes 5435 ms
 * (see the difference with 2 recursive calls in order to avoid a for loop
 */


 // Below is the code with take or not_take approach- my idea,but less efficient

 /*public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int ans = util(coins, amount, coins.length - 1, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int util(int[] coins, int amt, int i, int coin, int[] dp) {
        if (i < 0)
            return Integer.MAX_VALUE;
        if (amt == 0)
            return coin;
        if (dp[amt] != -1)
            return dp[amt];
        int take = Integer.MAX_VALUE;
        if (amt >= coins[i]) {
            take = util(coins, amt - coins[i], i, coin + 1, dp);
        }
        int donot_take = util(coins, amt, i - 1, coin, dp);

        return Math.min(take, donot_take);
    } */