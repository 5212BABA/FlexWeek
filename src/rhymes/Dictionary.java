package rhymes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private Map<String, Word> dictionary;
    

    public Dictionary(){
        init();
    }
    
    public void init(){
        this.dictionary = new HashMap<>();
        try {
            Path filePath = Paths.get("data/cmudict-0.7b");
            List<String> lines = Files.readAllLines(filePath);
            for(String line : lines){
                if(line.startsWith(";;;")){
                    continue;
                }
                String[] splits = line.split("  ");
                if(splits.length < 2){
                    continue;
                }
                String word = splits[0];
                String[] soundsArray = splits[1].split(" ");
                ArrayList<String> sounds = new ArrayList<String>(Arrays.asList(soundsArray));
                
                Word wordInstance = new Word(word, sounds);
                this.dictionary.put(word, wordInstance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int rhymeLength(String s1, String s2){
        List<String> sounds1 = this.getSounds(s1);
        List<String> sounds2 = this.getSounds(s2);
        System.out.println(sounds1);
        System.out.println(sounds2);
        if(sounds1 == null || sounds2 == null){
            return 0;
        }
        int pointer1 = sounds1.size() - 1;
        int pointer2 = sounds2.size() - 1;
        int rhymingSyllables = 0;
        while(pointer1 >= 0 && pointer2 >= 0){
            if(!sounds1.get(pointer1).equals(sounds2.get(pointer2))){
                break;
            }
            if(isVowel(sounds1.get(pointer1))){
                rhymingSyllables++;
            }
            pointer1--;
            pointer2--;
        }
        return rhymingSyllables;
    }

    private List<String> getSounds(String word){
        return dictionary.get(word.toUpperCase()).getSounds();
    }
    
    private boolean isVowel(String string) {
        return string.length() > 2;
    }
    
}
