package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

import java.util.Scanner;

public class OrderByGenreCommand implements Command {
    Disk disk;

    public OrderByGenreCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter audio collection:");
        String collectionStr = scanner.next();

        disk.getAudioCollection(collectionStr).orderByGenre();
        System.out.println("Ordered by genre!");
    }

    @Override
    public String getInfo() {
        return "Order by genre";
    }
}
