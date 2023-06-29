package Observable;

import Observer.Alert;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Czujnik {
    private DaneKosmos daneKosmos;

    public Czujnik(DaneKosmos daneKosmos){
        this.daneKosmos = daneKosmos;
    }

    // funkcja pomocnicza - tworzy losowe pomiary i wypisuje w konsoli.
    public static void generujOdczyty(){
        LocalDateTime t = LocalDateTime.now();
        for(int i = 0; i<100; i++){
            System.out.println(t.
                    plusMinutes(2000+i*20).
                    format(DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm:ss"))+
                    " "+(int)(200 + Math.random() * (200)));

        }

    }

    // symulator czujnika - pobiera wartosci pomiarow z pliku
    public void uruchomCzujnik(String filename){

        ArrayList <Dane> pakiet = new ArrayList<Dane>();
        String linia;
        String dzien;
        Dane pomoc;

        File plik = new File("data//"+filename);

        try (BufferedReader breader = new BufferedReader(new FileReader(plik))){
            while((linia = breader.readLine())!=null){
                pomoc = new Dane(linia.split(" ")[0],
                        Integer.parseInt(linia.split(" ")[1]));

                if(pakiet.size() == 0 ||
                        pomoc.getData().substring(8,10).equals(pakiet.get(0).getData().substring(8,10))){
                    pakiet.add(pomoc);
                }
                else{
                    daneKosmos.ustawPomiary(pakiet);
                    pakiet.clear();
                }

            }
            daneKosmos.ustawPomiary(pakiet);
            pakiet.clear();
        } catch (IOException e){
            System.out.print("Wystapił blad! :(");
        }

        Alert.zapisz();

    }
}
