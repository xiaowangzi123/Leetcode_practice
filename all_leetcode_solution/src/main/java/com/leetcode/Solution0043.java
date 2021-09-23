package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/21
 * @description： {@link Solution0415}
 */
public class Solution0043 {
    public static void main(String[] args) {
        Solution0043 obj = new Solution0043();
        String num1 = "123", num2 = "456";
        System.out.println(obj.multiply(num1, num2));
    }

    /**
     * 计算形式
     * num1
     * * num2
     * ------
     * result
     * 1 2 3     1 2 3      1 2 3      1 2 3
     * 4 5 6---->    6----->  5   ---->4
     * -----     -----   --------   --------
     * 7 3 8    6 1 5 0   49 2 0 0   ---->738+6150+49200=56088
     */
    public String multiply(String num1, String num2) {
        //有一个是“0”，直接返回“0”
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //ans存储结果
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();

            //num2的高进位乘以num1时，需要补0
            for (int j = n - 1; j > i; j--) {
                temp.append("0");
            }

            //base表示乘积结果的进位值
            int base = 0;
            //用num2的每一个元素与num1相乘
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                temp.append((x * y + base) % 10);
                base = (x * y + base) / 10;
            }
            if (base != 0) {
                temp.append(base);
            }
            //num2的每一个元素与num1相乘的结果相加
            ans = addStrings(ans, temp.reverse().toString());
        }
        return ans;
    }

    /**
     * {@link Solution0415}
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1, n = num2.length() - 1, base = 0;
        while (m >= 0 || n >= 0) {
            int i = m >= 0 ? num1.charAt(m) - '0' : 0;
            int j = n >= 0 ? num2.charAt(n) - '0' : 0;
            sb.append((i + j + base) % 10);
            base = (i + j + base) / 10;
            m--;
            n--;
        }
        if (base == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * 123
     * 56
     * ---------
     * 18
     * 120
     * 600
     * 150
     * 1000
     * 5000
     * --------
     * 6888
     * num1[i]*num2[j]的结果处于res的res[i+j]和res[i+j+1]
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }


    /**
     * 做乘法
     * num1[i]*num2[j]的结果位于ansArr[i+j+1]，
     * 如果ansArr[i+j+1]≥10，则将进位部分加到ansArr[i+j]。
     */
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        //长度m与长度N的数据相乘，最多m+n位
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}