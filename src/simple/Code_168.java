package simple;

/**
 * Description:
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * @author: chengrongkai
 * Date: 2019-10-30
 * Time: 11:19
 */
public class Code_168 {
    public String convertToTitle(int n) {
        String AZ = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] CZ = AZ.toCharArray();

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append(CZ[n % 26]);
                n = n / 26;
            }
        }

        return sb.reverse().toString();
    }
}
