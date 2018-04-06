/*
 * Authors: Jake O'Malley, Robert Tiller
 * Date: 4/10/2018
 * Overview:
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class algorithm {

    public static void main(String [] args){
        String line;
                Path file;
                file = FileSystems.getDefault().getPath("src", "matrix.txt");
                
                try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
                    line = null;
                    line = reader.readLine();
                    String[] labelArray = line.split(",");
                    for(int i = 0; i < labelArray.length; i++){
                        System.out.println(labelArray[i]);
                    }
                    
                }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
    }
}
