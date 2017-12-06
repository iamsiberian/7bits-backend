package it.sevenbits.formatter.lexer.stateMachineComponents.commands;

import it.sevenbits.formatter.lexer.IContext;

/**
 * Created by user on 06.12.2017.
 */
public class WriteComment implements ICommand {

    @Override
    public void execute(char c, IContext iContext) {
        iContext.appendLexeme(c);
        iContext.setTokenName("Comment");
    }
}
