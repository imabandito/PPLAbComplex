package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

public class OrderByGenreCommand implements Command {
    Disk disk;

    public OrderByGenreCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        disk.orderByGenre();
        System.out.println("Ordered by genre!");
    }

    @Override
    public String getInfo() {
        return "Order by genre";
    }
}
