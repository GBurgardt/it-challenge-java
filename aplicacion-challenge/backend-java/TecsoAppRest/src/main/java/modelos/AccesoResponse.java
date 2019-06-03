package modelos;

import entidades.Acceso;

public class AccesoResponse implements Payload {
    private int identificador;
    private String token;
    
    public AccesoResponse(Acceso acceso) {
        this.identificador = acceso.getIdentificador();
        this.token = acceso.getToken();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
