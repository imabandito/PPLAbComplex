package Audio.UI;

import Audio.AudioFile;
import Audio.Commands.Command;
import Audio.Storage.Disk;

import java.util.List;
import java.util.Scanner;

public class RangeByDurationCommand implements Command {
    Disk disk;

    public RangeByDurationCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        System.out.print("Enter range start: ");
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        System.out.print("Enter range end:");
        int to = scanner.nextInt();
        List<AudioFile> audios = disk.audioByRange(from,to);
        System.out.println("Audios ranged from "+from+" to "+to+":");
        for (AudioFile audio: audios) {
            System.out.println(audio);
        }
    }

    @Override
    public String getInfo() {
        return "Range by duration";
    }
}
