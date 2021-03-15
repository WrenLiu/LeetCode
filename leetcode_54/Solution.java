class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new LinkedList<>();



        int rows = matrix.length;
        int columns = matrix[0].length;

        List<Integer> result = new LinkedList<>();
        int indexResult = 0;
        int ring = 0;

        // 循坏得以继续的条件就是ring*2永远小于行数和列数，其实就是找中间的位置，但是偶数的时候需要先-1
        while(columns > ring *2 && rows > ring*2 && indexResult < rows*columns ){
            indexResult = spiralOrderMain(matrix,result,indexResult,ring);
            ring++;
        }

        return result;

    }


    private static int spiralOrderMain(int[][] matrix ,List<Integer> result,int result_index,int rings ){

        int endRow = matrix.length - rings -1;
        int endCol = matrix[0].length - rings - 1;

        // 处理最上方行
        for (int i = rings; i <= endCol; i++) {
            // result[result_index++] = matrix[rings][i];
            result_index++;
            result.add( matrix[rings][i]);
        }

        // 处理最右边列
        if(rings <= endRow) {
            for (int i = rings + 1; i <= endRow; i++) {
                // result[result_index++] = matrix[i][endCol];
                result_index++;
                result.add(matrix[i][endCol]);
            }
        }


        // 处理最下边行
        if(rings<endCol && rings < endRow) {
            for (int i = endCol - 1; i >= rings; i--) {
                // result[result_index++] = matrix[endRow][i];
                result_index++;
                result.add(matrix[endRow][i]);
            }
        }

        // 处理最左边的列
        if(rings < endCol && rings < endRow-1) {
            for (int i = endRow - 1; i > rings; i--) {
                // result[result_index++] = matrix[i][rings];
                result_index++;
                result.add( matrix[i][rings]);
            }
        }

        return result_index;
    }






}