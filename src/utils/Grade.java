package utils;

import java.util.ArrayList;

public class Grade {
    public String codigo;
    public ArrayList<Aluno> alunos = new ArrayList<>();

    public void Change(Object str){
        this.codigo = str.toString();
    }
}
