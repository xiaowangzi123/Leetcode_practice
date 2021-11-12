package com.leetcode;

import java.util.LinkedList;

/**
 * @author :wyq
 * @date ：Created in 2021/11/12
 * @description : 无法吃午餐的学生数量
 */
public class Solution1700 {
    public static void main(String[] args) {
        Solution1700 obj = new Solution1700();
        int[] students = {1, 1, 1, 0, 0, 1}, sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(obj.countStudents(students, sandwiches));
        System.out.println(obj.countStudents2(students, sandwiches));
        System.out.println(obj.countStudents3(students, sandwiches));
    }

    /**
     * 学生的顺序不重要，如果不喜欢当前汉堡可以继续排队在队尾等待
     * 但只剩喜欢0类型的汉堡的学生，此时刚好是汉堡1排在前面，则后续的学生都无法吃到汉堡
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] ans = new int[2];
        for (int i : students) {
            ans[i]++;
        }
        for (int i = 0; i < n; i++) {
            if (ans[sandwiches[i]] > 0) {
                ans[sandwiches[i]]--;
            } else {
                return n - i;
            }
        }

        return 0;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        int n = students.length;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i : students) {
            stack.add(i);
        }
        for (int i = 0; i < n; i++) {
            int count = stack.size();
            while (!stack.isEmpty() && sandwiches[i] != stack.peekFirst()) {
                if (count == 0) {
                    return stack.size();
                }
                count--;
                int temp = stack.pollFirst();
                stack.add(temp);
            }
            stack.pollFirst();
        }

        return stack.size();
    }


    public int countStudents3(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] ans = new int[2];
        for (int i : students) {
            ans[i]++;
        }
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0 && ans[0] > 0) {
                ans[0]--;
            }
            if (sandwiches[i] == 1 && ans[1] > 0) {
                ans[1]--;
            }
        }

        return ans[0] + ans[1];
    }
}