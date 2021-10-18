
import java.util.*;

public class Solution {

    public static void main(String[] args) {


        List<String> res = fizzBuzz(15);

        for (String re : res) {
            System.out.println(re);
        }


    }


    public static List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if(i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if(i % 3 == 0){
                res.add("Fizz");
            }else if(i % 5 == 0){
                res.add("Buzz");
            }else{
                res.add(i+"");
            }

        }

        return res;

    }


}

