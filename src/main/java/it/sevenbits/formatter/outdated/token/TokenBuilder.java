package it.sevenbits.formatter.outdated.token;

import java.util.HashMap;

public class TokenBuilder implements IBuildToken {

    private HashMap<String, Token> hashMap;

    public TokenBuilder() {
        hashMap = new HashMap<>();
        hashMap.put("{", new Token("OpenBracket", "{"));
        hashMap.put("}", new Token("CloseBracket", "}"));
        hashMap.put(";", new Token("EndLine", ";"));
        hashMap.put("\n", new Token("LineSeparator", "\n"));
        hashMap.put(" ", new Token("WhiteSpace", " "));
        hashMap.put("/*", new Token("CommentStart", "/*"));
        hashMap.put("*/", new Token("CommentEnd", "*/"));
        hashMap.put("//", new Token("LineComment", "//"));
        hashMap.put("\"", new Token("QuotationMark", "\""));

    }

    @Override
    public Token buildToken(StringBuilder lexeme) {
        String lexemeString = lexeme.toString();
        if (hashMap.containsKey(lexemeString)) {
            return hashMap.get(lexemeString);
        }
        if (lexemeString.startsWith(" ") && lexemeString.endsWith(" ") && lexemeString.length() > 1) {
            return new Token("WhiteSpaces", lexemeString);
        }


        return new Token("Char", lexemeString);
    }
}
