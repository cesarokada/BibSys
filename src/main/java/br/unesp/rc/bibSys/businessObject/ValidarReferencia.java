package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidarReferencia {
    /**
     * Dado uma String, verifica se o número de abre chaves é igual ao 
     * número de fecha chaves, retornando verdadeiro ou falso
     * 
     * @param obj String a ser analisada
     * @return verdadeiro caso o número de abre e fecha chaves sejam iguais, falso caso constrário
     */
    public boolean validarParentesis(String obj){
        int countAbreChaves = 0;
        int countFechaChaves = 0;
        
        for(char c : obj.toCharArray()){
            countAbreChaves += c == '{' ? 1 : 0;
            countFechaChaves += c == '}' ? 1 : 0;
        }
        
        return countAbreChaves == countFechaChaves;
    }
    /**
     * Retorna uma lista de String 
     * @param refList
     * @return 
     */
    public List<String> validarBibKeyUnica(List<ReferenciaBeans> refList){
        List<String> retorno = new ArrayList<>();
        refList.forEach((ReferenciaBeans r) -> {
            int count = 0;
            count = refList.stream().filter((f) -> (f.getBibKey().equals(f.getBibKey()))).map((_item) -> 1).reduce(count, Integer::sum);
            if (count > 1) {
                retorno.add(r.getBibKey());
            }
        });
        
        return retorno;
    }
    /**
     * Retorna uma String sem os caracteres \{|} dado uma String de referência
     * @param txt String a ser tratada
     * @return String tratada
     */
    private String retirarParentesis(String txt){
        return txt.replaceAll("\\{|}", "");
    }
    /**
     * Dado uma string, retorna uma String tratada para o padrão bibsys.
     * Tags em linhas diferentes
     * Valores de Tags entre chaves ({})
     * Antes das Tag existe 2 espaços
     * Até o sinal de (=) há 16 caracteres, preenchido por espaço caso necessário
     * Entre o sinal de (=) e o abre chaves há 1 espaço
     * O valor da tag sem espaços em branco no início e no fim
     * 
     * @param objRef String a ser tratada
     * @return  String tratada
     */
    public String retirarEspacosChaves(String objRef){
        String pattern =  "[a-zA-Z0-9]+(\\s|\\S)*=(\\s|\\S)*(\\{|\").*(\\s|\\S)*";
        StringBuilder retorno = new StringBuilder();
        
        Pattern r = Pattern.compile(pattern);
        
        String patternSeparation = "(},\\s*\\n\\s*|\",\\s*\\n\\s*)";
        
        for(int i = 0; i < objRef.length(); i++){
            char c = objRef.charAt(i);
            if(c == ','){
                objRef = objRef.substring(0, i) + '}' + objRef.substring(i, objRef.length());
                break;
            }
        }
        
        List<String> linesRef = Arrays.asList(objRef.split(patternSeparation));

        linesRef.stream().map((line) -> {
            Matcher m = r.matcher(line);
            if (m.find()) {
                line = line.trim();
                line = line.replaceAll("\\{", "");
                line = line.replaceAll("\\}", "");

                line = line.replaceAll("\"", "");
                line = line.replaceAll(System.lineSeparator(), "");
                line = line.replaceAll("\\t", "");
                line = line.replaceAll(",", "");
            }
            return line;
        }).forEachOrdered((line) -> {
            retorno.append(line).append(System.lineSeparator());
        });

        return retorno.toString();
    }
}
