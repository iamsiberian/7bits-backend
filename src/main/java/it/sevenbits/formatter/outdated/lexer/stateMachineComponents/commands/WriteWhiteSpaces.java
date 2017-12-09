package it.sevenbits.formatter.outdated.lexer.stateMachineComponents.commands;

import it.sevenbits.formatter.outdated.lexer.IContext;

/**
 * Created by user on 02.12.2017.
 */
public class WriteWhiteSpaces implements ICommand {
    @Override
    public void execute(char c, IContext iContext) {
        iContext.appendLexeme(c);
        iContext.setTokenName("WhiteSpace");
    }
    /*
    @Override
    public void execute(char c, StringBuilder stringBuilder) {
        stringBuilder.append(c);
    }*/

}
