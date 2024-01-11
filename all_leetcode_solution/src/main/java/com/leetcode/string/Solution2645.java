package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyq
 * @date 2024/1/11
 * @desc 构造有效字符串的最少插入数
 */
public class Solution2645 {
    public static void main(String[] args) {
        Solution2645 solution = new Solution2645();
        System.out.println(solution.addMinimum("aa"));
        System.out.println(solution.addMinimum("bbb"));
    }

    /**
     * 分组，对于abac，可以分成ab,ac,两组，每组填充1个字母
     */
    public int addMinimum(String word) {

        List<String> strings = groupContinuous(word);
        return 3*strings.size()-word.length();
    }

    public static List<String> groupContinuous(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length()==0) {
            return new ArrayList<>();
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(i-1)){
                temp.append(str.charAt(i));
            }else {
                result.add(temp.toString());
                temp.setLength(0);
                temp.append(str.charAt(i));
            }
        }
        result.add(temp.toString());
        return result;
    }
}
