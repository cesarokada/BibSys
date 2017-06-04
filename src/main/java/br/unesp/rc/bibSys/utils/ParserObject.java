package br.unesp.rc.bibSys.utils;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

public final class ParserObject {
    
    public static ReferenciaBeans stringToObject(String element) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, InvocationTargetException{
                
        ReferenciaBeans referencia = new ReferenciaBeans();
        
        //Separa em linhas
        String[] lines = element.split(System.getProperty("line.separator"));
        
        //Convert to List
        List<String> listLines = new ArrayList<>(Arrays.asList(lines));
        
        //Separa Primeira linha por '{', obtendo ARTICLE(tipoReferencia) e bibKey
        String[] firstLine = listLines.get(0).split("\\{");
        referencia.setTipoReferencia(firstLine[0]);
        referencia.setBibKey(firstLine[1].replace(",", ""));
        
        //Remove da lista primeira e última linha (cabeçalho e fim de chaves)
        listLines.remove(0);
        listLines.remove(listLines.size() - 1);
        
        //seta os Atributos do objeto
        for(String line : listLines){
            String[] keyValue = line.split("=");
            BeanUtils.setProperty(referencia,keyValue[0].trim(),keyValue[1].trim());
        }
        
        return referencia;
    }
}