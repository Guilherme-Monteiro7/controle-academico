package regex;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    private static final Logger LOGGER = Logger.getLogger(regex.class.getName());

    public static void main(String[] args) {
        // Expressão regular corrigida para evitar repetições aninhadas perigosas (S5998)
        String regex = "[\\p{Alnum}._]+@[\\p{Alnum}]+(\\.[\\p{Alnum}]+)*";
        String texto = "n_puipo@yttuyy viin.lopes@terra.com.br iou-po@gmail.com ert@trt_tyu";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        LOGGER.log(Level.INFO, "Texto: {0}", texto);
        LOGGER.info("Índice: 012345678901234567");
        LOGGER.log(Level.INFO, "Expressão: {0}", pattern.pattern());
        LOGGER.info("Posições encontradas:");

        while (matcher.find()) {
            LOGGER.log(Level.INFO, "{0} {1}", new Object[]{matcher.start(), matcher.group()});
        }

        String dado = "teste_.5T1234@gmail.com.org";
        LOGGER.log(Level.INFO, "Email valido? {0}", dado.matches(regex));
    }
}