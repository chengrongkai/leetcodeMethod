package simple;
import java.lang.Character;
/**
 * Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @author: chengrongkai
 * Date: 2019-10-28
 * Time: 16:48
 */
public class Code_125 {
    public static boolean isPalindrome(String s) {
        boolean result = true;
        if (s.isEmpty()){
            return result;
        }
        int i=0;
        int j = s.length()-1;
        while(i<j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!(Character.isLetter(left)||Character.isDigit(left))){
                i++;
                continue;
            }
            if (!(Character.isLetter(right)||Character.isDigit(right))){
                j--;
                continue;
            }
            if (Character.toUpperCase(left) != Character.toUpperCase(right)){
                result = false;
                break;
            }
            i++;
            j--;

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
