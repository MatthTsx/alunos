package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import components.Button;
import types.Page;
import types.Screen;
import utils.Pair;

public class HomePage extends Page {
    ArrayList<Pair> pages = new ArrayList<>();
    String[] texts = {"Alunos input","Aluno search","Grade input","Grade search"};
    JPanel c = new JPanel();

    public HomePage(Screen scrn){
        super(scrn);
        // this.c.setLayout(new GridLayout(10, 20));
        this.c.setPreferredSize(new Dimension(
            (int) Math.floor(this.getWidth() / 1.25),
            (int) Math.floor(this.getHeight() / 1.25)
            )
        );
        this.c.setBackground(Color.black);

        this.initPages();
        this.createComponents();
        JPanel a = new JPanel();
        a.setBackground(Color.black);
        a.add(c);
        this.add(a);
    }

    private void createComponents(){
        for (Pair i : pages) {
            Button b = new Button(() -> {
                this._scrn.setVisiblePage( (int) i.o1);
            });
            b.setPreferredSize(new Dimension(200, 50));
            b.setBackground(Color.gray);
            b.setText((String) i.o2);
            this.c.add(b);
        }
    }

    private void initPages(){
        for(int i = 0; i < texts.length; i++){
            pages.add(new Pair(i + 1, texts[i]));
        }
    }
}
