package net.zhongli.geometry;

public class Voxel2D {

    private int x;
    private int y;

    public Voxel2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Voxel2D other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Voxel2D add(Voxel2D other) {
        return new Voxel2D(this.x + other.x, this.y + other.y);
    }

    public Voxel2D subtract(Voxel2D other) {
        return new Voxel2D(this.x - other.x, this.y - other.y);
    }

    public Voxel2D multiply(Voxel2D other) {
        return new Voxel2D(this.x * other.x, this.y * other.y);
    }

    public Voxel2D divide(Voxel2D other) {
        return new Voxel2D(this.x / other.x, this.y / other.y);
    }

    public Voxel2D add(int x, int y) {
        return new Voxel2D(this.x + x, this.y + y);
    }

    public Voxel2D subtract(int x, int y) {
        return new Voxel2D(this.x - x, this.y - y);
    }

    public Voxel2D multiply(int x, int y) {
        return new Voxel2D(this.x * x, this.y * y);
    }

    public Voxel2D divide(int x, int y) {
        return new Voxel2D(this.x / x, this.y / y);
    }

    public Voxel2D add(int value) {
        return new Voxel2D(this.x + value, this.y + value);
    }

    public Voxel2D subtract(int value) {
        return new Voxel2D(this.x - value, this.y - value);
    }

    public Voxel2D multiply(int value) {
        return new Voxel2D(this.x * value, this.y * value);
    }

    public Voxel2D divide(int value) {
        return new Voxel2D(this.x / value, this.y / value);
    }

    public Voxel2D addX(int value) {
        return new Voxel2D(this.x + value, this.y);
    }

    public Voxel2D subtractX(int value) {
        return new Voxel2D(this.x - value, this.y);
    }

    public Voxel2D multiplyX(int value) {
        return new Voxel2D(this.x * value, this.y);
    }

    public Voxel2D divideX(int value) {
        return new Voxel2D(this.x / value, this.y);
    }

    public Voxel2D addY(int value) {
        return new Voxel2D(this.x, this.y + value);
    }

    public Voxel2D subtractY(int value) {
        return new Voxel2D(this.x, this.y - value);
    }

    public Voxel2D multiplyY(int value) {
        return new Voxel2D(this.x, this.y * value);
    }

    public Voxel2D divideY(int value) {
        return new Voxel2D(this.x, this.y / value);
    }

    public Voxel2D add(Voxel2D other, int value) {
        return new Voxel2D(this.x + other.x + value, this.y + other.y + value);
    }

    public Voxel2D subtract(Voxel2D other, int value) {
        return new Voxel2D(this.x - other.x - value, this.y - other.y - value);
    }

    public Voxel2D multiply(Voxel2D other, int value) {
        return new Voxel2D(this.x * other.x * value, this.y * other.y * value);
    }

    public Voxel2D divide(Voxel2D other, int value) {
        return new Voxel2D(this.x / other.x / value, this.y / other.y / value);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
