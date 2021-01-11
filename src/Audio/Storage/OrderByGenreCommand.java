package Audio.Storage;

import Audio.AudioFile;
import Audio.Commands.Command;
import Audio.Commands.CommandWithResult;

import java.util.List;

public class OrderByGenreCommand implements CommandWithResult<List<AudioFile>> {
    Disk disk;
    List<AudioFile> result;
    public OrderByGenreCommand(Disk disk){this.disk = disk;}
    @Override
    public void execute() {
        this.result = disk.orderByGenre();
    }

    @Override
    public List<AudioFile> getResult() {
        return result;
    }
}
