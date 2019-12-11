package com.zl.github;

/**
 * @Author zl
 * @Date 2019-12-11
 * @Des 找出最长回文字符串
 * <p>
 * babad
 * 输出bab
 */
public class longestPalindrome_5 {

    public static void main(String[] args) {

        longestPalindrome("abcdcba");
    }

    /**
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     * 单个字母一个,俩个字母之间一个 所有为 2n-1
     * 你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。
     *
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";
        Integer start = 0;
        Integer end   = 0;
        for (int i = 0; i < s.length();i ++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            System.out.println("i= " + i + " len1 = " + len1 + " len2=" + len2 + " len=" + len + " start=" + start + " end=" + end);
        }
        return s.substring(start,end);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
