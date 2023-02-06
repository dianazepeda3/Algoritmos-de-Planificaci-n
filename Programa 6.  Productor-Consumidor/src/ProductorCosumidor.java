
/**
 * @author diana
 */
public class ProductorCosumidor {    
    public boolean tipo; // tipo -- Dormido = 0 -- Trabajando= 1
    public int Tes;
    public int elementos; // 2-5 elementos
    public int elementosRes;
    public int ultElemento;
    public boolean aux;

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getTes() {
        return Tes;
    }

    public void setTes(int Tes) {
        this.Tes = Tes;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public int getUltElemento() {
        return ultElemento;
    }

    public void setUltElemento(int ultElemento) {
        this.ultElemento = ultElemento;
    }

    public int getElementosRes() {
        return elementosRes;
    }

    public void setElementosRes(int elementosRes) {
        this.elementosRes = elementosRes;
    }

    public boolean isAux() {
        return aux;
    }

    public void setAux(boolean aux) {
        this.aux = aux;
    }
    
    
    
}
