package api_OperatoreTelefonico;

public class NotEnoughCreditException extends Exception {
    public NotEnoughCreditException(String msg){
        super(msg);
    }

    @Override
    public String getMessage(){
        return "Not enough credit";
    }
}