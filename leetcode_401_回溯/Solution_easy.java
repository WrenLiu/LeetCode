import java.util.*;

/**
 * 没有用到回溯算法
 */
public class tmp {

    public static void main(String[] args) {
        List<String> list = readBinaryWatch(1);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> readBinaryWatch(int num) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i)+Integer.bitCount(j) == num){
                    StringBuffer stringBuffer;
                    if(j<10){
                        stringBuffer = new StringBuffer(i+":0"+j);
                    }else{
                        stringBuffer = new StringBuffer(i+":"+j);
                    }
                    arrayList.add(stringBuffer.toString());

                }
            }
        }

        return arrayList;
    }




}
