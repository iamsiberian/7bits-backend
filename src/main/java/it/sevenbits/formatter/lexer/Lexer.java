package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.lexer.stateMachineComponents.CommandRepository;
import it.sevenbits.formatter.lexer.stateMachineComponents.PostponeReader;
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
public final class Lexer implements ILexer, IContext {

    private IReader iReader;
    private StringBuilder lexeme;
    private StringBuilder postpone;
    private PostponeReader postponeReader;

    private Transitions transitions;
    private CommandRepository commandRepository;
    private State state;

    private String tokenName;

    private Token token;
    private TokenBuilder tokenBuilder;

    /**
     * The constructor initializes instance of a class
     *
     * @param iReader class that implements iReader interface
     * @throws ReaderException if an error occurred
     */
    public Lexer(final IReader iReader) throws ReaderException {

        this.iReader = iReader;
        lexeme =  new StringBuilder();
        postpone = new StringBuilder();
        postponeReader = new PostponeReader(postpone);

        transitions = new Transitions();
        commandRepository = new CommandRepository();
        //state = new State("StartLexeme");

        tokenName = "";

        //token = new Token();
        tokenBuilder = new TokenBuilder();
    }

    @Override
    public IToken readToken() throws ReaderException {
        state = new State("StartLexeme");
        lexeme.delete(0, lexeme.length());

        while (postponeReader.hasNext() && !state.getName().equals("EndLexeme")) {
            state = step(state, this);
        }

        while (iReader.hasNext() && !state.getName().equals("EndLexeme")) {
/*
            char c = iReader.readNext();
            ICommand command = commandRepository.getCommand(state, c);
            command.execute(c, this);
            state = transitions.nextState(state, c);
*/
            state = step(state, this);
        }

        return /*tokenBuilder.buildToken(lexeme)*/ buildToken();
    }

    /**
     * The method checks if there are more tokens, when an empty token is received at the input, it returns NO
     * @return boolean yes/no
     */
    @Override
    public boolean hasMoreTokens() throws ReaderException {
        try {
            return iReader.hasNext();
        } catch (ReaderException e) {
            throw new ReaderException("Lexer.hasMoreTokens() generated error in iReader.hasNext();", e);
        }
    }

    @Override
    public void appendLexeme(char c) {
        lexeme.append(c);
    }

    @Override
    public void setTokenName(String s) {
        tokenName = s;
    }

    @Override
    public void appendPostpone(char c) {
        postpone.append(c);
    }


    private State step(State state, IContext iContext) throws ReaderException {
        try {
            char c = iReader.readNext();
            ICommand command = commandRepository.getCommand(state, c);
            command.execute(c, iContext);
            return transitions.nextState(state, c);
        } catch (ReaderException e) {
            throw new ReaderException("ReaderException in Lexer.step(State state, IReader iReader)", e);
        }
    }

    private Token buildToken() {
        return new Token(tokenName, lexeme.toString());
    }
}
