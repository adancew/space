package ProjektMain;

import Observable.DaneKosmos;
import Observer.*;

public class Main {

    public static void main(String[] args) {

        DaneKosmos daneKosmos = new DaneKosmos();
        ObserwatorJedenPakiet obs1= new ObserwatorJedenPakiet();
        ObserwatorWszystkiePakiety obs2= new ObserwatorWszystkiePakiety();
        daneKosmos.registerObserver(obs1);
        daneKosmos.registerObserver(obs2);

        daneKosmos.uruchomCzujnik();


    }
}
