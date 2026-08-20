package regex;

public class ValidaCampos {

    // Constante para evitar duplicidade (java:S1192)
    private static final String NAME_PATTERN = "\\p{Upper}[\\p{IsLatin} ]+";

    // Construtor privado para evitar instanciação (java:S1118)
    private ValidaCampos() {
        throw new IllegalStateException("Classe utilitária");
    }

    public static boolean validaNome(String nome) {
        return nome.matches(NAME_PATTERN);
    }

    public static boolean validaEndereco(String endereco) {
        // Corrigido para não usar classe desnecessária em [ ,-] (java:S6397)
        return endereco.matches("\\p{Upper}[\\p{IsLatin}\\p{Alnum} ,-]+");
    }

    public static boolean validaEmail(String correio) {
        // Refatorado para evitar estouro de pilha (java:S5998)
        return correio.matches("[\\p{Alnum}._]+@[\\p{Alnum}]+\\.[\\p{Alnum}]+");
    }

    public static boolean validaFone(String fone) {
        return fone.matches("\\(\\p{Digit}{2}\\) \\p{Digit}{4,5}-\\p{Digit}{4}");
    }

    public static boolean validaMatricula(String matr) {
        return matr.matches("\\p{Alnum}+");
    }

    public static boolean validaCurso(String curso) {
        return curso.matches(NAME_PATTERN);
    }

    public static boolean validaNomeDisciplina(String nome) {
        return nome.matches(NAME_PATTERN);
    }

    public static boolean validaCodigoDisciplina(String codigo) {
        return codigo.matches("\\p{Alnum}+");
    }

    public static boolean validaCargaHoraria(String ch) {
        return ch.matches("\\p{Digit}+");
    }

    public static boolean validaAno(String ano) {
        return ano.matches("\\p{Digit}{4}");
    }

    public static boolean validaNota(String n) {
        // Corrigida a regex da nota para aceitar decimal simples
        return n.matches("\\p{Digit}{1,2}(\\.\\p{Digit}{1,2})?");
    }

    public static boolean validaFaltas(String f) {
        return f.matches("\\p{Digit}+");
    }

    public static boolean validaFormacao(String forma) {
        // Corrigido de \p{Cimbo} para \p{Upper} (presumindo o padrão de nomenclatura)
        return forma.matches(NAME_PATTERN);
    }

    public static boolean validaSalario(String sal) {
        return sal.matches("\\p{Digit}{1,10}(\\.\\p{Digit}{1,3})?");
    }
}