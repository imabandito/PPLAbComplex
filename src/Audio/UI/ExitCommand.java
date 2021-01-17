package Audio.UI;

import Audio.Commands.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Exit");
    }

    @Override
    public String getInfo() {
        return "Exit";
    }
}
