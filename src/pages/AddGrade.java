package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Button;
import listeners.TextLis;
import listeners.TextLis.MyInterface;
import types.Page;
import types.Screen;
import utils.Grade;

public class AddGrade extends Page {
    String[] txts = {
        "Codigo",
    };

    public JTextField values = new JTextField();
    public Object vv;

    private JPanel c = new JPanel();

    public AddGrade(Screen scrn){
        super(scrn);

        this.createComponents();
        this.c.setBackground(null);
        this.add(c);

        JPanel p = new JPanel();
        Button btn = new Button(() -> {this.Add();});
        p.add(btn);
        p.setBackground(null);
        btn.setBackground(Color.gray);
        btn.setText("Add");
        this.add(p, BorderLayout.SOUTH);
    }

    private void createComponents(){
        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(250, 30));
        t.setText(txts[0].toString());
        t.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (t.getText().equals(txts[0].toString())) {
                t.setText("");
                t.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (t.getText().isEmpty()) {
                t.setForeground(Color.GRAY);
                t.setText(txts[0].toString());
            }
        }
        });
        this.c.add(t);
        MyInterface a = (Object str, int index) -> { this.setValue(str, index); };
        t.getDocument().addDocumentListener(new TextLis(a, 0));
        values = t;
    }

    public void setValue(Object str, int index){
        if(str.toString().length() == 0) return;
        for (Grade g: _scrn.grades) {
            if(g.codigo.equals(str.toString())) return;
        }
        vv = str;
        values.setText("Codigo");
    }

    public void Add(){
        Grade g = new Grade();
        Boolean cont = true;
        if(vv.toString() == null) return;
        for (Grade gs : _scrn.grades) {
            if(gs.codigo == vv.toString()) cont = false; break;
        }
        if(cont){
            g.Change(vv);
            _scrn.grades.add(g);
        }
    }
}
