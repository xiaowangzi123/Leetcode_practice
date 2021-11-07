### 1961. 检查字符串是否为数组前缀

给你一个字符串s和一个字符串数组 words，请你判断s是否为words的前缀字符串。

字符串s要成为words的前缀字符串，
需要满足：s可以由words中的前k（k为正数个字符串按顺序相连得到，且 k 不超过 words.length 。

如果s是 words的前缀字符串，返回true；否则，返回false 。

 

示例 1：
输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
输出：true
解释：
s 可以由 "i"、"love" 和 "leetcode" 相连得到。

示例 2：
输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
输出：false
解释：
数组的前缀相连无法得到 s 。
 

提示：
1 <= words.length <= 100
1 <= words[i].length <= 20
1 <= s.length <= 1000
words[i] 和 s 仅由小写英文字母组成