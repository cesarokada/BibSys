package br.unesp.rc.bibSys.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    
}
