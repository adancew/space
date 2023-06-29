package Observer;

import Observable.Dane;

import java.util.ArrayList;

public class ObserwatorWszystkiePakiety implements Observer{
    private ArrayList<ArrayList<Dane>> pakiety;

    private int ile_dni_wysoka_f = 2;

    public ObserwatorWszystkiePakiety(){
        pakiety = new ArrayList<>();
    }

    @Override
    public void update(ArrayList<Dane> pakiet) {
        pakiety.add(pakiet);
        doAnalyze();
    }

    public void doAnalyze(){
        test1();
    }

    // czy srednia czestotliwosc przez minimum 2 dni wyższa od 1000
    public void test1(){
        if(pakiety.size()>=2){
            if(srednia(pakiety.get(pakiety.size()-1))>1000 && srednia(pakiety.get(pakiety.size()-2))>1000) {
                Alert.throwAlert( " od " + ile_dni_wysoka_f + " dni czestotliwosc >1000!",
                        pakiety.get(pakiety.size() - 1).get(0).getData().substring(0, 10),
                        Alert.Alerty.CZERWONY);
                ile_dni_wysoka_f++;
            } else {
                ile_dni_wysoka_f = 2;
            }
        }

    }


    public double srednia(ArrayList<Dane> p){
        double suma = 0;
        for(Dane i : p){
            suma+=i.getCzestotliwosc();
        }
        return suma/p.size();

    }
}
