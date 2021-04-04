

/* 循环处理的都是非空正则的情况，从结尾开始看
 * 1）如果正则是字符，则判断 s[s.length()-1] == p[p.length()-1] ,相等则看 s[0...s.length()-2]与p[0...p.length()-2]
 * 2）如果正则是'.'，则能匹配任意字符，直接看 s[0...s.length()-2]与p[0...p.length()-2]
 * 3）如果正则是'*'，则代表p[p.length()-2]=c这个字符可以重复0次或多次，是一个整体 'c*'
 *      (1) s[s.length()-1]没有c，正则的这个c没有任何用，继续向前匹配
 *      (2) s[s.length()]是多个c的最后一个，所以s的索引要完全挪一位，p的索引保持不变(因为可以匹配多个)，
 *          继续看s[0...s.length()-2]和p[0...p.length()-1]是否匹配
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(isMatch("aa","a*"));


    }






    public static boolean isMatch(String s, String p) {

        // 比如假设 s="aab" ,p="c*a*b"

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        // dp[0][0] 相当于s、p都是空字符串时，则可以match
        dp[0][0] = true;

        // 这个for循环是在讨论当s为空字符串时，p在不同大小时能否match（p的长度已经固定）
        for(int j=1;j<=p.length();j++){

            // 这个时候探讨的就是当s为空，p在取'c','c*','c*a'...'c*a*b'时，记录下能否match
            if(p.charAt(j-1)=='*'&&dp[0][j-2])
                dp[0][j] = true;
        }

        for (int i = 1; i <= s.length() ; i++) {
            for(int j = 1;j<=p.length();j++){

                // 当字符相等或者p='.'时，当前的dp值取决于dp[i-1][j-1]
                if(  s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.'){
                    // dp[i][j] = dp[i-1][j-1] 原因是相当于视作这个字符不存在，结果和之前的字符串比较结果相同
                    // eg 'a'&'c*a',忽略'a', 直接用''&'c*'的结果
                    dp[i][j] = dp[i-1][j-1];

                }else if(p.charAt(j-1) == '*'){
                    // '*'前面的字符和s即不相同(eg 'a' 'b*')，同时又不是'.'(eg 'a' '.*')，即意味着完全不能match
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        // eg 'a'&'ab*',删掉'b*'这两个字符,看'a'&'a'的结果(之前记录的结果)
                        // 删除这两个字符，只能寄希望于删掉这两个字符后(相当于这两个字符前的字符串)能否匹配
                        dp[i][j] = dp[i][j-2];
                    }else{
                        // eg 'a' 'c*a*'
                        // dp[i][j-2]: 'a' 'c*'   即代表0个，忽略p最后的'a*'再判断是否match
                        // dp[i][j-1]: 'a' 'c*a'  即代表1个，两者末尾字符恰好一致,拿之前的dp结果
                        // dp[i-1][j]: ''  'c*a*' 即代表多个，保留p末尾'a*',
                        // 检测到'*'时，并发现有机会match时就去参考前面的dp结果
                        dp[i][j] = ( dp[i][j-2] || dp[i][j-1] || dp[i-1][j] );
                    }
                }
            }

        }


        return dp[s.length()][p.length()];
    }




}
