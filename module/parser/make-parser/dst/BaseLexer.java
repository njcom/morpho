import org.antlr.v4.runtime.Lexer;
import java.util.ArrayList;
import org.antlr.v4.runtime.CharStream;

public abstract class BaseLexer extends Lexer {
/*    protected LexerState state = LexerState.INIT;

    private ArrayList<LexerState> inclusiveStates = new ArrayList<LexerState>();*/

    public BaseLexer(CharStream input) {
        super(input);
    }

/*    protected Boolean writeLog(Object first, Boolean second) {
        System.out.println(first);
        return second;
    }

    protected void setInclusiveState(LexerState state) {
        inclusiveStates.add(state);
    }

    protected Boolean isState(LexerState state) {
        return this.state == state || this.inclusiveStates.contains(state);
    }*/
}