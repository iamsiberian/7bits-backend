package it.sevenbits.formatter.token;

/**
 * Class token that stores the name of the token and the lexeme
 *
 * @author Minyukhin Ilya
 */
public class Token implements IToken {
    private String tokenName = "";
    private String lexeme = "";

    /**
     * A basic constructor initializing the fields of an instance of the class
     *
     * @param tokenName name of the token
     * @param lexeme lexeme
     */
    public Token(final String tokenName, final String lexeme) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return tokenName;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token token = (Token) o;

        return tokenName != null ? tokenName.equals(token.tokenName) : token.tokenName == null;
    }

    @Override
    public int hashCode() {
        return tokenName != null ? tokenName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenName='" + tokenName + '\'' +
                ", lexeme='" + lexeme + '\'' +
                '}';
    }
}
