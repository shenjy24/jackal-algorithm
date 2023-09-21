package com.jonas.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenjy
 * @createTime 2023/8/29 9:19
 * @description 杨辉三角
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle app = new PascalTriangle();
        System.out.println(app.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                List<Integer> last = res.get(i-1);
                int num = last.get(j - 1) + last.get(j);
                row.add(num);
            }
            res.add(row);
        }
        return res;
    }
}
