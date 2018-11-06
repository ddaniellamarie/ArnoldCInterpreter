import java.util.ArrayList;

public class ArnoldCLexer {

  public enum ArnoldCLexemes {

    // FALSE("@I LIED"),
    // TRUE("@NO PROBLEMO"),
    // IF("BECAUSE I'M GOING TO SAY PLEASE"),
    // ELSE("BULLSHIT"),
    // ENDIF("YOU HAVE NO RESPECT FOR LOGIC"),
    // WHILE("STICK AROUND"),
    // ENDWHILE("CHILL"),
    //
    //
    // ADD("GET UP"),
    // SUBTRACT("GET DOWN"),
    // MULTIPLY("YOU'RE FIRED"),
    // DIVIDE("HE HAD TO SPLIT"),
    // MODULO("I LET HIM GO"),
    // EQUALEQUAL("YOU ARE NOT YOU YOU ARE ME"),
    // GREATERTHAN("LET OFF SOME STEAM BENNET"),
    // OR("CONSIDER THAT A DIVORCE"),
    // AND("KNOCK KNOCK"),
    //
    //
    // DECLAREMETHOD("LISTEN TO ME VERY CAREFULLY"),
    // // NONVOIDMETHOD("GIVE THESE PEOPLE AIR"),
    // // METHODARGUMENTS("I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE"),
    // // RETURN("I'LL BE BACK"),
    // // ENDMETHOD("HASTA LA VISTA, BABY"),
    // // CALLMETHOD("DO IT NOW"),
    // ASSIGNVARIABLEFROMMETHODCALL("GET YOUR ASS TO MARS"),
    // DECLAREINTEGER("HEY CHRISTMAS TREE"),
    // SETINITIALVALUE("YOU SET US UP"),
    // BEGINMAIN("IT'S SHOWTIME"),
    // ENDMAIN("YOU HAVE BEEN TERMINATED"),
    // PRINT("TALK TO THE HAND"),
    // READINTEGER("I WANT TO ASK YOU A BUNCH OF QUESTIONS AND I WANT TO HAVE THEM ANSWERED IMMEDIATELY"),
    // ASSIGNVARIABLE("GET TO THE CHOPPER"),
    // SETVALUE("HERE IS MY INVITATION"),
    // ENDASSIGNVARIABLE("ENOUGH TALK");

    //enumerations in java have private constructors
    INTEGER("[0-9]"),
    WHITESPACE("[\t\f\r\n]+"),
    ARHITHMETICOPERATOR("GET UP
                        |GET DOWN
                        |YOU'RE FIRED
                        |HE HAD TO SPLIT
                        |I LET HIM GO"),
    LOGICALOPERATOR("YOU ARE NOT YOU YOU ARE ME
                    |LET OFF SOME STEAM BENNET
                    |CONSIDER THAT A DIVORCE
                    |KNOCK KNOCK"),
    DELIMITER("\""),
    STRINGLITERAL(".*"),
    BOOLEAN("@I LIED|@NO PROBLEMO"),
    FUNCTIONIDENTIFIER("BECAUSE I'M GOING TO SAY PLEASE
                        |BULLSHIT
                        |YOU HAVE NO RESPECT FOR LOGIC
                        |STICK AROUND
                        |CHILL
                        |LISTEN TO ME VERY CAREFULLY
                        |GET YOUR ASS TO MARS
                        |HEY CHRISTMAS TREE
                        |YOU SET US UP
                        |IT'S SHOWTIME
                        |YOU HAVE BEEN TERMINATED
                        |TALK TO THE HAND
                        |I WANT TO ASK YOU A BUNCH OF QUESTIONS AND I WANT THEM ANSWERED IMMEDIATELY
                        |GET TO THE CHOPPER
                        |HERE IS MY INVITATION
                        |ENOUGH TALK");



    private String s;

    private ArnoldCLexemes(String s){
      this.s = s;
    }

    public String svalue(){
      return this.s;
    }

  }

}
