public class Brick {
    private int y1;
    private int x1;
    private int y2;
    private int x2;

    public Brick(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
    }

    public Brick(String brick) {
        String[] brick_data = brick.split("_");
        String[] firstData = brick_data[0].split("x");
        String[] secondData = brick_data[1].split("x");

        y1 = Integer.parseInt(firstData[0]);
        x1 = Integer.parseInt(firstData[1]);
        y2 = Integer.parseInt(secondData[0]);
        x2 = Integer.parseInt(secondData[1]);
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public boolean equals(Object o)
    {
        return o instanceof Brick && ((((Brick) o).x1 ==this.x1 && ((Brick) o).y1==this.y1 && ((Brick) o).x2==this.x2 && ((Brick) o).y2==this.y2) ||
                (this.x1 == ((Brick) o).x2 && this.y1 == ((Brick) o).y2 && this.x2 == ((Brick) o).x1 && this.y2 == ((Brick) o).y1));
    }

    public boolean equalsBrick(String s) {
        String[] brick_data = s.split("_");
        String[] firstData = brick_data[0].split("x");
        String[] secondData = brick_data[1].split("x");

        int y1 = Integer.parseInt(firstData[0]);
        int x1 = Integer.parseInt(firstData[1]);
        int y2 = Integer.parseInt(secondData[0]);
        int x2 = Integer.parseInt(secondData[1]);


        if ((this.y1 == y1 && this.x1 == x1 && this.x2 == x2 && this.y2 == y2) ||
                (this.y1 == y2 && this.x1 == x2 && this.y2 == y1 && this.x2 == x1))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y1).append('x').append(x1).append('_').append(y2).append('x').append(x2);
        return sb.toString();
    }
}
