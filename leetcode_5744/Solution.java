

public class Solution {

    public static void main(String[] args) {

        char[][] box = {{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};
//
//        char[][] box = {{'#','.','*','.'},
//                {'#','#','*','.'}};

        char[][] res = rotateTheBox(box);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }


    public static char[][] rotateTheBox(char[][] box) {

        if(box == null){
            return null;
        }


//        '#' 表示石头
//        '*' 表示固定的障碍物
//        '.' 表示空位置
//        char[][] box = {{'#','.','*','.'},
////                        {'#','#','*','.'}};
        int boxRow = box.length;
        int boxCol = box[0].length;
        char[][] res = new char[boxCol][boxRow];



        int row ,col;

        for (row = 0; row < boxRow;row ++) {

            for (col = boxCol-1; col >= 0 ;col--) {


                if(box[row][col] == '.'){
                    res[col][boxRow - row -1 ] = '.';
                    continue;
                }

                if(box[row][col] == '*'){
                    res[col][boxRow - row -1 ] = '*';
                    continue;
                }

                if(box[row][col] == '#'){

                    int curCol = col;
                    res[col][boxRow - row -1 ] = '#';

                    while(curCol+1 < boxCol ){

//        char[][] box = {{'#','.','*','.'},
////                      {'#','#','*','.'}};


                        if(res[curCol+1][boxRow - row -1 ] == '.'){
                            res[curCol+1][boxRow - row -1 ] = '#';
                            res[curCol][boxRow - row -1 ] = '.';

                            curCol++;
                            continue;
                        }else{
                            break;
                        }
                    }

                }


            }
        }





        return res;
    }
}
