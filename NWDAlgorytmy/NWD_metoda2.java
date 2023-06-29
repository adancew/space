package NWDAlgorytmy;

public class NWD_metoda2 implements NWD {
    @Override
    public int policzNWD(int a, int b) {
        int c;
        while (b!=0) {
           c = a%b;
           a=b;
           b=c;
        }
        return a;
    }
}
