package BaiTapppppp;
//Bài tập 28. Mẫu command

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class MyCommand implements Command {
    private Receiver receiver;
    private String message;

    public MyCommand(Receiver receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    @Override
    public void execute() {
        receiver.processMessage(message);
    }
}

class Receiver {
    public void processMessage(String message) {
        System.out.println("Processing message: " + message);
    }
}

class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

public class Bai28 {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Receiver receiver = new Receiver();
        Command command1 = new MyCommand(receiver, "Thêm");
        Command command2 = new MyCommand(receiver, "Sửa");

        Invoker invoker = new Invoker();
        invoker.addCommand(command1);
        invoker.addCommand(command2);
        invoker.executeCommands();
    }
}