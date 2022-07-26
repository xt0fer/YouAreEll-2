package youareell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import controllers.*;
import views.TextView;

public class YouAreEll {

    TransactionController tt;
    private boolean _debug = true;
    private String inviteString = "YouAreEll(URL) v1.1";
    private TextView view;
    //private Result resultFromCommand;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll app = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

        app.runMainLoop();
    }

    // Used to bundle Command Enum with strings from commandline
    class CommandLine { 
        private Command cmd;
        private List<String> list;
        CommandLine(Command c, List<String> tokens) {
            cmd = c; list = tokens;
        }
        Command getCmd() {
            return this.cmd;
        }
        List<String> getLine() {
            return this.list;
        }
    }
    private void runMainLoop() {
        CommandLine cmdLine = null;
        Command op = null;
        Boolean fault = false;
        
        this.showInvite();
        while (true) {
            cmdLine = processInput("? ");
            op = cmdLine.getCmd();
            
            // if (_debug) System.err.printf("State: %s ??\n", op);

            if (op == Command.QUIT) break; // while loop, we're done.

            switch (op) {
                case HELP:
                    printHelp();
                    break;
                case ERR:
                    this.display(true);
                    break;
                default:
                fault = this.display(this.eval(op));    
            }

        }
    }


    /** 
     * Ids
     *  ids
     *      should return all the githubIDs of the system
     *  setid
     *      should set my githubID
     * 
     * Messages
     * `messages` 
     *     should return the last 20 messages, nicely formatted.
     * //`mine` 
     * //     should return the last 20 messages sent to you.
     * `send 'Hello World' ` 
     *     should post a new message in the timeline
     * `send 'my string message' to some_friend_githubid` 
     *     should post a message to your friend from you on the timeline.
     * `send 'Hello old buddy!' to torvalds`
     */
    private Boolean eval(Command op) {
        if (op == Command.MSG) { // no commandline args used
            this.view = tt.getNewMessages();
            return false;
        }
        // more commands eval's here
        return true; // command not eval, hence error
    }

    private CommandLine processInput(String prompt) {
        String commandLine = Console.getStringInput(prompt);
        String[] tokens = commandLine.split("\\W(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        List<String> tokenList = new ArrayList<>();
        tokenList = Arrays.asList(tokens);
        
        if (_debug) Stream.of(tokens).forEach(System.err::println); 
        
        return new CommandLine(Command.get(tokens[0]), tokenList);
    }

    private void showInvite() {
        Console.println("%s", inviteString);
    }

    private boolean display(Boolean fault) {
        if (fault) {
            Console.print("= Err\t");
            return fault;
        }
        Console.print("%s\n",this.view.toString());
        return fault;
     }

     private void printHelp() {
    }

    private void runTests() {
        
    }

}
