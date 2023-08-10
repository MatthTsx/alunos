package components;

import javax.swing.JButton;

import listeners.ButtonAct;

public class Button extends JButton{
    public interface Action {
        void action();
    };

    Action act;

    public Button(Action act){
        this.act = act;

        this.addActionListener(new ButtonAct(act));
    }
}
