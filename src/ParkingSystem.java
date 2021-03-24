class ParkingSystem {
    public int[] res =new int[3];
    public ParkingSystem(int big, int medium, int small) {
        res[0]=big;
        res[1]=medium;
        res[2]=small;
    }

    public boolean addCar(int carType) {
        if(res[carType-1]>0){
            res[carType-1]--;
            return true;
        }
        return false;
    }
}