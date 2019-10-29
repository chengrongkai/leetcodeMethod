package simple;

/**
 * Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * @author: chengrongkai
 * Date: 2019-10-25
 * Time: 10:56
 */
public class Code_121 {
    public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE,sale=Integer.MIN_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            //买入
            buy = Math.min(prices[i],buy);
            //卖出
            sale = Math.max(prices[i],buy);
            profit = Math.max(profit,sale-buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
