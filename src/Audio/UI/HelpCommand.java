package Audio.UI;

import Audio.Commands.Command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Useful help! O, menu <3");
    }

    @Override
    public String getInfo() {
        return "Help";
    }
}
