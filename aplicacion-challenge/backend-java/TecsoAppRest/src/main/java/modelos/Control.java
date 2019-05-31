package modelos;

public class Control {
    private AppCodigo codigo;
    private String descripcion;
    private String descripcionLarga;
    private String version;
    private String versionLib;

    public AppCodigo getCodigo() {
        return codigo;
    }

    public void setCodigo(AppCodigo codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionLib() {
        return versionLib;
    }

    public void setVersionLib(String versionLib) {
        this.versionLib = versionLib;
    }
}
