package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Button;
import listeners.TextLis;
import listeners.TextLis.MyInterface;
import types.Page;
import types.Screen;
import utils.Aluno;

public class AddAluno extends Page {
    String[] txts = {
        "Codigo",
        "nome",
        "grade"
    };

    public ArrayList<JTextField> values = new ArrayList<>();
    public ArrayList<Object> vv = new ArrayList<>();

    private JPanel c = new JPanel();

    public AddAluno(Screen scrn){
        super(scrn);
        vv.add("");
        vv.add("");
        vv.add("");

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
        for (int i = 0; i < txts.length; i++) {
            JTextField t = new JTextField();
            t.setPreferredSize(new Dimension(250, 30));
            t.setText(txts[i].toString());
            final int inderx = i;
            t.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t.getText().equals(txts[inderx].toString())) {
                    t.setText("");
                    t.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t.getText().isEmpty()) {
                    t.setForeground(Color.GRAY);
                    t.setText(txts[inderx].toString());
                }
            }
            });
            this.c.add(t);
            MyInterface a = (Object str, int index) -> { this.setValue(str, index); };
            t.getDocument().addDocumentListener(new TextLis(a, i));
            values.add(t);
        }
    }

    public void setValue(Object str, int index){
        if(index >= vv.size()) return;
        vv.set(index, str);
    }

    public void Add(){
        Aluno a = new Aluno(_scrn);
        for (Aluno al : _scrn.alunos) {
            if(al.codigo.equals(vv.get(0).toString())) return;
        }
        for (int i = 0; i < values.size(); i++) {
            if(values.get(i).getText() == null) return;
            a.Change(i, vv.get(i));
            values.get(i).setText("");
        }
        _scrn.alunos.add(a);
    }
}
