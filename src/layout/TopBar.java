package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import components.Button;
import types.Page;

public class TopBar extends JPanel{
    Page parent;

    public TopBar(Page parent){
        this.parent = parent;

        this.setPreferredSize(new Dimension(
            this.parent.getWidth(),
            this.parent.getHeight() / 15
        ));
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.createComponents();
    }

    private void createComponents(){
        Button btn = new Button(() -> {
            this.parent._scrn.setVisiblePage(0);
        });
        btn.setBackground(Color.lightGray);
        btn.setText("Go back");
        this.add(btn, BorderLayout.WEST);
    }
}
