package Audio.UI;

import Audio.Commands.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    ArrayList<Command> commands;
    public Menu(Command ... commands){
        this.commands = new ArrayList<>(Arrays.asList(commands));
    }
    public void addCommand(Command command){ commands.add(command);}

    public void run() {
        int pick = 0;

        do {
        try {
                pick = getPickedCommand();
                commands.get(pick).execute();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while (!commands.get(pick).getInfo().equals("Exit"));
    }

    private int getPickedCommand() throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i+1+". "+commands.get(i).getInfo());
        }
        int pick = scanner.nextInt()-1;
        if(pick<commands.size())
            return pick;
        throw new IOException("Wrong input!");
    }

}
