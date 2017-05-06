import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileConverter{

    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("Improper usage");
            System.exit(1);
        }
        String inputFile = args[0];
        String outputFile = args[1];
        String newFile = "";
        try{
            for(String line : Files.readAllLines(Paths.get(inputFile))){
                String[] splits = line.split(",");
                if(splits.length < 5){
                    System.out.println("Invalid line: " + line);
                    continue;
                }
                String newLine = splits[1] + "," + splits[3] + "," + splits[4];
                newFile += newLine + '\n';
            }
            Files.write(Paths.get(outputFile), newFile.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

