package layout.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.Aluno;
import utils.Grade;
import utils.Pair;

public class GradeInfo extends JPanel{
    Grade a;

    public float getAvg(){
        float resp = 0;
        int qntd = 0;
        for (Aluno al : a.alunos) {
            for (Pair p : al.notas) {
                resp += Float.parseFloat( p.o2.toString() );
                qntd++;
            }
        }
        resp /= qntd == 0 ? 1 : qntd;
        return resp;
    }

    public GradeInfo(Grade a, Color c){
        this.a = a;
        this.setLayout(new GridLayout(1,3));
        this.setBackground(c);

        JPanel jp = new JPanel(new GridLayout(1,2));
        jp.add(addLabel(a.codigo));
        jp.add(addLabel(getAvg()));
        this.add(jp);
    }

    private JLabel addLabel(Object str){
        JLabel jl = new JLabel();
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        if(str != null){
            jl.setText(str.toString());
        }else{
            jl.setText("");
        }
        return jl;
    }
}
