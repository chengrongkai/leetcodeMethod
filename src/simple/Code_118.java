package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @author: chengrongkai
 * Date: 2019-10-25
 * Time: 9:35
 */
public class Code_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> start = new ArrayList<List<Integer>>();
        if (numRows == 0){return start;}
        List<Integer> one = new ArrayList<Integer>();
        one.add(1);
        start.add(one);
        if (numRows == 1){return start;}
        for (int i = 1; i < numRows; i++) {
            List<Integer> preList = start.get(i-1);
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j <i+1; j++) {
                int temp = 0;
                if (j-1 >= 0){
                    temp = temp+preList.get(j-1);
                }
                if (j<preList.size()){
                    temp = temp+preList.get(j);
                }
                curList.add(temp);
            }
            start.add(curList);
        }

        return start;
    }

    public static void main(String[] args) {

    }
}
