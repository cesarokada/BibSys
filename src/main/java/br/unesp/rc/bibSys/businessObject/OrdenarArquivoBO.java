/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class OrdenarArquivoBO {
    public List<ReferenciaBeans> ordenarArquivo(String pathArquivo) throws IOException{
        PreencherObjetoBO preencherBO = new PreencherObjetoBO();
        
        List<ReferenciaBeans> listaRef = preencherBO.montarObjetoReferencia(pathArquivo);
        
        if (!listaRef.isEmpty()) {
            Collections.sort(listaRef, new Comparator<ReferenciaBeans>() {
                @Override
               public int compare(final ReferenciaBeans object1, final ReferenciaBeans object2) {
                   return object1.getBibKey().toUpperCase().compareTo(object2.getBibKey().toUpperCase());
               }
            });
        }
        
        return listaRef;
    }
}
