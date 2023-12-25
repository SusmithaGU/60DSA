public class StocksBuySell1 {
    static int getMaxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int diff = 0, max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }

            diff = prices[i] - lsf;
            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        //nt[] prices={6,9,1,2};  //Incresing->Decreasing->Increasing
        int[] prices={7,1,3,5,6,4};  //Descreasing-Increasing-Decreasing
        //int[] prices={1,2,3,4,5};  //Increasing
        //int[] prices={5,4,2};  //Decreasing

        System.out.println(getMaxProfit(prices));
    }
}
/*
 * The trick is to remember that there will be local min and local max for a given range 
 * but we only need to find the max difference between any local min and max. Hence
 * move forward and locate a minimum so far and keep taking the diff until you find a max one. If you find
 * such pair and still moving forward you might find another of such pair but then you will be updating the 
 * minimum so far and will move on to find the max difference you could get with this lsf and any given number you 
 * encounter as you move forward
 */