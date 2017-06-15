package br.unesp.rc.bibSys.beans;

import java.util.ArrayList;
import java.util.List;

public class ReferenciaCompararBeans {

    public ReferenciaCompararBeans(){
        referenciasA = new ArrayList<>();
        referenciasB = new ArrayList<>();
    }
    
    /**
     * @return the referenciasA
     */
    public List<ReferenciaBeans> getReferenciasA() {
        return referenciasA;
    }

    /**
     * @param referenciasA the referenciasA to set
     */
    public void setReferenciasA(List<ReferenciaBeans> referenciasA) {
        this.referenciasA = referenciasA;
    }

    /**
     * @return the referenciasB
     */
    public List<ReferenciaBeans> getReferenciasB() {
        return referenciasB;
    }

    /**
     * @param referenciasB the referenciasB to set
     */
    public void setReferenciasB(List<ReferenciaBeans> referenciasB) {
        this.referenciasB = referenciasB;
    }
    private List<ReferenciaBeans> referenciasA;
    private List<ReferenciaBeans> referenciasB;
    
}
