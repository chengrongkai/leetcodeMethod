package simple;

/**
 * Description:给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * User: chengrongkai
 * Date: 2019-10-12
 * Time: 9:44
 */
public class Code_58 {

    public static int lengthOfLastWord(String s) {
        if (null == s || s.length()==0){
            return 0;
        }
        int result = 0;
        int i = s.length()-1;
        while(i>=0){
            if (s.charAt(i) != ' '){
                result++;
            }else{
                if (result>0){
                    break;
                }
            }
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "a bc ";
        System.out.println(lengthOfLastWord(s));
    }
}
