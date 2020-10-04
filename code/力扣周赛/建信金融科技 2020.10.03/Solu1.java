//1 设计停车系统

class ParkingSystem {
    int[] container;
    public ParkingSystem(int big, int medium, int small) {
        container = new int[]{big,medium,small};
    }

    public boolean addCar(int carType) {
        return (container[carType - 1]--) > 0 ;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
