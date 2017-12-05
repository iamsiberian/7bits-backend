package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.lexer.stateMachineComponents.CommandRepository;
import it.sevenbits.formatter.lexer.stateMachineComponents.State;
import it.sevenbits.formatter.lexer.stateMachineComponents.Transitions;
import it.sevenbits.formatter.lexer.stateMachineComponents.commands.ICommand;
import it.sevenbits.formatter.token.IToken;
import it.sevenbits.formatter.token.Token;
import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.token.TokenBuilder;

/**
 * Class Lexer is intended for reading lexemes
 *
 * @author Minyukhin Ilya
 */
public final class Lexer implements ILexer {

    private IReader iReader;
    private Token token;
    private Transitions transitions;
    private CommandRepository commandRepository;
    private State state;
    private char prevCharValue;
    private TokenBuilder tokenBuilder;
    //private StringBuilder lexeme;

    /**
     * The constructor initializes instance of a class
     *
     * @param iReader class that implements iReader interface
     * @throws ReaderException if an error occurred
     */
    public Lexer(final IReader iReader) throws ReaderException {
        this.iReader = iReader;
        transitions = new Transitions();
        commandRepository = new CommandRepository();
        state = new State("StartLexeme");
        tokenBuilder = new TokenBuilder();
        //lexeme =  new StringBuilder();
    }

    @Override
    public IToken readToken() throws ReaderException {

        StringBuilder lexeme =  new StringBuilder();

        /*
        while (postponeReader.hasNext() && !state.getName().equals("EndLexeme")) {
            state = step(state, iReader);
        }
        */



        while (iReader.hasNext() && !state.getName().equals("EndLexeme")) {

            char c = iReader.readNext();
            ICommand command = commandRepository.getCommand(state, c);
            command.execute(c, lexeme);
            state = transitions.nextState(state, c);

            //state = step(state, iReader);
        }

        return tokenBuilder.buildToken(lexeme);
    }

    /**
     * The method checks if there are more tokens, when an empty token is received at the input, it returns NO
     * @return boleean yes/no
     */
    @Override
    public boolean hasMoreTokens() throws ReaderException {
        try {
            return iReader.hasNext();
        } catch (ReaderException e) {
            throw new ReaderException("Lexer.hasMoreTokens() generated error in iReader.hasNext();", e);
        }
    }

    /*
    private State step(State state, IReader iReader) throws ReaderException {
        try {
            char c = iReader.readNext();
            ICommand command = commandRepository.getCommand(state, c);
            command.execute(c, lexeme);
            return transitions.nextState(state, c);
        } catch (ReaderException e) {
            throw new ReaderException("ReaderException in Lexer.step(State state, IReader iReader)", e);
        }
    }
    */
}
