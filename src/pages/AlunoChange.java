package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Button;
import layout.components.Footer;
import listeners.TextLis;
import listeners.TextLis.MyInterface;
import types.Page;
import types.Screen;
import utils.Aluno;
import utils.Pair;

public class AlunoChange extends Page { //go horse
    public int index = -1;
    private int PageIndex = 0;
    private int PorPage = 15;
    public Aluno al;
    public JPanel c = new JPanel(new BorderLayout());
    public Footer footer;
    private JPanel Infos = new JPanel();
    private JLabel textinhoLa = new JLabel();

    private float getAvg(ArrayList<Pair> notas){
        float n = 0;
        for (Pair pair : notas) {
            n += Float.parseFloat( pair.o2.toString() );
        }
        n /= notas.size();
        return n;
    }

    public AlunoChange(Screen scrn){
        super(scrn);
        this.c.setBackground(null);
        this.add(c);
    }

    @Override
    public void OnLoad(){
        if(index != _scrn.index) {
            this.index = this._scrn.index;
            this.al = _scrn.alunos.get(index);
            this.Load();
        };
    }

    public void Load(){
        this.c.removeAll();

        JPanel top = new JPanel();
        JTextField t = new JTextField(al.name);
        t.setPreferredSize(new Dimension(250, 30));
        t.setText(al.name);
        t.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t.getText().equals(al.name)) {
                    t.setText("");
                    t.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t.getText().isEmpty()) {
                    t.setForeground(Color.GRAY);
                    t.setText(al.name);
                }
            }
        });
        MyInterface a = (Object str, int index) -> { this.al.name = str.toString(); };
        t.getDocument().addDocumentListener(new TextLis(a,0));
        
        top.add(t);
        float avg = this.getAvg(al.notas);
        textinhoLa.setText(
            "Media geral: " + avg + "              " + (avg < 5 ? "Reprovado" : "Aprovado")
        );
        top.add(textinhoLa);
            
        footer = new Footer(
            PageIndex,
            (int) Math.floor(al.notas.size()/PorPage),
            this,
            _scrn,
            index,
            () -> {
                this.footer.max = al.notas.size() / PorPage;
                this.re();
                this.footer.Reload();
            }
        );
        
        Button reload = new Button(() -> {
            this._scrn.alunos.set(index, al);
            this.re();
        });
        reload.setText("Update");

        JPanel bottom = new JPanel(new GridLayout(2,1));
        bottom.add(reload);
        bottom.add(footer);
        this.re();
        
        this.c.add(bottom, BorderLayout.SOUTH);
        this.c.add(Infos);
        this.c.add(top, BorderLayout.NORTH);
        this.c.repaint();
        this.c.revalidate();
    }

    public void re(){
        Infos.removeAll();
        Infos.setLayout(new GridLayout(PorPage + 1, 1));
        for (int i = PorPage * footer.index; i < Math.min(footer.index*PorPage + PorPage, al.notas.size()); i++) {
            Pair not = al.notas.get(i);
            JPanel pp = new JPanel(new GridLayout(1,4));
            pp.add(new JLabel(not.o1.toString()));
            pp.add(new JLabel(not.o2.toString()));
            JTextField _t = new JTextField(al.name);
            _t.setPreferredSize(new Dimension(250, 30));
            _t.setText(not.o2.toString());
            _t.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (_t.getText().equals(not.o2.toString())) {
                        _t.setText("");
                        _t.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (_t.getText().isEmpty()) {
                        _t.setForeground(Color.GRAY);
                        _t.setText(not.o2.toString());
                    }
                }
            });
            MyInterface _a = (Object str, int index) -> { this.al.notas.get(index).o2 = Float.parseFloat(str.toString()); };
            _t.getDocument().addDocumentListener(new TextLis(_a,i));
            final int a = i;
            Button delete = new Button(() -> {
                _scrn.alunos.get(index).notas.remove(a);
                this.re();
            });
            delete.setText("Delete");
            pp.add(delete);
            pp.add(_t);
            Infos.add(pp);
        }
        Button btn = new Button(() -> {
            _scrn.alunos.get(index).notas.add(new Pair("Prova",0));
            this.re();
        });
        btn.setText("add");
        Infos.add(btn);
        Infos.repaint();
        Infos.revalidate();

        float avg = this.getAvg(al.notas);
        textinhoLa.setText("Media geral: " + avg + "              " + (avg < 5 ? "Reprovado" : "Aprovado"));
        footer.re();
        footer.Reload();
        footer.max = this.al.notas.size() / PorPage;
        // textinhoLa.repaint();
        // textinhoLa.revalidate();
    }
}
