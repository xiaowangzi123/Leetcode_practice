### 1668. 最大重复子字符串

给你一个字符串sequence，如果字符串word连续重复k次形成的字符串是sequence的一个子字符串，
那么单词word的重复值为k。单词word的最大重复值是单词word在sequence中最大的重复值。
如果word不是sequence的子串，那么重复值k为0 。

给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。

 

示例 1：
输入：sequence = "ababc", word = "ab"
输出：2
解释："abab" 是 "ababc" 的子字符串。

示例 2：
输入：sequence = "ababc", word = "ba"
输出：1
解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。

示例 3：
输入：sequence = "ababc", word = "ac"
输出：0
解释："ac" 不是 "ababc" 的子字符串。
 

提示：
1 <= sequence.length <= 100
1 <= word.length <= 100
sequence 和 word 都只包含小写英文字母。
