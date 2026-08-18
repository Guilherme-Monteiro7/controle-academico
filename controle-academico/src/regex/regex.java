package regex;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    
    private static final Logger LOGGER = Logger.getLogger(RegexUtil.class.getName());

    public static void main(String[] args) {
        // Regex corrigida e simplificada para evitar falhas de backtracking excessivo
        String regex = "^[\\p{Alnum}._-]+@[\\p{Alnum.-]+\\.[\\p{Alnum}]{2,}$";
        String texto = "n_puipo@yttuyy viin.lopes@terra.com.br iou-po@gmail.com ert@trt_tyu";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        
        LOGGER.info("Texto: " + texto);
        LOGGER.info("Índice: 012345678901234567");
        LOGGER.info("Expressão: " + matcher.pattern().pattern());
        LOGGER.info("Posições encontradas: ");
        
        while (matcher.find()) {
            LOGGER.info(matcher.start() + " " + matcher.group());
        }
        
        String dado = "teste_.5T1234@gmail.com.org";
        LOGGER.info("Email valido? " + dado.matches(regex));
    }
}