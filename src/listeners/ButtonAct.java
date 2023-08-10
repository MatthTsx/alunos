package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Button;

public class ButtonAct implements ActionListener{


    private Button.Action act;

    public ButtonAct(Button.Action act){
        this.act = act;
    }

    public void actionPerformed(ActionEvent e) {
        this.act.action();
    }
}
