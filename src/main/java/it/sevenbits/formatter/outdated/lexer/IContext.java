package it.sevenbits.formatter.outdated.lexer;

public interface IContext {
    void appendLexeme(char c);
    void setTokenName(String s);
    void appendPostpone(char c);
}
