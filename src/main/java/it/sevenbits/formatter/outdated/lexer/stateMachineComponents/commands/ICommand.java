package it.sevenbits.formatter.outdated.lexer.stateMachineComponents.commands;

import it.sevenbits.formatter.outdated.lexer.IContext;

public interface ICommand {
    public void execute(char c, IContext iContext);
}
