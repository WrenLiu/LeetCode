public class Solution {

    public static void main(String[] args) {


        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));


    }

    static class ParkingSystem {

        private int bigNum , mediumNum , smallNum ;
        public ParkingSystem(int big, int medium, int small) {

            if(big < 0 || medium < 0 || small < 0){
                this.bigNum = 0;
                this.mediumNum = 0;
                this.smallNum = 0;
                return;
            }

            this.bigNum = big;
            this.mediumNum = medium;
            this.smallNum = small;

        }

        public boolean addCar(int carType) {

            if(carType == 0){
                return false;
            }

            if(carType == 1){

                if(bigNum > 0) {
                    bigNum -- ;
                    return true;
                }else if(bigNum == 0){
                    return false;
                }
            }

            if(carType == 2){

                if(mediumNum > 0) {
                    mediumNum -- ;
                    return true;
                }else if(mediumNum == 0){
                    return false;
                }
            }

            if(carType == 3){

                if(smallNum > 0) {
                    smallNum -- ;
                    return true;
                }else if(smallNum == 0){
                    return false;
                }
            }

            return false;

        }
    }



}
