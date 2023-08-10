package layout.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.Grade;

public class GradeInfo extends JPanel{
    Grade a;

    public GradeInfo(Grade a, Color c){
        this.a = a;
        this.setLayout(new GridLayout(1,3));
        this.setBackground(c);

        this.add(addLabel(a.codigo));
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
