package br.unesp.rc.bibSys.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosUtils {
    /**
     * Escreve o conteudo dado no arquivo do caminho fornecido
     * 
     * @param path caminho do arquivo
     * @param conteudo conteudo a ser escrito
     * @return String com caminho do arquivo
     * @throws IOException 
     */
    public static String escreverArquivo(String path, String conteudo) throws IOException{
        //Abre o arquivo
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(conteudo);
        }
        
        return file.getPath();
    }
    /**
     * Dado o caminho do arquivo, faz a leitura retornando em uma String
     * 
     * @param path caminho do arquivo
     * @return String com o conteudo
     * @throws FileNotFoundException
     * @throws IOException 
     */
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
