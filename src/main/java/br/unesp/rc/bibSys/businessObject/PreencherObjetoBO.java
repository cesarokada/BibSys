/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.utils.ArquivosUtils;
import br.unesp.rc.bibSys.utils.ParserObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cesar
 */
public class PreencherObjetoBO {
        public List<ReferenciaBeans> montarObjetoReferencia(String pathArquivo) throws IOException{
        String contentFile = ArquivosUtils.lerArquivo(pathArquivo);
        
        if(contentFile.equals(""))
            return null;
        
        ValidarReferencia validador = new ValidarReferencia();
        List<String> refList = Arrays.asList(contentFile.split("@"));
        List<ReferenciaBeans> retorno = new ArrayList<>();
                
        try {
            for(String ref : refList){
                if(!ref.trim().equals("")){
                    ref = validador.retirarEspacosChaves(ref);
                    ReferenciaBeans objReferencia = ParserObject.stringToObject(ref);
                    retorno.add(objReferencia);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | InvocationTargetException ex) {
            Logger.getLogger(PadronizarBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
}
