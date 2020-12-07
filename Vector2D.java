public final class Vector2D {
    public double x, y;

    // constructor for zero vector
    public Vector2D() {}

    // constructor for vector with given coordinates
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // constructor that copies the argument vector
    public Vector2D(Vector2D v) {
        set(v);
    }

    // set coordinates
    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    // set coordinates based on argument vector
    public Vector2D set(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
        return this;
    }

    // compare for equality (note Object type argument)
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Vector2D) {
            Vector2D v = (Vector2D) o;
            return (x == v.x) && (y == v.y);
        }
        return false;
    }

    // String for displaying vector as text
    public String toString() {
        return "Vector2d[" + x + ", " + y + "]";
    }

    //  magnitude (= "length") of this vector
    public double mag() {
        return Math.sqrt(x * x + y * y);
    }

    // angle between vector and horizontal axis in radians in range [-PI,PI]
// can be calculated using Math.atan2
    public double angle() {
        return Math.atan2(y, x);
    }

    public double angle(Vector2D other) {
        return 0;
    }

    // add argument vector
    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    // add values to coordinates
    public Vector2D add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    // weighted add - surprisingly useful
    public Vector2D addScaled(Vector2D v, double fac) {
        this.x += v.x * fac;
        this.y += v.y * fac;
        return this;
    }

    // subtract argument vector
    public Vector2D subtract(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    // subtract values from coordinates
    public Vector2D subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    // multiply with factor
    public Vector2D mult(double fac) {
        x *= fac;
        y *= fac;
        return this;
    }

    // rotate by angle given in radians
    public Vector2D rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double rx = x * cos - y * sin;
        y = x * sin + y * cos;
        x = rx;
        return this;
    }

    // "dot product" ("scalar product") with argument vector
    public double dot(Vector2D v, Vector2D v2) {
        return (v.x * v2.x + v.y * v2.y);
    }

    // distance to argument vector
    public double dist(Vector2D v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    // normalise vector so that magnitude becomes 1
    public Vector2D normalise() {
        double magnitude = mag();
        double newX = (magnitude > 0) ? (x / magnitude) : 0.0;
        double newY = (magnitude > 0) ? (y / magnitude) : 0.0;

        Vector2D newVec = new Vector2D(newX, newY);
        return newVec;
    }

    public Vector2D wrap(double w, double h) {return null;}

    // construct vector with given polar coordinates
    public static Vector2D polar(double angle, double mag) {
        return new Vector2D(mag * Math.cos(angle), mag * Math.sin(angle));
    }

}