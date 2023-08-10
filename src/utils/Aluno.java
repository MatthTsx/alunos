package utils;

import java.util.ArrayList;

import types.Screen;

public class Aluno {
    public String codigo;
    public String name;
    public Grade g;
    public ArrayList<Pair> notas;
    // 1: codigo
    // 2: name
    // 3: GradeCodigo
    // 4: Notas
    public Screen scrn;

    public Aluno(Screen scrn){
        this.scrn = scrn;
    }

    public void Change(int i, Object value){
        if(i == 0) codigo = value.toString();
        else if(i == 1) name = value.toString();
        else if(i == 2){
            Boolean has = false;
            for (Grade pair : scrn.grades) {
                if(pair.codigo == value.toString()) {
                    has = true;
                    pair.alunos.add(this);
                    this.g = pair;
                }
            }
            if(!has){
                Grade gr = new Grade();
                gr.alunos.add(this);
                gr.codigo = value.toString();
                scrn.grades.add(gr);
                this.g = gr;
            }
        }
    }
}
