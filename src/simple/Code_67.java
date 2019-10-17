package simple;

/**
 * Description:给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 * User: chengrongkai
 * Date: 2019-10-15
 * Time: 9:55
 */
public class Code_67 {
    public static String addBinary(String a, String b) {
        int i = a.length()>b.length()?a.length()-1:b.length()-1;
        int j = a.length()<b.length()?a.length()-1:b.length()-1;
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i>=0){
            char A = a.charAt(i);
            if (j<0){
                if (temp == 0){
                    stringBuilder.append(A);
                }else {
                    if (A == '1'){
                        stringBuilder.append('0');
                    }
                }
                j--;
            }else{
                char B = b.charAt(j);
                if (temp == 0){
                    if (A == '1' && B == '1'){
                        temp = 1;
                        stringBuilder.append('0');
                    }else if (A == '1'
                    ){}
                }
            }
            i--;
            if (i<0 && temp != 0){
                stringBuilder.append(temp);
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
//        System.out.println(addBinary(a,b));


        char A = '1';
        char B = '1';
        System.out.println(A);
    }
}
