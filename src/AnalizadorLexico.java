
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    public static void main(String[] args) {
        String codigoEntrada = "Num años = 12+12\nSi(12<=25)"
                + "\n MensajeS \"asinomasquedó\"";

        List<Token> tokens = analizar(codigoEntrada);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    public static List<Token> analizar(String codigo) {
        List<Token> tokens = new ArrayList<Token>();

        String regex = "\\s+|("
                + "Si|SiNo|Repite|Mientras|FMientras|Car|Cad|Num|IniC|FinC|IniB|FinB|Dec|Bool|Seno|Coseno|Tangente|Cotangente|Secante|Cosecante|Elegir|Com|MensajeS|DatoE|Posicion"
                + "\\d+|==|<=|>=|[+*\\-/%=<>()]|[a-zA-Z_][a-zA-Z0-9_]*|\"[^\"]*\")";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(codigo);

        while (matcher.find()) {
            String textoToken = matcher.group();
            TipoToken tipoToken;
//
            if (textoToken.matches("\\d+|[+-]?[d+]|[+-]?[d+]*.[d+]|([eE][+-]?[d+])?")) {
                tipoToken = TipoToken.NUMERO;
            } else if (textoToken.matches("Si|SiNo|Repite|Mientras|FMientras|Car|Cad|Num|IniC|FinC|IniB|FinB|Dec|Bool|Seno|Coseno|Tangente|Cotangente|Secante|Cosecante|Elegir|Com|MensajeS|DatoE|Posicion")) {
                tipoToken = TipoToken.PALABRARESERVADA;
            } else if (textoToken.matches("\"[^\"]*\"")) {
                tipoToken = TipoToken.CARACTER;
            } else if (textoToken.matches(" ")) {
                tipoToken = TipoToken.ESPACIO;
            } else if (textoToken.matches("==|<=|>=|[+*\\-/%=<>()]")) {
                tipoToken = TipoToken.OPERADOR;
            }else if (textoToken.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                tipoToken = TipoToken.IDENTIFICADOR;
            }else if (textoToken.matches("\n")) {
                tipoToken= TipoToken.SALTO;
            }else
            {
                tipoToken = TipoToken.INVALIDO;
            }

            tokens.add(new Token(tipoToken, textoToken));
        }

        return tokens;
    }
}

enum TipoToken {
    // Define tus tipos de token aquí
    NUMERO,
    IDENTIFICADOR,
    CARACTER,
    INVALIDO,
    ESPACIO,
    OPERADOR,
    PALABRARESERVADA,
    SALTO
    // ...
}

class Token {

    private TipoToken tipo;
    private String texto;

    public Token(TipoToken tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "Token tipo = " + tipo + " , texto= " + texto;
    }
}
