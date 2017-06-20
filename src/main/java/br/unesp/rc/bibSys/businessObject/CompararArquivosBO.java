
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
        PreencherObjetoBO preencherObjeto = new PreencherObjetoBO();
        
        List<ReferenciaBeans> listaRefA = preencherObjeto.montarObjetoReferencia(pathArquivoA);
        List<ReferenciaBeans> listaRefB = preencherObjeto.montarObjetoReferencia(pathArquivoB);
        
        //Retorna referências que estão em A e não em B
        List<ReferenciaBeans> retornoListA = retornarDiferencas(listaRefA, listaRefB);
        //Retorna referências que estão em B e não em A
        List<ReferenciaBeans> retornoListB = retornarDiferencas(listaRefB, listaRefA);
        
        retorno.setReferenciasA(retornoListA);
        retorno.setReferenciasB(retornoListB);
        
        return retorno;
    }
    
    public List<ReferenciaBeans> retornarDiferencas(List<ReferenciaBeans> listaA, List<ReferenciaBeans> listaB){
        
        List<ReferenciaBeans> retornoList = new ArrayList<>();
        
        for(ReferenciaBeans r : listaA){
            boolean exists = false;
            for(ReferenciaBeans s : listaB){
                if(r.getBibKey().equals(s.getBibKey()))
                    exists = true;
            }
            if(!exists)
                retornoList.add(r);
        }
        
        return retornoList;
    }
}
