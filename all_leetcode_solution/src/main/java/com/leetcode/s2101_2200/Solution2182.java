package com.leetcode.s2101_2200;


/**
 * @author wyq
 * @date 2024/1/13
 * @desc 构造限制重复的字符串
 */
public class Solution2182 {

    public static void main(String[] args) {
        Solution2182 solution = new Solution2182();
        String s = "cczazcc";
        int repeatLimit = 3;
//        System.out.println(solution.repeatLimitedString(s, repeatLimit));
        System.out.println(solution.repeatLimitedString2(s, repeatLimit));
//        System.out.println(solution.repeatLimitedString(s, 1));
        System.out.println(solution.repeatLimitedString2(s, 1));
    }

    public static int SIZE = 26;

    public String repeatLimitedString(String s, int repeatLimit) {
        int m = 0; //当前字母已经连续的个数
        int[] cnt = new int[SIZE];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = SIZE - 1, j = SIZE - 2; i >= 0 && j >= 0; ) {
            if (cnt[i] == 0) {
                m = 0;
                i--;
            } else if (m < repeatLimit) {
                cnt[i]--;
                sb.append((char) ('a' + i));
                m++;
            } else if (j >= i || cnt[j] == 0) {
                j--;
            } else {
                cnt[j]--;
                sb.append((char) ('a' + j));
                m = 0;
            }

        }
        return sb.toString();
    }

    public String repeatLimitedString2(String s, int repeatLimit) {
        int[] cnt = new int[SIZE];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = SIZE - 1, j = SIZE - 2; i >= 0 && j >= 0; ) {
            if (cnt[i] == 0) {
                i--;
                j--;
            }else if (cnt[i] <= repeatLimit){
                getStr(sb,cnt[i],(char) ('a' + i));
                cnt[i]=0;
                i--;
                j--;
            }else {
                while (cnt[i]>repeatLimit){
                    getStr(sb,repeatLimit,(char) ('a' + i));
                    cnt[i]=-repeatLimit;
                    while (cnt[j]==0) {
                        j--;
                    }
                    sb.append((char) ('a' + j));
                    cnt[j]--;
                }
                getStr(sb,cnt[i],(char) ('a' + i));
                cnt[i]=0;
                i=j;
                j--;
            }
        }

        return sb.toString();

    }

    public void getStr(StringBuilder s,int n,char c){
        for (int i=0;i<n;i++){
            s.append(c);
        }
    }
}
