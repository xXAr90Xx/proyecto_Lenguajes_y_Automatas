
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    public AnalizadorLexico(String rutaArchivo) {
        // Carga el código desde el archivo y realiza el análisis léxico.
        String codigoEntrada = cargarCodigoDesdeArchivo(rutaArchivo);
        List<Token> tokens = analizar(codigoEntrada);
        // Imprime los tokens resultantes.
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    /**
     * Carga el código desde un archivo de texto.
     *
     * @param rutaArchivo Ruta del archivo de texto.
     * @return Código cargado desde el archivo.
     */
    public String cargarCodigoDesdeArchivo(String rutaArchivo) {
        StringBuilder codigo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                codigo.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
        return codigo.toString();
    }

    /**
     * Realiza el análisis léxico del código.
     *
     * @param codigo Código a analizar.
     * @return Lista de tokens generados durante el análisis léxico.
     */
    public static List<Token> analizar(String codigo) {
        List<Token> tokens = new ArrayList<Token>();

        // Expresión regular actualizada
        String regex = "(?i)\\s+|("
                + "(SiNo|FinSino|Si|FinSi|Repite|Mientras|FMientras|Car|Cad|Num|IniC|FinC|IniB|FinB|Dec|Bool|Seno|Coseno|Tangente|Cotangente|Secante|Cosecante|Elegir|Com|MensajeS|DatoE|Posicion|Gravedad|Sprite|Velocidad|Vacio)"
                + "|[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?"
                + "|==|<=|>=|!=|[\\(|\\)|\\[|\\]|\\¿|\\?]|[a-zA-Z_][a-zA-Z0-9_]*|\"[^\"]*\")";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(codigo);

        // Itera sobre las coincidencias y genera tokens.
        while (matcher.find()) {
            String textoToken = matcher.group();
            TipoToken tipoToken;

            // Identifica el tipo de token según la expresión regular.
            if (textoToken.matches("[+-]?\\d+|([+-]?\\d*\\.\\d+([eE][+-]?\\d+)?)?")) {
                tipoToken = TipoToken.NUMERO;
            } else if (textoToken.matches("IniC|FinC|IniB|FinB")) {
                tipoToken = TipoToken.INICIODEBLOQUE;
            } else if (textoToken.matches("Car|Cad|Num|Dec|Bool")) {
                tipoToken = TipoToken.TIPODEDATO;
            } else if (textoToken.matches("Com|MensajeS")) {
                tipoToken = TipoToken.COMUNICACION;
            } else if (textoToken.matches("Seno|Coseno|Tangente|Cotangente|Secante|Cosecante")) {
                tipoToken = TipoToken.FUNCIONESESPECIALES;
            } else if (textoToken.matches("Si|SiNo|Repite|Mientras|FMientras|Car|Cad|Num|IniC|FinC|IniB|FinB|Dec|Bool|Seno|Coseno|Tangente|Cotangente|Secante|Cosecante|Elegir|Com|MensajeS|DatoE|Posicion|Gravedad|Sprite|Velocidad")) {
                tipoToken = TipoToken.PALABRARESERVADA;
            } else if (textoToken.matches("Si|SiNo|Repite|Mientras|FMientras|Elegir")) {
                tipoToken = TipoToken.CONTROL;
            } else if (textoToken.matches("\"[^\"]*\"")) {
                tipoToken = TipoToken.CARACTER;
            } else if (textoToken.matches("Gravedad")) {
                tipoToken = TipoToken.CONSTANTESESPECIALES;
            } else if (textoToken.matches("Sprite|Velocidad")) {
                tipoToken = TipoToken.OBJETOSENTIDADES;
            } else if (textoToken.matches(" ")) {
                tipoToken = TipoToken.ESPACIO;
            } else if (textoToken.matches("[+|*|/|-|%|e|E]")) {
                tipoToken = TipoToken.OPERADORAR;
            } else if (textoToken.matches("==|<=|>=|!=")) {
                tipoToken = TipoToken.OPERADORRE;
            } else if (textoToken.matches("\\[\\(|\\)|\\[|\\]|\\¿|\\?]")) {
                tipoToken = TipoToken.OPERADORAG;
            } else if (textoToken.matches("\\[++|--]")) {
                tipoToken = TipoToken.OPERADORIYD;
            } else if (textoToken.matches("(&&|^^|!)")) {
                tipoToken = TipoToken.OPERADORLOG;
            } else if (textoToken.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                tipoToken = TipoToken.IDENTIFICADOR;
            } else if (textoToken.matches("\n")) {
                tipoToken = TipoToken.SALTO;
            } else if (textoToken.matches("=|\\+=|-=")) {
                tipoToken = TipoToken.OPERADORASG;
            } else {
                tipoToken = TipoToken.INVALIDO;
            }

            // Agrega el token a la lista.
            tokens.add(new Token(tipoToken, textoToken,"error lexico"));
        }

        return tokens;
    }
}

/**
 * Enumeración que representa los diferentes tipos de tokens.
 */
enum TipoToken {
    // Define tus tipos de token aquí
    NUMERO,
    IDENTIFICADOR,
    CARACTER,
    INVALIDO,
    ESPACIO,
    OPERADORAR,
    OPERADORRE,
    OPERADORAG,
    OPERADORIYD,
    OPERADORLOG,
    OPERADORASG,
    PALABRARESERVADA,
    SALTO,
    BUCLE,
    EXCEPCIONES,
    CONTROL,
    INICIODEBLOQUE,
    TIPODEDATO,
    COMUNICACION,
    FUNCIONESESPECIALES,
    CONSTANTESESPECIALES,
    OBJETOSENTIDADES,
}

/**
 * Clase que representa un token con su tipo y texto asociado.
 */
class Token {

    public TipoToken tipo;
    public String texto;
    // Campo adicional para el mensaje de error
    private String error;

    /**
     * Constructor de la clase Token.
     *
     * @param tipo Tipo del token.
     * @param texto Texto asociado al token.
     */
    // Constructor modificado para incluir el mensaje de error
    public Token(TipoToken tipo, String texto, String error) {
        this.tipo = tipo;
        this.texto = texto;
        this.error = error;
    }

    /**
     * Obtiene el tipo del token.
     *
     * @return Tipo del token.
     */
    public TipoToken getTipo() {
        return tipo;
    }

    /**
     * Obtiene el texto asociado al token.
     *
     * @return Texto asociado al token.
     */
    public String getTexto() {
        return texto;
    }

    // Método para obtener el mensaje de error
    public String getError() {
        return error;
    }

    /**
     * Representación en cadena del token.
     *
     * @return Cadena que representa el token.
     */
    @Override
    public String toString() {
        return "Token tipo = " + tipo + " , texto= " + texto;
    }
}
