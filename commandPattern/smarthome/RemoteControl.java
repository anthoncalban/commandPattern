package smarthome;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoteControl {
    private final Map<String, Command> commands = new HashMap<>();
    private final Stack<Command> history = new Stack<>();

    public void setCommand(String name, Command command) 
    {
        commands.put(name, command);
    }

    public void send(String name) 
    {
        Command cmd = commands.get(name);
        if (cmd == null) 
        {
            System.out.println("No command registered for: " + name);
            return;
        }
        cmd.execute();
        history.push(cmd);
    }

    public void undoLast() 
    {
        if (history.isEmpty()) 
        {
            System.out.println("No commands to undo.");
            return;
        }

        Command lastCommand = history.pop();
        lastCommand.undo();
    }
}