package EcoFriendly;

class Consumer {
    private int id;
    private String name;
    private int waterCountDay;
    private int waterCountNight;
    private int gasCount;
    private int electroCountDay;
    private int electroCountNight;

    public Consumer(int id, String name, int waterCountDay, int waterCountNight, int gasCount, int electroCountDay, int electroCountNight) {
        this.id = id;
        this.name = name;
        this.waterCountDay = waterCountDay;
        this.waterCountNight = waterCountNight;
        this.gasCount = gasCount;
        this.electroCountDay = electroCountDay;
        this.electroCountNight = electroCountNight;
    }

    public Consumer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWaterCountDay() {
        return waterCountDay;
    }

    public int getWaterCountNight() {
        return waterCountNight;
    }

    public int getGasCount() {
        return gasCount;
    }

    public int getElectroCountDay() {
        return electroCountDay;
    }

    public int getElectroCountNight() {
        return electroCountNight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaterCountDay(int waterCountDay) {
        this.waterCountDay = waterCountDay;
    }

    public void setWaterCountNight(int waterCountNight) {
        this.waterCountNight = waterCountNight;
    }

    public void setGasCount(int gasCount) {
        this.gasCount = gasCount;
    }

    public void setElectroCountDay(int electroCountDay) {
        this.electroCountDay = electroCountDay;
    }

    public void setElectroCountNight(int electroCountNight) {
        this.electroCountNight = electroCountNight;
    }

    @Override
    public String toString() {
        return id +
                "|" + name +
                "|" + waterCountDay +
                "|" + waterCountNight +
                "|" + gasCount +
                "|" + electroCountDay +
                "|" + electroCountNight;
    }
}