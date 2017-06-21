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
    * Retorna uma lista de objetos ReferenciaBeans com as possíves duplicatas de
     * bibkey concatenadas por letras à partir do 'a' para diferenciá-las, dado uma
     * lista de objetos ReferenciaBeans
     * 
     * @param refList
     * @return uma lista de objetos ReferenciaBeans com as possíveis duplicatas tratadas
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
    /**
     * Retona uma string que contém o 'Sobrenome do Primeiro Autor .etal: Ano'
     * caso haja 3 ou mais autores
     * 
     * Retona uma string que contém o 'Sobrenome do Primeiro Autor .Sobrenome do Segundo Autor: Ano'
     * caso haja 2 autores
     * 
     * Retona uma string que contém o 'Sobrenome do Primeiro Autor : Ano'
     * caso haja 1 autores
     * 
     * tendo como base um objeto ReferenciaBeans
     * 
     * @param ref objeto ReferenciaBeans
     * @return String seguindo as condições descritas
     */
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
    /**
     * Retorna uma String contendo o sobrenome, dado uma String com o nome completo
     * 
     * @param nomeCompleto String contendo o nome completo
     * @return String contendo o sobrenome
     */
    private String getSobrenome(String nomeCompleto){
        if(nomeCompleto.trim().contains(" "))
            return nomeCompleto.trim().split(" ")[0].trim();
        else
            return nomeCompleto.trim();
    }
    /**
     * Verifica a existência de uma referência bibkey, dado uma String da qual se
     * deseja analisar e uma lista de objetos ReferenciaBeans, retornando verdadeiro
     * caso exista ocorrencia da String na lista
     * 
     * @param bibKey String contendo a referência bibkey
     * @param refList lista de objetos ReferenciaBeans
     * @return verdadeiro caso exista ocorrência da String na lsita de ReferenciaBeans
     */
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
