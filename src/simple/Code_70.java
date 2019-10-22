package simple;

/**
 * Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @author: chengrongkai
 * Date: 2019-10-18
 * Time: 9:21
 */
public class Code_70 {
    public static int climbStairs(int n) {
        int count = 0;
        if(n>1){
            count = count+climbStairs(n-2)+climbStairs(n-1);
        }else if(n>0){
            count = count+climbStairs(n-1);
        }else{
            count = 1;
        }
        return count;
    }

    /**
     * dp动态规划
     * @param n
     * @return
     */
    public static int climbStairsPlus(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     *在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     *
     * Fib(n)=Fib(n-1)+Fib(n-2)
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 11 和 22 作为第一项和第二项的斐波那契数列中的第 nn 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     * @param n
     * @return
     */
    public int climbStairsPlus1(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
