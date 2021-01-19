package Audio.UI;

import Audio.Storage.AudioCollection;
import Audio.Commands.Command;
import Audio.Storage.Disk;

import java.util.Map;

public class PrintAudioCommand implements Command {
    Disk disk;
    public PrintAudioCommand(Disk disk){
        this.disk = disk;
    }

    @Override
    public void execute() {
        for(Map.Entry<String, AudioCollection> item : disk.getAudioCollections().entrySet()){
            System.out.println(item.getKey()+"  collection:");
            for (int i = 0; i < item.getValue().getAudioFiles().size(); i++) {
                System.out.println(i+1+". "+item.getValue().getAudioFiles().get(i));
            }
        }
        System.out.println();
    }

    @Override
    public String getInfo() {
        return "Print audio";
    }
}
