package simple;

/**
 * Description:
 *
 * @author: chengrongkai
 * Date: 2019-10-17
 * Time: 19:07
 */
public class Code_69 {
    public static int mySqrt(int x) {
        int i = 1;
        while(i <= x){
            if((i*i)-x>0){
                break;
            }
            i++;
        }
        return i-1;
    }

    public static int mySqrtPlus(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static void main(String[] args) {
        int x = 2147395600;
//        System.out.println(mySqrt(x));

        System.out.println((46341*46341)-x>0);
    }
}
