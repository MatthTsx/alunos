package layout.components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import components.Button;
import types.Screen;

public class Footer extends JPanel{
    public interface A{
        void action(int index);
    }

    public int index;
    public int max;
    public Screen s;
    public int isAlunos;
    public Button.Action a;

    public Footer(int i, int max, JPanel parent, Screen s, int isAlunos,
    Button.Action act){
        this.index = i;
        this.max = max;
        this.s = s;
        this.isAlunos = isAlunos;
        this.a = act;

        this.setLayout(new GridLayout(1,3));
        this.setSize(parent.getWidth(), parent.getHeight() / 10);

        this.Reload();
    }

    public void re(){
        int max = isAlunos == -1? s.alunos.size() : isAlunos == -2? s.grades.size() : s.alunos.get(isAlunos).notas.size();
        this.max = max;
    }

    public void Reload(){

        this.removeAll();

        if(this.index > 0){
            this.add(addButton(index - 1, true));
        }
        this.add(addButton(index, false));
        if(this.index < max){
            this.add(addButton(index + 1, true));
        }
        
        this.repaint();
        this.revalidate();
    }

    public Button addButton(int i, Boolean is){
        Button btn = new Button(
            () -> {this.index = i;this.a.action();}
        );
        btn.setEnabled(is);
        btn.setText(i + "");
        return btn;
    }
}
