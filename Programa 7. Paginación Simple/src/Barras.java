
import java.awt.Color;


/**
 *
 * @author diana
 */
public class Barras {
    public int macro;
    public int id;
    public int estado;
    public boolean vacio;
    public int espacio;
    public Color color;
    
    /*
    Estado
      - 0 nuevo       Color 
      - 1 listo       Color amarillo
      - 2 ejecución   Color verde
      - 3 bloqueado   Color rojo
      - 4 terminado   Color azul
      - 5 SO
    */ 

    public int getMacro() {
        return macro;
    }

    public void setMacro(int macro) {
        this.macro = macro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
