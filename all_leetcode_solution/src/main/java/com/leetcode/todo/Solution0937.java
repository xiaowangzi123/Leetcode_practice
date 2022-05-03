package com.leetcode.todo;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 重新排列日志文件
 */
public class Solution0937 {
    public static void main(String[] args) {
        Solution0937 obj = new Solution0937();
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(obj.reorderLogFiles(logs)));

    }


    /**
     *
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            //按分隔符“ ” ，分成2份
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            //判断日志是否为数字
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                //字母日志比较，不相等，按照字母顺序排序
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                //日志一样，则按照标识符排序
                return split1[0].compareTo(split2[0]);
            }
            //如果split1是数字字符，且split2是数字字符返回0，
            //如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}