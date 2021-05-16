

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String s = "Myself2 Me1 I4 and3";


        System.out.println(sortSentence(s));

    }

    public static String sortSentence(String s) {

        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");

        Arrays.sort(strs, (o1, o2) -> {
            int n1 = o1.charAt(o1.length() - 1);
            int n2 = o2.charAt(o2.length() - 1);
            return Integer.compare(n1, n2);
        });
        // 拼接排序后的单词
        for (String str : strs) {
            res.append(str, 0, str.length() - 1).append(" ");
        }
        // 去末尾空格
        return res.toString().trim();
    }

}