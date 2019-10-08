package simple;

/**
 * Description:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 * User: chengrongkai
 * Date: 2019-09-30
 * Time: 10:58
 */
public class Code_9 {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int y = x;
        long rs = 0;
        while(x != 0){
            rs = rs*10+x%10;
            x /= 10;
        }
        rs = (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
        return rs==y;

    }

    public static int reverse(int x) {
        long rs = 0;//
        while(x != 0){
            rs = rs*10+x%10;//rs=0+123%10 rs=3+12%10
            x /= 10;//x=12 x=1
        }
        return (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
    }
}
