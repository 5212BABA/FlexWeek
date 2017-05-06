package babbler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main{

    private static List<String> getPartOfSpeech(String speech){
        List<String> words = new LinkedList<>();

        try{
            for(String line : Files.readAllLines(Paths.get("data/index." + speech))){
                if(line.startsWith(" ")){
                    continue;
                }
                words.add(line.split(" ")[0].replace("_", " "));
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return words;
    }


    private static String getRandomElement(List<String> words){
        double random = Math.random();
        int n = words.size();
        int randomIndex = (int) (random * n);
        return words.get(randomIndex);
    }

    public static void main(String[] args){

        List<String> nouns = getPartOfSpeech("noun");
        List<String> adjectives = getPartOfSpeech("adj");
        List<String> verbs = getPartOfSpeech("verb");

        for(int i = 0; i < 10; i++){
            System.out.println(getRandomElement(adjectives) + " " + getRandomElement(nouns) + " " + 
                    getRandomElement(verbs));
        }
    }

}
