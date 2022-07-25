package youareell;

import java.util.List;

import controllers.*;
import models.Message;
import models.Result;
import views.MessageTextView;
import views.TextView;

public class YouAreEll {

    TransactionController tt;
    private boolean _debug = true;
    private String inviteString = "YouAreEll(URL) v1.1";
    private TextView view;
    private Result resultFromCommand;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll app = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

        app.runMainloop();
    }

    private void runMainloop() {
        Command op = null;
        Boolean fault = false;
        
        this.showInvite();
        while (true) {
            op = processInput("? ");

            if (_debug) {
            System.err.printf("State: %s ??\n", op);
            }

            if (op == Command.QUIT) break; // while loop, we're done.

            switch (op) {
                case HELP:
                    printHelp();
                    break;
                case ERR:
                    this.display(true);
                    break;
                default:
                fault = this.reactTo(op);
                this.display(fault);    
            }

        }
    }


    /**
     * 
     * @param op
     * @return fault
     * 
     * Ids
     *  ids
     *      should return all the githubIDs of the system
     *  setid
     *      should set my githubID
     * 
     * Messages
     * `messages` 
     *     should return the last 20 messages, nicely formatted.
     * `mymessages` 
     *      should return the last 20 messages sent to you.
     * `send 'Hello World' ` 
     *     should post a new message in the timeline
     * `send 'my string message' to some_friend_githubid` 
     *     should post a message to your friend from you on the timeline.
     * `send 'Hello old buddy!' to torvalds`
     */
    private Boolean reactTo(Command op) {
        boolean f = false;

        if (op == Command.MSG) {
            StringBuilder s = new StringBuilder();
            List<Message> lm = tt.getNewMessages();
            for (Message m: lm) {
                s.append(m.toString());
            }
            this.view = new MessageTextView(s.toString());
            f = false;
        }
        return f;
    }

    private void printHelp() {
    }

    private Command processInput(String prompt) {
        String input = Console.getStringInput(prompt);
        Command cmd = Command.get(input);
        
        return cmd;
    }

    private void showInvite() {
        Console.println("%s", inviteString);
    }

    private void display(Boolean fault) {
        if (fault) {
            Console.print("= Err\t");
            return;
        }
        Console.print("%s\n",this.view.toString());
     }


    private void runTests() {
        
    }

}
