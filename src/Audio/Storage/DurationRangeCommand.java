package Audio.Storage;

import Audio.AudioFile;
import Audio.Commands.CommandWithResult;

import java.util.ArrayList;
import java.util.List;

public class DurationRangeCommand implements CommandWithResult<List<AudioFile>> {
    Disk disk;
    List<AudioFile> result = new ArrayList<>();
    int from;
    int to;

    public DurationRangeCommand(Disk disk,int from,int to){
        this.disk = disk;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        this.result = disk.audioByRange(from,to);
    }
    public void setRangeStart(int from){this.from = from;}
    public void setRangeEnd(int to){this.to = to;}

    public List<AudioFile> getResult() { return result; }
}
