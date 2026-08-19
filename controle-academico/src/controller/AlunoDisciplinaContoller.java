package controller;

import java.util.List;
import model.bean.Aluno;
import model.bean.AlunoDisciplina;
import model.bean.Disciplinas;
import model.dao.AlunoDisciplinaDAO;

public class AlunoDisciplinaContoller {

    public boolean insert(Aluno aluno, Disciplinas disco, int semes, int ano, double nota1, double nota2, int faltas) {
        AlunoDisciplina ad = new AlunoDisciplina();
        ad.setAluno(aluno);
        ad.setDisciplinas(disco);
        ad.setSemestre(semes);
        ad.setAno(ano);
        ad.setNota1(nota1);
        ad.setNota2(nota2);
        ad.setFaltas(faltas);
        
        AlunoDisciplinaDAO add = new AlunoDisciplinaDAO();
        return add.insert(ad);
    }
    
    public boolean update(Aluno aluno, Disciplinas disco, int semes, int ano, double nota1, double nota2, int faltas) {
        AlunoDisciplina ad = new AlunoDisciplina();
        ad.setAluno(aluno);
        ad.setDisciplinas(disco);
        ad.setSemestre(semes);
        ad.setAno(ano);
        ad.setNota1(nota1);
        ad.setNota2(nota2);
        ad.setFaltas(faltas);
        
        AlunoDisciplinaDAO add = new AlunoDisciplinaDAO();
        return add.update(ad);
    }
    
    public List<AlunoDisciplina> read(Aluno a) {
        AlunoDisciplinaDAO ad = new AlunoDisciplinaDAO();
        return ad.read(a);
    }
    
    public boolean delete(Aluno aluno, Disciplinas disco) {
        AlunoDisciplina a = new AlunoDisciplina();
        a.setAluno(aluno);
        a.setDisciplinas(disco);
        
        AlunoDisciplinaDAO add = new AlunoDisciplinaDAO();
        return add.delete(a);
    }
}