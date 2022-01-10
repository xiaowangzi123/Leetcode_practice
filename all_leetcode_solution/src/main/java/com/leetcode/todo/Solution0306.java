package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/1/10
 * @description: 累加数
 */
public class Solution0306 {
    public static void main(String[] args) {
        Solution0306 obj = new Solution0306();
        System.out.println(obj.isAdditiveNumber("0112358"));
        System.out.println(obj.isAdditiveNumber2("0112358"));
        System.out.println(obj.isAdditiveNumber2("111"));
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        char[] chars = num.toCharArray();
        long pre1, pre2;
        // 起始数字要满足：
        // 1.开头不为0,如果为0,则0是一个加数
        // 2.长度不超过总长度的一半
        for (int i = 0; i < num.length() / 2; i++) {
            //字符串开头是0，则第一个加数只能为0，
            if (chars[0] == '0' && i > 0) {
                break;
            }
            pre1 = getNum(chars, 0, i);
            for (int j = i + 1; j < num.length(); j++) {
                if (chars[i + 1] == '0' && j > i + 1) {
                    break;
                }
                pre2 = getNum(chars, i + 1, j);
                if (isAdditiveNumberCore(chars, j + 1, pre1, pre2)) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 前两个数相加等于第三个数，如果不符返回false
     */
    private boolean isAdditiveNumberCore(char[] num, int start, long pre1, long pre2) {
        long target = pre1 + pre2;
        int length = String.valueOf(target).length();
        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }
        start = start + length;
        return start == num.length || isAdditiveNumberCore(num, start, pre2, target);
    }

    private long getNum(char[] chars, int start, int end) {
        if (end >= chars.length) {
            return -1;
        }
        long ans = 0;
        for (int i = start; i <= end; i++) {
            ans *= 10;
            ans += (chars[i] - '0');
        }
        return ans;
    }


    public boolean isAdditiveNumber2(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        for (int i = 0; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }
            String s1 = num.substring(0, i + 1);
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                String s2 = num.substring(i + 1, j+1);
                if (stringAddIsAdditive(num, s1, s2, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean stringAddIsAdditive(String num, String s1, String s2, int index) {
        String sum = getAddString(s1, s2);
        if (!sum.equals(num.substring(index, index + sum.length()))) {
            return false;
        }
        index += sum.length();
        return index == num.length() || stringAddIsAdditive(num, s2, sum, index);
    }

    public String getAddString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int m = s1.length() - 1, n = s2.length() - 1, k = 0;
        while (m >= 0 || n >= 0) {
            int i = m >= 0 ? s1.charAt(m) - '0' : 0;
            int j = n >= 0 ? s2.charAt(n) - '0' : 0;
            sb.append((i + j + k) % 10);
            k = (i + j + k) / 10;
            m--;
            n--;
        }
        if (k == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}