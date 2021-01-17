package Audio.UI;

import Audio.AudioFile;
import Audio.Commands.Command;
import Audio.Commands.CommandWithResult;
import Audio.Storage.Disk;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddAudioCommand implements Command {

    Disk disk;
    public AddAudioCommand(Disk disk){this.disk = disk;}
    @Override
    public void execute() {
        AudioFile audioFile = new AudioFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add manually\n2. Add from file");
        int pick = scanner.nextInt();
        if(pick == 1) {
            System.out.print("Enter artist: ");
            audioFile.setArtist(scanner.next());
            System.out.print("Enter title: ");
            audioFile.setTitle(scanner.next());
            System.out.print("Enter genre: ");
            audioFile.setGenre(scanner.next());
            System.out.print("Enter duration in seconds: ");
            audioFile.setDuration(scanner.nextInt());
            disk.addAudio(audioFile);
        }else if(pick ==2){
            System.out.println("Enter path:");
            try {
                disk.addAudios(scanner.next());
            } catch (Exception e) {
                System.out.println(e.getCause()+"  "+e.getMessage());
            }
        }
    }

    @Override
    public String getInfo() {
        return "Add audio";
    }

}
