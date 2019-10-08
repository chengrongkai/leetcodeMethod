package simple;

/**
 * Description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * User: chengrongkai
 * Date: 2019-09-30
 * Time: 10:32
 */
public class Code_7 {
    public static void main(String[] args) {
        int x = -1233333339;
        System.out.println(reverse(x));
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
