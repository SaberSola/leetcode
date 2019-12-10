package com.zl.github;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zl
 * @Date 2019-12-10
 * @Des 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class lengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("qwrfiuoq"));

        System.out.println(lengthOfLongestSubstring_windows("cqwrfiuoq"));
    }


    public static Integer repeat(String string) {

        return 0;
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(allUnique(s,i,j)){ans = Math.max(ans, j - i);}
            }
        }
        return  ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     *      cqwcrtgyoq
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_windows(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) { // 如果包含此时包含 j = 3
                i = Math.max(map.get(s.charAt(j)), i); //(j = 3, i=0; s.charAt(j) = 1 i = 1 )
            }
            ans = Math.max(ans, j - i + 1);// (j = 0 ans = 1),(j = 1 ans = 2) (j = 2,ans = 3) (j = 3, ans = 3),(j =4,ans = 4) (j = 5)
            map.put(s.charAt(j), j + 1); //(c,1),(q,2),(w,3)
                                         //(c,4),(q,2),(w,3) (r,t)
        }
        return ans;
    }
}
