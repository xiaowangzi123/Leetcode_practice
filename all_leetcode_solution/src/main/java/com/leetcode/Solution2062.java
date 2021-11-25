package com.leetcode;

/**
 * @author: wyq
 * @create time: 2021/11/25
 * @description: 统计字符串中的元音子字符串
 */
public class Solution2062 {
    public static void main(String[] args) {
        Solution2062 obj = new Solution2062();
        System.out.println(obj.countVowelSubstrings("aeiouu"));
        System.out.println(obj.countVowelSubstrings("unicornarihan"));
        System.out.println(obj.countVowelSubstrings("cuaieuouac"));
    }

    public int countVowelSubstrings(String word) {
        int count = 0, n = word.length();
        for (int i = 0; i < n - 4; i++) {
            for (int j = i + 5; j <= n; j++) {
                if (isVowelSubstring(word.substring(i, j))) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isVowelSubstring(String s) {
        if (s.length() < 5) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return false;
            }
        }
        if (!s.contains("a") || !s.contains("e") || !s.contains("i") || !s.contains("o") || !s.contains("u")) {
            return false;
        }
        return true;
    }


}