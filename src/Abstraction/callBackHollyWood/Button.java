package Abstraction.callBackHollyWood;

public class Button {
    Executable action;

    public Button(Executable newaction){
        this.action = newaction;
    }

    public void click(){
        action.execute();
    }
}
