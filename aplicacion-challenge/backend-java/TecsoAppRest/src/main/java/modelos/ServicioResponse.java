package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.List;

public class ServicioResponse implements Serializable {
    private Control control;
    private Payload datos;
    private List<Payload> arraydatos;
    private List<Payload> array;

    public Payload getDatos() {
        return datos;
    }

    public void setDatos(Payload payload) {
        this.datos = payload;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(AppCodigo codigo) {
        this.setControl(codigo, "", "");
    }

    public void setControl(AppCodigo codigo, String descripcionCorta) {
        this.setControl(codigo, descripcionCorta, "");
    }

    public void setControl(AppCodigo codigo, String descripcionCorta, String descripcionLarga) {
        if (control == null) {
            control = new Control();
        }
        control.setCodigo(codigo);
        control.setDescripcion(descripcionCorta);
        control.setDescripcionLarga(descripcionLarga);
    }

    public String toJson() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").create();
        return gson.toJson(this);
    }

    public ServicioResponse() {
        //Seteo por defecto ok
        this.setControl(AppCodigo.OK);
    }
    
    
    public List<Payload> getArraydatos() {
        return arraydatos;
    }

    public void setArraydatos(List<Payload> arraydatos) {
        this.arraydatos = arraydatos;
    }

    public List<Payload> getArray() {
        return array;
    }

    public void setArray(List<Payload> array) {
        this.array = array;
    }
    
    

}
