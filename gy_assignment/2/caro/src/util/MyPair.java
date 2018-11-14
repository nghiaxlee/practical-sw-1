package util;

public class MyPair<A, B> {
    public A first;
    public B second;

    public MyPair(A first, B second)
    {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
