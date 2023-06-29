package LiczbyPierwszeAlgorytmy;

public class TestPierwszosci2 implements TestPierwszosci{
    @Override
    public boolean sprawdzCzyPierwsza(int a) {
        if(a<2) return false;
        if(a==2 || a==3 || a==5 || a==7) return true;
        if(a%6!=1 && a%6!=5) return false;
        for(int i = 6; i<=a; i+=6){
            if(a%(i-1)==0) return false;
            if(a>i+1 && a%(i+1)==0) return false;
        }
        return true;

    }
}
