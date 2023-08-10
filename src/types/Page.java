package types;

import javax.swing.JPanel;

import layout.TopBar;

import java.awt.*;

public class Page extends JPanel{
    public Screen _scrn;

    public Page(Screen scrn){
        this._scrn = scrn;
        // this.setPreferredSize(scrn.getSize());
        this.setSize(scrn.getSize());
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());

        this.add(new TopBar(this), BorderLayout.NORTH);
    }

    public void OnLoad(){
        
    }
}
