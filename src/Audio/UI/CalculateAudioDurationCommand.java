package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

public class CalculateAudioDurationCommand implements Command {
    Disk disk;

    public CalculateAudioDurationCommand(Disk disk) { this.disk = disk; }

    @Override
    public void execute() {
        System.out.println("Total audio duration: "+disk.calcutateDurarion());
    }

    @Override
    public String getInfo() {
        return "Calculate audio duration";
    }
}
