package Observable;

public class Dane {
    private String data;
    private int czestotliwosc;

    public Dane(String data, int czestotliwosc) {
        this.data = data;
        this.czestotliwosc = czestotliwosc;

    }

    public String getData() {
        return data;
    }

    public int getCzestotliwosc() {
        return czestotliwosc;
    }

    @Override
    public String toString() {
        return data+" "+czestotliwosc;
    }
}
