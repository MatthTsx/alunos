package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import layout.components.Footer;
import layout.components.GradeInfo;
import types.Page;
import types.Screen;
import utils.Grade;

public class SeachGrade extends Page{
    
    int PorPage = 20;
    Footer footer;
    JPanel c = new JPanel(new GridLayout(PorPage / 4, 4, 5, 0));

    public SeachGrade(Screen scrn){
        super(scrn);
        footer = new Footer(0, (int) Math.floor( _scrn.grades.size() / this.PorPage),
            this, _scrn, false, () -> {
            this.Change();
        });
        this.add(footer, BorderLayout.SOUTH);
        c.setBackground(null);
        this.add(c);
    }

    public void addComps(){
        this.c.removeAll();
        for (int i = 0 + footer.index*PorPage; i < Math.min(_scrn.grades.size(), footer.index*PorPage + PorPage); i++) {
            Grade al = _scrn.grades.get(i);
            c.add(new GradeInfo(al, i % 2 == 0 ? Color.gray : Color.LIGHT_GRAY));
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
        this.footer.max = _scrn.grades.size() / PorPage;
        this.addComps();
        this.footer.Reload();
    }
}
