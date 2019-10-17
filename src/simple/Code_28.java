package simple;

/**
 * Description:实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * User: chengrongkai
 * Date: 2019-10-10
 * Time: 9:57
 */
public class Code_28 {
    public static int strStr(String haystack, String needle) {
        int position = -1;
        if (null == haystack || null==needle || haystack.length()<needle.length()){
            return position;
        }
        if (haystack.length()==0||needle.length()==0){
            return 0;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            int j=0;
            position = i;
            while(j<needle.length()){
                if (haystack.charAt(i+j) != needle.charAt(j++)){
                    position = -1;
                    break;
                }
            }
            if (position != -1){
                break;
            }

        }
        return position;
    }

    public static void main(String[] args) {
        String haystack = "aaabcabc";
        String needle = "abc";
        System.out.println(strStr(haystack,needle));
    }
}
