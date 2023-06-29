package Observable;

import Observer.Observer;

import java.util.ArrayList;

public class DaneKosmos implements Observable {
    // pakiet zawiera informacje z jednego dnia
    private ArrayList<Dane> pakiet;

    private ArrayList<Observer> ObserverList;
    private Czujnik czujnik;

    public DaneKosmos() {
        czujnik = new Czujnik(this);
        ObserverList = new ArrayList<>();
    }

    public void uruchomCzujnik() {
        System.out.print(
                "\n PROGRAM POSZUKUJACY ZYCIA POZAZIEMSKIEGO\n" +
                        "              _.---._   .   .     *\n" +
                        "    *       .'       '.\n" +
                        "        _.-~===========~-._\n" +
                        "       (___________________)       .   *\n" +
                        "  .          \\_______/ \n" +
                        " Program analizuje zachowanie promieniowanie kosmicznego na podstawie danych z pliku.\n"+
                        " Wykrywszy podejrzaną aktywność wypisuje ostrzezenie w konsoli.\n"+
                        " Ostrzezenia sa takze automatycznie archiwizowane w pliku tesktowym.\n"+
                        " ***********************************************************************\n"
        );
        System.out.printf("\n%-20s | %15s | %s\n", "ranga alertu", "data", " komentarz");
        czujnik.uruchomCzujnik("data.txt");
    }


    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer i : ObserverList)
            i.update(pakiet);
    }

    public void ustawPomiary(ArrayList<Dane> pakiet) {
        this.pakiet = pakiet;
        if (pakiet != null) notifyObservers();
    }
}
