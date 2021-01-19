package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

import java.util.Scanner;

public class CalculateAudioDurationCommand implements Command {
    Disk disk;

    public CalculateAudioDurationCommand(Disk disk) { this.disk = disk; }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter audio collection:");
        String collectionStr = scanner.next();
        System.out.println("Total audio duration: "+disk.getAudioCollection(collectionStr).calcutateDurarion());
    }

    @Override
    public String getInfo() {
        return "Calculate audio duration";
    }
}
