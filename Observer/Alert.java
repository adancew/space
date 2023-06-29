package Observer;

import Observable.Dane;

import java.io.FileWriter;
import java.util.ArrayList;

public class Alert {
    private static ArrayList<String> archiwum = new ArrayList<>();

    public enum Alerty{
        CZERWONY, POMARANCZOWY, ZOLTY, ZIELONY;
    }

    public static void throwAlert(String message, String data, Alert.Alerty kolor){
        System.out.printf("\n%-20s | %15s | %s\n", "Alert "+kolor, data, message);
        archiwum.add(String.format("%-20s | %15s | %s\n", "Alert "+kolor, data, message));
    }

    // zapisz zawartosc archiwum do pliku.
    // metoda jest uruwamiana po zakonczeniu odczytu z pliku z danymi (z czujnika)
    public static void zapisz(){
        try(FileWriter myWriter = new FileWriter("data//archiwum_alertow.txt")){
            for(String s : archiwum){
                myWriter.write(s+"\n");
            }
        } catch (java.io.IOException e){
            System.out.print("Nie udalo sie zapisac alertow do pliku :(\n");
        }
    }


}
