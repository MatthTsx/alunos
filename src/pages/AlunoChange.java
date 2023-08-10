package pages;

import types.Page;
import types.Screen;
import utils.Aluno;

public class AlunoChange extends Page {
    public int index;
    public Aluno al;

    public AlunoChange(Screen scrn, int index){
        super(scrn);
        this.index = index;
        this.al = _scrn.alunos.get(index);

        
    }
}
