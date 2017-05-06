package rhymes;

import java.util.ArrayList;

public class Word {

    private String word;
    private ArrayList<String> sounds;
    
    
    public Word(String word1, ArrayList<String> sounds) {
        this.word = word1;
        this.sounds = sounds;
    }
    
    
    
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public ArrayList<String> getSounds() {
        return sounds;
    }
    public void setSounds(ArrayList<String> sounds) {
        this.sounds = sounds;
    }
    
    
    
}
