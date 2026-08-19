package model.bean;

public class Disciplinas {
    private int id; // Ajustado para camelCase
    private String nome;
    private String codigo;
    private int cargaHoraria;

    // Construtor padrão com inicialização de valores default (Abordagem 1)
    public Disciplinas() {
        this.id = 0;
        this.nome = "";
        this.codigo = "";
        this.cargaHoraria = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}