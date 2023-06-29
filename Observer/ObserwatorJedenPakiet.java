package Observer;

import LiczbyPierwszeAlgorytmy.TestPierwszosci1;
import NWDAlgorytmy.NWD_metoda1;
import Observable.Dane;

import java.util.ArrayList;

public class ObserwatorJedenPakiet extends PoszukiwaczUFO implements Observer {
    // pakiet zawiera informacje z danego dnia
    private ArrayList<Dane> pakiet;

    public ObserwatorJedenPakiet() {
        testPierwszosci = new TestPierwszosci1();
        nwd = new NWD_metoda1();
    }

    @Override
    public void update(ArrayList<Dane> pakiet) {
        this.pakiet = pakiet;
        doAnalyze();
    }

    public void doAnalyze() {
        test0();
        if (pakiet.size() != 0) {
            test1();
            test2();
        }
    }

    // sprawdza czy w tym dniu byly odczyty
    public void test0() {
        if (pakiet.size() == 0)
            Alert.throwAlert(
                    " w tym dniu brak odczytow",
                    pakiet.get(0).getData().substring(0, 10),
                    Alert.Alerty.ZIELONY);
    }

    // sprawdza, czy wszystkie liczby w pakiecie są pierwsze
    public void test1() {
        int ilePierwszych = 0;
        for (Dane i : pakiet) {
            if (testPierwszosci.sprawdzCzyPierwsza(i.getCzestotliwosc())) {
                ilePierwszych++;
            }
        }
        if (ilePierwszych == pakiet.size())
            Alert.throwAlert(" same liczby pierwsze",
                    pakiet.get(0).getData().substring(0, 10),
                    Alert.Alerty.ZOLTY);
    }

    // sprawdza, czy wszystkie liczby w pakiecie maja NWD > 1
    public void test2() {
        if (pakiet.size() == 1) {
            Alert.throwAlert(" NWD dziennych pomiarow > 1",
                    pakiet.get(0).getData().substring(0, 10) ,
                    Alert.Alerty.POMARANCZOWY);
        } else {
            int currentNWD = nwd.policzNWD(
                    pakiet.get(0).getCzestotliwosc(),
                    pakiet.get(1).getCzestotliwosc());

            for (int i = 2; i<pakiet.size(); i++) {
                currentNWD = nwd.policzNWD(currentNWD, pakiet.get(i).getCzestotliwosc());
            }
            if (currentNWD>1)
                Alert.throwAlert(" NWD dziennych pomiarow > 1",
                        pakiet.get(0).getData().substring(0, 10),
                        Alert.Alerty.POMARANCZOWY);
        }
    }

}
