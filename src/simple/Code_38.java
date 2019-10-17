package simple;

/**
 * Description:报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 * User: chengrongkai
 * Date: 2019-10-11
 * Time: 11:40
 */
public class Code_38 {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countAndSayLine(countAndSay(n - 1));
    }

    private static String countAndSayLine(String line) {
        StringBuilder newLine = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < line.length()) {
            if (i == 0 || line.charAt(i) == line.charAt(i - 1)) {
                count ++;
            } else {
                newLine.append(count).append(line.charAt(i - 1));
                count = 1;
            }
            if (i == line.length() - 1) {
                newLine.append(count).append(line.charAt(i));
            }
            i++;
        }
        return newLine.toString();
    }
}
