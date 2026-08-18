package regex;

import java.util.regex.Pattern;

public class ValidaCampos {

    // Constante para a regex de nome compartilhada em 4 métodos
    private static final Pattern NOME_PATTERN = Pattern.compile("\\p{Upper}[\\p{IsLatin} ]+");
    
    // Padrões pre-compilados para os demais métodos (Melhor performance e evita re-compilação)
    private static final Pattern ENDERECO_PATTERN = Pattern.compile("\\p{Upper}[\\p{IsLatin}\\p{Alnum} ,-]+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\p{Alnum}._%+-]+@[\\p{Alnum}.-]+\\.[\\p{Alnum}]{2,}$");
    private static final Pattern FONE_PATTERN = Pattern.compile("\\(\\p{Digit}{2}\\)\\s\\p{Digit}{4,5}-\\p{Digit}{4}");
    private static final Pattern ALNUM_PATTERN = Pattern.compile("\\p{Alnum}+");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\p{Digit}+");
    private static final Pattern ANO_PATTERN = Pattern.compile("\\p{Digit}{4}");
    private static final Pattern NOTA_PATTERN = Pattern.compile("\\p{Digit}{1,2}(\\.\\p{Digit}{1,2})?");
    private static final Pattern SALARIO_PATTERN = Pattern.compile("\\p{Digit}{1,10}(\\.\\p{Digit}{1,3})?");

    // Construtor privado adicionado para esconder o construtor público implícito (Classe utilitária)
    private ValidaCampos() {
        throw new UnsupportedOperationException("Classe utilitária não deve ser instanciada.");
    }

    public static boolean validaNome(String nome) {
        return nome != null && NOME_PATTERN.matcher(nome).matches();
    }

    public static boolean validaEndereco(String endereco) {
        return endereco != null && ENDERECO_PATTERN.matcher(endereco).matches();
    }

    public static boolean validaEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean validaFone(String fone) {
        return fone != null && FONE_PATTERN.matcher(fone).matches();
    }

    public static boolean validaMatricula(String matr) {
        return matr != null && ALNUM_PATTERN.matcher(matr).matches();
    }

    public static boolean validaCurso(String curso) {
        return curso != null && NOME_PATTERN.matcher(curso).matches();
    }

    public static boolean validaNomeDisciplina(String nome) {
        return nome != null && NOME_PATTERN.matcher(nome).matches();
    }

    public static boolean validaCodigoDisciplina(String codigo) {
        return codigo != null && ALNUM_PATTERN.matcher(codigo).matches();
    }

    public static boolean validaCargaHoraria(String ch) {
        return ch != null && DIGIT_PATTERN.matcher(ch).matches();
    }

    public static boolean validaAno(String ano) {
        return ano != null && ANO_PATTERN.matcher(ano).matches();
    }

    public static boolean validaNota(String n) {
        return n != null && NOTA_PATTERN.matcher(n).matches();
    }

    public static boolean validaFaltas(String f) {
        return f != null && DIGIT_PATTERN.matcher(f).matches();
    }

    public static boolean validaFormacao(String forma) {
        return forma != null && NOME_PATTERN.matcher(forma).matches();
    }

    public static boolean validaSalario(String sal) {
        return sal != null && SALARIO_PATTERN.matcher(sal).matches();
    }
}