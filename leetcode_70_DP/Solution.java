import java.util.ArrayList;
import java.util.Scanner;

import jdk.internal.jshell.tool.resources.version;
import jdk.internal.util.xml.impl.Input;

class Solution {

    static String[] usernames = {"zhangsan","lisi","wangwu"};
    // ArrayList<String> usernames = new ArrayList<>();


    public static void main(String[] args)throws registerException {
        // 使用Scanner获取用户输入的注册的用户名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String Inputname = sc.nextLine();
        checkName(Inputname);
    }

    // 定义一个方法，对用户输入的用户名进行判断
    public static void checkName (String inputName)throws registerException{
        for(String str : usernames){
            if(str.equals(inputName)){
                try{
                    throw new registerException("用户名已存在");
                }catch(registerException e){
                    e.printStackTrace();
                    return ;
                }
            }
        }

        System.out.println("注册成功");
    }



}