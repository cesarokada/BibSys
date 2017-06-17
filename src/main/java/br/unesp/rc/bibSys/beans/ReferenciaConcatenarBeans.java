package br.unesp.rc.bibSys.beans;

public class ReferenciaConcatenarBeans {

    /**
     * @return the referencia
     */
    public ReferenciaBeans getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(ReferenciaBeans referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the codigoArquivo
     */
    public String getCodigoArquivo() {
        return codigoArquivo;
    }

    /**
     * @param codigoArquivo the codigoArquivo to set
     */
    public void setCodigoArquivo(String codigoArquivo) {
        this.codigoArquivo = codigoArquivo;
    }
    private ReferenciaBeans referencia;
    private String codigoArquivo;
}
