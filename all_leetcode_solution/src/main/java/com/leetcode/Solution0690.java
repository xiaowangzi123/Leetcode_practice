package com.leetcode;

import com.leetcode.bean.Employee;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0690 {
    public static void main(String[] args) {
        Solution0690 obj = new Solution0690();

        Employee e3 = new Employee(3, 3, new ArrayList<>());
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e1 = new Employee(1, 5, new ArrayList<Integer>(Arrays.asList(2, 3)));

        List<Employee> list = new ArrayList<Employee>() {{
            add(e1);
            add(e2);
            add(e3);
        }};

        System.out.println(obj.getImportance(list, 1));
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id, map);
    }

    public int dfs(int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        int ans = e.importance;
        List<Integer> list = e.subordinates;
        for (int i : list) {
            ans += dfs(i, map);
        }
        return ans;
    }
}