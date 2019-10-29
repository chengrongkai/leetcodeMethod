package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @author: chengrongkai
 * Date: 2019-10-25
 * Time: 10:07
 */
public class Code_119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> start = new ArrayList<Integer>();
        if (rowIndex == 0){return start;}
        start.add(1);
        if(rowIndex == 1){return start;}
        return getRow(start,2,rowIndex);
    }

    public static List<Integer> getRow(List<Integer> preList,int count,int row){
        if (count>row){return preList;}else{
            List<Integer> curList = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                int temp = 0;
                if (i-1 >= 0){
                    temp = temp+preList.get(i-1);
                }
                if (i<preList.size()){
                    temp = temp+preList.get(i);
                }
                curList.add(temp);
            }
            return getRow(curList,count+1,row);
        }
    }

    /**
     * 公式法
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowPlus(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> integers = getRow(2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
