package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.utils.ParserBibTex;
import br.unesp.rc.bibSys.utils.ParserObject;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PadronizarBO {
    public String padronizar(String txt){
        StringBuilder retorno = new StringBuilder();
        
        List<String> refList = Arrays.asList(txt.split("@"));
                
        try {
            for(String ref : refList){
                if(!ref.equals("")){
                    ref = retirarEspacosChaves(ref);
                    
                    ReferenciaBeans objReferencia = ParserObject.stringToObject(ref);
                    retorno.append(ParserBibTex.jsonToBibTex(objReferencia)).append(System.lineSeparator());
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | InvocationTargetException ex) {
            Logger.getLogger(PadronizarBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno.toString();
    }
    
    public String retirarEspacosChaves(String objRef){
        String pattern;
        pattern = "[a-zA-Z0-9]+(\\s|\\S)*=(\\s|\\S)*(\\{|\\\")[a-zA-Z0-9\\W\\s]*(\\}|\\\")";
        StringBuilder retorno = new StringBuilder();

        Pattern r = Pattern.compile(pattern);
        
        List<String> linesRef = Arrays.asList(objRef.split(System.lineSeparator()));
                
        linesRef.stream().map((line) -> {
            Matcher m = r.matcher(line);
            if (m.find()) {
                line = line.trim();
                line = line.replaceAll("\\{", "");
                line = line.replaceAll("\\}", "");
                
                line = line.replaceAll("\"", "");
                
                line = line.replaceAll(",", "");
            }
            return line;
        }).forEachOrdered((line) -> {
            retorno.append(line).append(System.lineSeparator());
        });
        
        return retorno.toString();
    }
}
