package it.sevenbits.formatter.outdated.token;

/**
 * class Token is designed to store lexemes and their names
 *
 * @author Minyukhin Ilya
 */
public class Token implements IToken {
    private String tokenName;
    private String lexeme;

    /**
     * The default constructor that creates an empty token
     */
    public Token() {
        this.tokenName = "";
        this.lexeme = "";
    }

    /**
     * A constructor that creates a token, assigning it a name and a value (a token)
     *
     * @param tokenName token name
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
    public String toString() {
        return "<" + getName() + "> : <" + getLexeme() + ">";
    }
}
