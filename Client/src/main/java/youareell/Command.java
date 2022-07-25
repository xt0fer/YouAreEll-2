package youareell;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Command {
    MSG("messages"),
    MYMSG("mymessages"),
    ERR("error"),
    QUIT("Quit"),
    HELP("?")
   ;

    private String name;

    private static final Map<String,Command> ENUM_MAP;

    Command (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String,Command> map = new ConcurrentHashMap<String, Command>();
        for (Command instance : Command.values()) {
            map.put(instance.getName().toLowerCase(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Command get (String name) {
        return ENUM_MAP.getOrDefault(name.toLowerCase(), Command.ERR);
    }

    public static boolean isBinaryOp(Command op) {
        // if (op == ADD ||
        //     op == SUB ||
        //     op == MUL ||
        //     op == DIV ||
        //     op == MOD ||
        //     op == POWER) 
        // {
        //     return true;
        // }
        return false;
    }
}