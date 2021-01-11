package Audio.UI;

import Audio.AudioFile;
import Audio.Client;
import Audio.Storage.CalcutateAudioDurationCommand;
import Audio.Storage.Disk;
import Audio.Storage.DurationRangeCommand;
import Audio.Storage.OrderByGenreCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu(){}

    public void run() {
        String path = "C:\\Users\\ilkop\\IdeaProjects\\PPLabComplex\\init.txt";
        String menuStr = "1. New disk\n2. Print audio from disk\n3. Add audio\n4. Remove audio\n5. Order by genre\n" +
                "6. Calculate audio duration\n7. Get audios by range\n";



        List<AudioFile> audioFiles = readStudentsFromFile(path);
        Disk disk = new Disk(audioFiles);
        Client client = new Client(new CalcutateAudioDurationCommand(disk),
                new OrderByGenreCommand(disk),
                new DurationRangeCommand(disk,80,90));

        while (true) {
            System.out.println(menuStr);
            Scanner scanner = new Scanner(System.in);
            int pick = scanner.nextInt();
            switch (pick) {
                case 1: newDiskMenu();break;
                case 2: printDiskAudio(disk);break;
                case 3: addNewAudioOnDiskMenu(disk);break;
                case 4: deleteAudioFromDiskMenu(disk);break;
                case 5: client.orderAudioByGenre();System.out.println("Sorted by genre:");printDiskAudio(disk);break;
                case 6: System.out.println("Audio duration at disk:");System.out.println(client.calculateAudioDuration());break;
                case 7: printAudioList(rangeByDurationMenu(client));break;
                default: System.out.println("дефолтич)))");
            }
        }

    }

    public void newDiskMenu(){

    }

    public void addNewAudioOnDiskMenu(Disk disk){
        AudioFile audioFile = new AudioFile();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter artist: ");
        audioFile.setArtist(scanner.next());
        System.out.print("Enter title: ");
        audioFile.setTitle(scanner.next());
        System.out.print("Enter genre: ");
        audioFile.setGenre(scanner.next());
        System.out.print("Enter duration in seconds: ");
        audioFile.setDuration(scanner.nextInt());
        disk.addAudio(audioFile);
    }
    public void deleteAudioFromDiskMenu(Disk disk){
        printDiskAudio(disk);
        System.out.println("What artist to remove?");
        disk.deleteAudio(new Scanner(System.in).nextInt());
    }
    public List<AudioFile> rangeByDurationMenu(Client client){
        System.out.print("Enter range start: ");
        Scanner scanner = new Scanner(System.in);
        ((DurationRangeCommand)client.getRangeDurationCommand()).setRangeStart(scanner.nextInt());
        System.out.print("Enter range end:");
        ((DurationRangeCommand)client.getRangeDurationCommand()).setRangeEnd(scanner.nextInt());
        return client.rangeByDuration();
    }

    private List<AudioFile> readStudentsFromFile(String path) {
        List<AudioFile> audioFiles = new ArrayList<>();
        int i = 0;
        try {
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter(",|\n");
            while (sc.hasNext()) {
                audioFiles.add(new AudioFile());
                audioFiles.get(i).setArtist(sc.next());
                audioFiles.get(i).setTitle(sc.next());
                audioFiles.get(i).setGenre(sc.next());
                audioFiles.get(i).setDuration((Integer.parseInt(sc.next().trim())));
                i++;
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found, Stack trace:");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getCause()+"\n"+e.getStackTrace());
            e.printStackTrace();
        }
        return audioFiles;
    }

    private void printDiskAudio(Disk disk){
        for (int i = 0; i < disk.getAudioFiles().size(); i++) {
            System.out.println(i+". "+disk.getAudioFiles().get(i).toString());
        }
    }
    private void printAudioList(List<AudioFile> audioFiles){
        for (int i = 0; i < audioFiles.size(); i++) {
            System.out.println(i+". "+audioFiles.get(i).toString());
        }
    }

}
