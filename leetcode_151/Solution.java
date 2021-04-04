class Solution {
    public String reverseWords(String s) {

        if(s == null){
            return null;
        }

        s = s.trim();
        if(s.length() == 0){
            return s;
        }

        String[] strings = s.split(" ");

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = strings.length-1; i >= 0 ; i--) {
            if (strings[i].length() == 0) {
                continue;
            }

            stringBuffer.append(strings[i]+" ");
        }

        if(stringBuffer.charAt(stringBuffer.length()-1) == ' '){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

        return stringBuffer.toString();
    }
}