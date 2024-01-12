package com.leetcode.s2001_2100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyq
 * @date 2024/1/12
 * @desc 统计出现过一次的公共字符串
 */
public class Solution2085 {
    public static void main(String[] args) {

        Solution2085 solution = new Solution2085();
        String[] word1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] word2 = {"amazing", "leetcode", "is"};
        System.out.println(solution.countWords(word1, word2));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int count = 0;
        for (String word : words1) {
            map1.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (String word : words2) {
            map2.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()){
            if (entry.getValue()==1 && map2.containsKey(entry.getKey()) && map2.get(entry.getKey())==1){
                count++;
            }
        }
        return count;
    }
}
