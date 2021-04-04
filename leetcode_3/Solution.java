class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s==null){
            return 0;
        }
        
        StringBuffer[] dpStrings = new StringBuffer[s.length()+1];

        char[] chars = s.toCharArray();
        dpStrings[0] = new StringBuffer("");


        dpStrings[0].append( chars[0]);
        int maxLength = 0;


        for (int i = 0; i < s.length(); i++) {
            char tmpChar = chars[i];

            if(dpStrings[i].toString().contains(String.valueOf(tmpChar)) ){
                int tmpIndex = dpStrings[i].lastIndexOf(String.valueOf(tmpChar));
                dpStrings[i+1] = dpStrings[i].delete(0,tmpIndex+1);
                dpStrings[i+1].append(tmpChar);

            }else{
                dpStrings[i+1] = dpStrings[i];
                dpStrings[i+1].append(tmpChar);
            }

            maxLength = Math.max(dpStrings[i+1].length(),maxLength);

        }

        return maxLength;
    }
}