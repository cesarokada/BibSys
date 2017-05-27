package br.unesp.rc.bibSys.businessObject;

import br.unesp.rc.bibSys.beans.ReferenciaBeans;
import java.util.ArrayList;
import java.util.List;

public class ValidarReferencia {
    
    public boolean validarParentesis(String obj){
        int countAbreChaves = 0;
        int countFechaChaves = 0;
        
        for(char c : obj.toCharArray()){
            countAbreChaves += c == '{' ? 1 : 0;
            countFechaChaves += c == '}' ? 1 : 0;
        }
        
        return countAbreChaves == countFechaChaves;
    }
    
    public List<String> validarBibKeyUnica(List<ReferenciaBeans> refList){
        List<String> retorno = new ArrayList<>();
        refList.forEach((ReferenciaBeans r) -> {
            int count = 0;
            count = refList.stream().filter((f) -> (f.getBibKey().equals(f.getBibKey()))).map((_item) -> 1).reduce(count, Integer::sum);
            if (count > 1) {
                retorno.add(r.getBibKey());
            }
        });
        
        return retorno;
    }
}
