package Audio.Storage;

import Audio.Commands.CommandWithResult;

public class CalcutateAudioDurationCommand implements CommandWithResult<Integer> {
    Disk disk;
    Integer duration;

    public CalcutateAudioDurationCommand(Disk disk){ this.disk = disk; }

    @Override
    public void execute() {
        duration = disk.calcutateDurarion();
    }

    @Override
    public Integer getResult() {
        return duration;
    }
}
