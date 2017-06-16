
package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.beans.ReferenciaCompararBeans;
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
public class CompararArquivosBO {
 
    /**
     * Retorna um objeto ReferenciaCompararBeans contendo duas listar de referências, 
     * uma referente ao arquivo A e outra do arquivo B.
     * 
     * @param pathArquivoA caminho do arquivo A
     * @param pathArquivoB caminho do arquivo B
     * @return
     * @throws IOException 
     */
    public ReferenciaCompararBeans compararArquivos(String pathArquivoA, String pathArquivoB) throws IOException{
        ReferenciaCompararBeans retorno = new ReferenciaCompararBeans();
        
        String arquivoA = ArquivosUtils.lerArquivo(pathArquivoA);
        String arquivoB = ArquivosUtils.lerArquivo(pathArquivoB);
        
        List<ReferenciaBeans> listaRefA = montarObjetoReferencia(arquivoA);
        List<ReferenciaBeans> listaRefB = montarObjetoReferencia(arquivoB);
        
        List<ReferenciaBeans> retornoListA = new ArrayList<>();
        List<ReferenciaBeans> retornoListB = new ArrayList<>();

        for(ReferenciaBeans r : listaRefA){
            boolean exists = false;
            for(ReferenciaBeans s : listaRefB){
                if(r.getBibKey().equals(s.getBibKey()))
                    exists = true;
            }
            if(!exists)
                retornoListA.add(r);
        }
        
        for(ReferenciaBeans r : listaRefB){
            boolean exists = false;
            for(ReferenciaBeans s : listaRefA){
                if(r.getBibKey().equals(s.getBibKey()))
                    exists = true;
            }
            if(!exists)
                retornoListB.add(r);
        }
        
        retorno.setReferenciasA(retornoListA);
        retorno.setReferenciasB(retornoListB);
        
        return retorno;
    }
    
    /**
     * 
     * @param fileContent
     * @return 
     */
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
