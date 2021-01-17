package Audio.UI;

import Audio.Commands.Command;
import Audio.Storage.Disk;

public class PrintAudioCommand implements Command {
    Disk disk;
    public PrintAudioCommand(Disk disk){
        this.disk = disk;
    }

    @Override
    public void execute() {
        for (int i = 0; i < disk.getAudioFiles().size(); i++) {
            System.out.println(i+". "+disk.getAudioFiles().get(i).toString());
        }
    }

    @Override
    public String getInfo() {
        return "Print audio";
    }
}
