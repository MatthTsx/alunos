package layout.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.Aluno;

public class alunoInfo extends JPanel{
    Aluno a;

    public alunoInfo(Aluno a, Color c){
        this.a = a;
        this.setLayout(new GridLayout(1,3));
        this.setBackground(c);

        this.add(addLabel(a.codigo));
        this.add(addLabel(a.name));
        this.add(addLabel(a.g.codigo));
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
