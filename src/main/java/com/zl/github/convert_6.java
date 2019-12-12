package com.zl.github;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zl
 * @Date 2019-12-12
 * @Des 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出:     "LCIRETOESIIGEDHN"
 * <p>
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出:     "LDREOEIIECIHNTSG"
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class convert_6 {

    public static void main(String[] args) {

    }
    /**
     * L   C   I   R          rows[0]
     * E T O E S I I G        rows[1]
     * E   D   H   N          rows[2]
     * 按行去遍历
     * flag 改变存储方向
     * @param string
     * @param numRows
     * @return
     */
    public static String covert_2(String string, Integer numRows) {
        if (numRows < 2) return string;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder()); //按行填充字符串
        int i = 0,flag = -1; //i为行,flag为转折点
        for (char c : string.toCharArray()){
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1){ //numRows == 3
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
