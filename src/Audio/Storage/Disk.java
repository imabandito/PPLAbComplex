package Audio.Storage;

import java.io.IOException;
import java.util.*;

//Receiver
public class Disk {
    private Map<String , AudioCollection> audioCollections;

    public Disk(){
    }
    public Disk(Map<String, AudioCollection> collection) {
        audioCollections = new HashMap<>();
        this.audioCollections.putAll(collection);
    }
    public Disk(String path, String collectionName) throws NumberFormatException, IOException {
        audioCollections = new HashMap<>();
        audioCollections.put(collectionName.toLowerCase(),new AudioCollection(path));
    }

    public AudioCollection getAudioCollection(String collectionName){
        collectionName = collectionName.toLowerCase();
        if(audioCollections.containsKey(collectionName))
            return audioCollections.get(collectionName);
        addAudioCollection(collectionName);
        return audioCollections.get(collectionName);
    }
    public Map<String , AudioCollection> getAudioCollections(){return audioCollections;}
    public void addAudioCollection(String collectionName){audioCollections.put(collectionName.toLowerCase(),new AudioCollection());}
    public void addAudioCollection(String collectionName, AudioCollection collection){
        audioCollections.put(collectionName.toLowerCase(),collection);
    }

}
