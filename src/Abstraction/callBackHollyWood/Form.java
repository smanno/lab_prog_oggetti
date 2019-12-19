package Abstraction.callBackHollyWood;

public class Form {
    private String title = "Form1";
    
    public Form(){
        Button btn = new Button(new Executable() {
            @Override
            public void execute() {
                Form newForm = new Form();
                newForm.show();
            }
        });

    }

    private void show() {
        // TODO: 19/12/2019
    }
}
