package layout.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import components.Button;
import pages.SearchAluno;
import utils.Aluno;

public class alunoInfo extends JPanel{
    Aluno a;
    SearchAluno parent;

    public alunoInfo(Aluno a, Color c, SearchAluno parent, int index){
        this.parent = parent;

        this.a = a;
        this.setLayout(new GridLayout(1,4));
        this.setBackground(c);

        this.add(addLabel(a.codigo));
        this.add(addLabel(a.name));
        this.add(addLabel(a.g.codigo));
        Button btn = new Button(() -> {
            this.parent._scrn.index = index;
            this.parent._scrn.setVisiblePage(5);
        });
        btn.setText("Manage");
        
        this.add(btn);
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
