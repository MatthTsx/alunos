package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import layout.components.Footer;
import layout.components.alunoInfo;
import types.Page;
import types.Screen;
import utils.Aluno;

public class SearchAluno extends Page{
    
    int PorPage = 20;
    Footer footer;
    JPanel c = new JPanel(new GridLayout(PorPage, 1, 5, 0));

    public SearchAluno(Screen scrn){
        super(scrn);
        footer = new Footer(0, (int) Math.floor( _scrn.alunos.size() / this.PorPage),
            this, _scrn, -2, () -> {
            this.Change();
        });
        this.add(footer, BorderLayout.SOUTH);
        c.setBackground(null);
        this.add(c);
    }

    public void addComps(){
        this.c.removeAll();
        for (int i = footer.index*PorPage; i < Math.min(_scrn.alunos.size(), footer.index*PorPage + PorPage); i++) {
            Aluno al = _scrn.alunos.get(i);
            c.add(new alunoInfo(al, i % 2 == 0 ? Color.gray : Color.LIGHT_GRAY, this, i));
        }
        this.c.revalidate();
        this.c.repaint();
    }

    @Override
    public void OnLoad(){
        addComps();
        footer.re();
        footer.Reload();
    }

    public void Change(){
        this.footer.max = _scrn.alunos.size() / PorPage;
        this.addComps();
        this.footer.Reload();
    }
}
