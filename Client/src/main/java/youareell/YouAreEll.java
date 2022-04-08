package youareell;

import controllers.*;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

        urlhandler.runTests();
    }

    private void runTests() {
        
    }

    // public String get_ids() {
    //     return tt.makecall("/ids", "GET", "");
    // }

    // public String get_messages() {
    //     return MakeURLCall("/messages", "GET", "");
    // }


}
