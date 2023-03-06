public class Plant {
    private int id;
    private int x;
    private int y;
    private int state;
    private int water;

    public Plant(int id, int x, int y, int state, int water) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.state = state;
        this.water = water;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
