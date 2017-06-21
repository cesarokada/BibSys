package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.beans.ReferenciaConcatenarBeans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcatenarArquivosBO {
    
    public List<ReferenciaConcatenarBeans> concatenarArquivos(String pathArquivoA, String pathArquivoB) throws IOException{
        List<ReferenciaConcatenarBeans> retorno = new ArrayList<>();
        PreencherObjetoBO preencherObjeto = new PreencherObjetoBO();
        CompararArquivosBO compararBO = new CompararArquivosBO();
        
        List<ReferenciaBeans> listaRefA = preencherObjeto.montarObjetoReferencia(pathArquivoA);
        List<ReferenciaBeans> listaRefB = preencherObjeto.montarObjetoReferencia(pathArquivoB);
        
//        GerarBibKeyBO gerar = new GerarBibKeyBO();
//        listaRefA = gerar.gerarBibSysAutomaricamente(listaRefA);
        
        listaRefA.forEach((t) -> {
            ReferenciaConcatenarBeans item = new ReferenciaConcatenarBeans();
            item.setReferencia(t);
            item.setCodigoArquivo("A");
            retorno.add(item);
        });
        
        List<ReferenciaBeans> retornoComparar = compararBO.retornarDiferencas(listaRefB, listaRefA);
        
        retornoComparar.forEach((t) -> {
            ReferenciaConcatenarBeans item = new ReferenciaConcatenarBeans();
            item.setReferencia(t);
            item.setCodigoArquivo("B");
            retorno.add(item);
        });
        
        return retorno;
    }
}
