package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import br.unesp.rc.bibSys.beans.ReferenciaConcatenarBeans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcatenarArquivosBO {
    
    /**
     * Retorna uma lista de objetos ReferenciaConcatenarBeans que concatena dois
     * arquivos .bib com suas respectivas referências de arquivo (codigoArquivo)
     * através de seu caminho
     * 
     * @param pathArquivoA caminho do arquivo A
     * @param pathArquivoB caminho do arquivo B
     * @return lista de objetos ReferenciaConcatenarBeans
     * @throws IOException 
     */
    public List<ReferenciaConcatenarBeans> concatenarArquivos(String pathArquivoA, String pathArquivoB) throws IOException{
        List<ReferenciaConcatenarBeans> retorno = new ArrayList<>();
        PreencherObjetoBO preencherObjeto = new PreencherObjetoBO();
        CompararArquivosBO compararBO = new CompararArquivosBO();
        
        List<ReferenciaBeans> listaRefA = preencherObjeto.montarObjetoReferencia(pathArquivoA);
        List<ReferenciaBeans> listaRefB = preencherObjeto.montarObjetoReferencia(pathArquivoB);
        
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
