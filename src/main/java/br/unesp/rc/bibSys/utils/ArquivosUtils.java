package br.unesp.rc.bibSys.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosUtils {

    public static String escreverArquivo(String path, String conteudo) throws IOException{
        //Abre o arquivo
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file)) {
            String lineBreak = System.getProperty("line.separator");
            String textArea = conteudo;
            String as = textArea.replaceAll("\n", lineBreak);
            fw.write(as);
        }
        
        return file.getPath();
    }
    
    public static String lerArquivo(String path) throws FileNotFoundException, IOException{
        
        FileInputStream fstream = new FileInputStream(path);
        StringBuilder result;
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream))) {
            String strLine;
            result = new StringBuilder();
            while ((strLine = buffer.readLine()) != null)
                result.append(strLine).append(System.getProperty("line.separator"));
        }
        
        return result.toString();
    }
}
