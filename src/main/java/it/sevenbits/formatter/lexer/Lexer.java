package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.lexer.stateMachineComponents.Command;
import it.sevenbits.formatter.lexer.stateMachineComponents.CommandRepository;
import it.sevenbits.formatter.lexer.stateMachineComponents.State;
import it.sevenbits.formatter.lexer.stateMachineComponents.Transitions;
import it.sevenbits.formatter.token.IToken;
import it.sevenbits.formatter.token.Token;
import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;

/**
 * Class Lexer is intended for reading lexemes
 *
 * @author Minyukhin Ilya
 */
public final class Lexer implements ILexer {

    private IReader iReader;
    private Token token;
    private Transitions transitions;

    /**
     * The constructor initializes instance of a class
     *
     * @param iReader class that implements iReader interface
     * @throws ReaderException if an error occurred
     */
    private Lexer(final IReader iReader) throws ReaderException {
        this.iReader = iReader;
        token = (Token) readToken();
        transitions = new Transitions();
    }

    @Override
    public IToken readToken() throws ReaderException {
        Token prevToken = token;
        StringBuilder lexeme =  new StringBuilder();

        State state = new State("init");
        while (iReader.hasNext() && state != null) {
            char c = iReader.readNext();
            Command command = CommandRepository.getCommand(state, c);
            command.execute(lexeme);
            state = transitions.nextState();
        }

        token = new Token("name", lexeme.toString());
        return prevToken;
    }

    /**
     * The method checks if there are more tokens, when an empty token is received at the input, it returns NO
     * @return boleean yes/no
     */
    @Override
    public boolean hasMoreTokens() {
        return (!token.getName().equals("") && token.getLexeme().equals(""));
    }
}
