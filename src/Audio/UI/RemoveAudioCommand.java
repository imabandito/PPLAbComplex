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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter audio collection:");
        String collectionStr = scanner.next();
        System.out.println("1. Remove all\n2. Remove one");
        int pick = scanner.nextInt();
        switch (pick){
            case 1: disk.getAudioCollection(collectionStr).deleteAllAudios(); break;
            case 2:
                System.out.println("Which one to delete?");
                disk.getAudioCollection(collectionStr).deleteAudio(scanner.nextInt()-1);break;
            default: System.out.println("Wrong input!");
        }
    }

    @Override
    public String getInfo() {
        return "Remove audio";
    }
}
