
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.swing.Timer;


/**
 *
 * @author diana
 */
public class Hilos extends Thread{
     javax.swing.JLabel lblTittulo;
    int h, m, s, cs;
    private DataOutputStream archivo2;
    private DataInputStream archivo4;
    
    public Hilos() throws IOException{   
        t = new Timer(10, acciones);       
    }
    
    private Timer t;
    
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
   public void run(){ 
        
        while(true){            
            ++cs; 
            try {
                sleep(10);
            } catch (InterruptedException ex) {}            
            if(cs==100){
                cs = 0;
                ++s;                
            }
            if(s==8){
                s = 0;
                ++m;
            }
                        actualizarLabel();
            System.out.println("h: "+h+"  m: "+m+"  s: "+s);           
        }
    }
    
    private void actualizarLabel() {
        String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        lblTittulo.setText(tiempo);
    }
    
    public void recibeJLabel(javax.swing.JLabel lblTittulo){
        this.lblTittulo = lblTittulo;
    }
       
}
