package controller;

import java.util.List;
import model.bean.Disciplinas;
import model.bean.Professor;
import model.bean.ProfessorDisciplina;
import model.dao.ProfessorDisciplinaDAO;

public class ProfessorDisciplinaController {

    public boolean insert(Professor prof, Disciplinas disco, int semes, int ano, String dias) {
        ProfessorDisciplina pd = new ProfessorDisciplina();
        pd.setProfessor(prof);
        pd.setDisciplina(disco);
        pd.setSemestre(semes);
        pd.setAno(ano);
        pd.setDia(dias);
        
        ProfessorDisciplinaDAO pdd = new ProfessorDisciplinaDAO();
        return pdd.insert(pd);
    }
    
    public boolean update(Professor prof, Disciplinas disco, int semes, int ano, String dias) {
        ProfessorDisciplina pd = new ProfessorDisciplina();
        pd.setProfessor(prof);
        pd.setDisciplina(disco);
        pd.setSemestre(semes);
        pd.setAno(ano);
        pd.setDia(dias);
        
        ProfessorDisciplinaDAO pdd = new ProfessorDisciplinaDAO();
        return pdd.update(pd);
    }
    
    public List<ProfessorDisciplina> getDisciplinasProfessor(int idprof) {
        ProfessorDisciplinaDAO pd = new ProfessorDisciplinaDAO();
        
        // Atribuição inicial inútil removida: a lista é inicializada diretamente do DAO (java:S1854)
        List<ProfessorDisciplina> array = pd.getDisciplinasProfessor(idprof);
        
        for (ProfessorDisciplina pdesc : array) {
            String dias = "";
            if (pdesc.getDia().contains("S")) {
                dias += "Segunda";
            }
            if (pdesc.getDia().contains("T")) {
                dias += "Terça ";
            }
            if (pdesc.getDia().contains("Q")) {
                dias += "Quarta";
            }
            if (pdesc.getDia().contains("U")) {
                dias += "Quinta";
            }
            if (pdesc.getDia().contains("X")) {
                dias += "Sexta";
            }
            
            pdesc.setDia(dias);
        }
        return array;
    }
    
    public boolean delete(int idprof, int iddisc) {
        ProfessorDisciplina pd = new ProfessorDisciplina();
        Professor prof = new Professor();
        prof.setIdprofessor(idprof);
        
        Disciplinas disco = new Disciplinas();
        disco.setId(iddisc);
        
        pd.setProfessor(prof);
        pd.setDisciplina(disco);
        
        ProfessorDisciplinaDAO p = new ProfessorDisciplinaDAO();
        return p.delete(pd);
    }
}