package com.leetcode;

import com.sun.org.glassfish.external.statistics.impl.StringStatisticImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/6
 * @description :
 */
public class Solution0139 {
    public static void main(String[] args) {
        Solution0139 obj = new Solution0139();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(obj.wordBreak(s, wordDict));
        System.out.println(obj.wordBreak2(s, wordDict));

        System.out.println(wordDict.contains("code"));
    }


    /**
     * dp[i] 表示字符串s前i个字符组成的字符串s[0..i−1]是否能被空格拆分成若干个字典中出现的单词
     * 对于边界条件，我们定义dp[0]=true表示空串且合法
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //java.lang.NullPointerException
//        Boolean[] dp = new Boolean[n + 1];
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}