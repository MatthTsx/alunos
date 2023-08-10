package types;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import pages.*;
import utils.*;

public class Screen extends JFrame{
    
    private ArrayList<Page> pages = new ArrayList<>();
    public String name;
    private Container c;
    public ArrayList<Grade> grades = new ArrayList<>();
    public ArrayList<Aluno> alunos = new ArrayList<>();

    public Screen(String name, int index){
        this.name = name;
        this.init();
        this.c = this.getContentPane();
        this.setPages();
    }

    public void setVisiblePage(int index){
        if(this.c.getComponents().length > 0){
            this.c.removeAll();
        }
        this.pages.get(index).OnLoad();
        this.c.add(this.pages.get(index));
        this.repaint();
        this.revalidate();
    }
    
    private void setPages(){
        pages.add(new HomePage(this));
        pages.add(new AddAluno(this));
        pages.add(new SearchAluno(this));
        pages.add(new AddGrade(this));
        pages.add(new SeachGrade(this));
    }

    private void init(){
        this.setTitle(name); //Add the title to this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setBounds(0, 0, 1080, 720); //Sets the position of the this
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(1080, 720));
        this.setResizable(true);
        this.setVisible(true);
    }
}
