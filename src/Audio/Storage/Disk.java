package Audio.Storage;

import Audio.AudioFile;
import Audio.GenreComparator;

import java.util.ArrayList;
import java.util.List;

//Receiver
public class Disk {
    private List<AudioFile> audioFiles;

    public Disk(){ audioFiles = new ArrayList<>(); }
    public Disk(List<AudioFile> collection) {
        this.audioFiles = collection;
    }

    public void addAudio(AudioFile audioFile){ audioFiles.add(audioFile); }
    public void deleteAudio(int index){audioFiles.remove(index);}
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


}
