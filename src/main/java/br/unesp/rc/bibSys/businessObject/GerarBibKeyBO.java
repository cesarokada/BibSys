/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class GerarBibKeyBO {

    /**
     *
     * @param refList
     * @return
     */
    public List<ReferenciaBeans> gerarBibSysAutomaricamente(List<ReferenciaBeans> refList){
        
        refList.forEach((t) -> {
            StringBuilder bibKey = new StringBuilder(gerarBibSys(t));
            boolean existList = false;
                int initValueAscii = 97; //Codigo ascii da letra 'a'
                while(verificarExistenciaBibKey(bibKey.toString(), refList)){
                    bibKey.append(Character.toString((char)initValueAscii));
                    initValueAscii++;
                }
                t.setBibKey(bibKey.toString());
        });
        
        return refList;
    }
    
    private String gerarBibSys(ReferenciaBeans ref){
        StringBuilder retorno = new StringBuilder();
        
        //Existe mais de um autor
        if(ref.getAuthor().contains("and")){
            List<String> autores = new ArrayList<>(Arrays.asList(ref.getAuthor().split("and")));
            
            if(autores.size() > 2) //Sobrenome do primero .etal
                retorno.append(getSobrenome(autores.get(0))).append(".etal");
            else //Sobrenome do primeiro . Sobrenome do segundo
                retorno.append(getSobrenome(autores.get(0))).append(".").append(getSobrenome(autores.get(1)));
        } else //apenas um autor
            retorno.append(getSobrenome(ref.getAuthor()));
        
        retorno.append(":").append(ref.getYear());
        
        return retorno.toString();
    }
    
    private String getSobrenome(String nomeCompleto){
        if(nomeCompleto.trim().contains(" "))
            return nomeCompleto.trim().split(" ")[0].trim();
        else
            return nomeCompleto.trim();
    }
    
    private boolean verificarExistenciaBibKey(String bibKey, List<ReferenciaBeans> refList){
        boolean existInList = false;
        
        for(ReferenciaBeans t : refList){
            if(t.getBibKey().equals(bibKey)){
                existInList = true;
                break;
            }
        }
        
        return existInList;
    }
}
