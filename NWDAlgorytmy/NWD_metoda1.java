package NWDAlgorytmy;

public class NWD_metoda1 implements NWD{
    @Override
    public int policzNWD(int a, int b) {
        if(a!=b)
            return policzNWD(a>b ? a-b : a, b>a ? b-a:b);
        return a;

    }
}
