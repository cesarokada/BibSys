/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.apresentacao.JDialogComparar;
import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.beans.ReferenciaCompararBeans;
import br.unesp.rc.bibSys.utils.ArquivosUtils;
import br.unesp.rc.bibSys.utils.ParserBibTex;
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
public class CompararArquivosBO {
 
    public ReferenciaCompararBeans compararArquivos(String pathArquivoA, String pathArquivoB) throws IOException{
        ReferenciaCompararBeans retorno = new ReferenciaCompararBeans();
        
        String arquivoA = ArquivosUtils.lerArquivo(pathArquivoA);
        String arquivoB = ArquivosUtils.lerArquivo(pathArquivoB);
        
        List<ReferenciaBeans> listaRefA = montarObjetoReferencia(arquivoA);
        List<ReferenciaBeans> listaRefB = montarObjetoReferencia(arquivoB);
        
        List<ReferenciaBeans> retornoListA = new ArrayList<>();
        List<ReferenciaBeans> retornoListB = new ArrayList<>();
        
        listaRefA.forEach((t) -> {
            if(!listaRefB.contains(t.getBibKey()))
                retornoListA.add(t);
        });
        
        listaRefB.forEach((t) -> {
            if(!listaRefA.contains(t.getBibKey()))
                retornoListB.add(t);
        });
        
        retorno.setReferenciasA(retornoListA);
        retorno.setReferenciasB(retornoListB);
        
        return retorno;
    }
    
    private List<ReferenciaBeans> montarObjetoReferencia(String fileContent){
        if(fileContent.equals(""))
            return null;
        
        ValidarReferencia validador = new ValidarReferencia();
        List<String> refList = Arrays.asList(fileContent.split("@"));
        List<ReferenciaBeans> retorno = new ArrayList<>();
                
        try {
            for(String ref : refList){
                if(!ref.equals("")){
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
