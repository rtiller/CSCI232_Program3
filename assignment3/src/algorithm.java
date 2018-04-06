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
        int value;
        Path file;
        file = FileSystems.getDefault().getPath("src", "matrix.txt");

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            line = null;
            value = 0;
            line = reader.readLine();
            String[] labelArray = line.split(",");
            int length = labelArray.length;
            int matrix[][] = new int[length][length];
            int[] temp = new int[(length*length)];
            
            
            while((value = reader.read()) != -1){
                for(int i = 0; i < temp.length; i++){
                    temp[i] = value;
                }
            }
            
            for(int h = 0; h < temp.length; h++){
                 System.out.println(temp[h]);
            }

            for(int i = 0; i < length; i++){
                int iter = i;
                for(int j = 0; j < length; j++){
                     //matrix[i][j] = Integer.parseInt(temp[iter]);
                     iter += length;
                     System.out.println(matrix[i][j]);
                }

            }
                
        }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
    }
}
