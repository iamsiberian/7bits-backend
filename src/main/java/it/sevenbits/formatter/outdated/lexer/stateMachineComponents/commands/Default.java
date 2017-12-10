package it.sevenbits.formatter.outdated.lexer.stateMachineComponents.commands;

import it.sevenbits.formatter.outdated.lexer.IContext;

public class Default implements ICommand {
/*
    @Override
    public void execute(char c, StringBuilder stringBuilder) {
        stringBuilder.append(c);
    }
*/
    @Override
    public void execute(char c, IContext iContext) {
        iContext.appendLexeme(c);
        iContext.setTokenName("Char");
    }
}
