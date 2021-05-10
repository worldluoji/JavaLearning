package com.leetcode;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new HashSet<>(), 0, 1, k, n, res);
        return res;
    }

    private void dfs(Set<Integer> currentSet, int current, int num, int k, int n, List<List<Integer>> res) {
        if (current == n && currentSet.size() == k) {
            List<Integer> item = new ArrayList<>();
            item.addAll(currentSet);
            res.add(item);
            return;
        }
      
        int limit = n > 9 ? 9:n;
        if (num > limit || current > n || currentSet.size() > k) {
            return;
        }

        // select num
        currentSet.add(num);
        dfs(currentSet, current + num, num + 1, k, n, res);
        // not select num
        currentSet.remove(num);
        dfs(currentSet, current, num + 1, k, n, res);           
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum3(3, 18);
        System.out.println(res);
    }
}