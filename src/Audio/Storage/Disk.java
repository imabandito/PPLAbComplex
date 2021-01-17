package Audio.Storage;

import Audio.AudioFile;
import Audio.GenreComparator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Receiver
public class Disk {
    private List<AudioFile> audioFiles;

    public Disk(){ audioFiles = new ArrayList<>(); }
    public Disk(List<AudioFile> collection) {
        this.audioFiles = collection;
    }
    public Disk(String path) throws NumberFormatException, IOException {
        this.audioFiles = readAudiosFromFile(path);
    }

    public void addAudio(AudioFile audioFile){ audioFiles.add(audioFile); }
    public void addAudios(String path) throws Exception {audioFiles.addAll(readAudiosFromFile(path));}
    public void deleteAudio(int index){audioFiles.remove(index);}
    public void deleteAllAudios(){audioFiles.clear();}
    public List<AudioFile> getAudioFiles(){ return audioFiles; }

    public int calcutateDurarion(){
        int totalDuration=0;
        for (AudioFile audioFile: audioFiles) {
            totalDuration+=audioFile.getDuration();
        }
        return totalDuration;
    }
    public List<AudioFile> audioByRange(int from,int to){
        List<AudioFile> list = new ArrayList<>();
        for (AudioFile audioFile: audioFiles) {
            if(audioFile.getDuration()>=from && audioFile.getDuration()<=to)
                list.add(audioFile);
        }
        return list;
    }
    public List<AudioFile> orderByGenre(){
        audioFiles.sort(new GenreComparator());
        return audioFiles;
    }

    private List<AudioFile> readAudiosFromFile(String path) throws NumberFormatException, IOException {
        List<AudioFile> audioFiles = new ArrayList<>();
        int i = 0;
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                audioFiles.add(new AudioFile());
                audioFiles.get(i).setArtist(sc.next());
                audioFiles.get(i).setTitle(sc.next());
                audioFiles.get(i).setGenre(sc.next());
                audioFiles.get(i).setDuration((Integer.parseInt(sc.next().trim())));
                i++;
            }

        return audioFiles;
    }
}
