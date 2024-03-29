package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.utils.ParserBibTex;
import br.unesp.rc.bibSys.utils.ParserObject;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PadronizarBO {
    /**
     * Dado uma String de referência, retorna uma String contendo todas as referências
     * padronizadas
     * 
     * @param txt
     * @return 
     */
    public String padronizar(String txt){
        StringBuilder retorno = new StringBuilder();
        ValidarReferencia validador = new ValidarReferencia();
        
        List<String> refList = Arrays.asList(txt.split("@"));
                
        try {
            for(String ref : refList){
                if(!ref.trim().equals("")){
                    ref = validador.retirarEspacosChaves(ref);
                    
                    ReferenciaBeans objReferencia = ParserObject.stringToObject(ref);
                    retorno.append(ParserBibTex.jsonToBibTex(objReferencia)).append(System.lineSeparator());
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | InvocationTargetException ex) {
            Logger.getLogger(PadronizarBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno.toString();
    }
}
