package controller;

import java.util.List;
import model.bean.Professor;
import model.dao.ProfessorDAO;

public class ProfessorController {

    public boolean insert(String nome, String endereco, String telefone, String email, String formacao, String titulacao, double salario) {
        Professor p = new Professor();
        p.setNome(nome);
        p.setEndereco(endereco);
        p.setFone(telefone);
        p.setEmail(email);
        p.setFormacao(formacao);
        p.setTitulacao(titulacao);
        p.setSalario(salario);
        
        ProfessorDAO pro = new ProfessorDAO();
        return pro.insert(p);
    }
    
    public List<Professor> read() {
        ProfessorDAO pro = new ProfessorDAO();
        return pro.read();
    }
    
    // Refatorado para receber a instância de Professor em vez de 8 parâmetros individuais (Regra java:S107)
    public boolean update(Professor p) {
        ProfessorDAO pro = new ProfessorDAO();
        return pro.update(p);
    }
    
    public boolean delete(int id) {
        Professor p = new Professor();
        p.setIdprofessor(id);
        
        ProfessorDAO pro = new ProfessorDAO();
        return pro.delete(p);
    }
    
    public List<Professor> getProfessoresNome(String n) {     
        ProfessorDAO pd = new ProfessorDAO();
        return pd.getProfessoresNome(n);
    }
    
    public List<Professor> getProfessoresFormacao(String matr) {     
        ProfessorDAO pd = new ProfessorDAO();
        return pd.getProfessoresFormacao(matr);
    }
    
    public List<Professor> getProfessoresTitulacao(String curso) {     
        ProfessorDAO pd = new ProfessorDAO();
        return pd.getProfessoresTitulacao(curso);
    }
}