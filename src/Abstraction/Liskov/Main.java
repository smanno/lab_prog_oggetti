package Abstraction.Liskov;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PhoneMessage sms = new PhoneMessage("3345596682", "22383093590", new Date(), "Hello everybody!");

        Notifier notifier = new Notifier();
        notifier.push(sms);

        /*What if I'd like to add an MMS (message with image) object to my world?*/
        /**
         * devo creare una nuova classe MMS che erediterà da SMS
         * devo chiedermi, tutto quello che vale per SMS varrà anche per MMS?
         * sì, allora posso ereditare
         * Per il principio di Liskov, posso usare un MMS come un SMS
         */
        MessageWithImage mms = new MessageWithImage("3345596682", "22383093590", new Date(), "Hello everybody!", null);
        notifier.push(mms); // possiamo usare push con un MMS che verrà trattato come SMS
    }
}