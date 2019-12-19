package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /**
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(4);
        //lista.add("stringa"); non posso farlo perchè la classe è fortemente tipizzata
         */
        /**
        gLamp // lampada google
        aLamp // lampada amazon
        gHub.add(gLamp);
        gHub.add(aLamp); // non si deve fare
         */
        Hub<Google> googleHub = new Hub<Google>();
        Hub<Amazon> amazonHub = new Hub<Amazon>();

        GoogleLamp glamp = new GoogleLamp();
        AmazonLamp alamp = new AmazonLamp();

        googleHub.addDevice(glamp);
        //googleHub.addDevice(alamp);
        //amazonHub.addDevice(glamp);
        amazonHub.addDevice(alamp);
    }
}
