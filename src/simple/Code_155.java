package simple;

import javafx.collections.transformation.SortedList;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Description:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @author: chengrongkai
 * Date: 2019-10-28
 * Time: 17:29
 */
public class Code_155 {

    static class MinStack {
        Deque<Integer> deque;
        TreeSet<Integer> treeSet = new TreeSet();
        /** initialize your data structure here. */
        public MinStack() {
            deque = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            deque.addLast(x);
            treeSet.add(x);
        }

        public void pop() {
            Integer last = deque.getLast();
            treeSet.remove(last);
            deque.removeLast();
        }

        public int top() {
           return deque.getLast();
        }

        public int getMin() {
            if(!treeSet.isEmpty()){
                return treeSet.first();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
