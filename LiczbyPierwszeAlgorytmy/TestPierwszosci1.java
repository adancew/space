package LiczbyPierwszeAlgorytmy;

public class TestPierwszosci1 implements TestPierwszosci{
    @Override
    public boolean sprawdzCzyPierwsza(int a) {
        if(a<2) return false;
        if(a==2) return true;
        for(int i = 2; i*i<=a; i++){
            if(a%i==0) return false;
        }
        return true;

    }
}
