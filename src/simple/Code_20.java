package simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * User: chengrongkai
 * Date: 2019-10-08
 * Time: 10:37
 */
public class Code_20 {
    public static void main(String[] args) {
        System.out.println(isValid("[({(())}[()])]"));
    }

    /**
     * 非栈的写法
     * @param s
     * @return
     */
    public static boolean isValid_normal(String s) {
        // 空字符串
        if (s.length() == 0)
            return true;
        // 排除奇数长度(位运算)
        if ((s.length() & 1) == 1)
            return false;

        // 栈元素个数
        int index = 0;
        // 栈
        char[] stack = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    // 进栈
                    stack[index++] = s.charAt(i);
                    continue;
                case ')':
                    if (index == 0 || stack[--index] != '(')
                        return false;
                    // stack[--index] == '(' ，才会contniue
                    // --index：相当于满足的元素出栈
                    continue;
                case ']':
                    if (index == 0 || stack[--index] != '[')
                        return false;
                    continue;
                case '}':
                    if (index == 0 || stack[--index] != '{')
                        return false;
                    continue;
            }
        }

        return index == 0; // 判断栈是否为空
    }

    /**
     * 栈的写法
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    continue;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    continue;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    continue;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    continue;
            }
        }
        return stack.isEmpty();
    }




}
