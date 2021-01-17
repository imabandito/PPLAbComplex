package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

import java.util.Scanner;

public class RemoveAudioCommand implements Command {
    Disk disk;

    public RemoveAudioCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        System.out.println("1. Remove all\n 2. Remove one");
        Scanner scanner = new Scanner(System.in);
        int pick = scanner.nextInt();
        switch (pick){
            case 1: disk.deleteAllAudios(); break;
            case 2: disk.deleteAudio(scanner.nextInt());break;
            default: System.out.println("Wrong input!");
        }
    }

    @Override
    public String getInfo() {
        return "Remove audio";
    }
}
