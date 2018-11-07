import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.util.Scanner;


public class Lexer {
  public static enum TokenType {
    // Token types cannot have underscores
    INTEGERLITERAL("[0-9]+"), 
    VARIABLEIDENTIFIER("[a-z]+[a-zA-Z0-9_]*"),
    //STRINGLITERAL(".*"),
    DELIMITER("\""),
    BOOLEAN("@I LIED|@NO PROBLEMO"),
    ARITHMETICOPERATOR("GET UP|GETDOWN|YOU'RE FIRED|HE HAD TO SPLIT|I LET HIM GO"), 
    LOGICALOPERATOR("YOU ARE NOT YOU YOU ARE ME|LET OFF SOME STEAM BENNET|CONSIDER THAT A DIVORCE|KNOCK KNOCK"),
    FUNCTIONIDENTIFIER("IT'S SHOWTIME|YOU HAVE BEEN TERMINATED|BECAUSE I'M GOING TO SAY PLEASE|BULLSHIT|YOU HAVE NO RESPECT FOR LOGIC|STICK AROUND|CHILL|LISTEN TO ME VERY CAREFULLY|GET YOUR ASS TO MARS|HEY CHRISTMAS TREE|YOU SET US UP|IT'S SHOWTIME|YOU HAVE BEEN TERMINATED|TALK TO THE HAND|I WANT TO ASK YOU A BUNCH OF QUESTIONS AND I WANT THEM ANSWERED IMMEDIATELY|GET TO THE CHOPPER|HERE IS MY INVITATION|ENOUGH TALK"),
    WHITESPACE("[ \t\f\r\n]+");

    public final String pattern;

    private TokenType(String pattern) {
      this.pattern = pattern;
    }
  }

  public static class Token {
    public TokenType type;
    public String data;

    public Token(TokenType type, String data) {
      this.type = type;
      this.data = data;
    }

    @Override
    public String toString() {
      return String.format("(%s %s)", type.name(), data);
    }
  }

  public static ArrayList<Token> lex(String input) {
    // The tokens to return
    ArrayList<Token> tokens = new ArrayList<Token>();

    // Lexer logic begins here
    StringBuffer tokenPatternsBuffer = new StringBuffer();
    for (TokenType tokenType : TokenType.values())
      tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
    Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

    // Begin matching tokens
    Matcher matcher = tokenPatterns.matcher(input);
    while (matcher.find()) {
      if (matcher.group(TokenType.INTEGERLITERAL.name()) != null) {
        tokens.add(new Token(TokenType.INTEGERLITERAL, matcher.group(TokenType.INTEGERLITERAL.name())));
        continue;
      } else if (matcher.group(TokenType.VARIABLEIDENTIFIER.name()) != null) {
        tokens.add(new Token(TokenType.VARIABLEIDENTIFIER, matcher.group(TokenType.VARIABLEIDENTIFIER.name())));
        continue;
      } else if (matcher.group(TokenType.DELIMITER.name()) != null) {
        tokens.add(new Token(TokenType.DELIMITER, matcher.group(TokenType.DELIMITER.name())));
        continue;
      } else if (matcher.group(TokenType.BOOLEAN.name()) != null) {
        tokens.add(new Token(TokenType.BOOLEAN, matcher.group(TokenType.BOOLEAN.name())));
        continue;
      } else if (matcher.group(TokenType.ARITHMETICOPERATOR.name()) != null) {
        tokens.add(new Token(TokenType.ARITHMETICOPERATOR, matcher.group(TokenType.ARITHMETICOPERATOR.name())));
        continue;
      } else if (matcher.group(TokenType.LOGICALOPERATOR.name()) != null) {
        tokens.add(new Token(TokenType.LOGICALOPERATOR, matcher.group(TokenType.LOGICALOPERATOR.name())));
        continue;
      } else if (matcher.group(TokenType.FUNCTIONIDENTIFIER.name()) != null) {
        tokens.add(new Token(TokenType.FUNCTIONIDENTIFIER, matcher.group(TokenType.FUNCTIONIDENTIFIER.name())));
        continue;
      } else if (matcher.group(TokenType.WHITESPACE.name()) != null)
        continue;
    }

    return tokens;
  }


  public static void main(String[] args) throws Exception {
    // String input = "IT'S SHOWTIME\nHEY CHRISTMAS TREE x\nYOU SET US UP 5\nYOU HAVE BEEN TERMINATED";

    // pass the path to the file as a parameter 
    File file = new File("keywords.arnoldc"); 
    Scanner sc = new Scanner(file); 

    // Create tokens and print them
    while (sc.hasNextLine()){ 
      ArrayList<Token> tokens = lex(sc.nextLine());
      for (Token token : tokens) System.out.println(token);
    }
  }

}


