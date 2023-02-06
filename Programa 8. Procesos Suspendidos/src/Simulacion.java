

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.table.DefaultTableModel;

/**
 * @author diana
 */
public class Simulacion extends javax.swing.JFrame{
    
    //LinkedList cola=new LinkedList();    
    public static boolean te;
    public static int numPro2;
    public static Object[][] procesos = new Object[100][20];
    Queue<Integer> cola=new LinkedList();
    Queue<Integer> colaAux=new LinkedList();
    Queue<Integer> cola2=new LinkedList();
    Queue<Integer> colaSus=new LinkedList();
    Queue<Integer> colaBarra=new LinkedList();
    Barras ba;
    ArrayList<Barras> barras = new ArrayList<Barras>();
    ArrayList<Boolean> listaBarras = new ArrayList<Boolean>();
    ArrayList<Integer> lista = new ArrayList<Integer>();    
    ArrayList<Integer> bloqueados = new ArrayList<Integer>();
    ArrayList<Integer> bloqueados2 = new ArrayList<Integer>();
    //int[] barras = new int[50];
    char tecla = 'Z';
    int ancho, numVacios, espacioQueda, suspendidos;
    float numeroAux;
    int numPro, aux, aux2, a=0, cont = 0;
    int loteP = 1, pro = 0, i = 0, bar;
    int tr = 0, tme, contador = 0, num = 0, quantum = 0;
    String operacion="", op="";
    Boolean sig = false, error = false, error2=false, interrup = false, inte = false, auxx = false, es = false;
    public Simulacion() {
        initComponents();        
        this.setTitle("PROCESOS SUSPENDIDOS");
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo
        numPro = Integer.parseInt(CapturarProcesos.txtnumP1.getText());     
        txtValQuantum.setText(CapturarProcesos.txtQuantum.getText());
        txtnumProSus.setText("0");
        te = Terminado.te;        
        
        for(int i=0; i<50; i++){
            //barras[i] = 0;
            ba = new Barras();
            ba.setVacio(true);
            ba.setMacro(i+1);
            barras.add(ba);
            listaBarras.add(false);
        }        
        colorBarra(pbar47, Color.blue);   
        colorBarra(pbar48, Color.blue);  
        colorBarra(pbar49, Color.blue);  
        colorBarra(pbar50, Color.blue);  
        pbar47.setValue(100);
        pbar48.setValue(100);
        pbar49.setValue(100);
        pbar50.setValue(100);
        barras.get(46).setEstado(5);
        barras.get(46).setVacio(false);
        barras.get(47).setEstado(5);
        barras.get(47).setVacio(false);
        barras.get(48).setEstado(5);
        barras.get(48).setVacio(false);
        barras.get(49).setEstado(5);
        barras.get(49).setVacio(false);
        listaBarras.set(46, true);
        listaBarras.set(47, true);
        listaBarras.set(48, true);
        listaBarras.set(49, true);
        inicio();
        
        setLocationRelativeTo(null);        
        t = new Timer(10, acciones); 
        
        t.start();
        btnFin.setVisible(false);        
    }
    
    public void inicio(){
        numPro2 = numPro;
        procesos = CapturarProcesos.procesos;              
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();         
        num = numPro;
        if(numPro>5){
            num = 5;
        }
        aux = numPro;
        aux--;
        //aux = aux -num;
        txtnumLP.setText(String.valueOf(aux));  
        procesos[0][6] = 2;
        procesos[0][12] = 0;
        numeroAux = Integer.parseInt(String.valueOf(procesos[0][19]));            
        numeroAux = (int)Math.ceil(numeroAux/4);
        numVacios = vaciosBarra();
        System.out.println(String.valueOf(procesos[0][19]));
        espacioQueda = Integer.parseInt(String.valueOf(procesos[0][19]));
        for(int d=0;d<numeroAux;d++){                    
            numVacios = vaciosBarra();                                                   
            listaBarras.set(d, true);
            vbarra();
            System.out.println("numVacios: "+numVacios+" bar: "+ 0);                     
            barras.get(d).setId(Integer.parseInt(String.valueOf(procesos[0][0])));
            barras.get(d).setEstado(2);
            barras.get(d).setVacio(false);
            barras.get(d).setColor(Color.green);           
            
            if(espacioQueda>=4){
                barras.get(d).setEspacio(100);                 
            }else if(espacioQueda==3){
                barras.get(d).setEspacio(75);
            }else if(espacioQueda==2){
                barras.get(d).setEspacio(50);
            }else if(espacioQueda==1){
                barras.get(d).setEspacio(25);
            }  
            espacioQueda = espacioQueda - 4;
        }     
        actualizarBarras();
        cont++;
        cola.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        //cola2.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        lista.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        for(int i = 0; i<numPro; i++){
            operacion(i);
            procesos[i][3] = operacion;
        }
        numVacios = vaciosBarra();
        vbarra();
        int a = 1, bar;                
        boolean salir = false;
        while(numVacios != 0 && !salir){                 
            numeroAux = Integer.parseInt(String.valueOf(procesos[a][19]));            
            numeroAux = (int)Math.ceil(numeroAux/4);
            System.out.println("id: "+String.valueOf(procesos[a][0])+"tam: "+String.valueOf(procesos[a][19])+" macros: "+numeroAux);
            if(numeroAux<=numVacios){
                espacioQueda = Integer.parseInt(String.valueOf(procesos[a][19]));
                for(int d=0;d<numeroAux;d++){                    
                    numVacios = vaciosBarra();  
                    System.out.println(colaBarra.size());
                    vbarra();
                    if(colaBarra.size()>0){
                    bar = colaBarra.poll();                    
                    listaBarras.set(bar, true);
                    vbarra();
                    System.out.println("numVacios: "+numVacios+" bar: "+ bar);         
                    
                    barras.get(bar).setId(Integer.parseInt(String.valueOf(procesos[a][0])));
                    barras.get(bar).setEstado(1);
                    barras.get(bar).setVacio(false);
                    barras.get(bar).setColor(Color.yellow);
                    //barras.get(bar).setEspacio(75);
                    if(espacioQueda>=4){
                        barras.get(bar).setEspacio(100);                 
                    }else if(espacioQueda==3){
                        barras.get(bar).setEspacio(75);
                    }else if(espacioQueda==2){
                        barras.get(bar).setEspacio(50);
                    }else if(espacioQueda==1){
                        barras.get(bar).setEspacio(25);
                    }  
                    espacioQueda = espacioQueda - 4;
                    }
                }          
                cola.add(Integer.parseInt(String.valueOf(procesos[a][0])));
                lista.add(Integer.parseInt(String.valueOf(procesos[a][0])));
                modelo.addRow(new Object[]{procesos[a][0],procesos[a][5],procesos[a][7], procesos[a][19]});            
                procesos[a][6] = 1;
                cont++;
                aux--;
                txtnumLP.setText(String.valueOf(aux));  
                //a++;
            }
            //System.out.println("a--"+a);
            a++;
            if(String.valueOf(procesos[a][19]).equals("null") || colaBarra.isEmpty() || a == numPro){
                salir = true;
            }
        }     
        actualizarBarras();
        /*for(int j=0; j<46; j++){
            System.out.println("id: "+barras.get(i).getId()+" vacio: "+barras.get(i).isVacio());
        }*/
        procesoAct();    
        proListo();        
    }    

    public void inicio2(){
        numPro2 = numPro;
        procesos = CapturarProcesos.procesos;              
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();         
        num = numPro;
        if(numPro>5){
            num = 5;
        }
        aux = numPro;
        aux = aux -num;
        txtnumLP.setText(String.valueOf(aux));  
        procesos[0][6] = 2;
        procesos[0][12] = 0;
        cont++;
        cola.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        lista.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        for(int i = 0; i<numPro; i++){
            operacion(i);
            procesos[i][3] = operacion;
        }
        for(int i = 1 ; i<num ; i++){
            cola.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            //cola2.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            lista.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7]});            
            procesos[i][6] = 1;
            //procesos[i][12] = 0;
            cont++;
        }          
        procesoAct();            
    }    
    
    public void nombreBarras(JProgressBar pbar, JLabel lblMem, int i){                  
            if(barras.get(i).vacio){
                pbar.setValue(0);
                lblMem.setText("-");
            }else if(!barras.get(i).vacio){
                pbar.setValue(barras.get(i).getEspacio());
                colorBarra(pbar, barras.get(i).getColor());
                lblMem.setText(""+barras.get(i).getId());
            }        
    }
    
    public void actualizarBarras(){               
        nombreBarras(pbar1, lblMem1, 0);        nombreBarras(pbar2, lblMem2, 1);
        nombreBarras(pbar3, lblMem3, 2);        nombreBarras(pbar4, lblMem4, 3);
        nombreBarras(pbar5, lblMem5, 4);        nombreBarras(pbar6, lblMem6, 5);
        nombreBarras(pbar7, lblMem7, 6);        nombreBarras(pbar8, lblMem8, 7);
        nombreBarras(pbar9, lblMem9, 8);        nombreBarras(pbar10, lblMem10, 9);
        nombreBarras(pbar11, lblMem11, 10);        nombreBarras(pbar12, lblMem12, 11);
        nombreBarras(pbar13, lblMem13, 12);        nombreBarras(pbar14, lblMem14, 13);
        nombreBarras(pbar15, lblMem15, 14);        nombreBarras(pbar16, lblMem16, 15);
        nombreBarras(pbar17, lblMem17, 16);        nombreBarras(pbar18, lblMem18, 17);
        nombreBarras(pbar19, lblMem19, 18);        nombreBarras(pbar20, lblMem20, 19);
        nombreBarras(pbar21, lblMem21, 20);        nombreBarras(pbar22, lblMem22, 21);
        nombreBarras(pbar23, lblMem23, 22);        nombreBarras(pbar24, lblMem24, 23);
        nombreBarras(pbar25, lblMem25, 24);        nombreBarras(pbar26, lblMem26, 25);
        nombreBarras(pbar27, lblMem27, 26);        nombreBarras(pbar28, lblMem28, 27);
        nombreBarras(pbar29, lblMem29, 28);        nombreBarras(pbar30, lblMem30, 29);
        nombreBarras(pbar31, lblMem31, 30);        nombreBarras(pbar32, lblMem32, 31);
        nombreBarras(pbar33, lblMem33, 32);        nombreBarras(pbar34, lblMem34, 33);
        nombreBarras(pbar35, lblMem35, 34);        nombreBarras(pbar36, lblMem36, 35);
        nombreBarras(pbar37, lblMem37, 36);        nombreBarras(pbar38, lblMem38, 37);
        nombreBarras(pbar39, lblMem39, 38);        nombreBarras(pbar40, lblMem40, 39);
        nombreBarras(pbar41, lblMem41, 40);        nombreBarras(pbar42, lblMem42, 41);
        nombreBarras(pbar43, lblMem43, 42);        nombreBarras(pbar44, lblMem44, 43);
        nombreBarras(pbar45, lblMem45, 44);        nombreBarras(pbar46, lblMem46, 45);          
    }
    
    public void colorBarra(JProgressBar barra, Color color){        
        barra.setUI(new BasicProgressBarUI(){            
            @Override            
            protected void paintDeterminate(Graphics g, JComponent jc){
                Graphics2D g2d = (Graphics2D)g;                 
                double porcentaje = barra.getPercentComplete();
                ancho = (int)(barra.getWidth()*porcentaje);                        
                g2d.setColor(color);
                Rectangle progreso = new Rectangle(0,0,ancho,barra.getHeight());
                g2d.fill(progreso);
            }
        }); 
    }
    
    public int vaciosBarra(){
        int numVacios = 0;        
        for(int i=0; i<47;i++){
            if(!listaBarras.get(i)){
                numVacios++;                
            }            
        }
        return numVacios;
    }
    
    public void vbarra(){
        while(!colaBarra.isEmpty()){
            colaBarra.remove();
        }
        for(int i=0; i<47;i++){
            if(!listaBarras.get(i)){                
                colaBarra.add(i);
            }            
        }
    }
    
    public void procesoAct(){
        if(!lista.isEmpty()){
            txtPID.setText(String.valueOf(procesos[lista.get(i)-1][0]));                     
            operacion(lista.get(i)-1);
            txtPOp.setText(String.valueOf(operacion));
            txtPTME.setText(String.valueOf(procesos[lista.get(i)-1][5]));                    
            tr = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][5]));
            txtPTT.setText("0");
            txtPTR.setText(String.valueOf(tr));              
        }else{
            limpiarP();
        }  
    }  

    public void procesoAct2(){       
            txtPID.setText(String.valueOf(procesos[lista.get(i)-1][0]));                     
            txtPOp.setText(String.valueOf(operacion));
            txtPTME.setText(String.valueOf(procesos[lista.get(i)-1][5]));                    
            tr = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][5]));
            txtPTT.setText("0");
            txtPTR.setText(String.valueOf(tr));              
         
    }
    
    public void operacion(int pro){
        if(!error){
        if(String.valueOf(procesos[pro][3]).equals("0")){
            op = " + ";
            procesos[pro][4] = Integer.parseInt(String.valueOf(procesos[pro][1])) + Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("1")){
            op = " - ";
            procesos[pro][4] = Integer.parseInt(String.valueOf(procesos[pro][1])) - Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("2")){
            op = " * ";
            procesos[pro][4] = Integer.parseInt(String.valueOf(procesos[pro][1])) * Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("3")){
            op = " / ";
            procesos[pro][4] = Integer.parseInt(String.valueOf(procesos[pro][1])) / Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("4")){
            op = " % ";
            procesos[pro][4] = Integer.parseInt(String.valueOf(procesos[pro][1])) % Integer.parseInt(String.valueOf(procesos[pro][2]));
        }
        operacion = String.valueOf(procesos[pro][1]+op+procesos[pro][2]);
        //procesos[cont][3]=operacion;
        }
        if(error){
            procesos[pro][4] = "Error";
            error = false;
        }
    }
    
    public void limpiarP(){
        txtPID.setText(null); 
        txtPOp.setText(null);
        txtPTME.setText(null);
        txtPTT.setText(null);
        txtPTR.setText(null); 
        txtQuantum.setText(null);
    }
    
    public void proListo(){
        DefaultTableModel modelo = (DefaultTableModel) jtProxListo.getModel();        
        modelo.setNumRows(0);  
        boolean auxi = true;
        int nuevos = 0;
        float numA = 0;
        for(int i = 0; i<20; i++){   
            if(auxi){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 0 && !String.valueOf(procesos[i][19]).equals("null")){
                numA = Integer.parseInt(String.valueOf(procesos[i][19]));          
                numA = (int)Math.ceil(numA/4);
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][19],numA});   
                //i = lista.size()-1;
                nuevos++;
                auxi = false;
            }  
            }
        }     
        System.out.println("NUEVOS "+nuevos);
    }
    
    public void pendientes(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        modelo.setNumRows(0);  
        int auxiliar;        
        for(int i = 0; i<lista.size(); i++){            
            if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6])) == 1){
                modelo.addRow(new Object[]{procesos[lista.get(i)-1][0],procesos[lista.get(i)-1][5],procesos[lista.get(i)-1][7],procesos[lista.get(i)-1][19]});           
            }            
        }               
    }
    
    public void pendientess(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        modelo.setNumRows(0);        
        for(int i = 0; i<numPro2; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 && Integer.parseInt(String.valueOf(procesos[i][15])) == 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7],procesos[lista.get(i)-1][19]});           
            }            
        }                  
        
        for(int i = 0; i<numPro2; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 && Integer.parseInt(String.valueOf(procesos[i][15])) != 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7], procesos[lista.get(i)-1][19]});           
            }            
        }        
    }
    
    public void pendientes2(int i){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        //modelo.setNumRows(0);
         
        //for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7], procesos[lista.get(i)-1][19]});     
                //procesos[i][15] = 1;
                //modelo.removeRow(0);
            }
            
        //} 
    }
    
    public void bloqueados(){
        DefaultTableModel modelo = (DefaultTableModel) jtBloqueados.getModel();        
        //modelo.setNumRows(0);
        //for(int i = 0; i<numPro; i++){
        try{
            if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6])) == 3){
                modelo.addRow(new Object[]{procesos[lista.get(i)-1][0],procesos[lista.get(i)-1][8]});           
            }
        }catch(Exception e){}
        //}           
    }
    
    public void bloqueados2(){
        DefaultTableModel modelo = (DefaultTableModel) jtBloqueados.getModel();        
        modelo.setNumRows(0);
        for(int i = 0; i<numPro2; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 3){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][8]});           
            }
        }           
    }
    
    public void primera(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        
                modelo.removeRow(0);
            

    }
    
    public void terminados(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        if(Integer.parseInt(String.valueOf(procesos[i][6])) == 4){
            operacion(i);
            procesos[i][7] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], procesos[i][4]/*,procesos[i][17]*/});                  
        }              
    }
    
    public void terminados2(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        if(Integer.parseInt(String.valueOf(procesos[i][6])) == 4){
            operacion(i);
            procesos[i][7] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], procesos[i][4]/*,procesos[i][17]*/});                  
        }              
    }
        
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtProE8 = new javax.swing.JLabel();
        jtProE16 = new javax.swing.JLabel();
        jtProE18 = new javax.swing.JLabel();
        jtProE19 = new javax.swing.JLabel();
        jtProE20 = new javax.swing.JLabel();
        jtProE21 = new javax.swing.JLabel();
        txtPOp = new javax.swing.JTextField();
        txtPTR = new javax.swing.JTextField();
        txtPID = new javax.swing.JTextField();
        txtPTME = new javax.swing.JTextField();
        txtPTT = new javax.swing.JTextField();
        jtProE22 = new javax.swing.JLabel();
        jtProE23 = new javax.swing.JLabel();
        jtProE24 = new javax.swing.JLabel();
        jtProE17 = new javax.swing.JLabel();
        txtQuantum = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtnumLP = new javax.swing.JTextField();
        lblTittulo = new javax.swing.JLabel();
        lblNumPro = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jpTer = new javax.swing.JScrollPane();
        jpTerminado = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtContG = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtBloqueados = new javax.swing.JTable();
        lblProBloqueados = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtBloqueados1 = new javax.swing.JTable();
        lblProBloqueados1 = new javax.swing.JLabel();
        lblPause = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEjecucion = new javax.swing.JTable();
        lblProLis1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblNumPro1 = new javax.swing.JLabel();
        txtValQuantum = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblMem19 = new javax.swing.JLabel();
        pbar36 = new javax.swing.JProgressBar();
        jLabel43 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        pbar3 = new javax.swing.JProgressBar();
        lblMem2 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        pbar2 = new javax.swing.JProgressBar();
        pbar4 = new javax.swing.JProgressBar();
        pbar5 = new javax.swing.JProgressBar();
        pbar6 = new javax.swing.JProgressBar();
        pbar7 = new javax.swing.JProgressBar();
        pbar8 = new javax.swing.JProgressBar();
        pbar9 = new javax.swing.JProgressBar();
        pbar10 = new javax.swing.JProgressBar();
        pbar11 = new javax.swing.JProgressBar();
        pbar12 = new javax.swing.JProgressBar();
        pbar13 = new javax.swing.JProgressBar();
        pbar14 = new javax.swing.JProgressBar();
        pbar16 = new javax.swing.JProgressBar();
        pbar19 = new javax.swing.JProgressBar();
        pbar20 = new javax.swing.JProgressBar();
        pbar21 = new javax.swing.JProgressBar();
        pbar22 = new javax.swing.JProgressBar();
        pbar23 = new javax.swing.JProgressBar();
        pbar24 = new javax.swing.JProgressBar();
        pbar25 = new javax.swing.JProgressBar();
        pbar26 = new javax.swing.JProgressBar();
        pbar27 = new javax.swing.JProgressBar();
        pbar29 = new javax.swing.JProgressBar();
        pbar1 = new javax.swing.JProgressBar();
        lblMem3 = new javax.swing.JLabel();
        lblMem4 = new javax.swing.JLabel();
        lblMem5 = new javax.swing.JLabel();
        lblMem6 = new javax.swing.JLabel();
        lblMem7 = new javax.swing.JLabel();
        lblMem8 = new javax.swing.JLabel();
        lblMem9 = new javax.swing.JLabel();
        lblMem10 = new javax.swing.JLabel();
        lblMem12 = new javax.swing.JLabel();
        lblMem1 = new javax.swing.JLabel();
        pbar17 = new javax.swing.JProgressBar();
        pbar15 = new javax.swing.JProgressBar();
        lblMem13 = new javax.swing.JLabel();
        lblMem14 = new javax.swing.JLabel();
        lblMem15 = new javax.swing.JLabel();
        lblMem16 = new javax.swing.JLabel();
        lblMem17 = new javax.swing.JLabel();
        lblMem11 = new javax.swing.JLabel();
        pbar30 = new javax.swing.JProgressBar();
        pbar31 = new javax.swing.JProgressBar();
        pbar32 = new javax.swing.JProgressBar();
        pbar33 = new javax.swing.JProgressBar();
        pbar34 = new javax.swing.JProgressBar();
        pbar28 = new javax.swing.JProgressBar();
        lblMem20 = new javax.swing.JLabel();
        lblMem21 = new javax.swing.JLabel();
        lblMem22 = new javax.swing.JLabel();
        lblMem23 = new javax.swing.JLabel();
        lblMem24 = new javax.swing.JLabel();
        lblMem25 = new javax.swing.JLabel();
        lblMem26 = new javax.swing.JLabel();
        lblMem27 = new javax.swing.JLabel();
        lblMem29 = new javax.swing.JLabel();
        lblMem35 = new javax.swing.JLabel();
        lblMem30 = new javax.swing.JLabel();
        lblMem31 = new javax.swing.JLabel();
        lblMem32 = new javax.swing.JLabel();
        lblMem33 = new javax.swing.JLabel();
        lblMem28 = new javax.swing.JLabel();
        lblMem34 = new javax.swing.JLabel();
        lblMem36 = new javax.swing.JLabel();
        lblMem37 = new javax.swing.JLabel();
        lblMem38 = new javax.swing.JLabel();
        lblMem40 = new javax.swing.JLabel();
        lblMem18 = new javax.swing.JLabel();
        lblMem41 = new javax.swing.JLabel();
        lblMem42 = new javax.swing.JLabel();
        lblMem43 = new javax.swing.JLabel();
        lblMem44 = new javax.swing.JLabel();
        lblMem45 = new javax.swing.JLabel();
        lblMem46 = new javax.swing.JLabel();
        lblMem47 = new javax.swing.JLabel();
        lblMem48 = new javax.swing.JLabel();
        lblMem50 = new javax.swing.JLabel();
        lblMem39 = new javax.swing.JLabel();
        lblMem49 = new javax.swing.JLabel();
        pbar18 = new javax.swing.JProgressBar();
        pbar37 = new javax.swing.JProgressBar();
        pbar38 = new javax.swing.JProgressBar();
        pbar39 = new javax.swing.JProgressBar();
        pbar41 = new javax.swing.JProgressBar();
        pbar35 = new javax.swing.JProgressBar();
        pbar42 = new javax.swing.JProgressBar();
        pbar43 = new javax.swing.JProgressBar();
        pbar44 = new javax.swing.JProgressBar();
        pbar45 = new javax.swing.JProgressBar();
        pbar46 = new javax.swing.JProgressBar();
        pbar47 = new javax.swing.JProgressBar();
        pbar48 = new javax.swing.JProgressBar();
        pbar49 = new javax.swing.JProgressBar();
        pbar50 = new javax.swing.JProgressBar();
        pbar40 = new javax.swing.JProgressBar();
        jLabel37 = new javax.swing.JLabel();
        btnFin = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblProLis = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtProxListo = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lblProLis2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtProxMemSus = new javax.swing.JTable();
        lblNumPro2 = new javax.swing.JLabel();
        txtnumProSus = new javax.swing.JTextField();
        lblTittulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contador global:");

        jPanel9.setBackground(new java.awt.Color(58, 58, 58));
        jPanel9.setLayout(null);

        jtProE8.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE8.setForeground(new java.awt.Color(255, 255, 255));
        jtProE8.setText("TR:");
        jPanel9.add(jtProE8);
        jtProE8.setBounds(180, 120, 30, 40);

        jtProE16.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jtProE16.setForeground(new java.awt.Color(255, 255, 255));
        jtProE16.setText("Quantum:");
        jPanel9.add(jtProE16);
        jtProE16.setBounds(50, 160, 80, 40);

        jtProE18.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE18.setForeground(new java.awt.Color(255, 255, 255));
        jtProE18.setText("seg");
        jPanel9.add(jtProE18);
        jtProE18.setBounds(290, 120, 30, 40);

        jtProE19.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jtProE19.setForeground(new java.awt.Color(255, 255, 255));
        jtProE19.setText("Operacion:");
        jPanel9.add(jtProE19);
        jtProE19.setBounds(20, 40, 70, 40);

        jtProE20.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE20.setForeground(new java.awt.Color(255, 255, 255));
        jtProE20.setText("TME:");
        jPanel9.add(jtProE20);
        jtProE20.setBounds(20, 120, 40, 40);

        jtProE21.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE21.setForeground(new java.awt.Color(255, 255, 255));
        jtProE21.setText("TT:");
        jPanel9.add(jtProE21);
        jtProE21.setBounds(180, 80, 30, 40);

        txtPOp.setBackground(new java.awt.Color(88, 88, 88));
        txtPOp.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPOp.setForeground(new java.awt.Color(88, 88, 88));
        txtPOp.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPOp.setEnabled(false);
        jPanel9.add(txtPOp);
        txtPOp.setBounds(100, 50, 180, 25);

        txtPTR.setBackground(new java.awt.Color(234, 234, 234));
        txtPTR.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPTR.setEnabled(false);
        jPanel9.add(txtPTR);
        txtPTR.setBounds(210, 130, 70, 25);

        txtPID.setBackground(new java.awt.Color(234, 234, 234));
        txtPID.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPID.setEnabled(false);
        jPanel9.add(txtPID);
        txtPID.setBounds(60, 90, 70, 25);

        txtPTME.setBackground(new java.awt.Color(234, 234, 234));
        txtPTME.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTME.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPTME.setEnabled(false);
        jPanel9.add(txtPTME);
        txtPTME.setBounds(60, 130, 70, 25);

        txtPTT.setBackground(new java.awt.Color(234, 234, 234));
        txtPTT.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPTT.setEnabled(false);
        jPanel9.add(txtPTT);
        txtPTT.setBounds(210, 90, 70, 25);

        jtProE22.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jtProE22.setForeground(new java.awt.Color(255, 255, 255));
        jtProE22.setText("ID:");
        jPanel9.add(jtProE22);
        jtProE22.setBounds(30, 80, 30, 40);

        jtProE23.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE23.setForeground(new java.awt.Color(255, 255, 255));
        jtProE23.setText("seg");
        jPanel9.add(jtProE23);
        jtProE23.setBounds(140, 120, 30, 40);

        jtProE24.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE24.setForeground(new java.awt.Color(255, 255, 255));
        jtProE24.setText("seg");
        jPanel9.add(jtProE24);
        jtProE24.setBounds(290, 80, 30, 40);

        jtProE17.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jtProE17.setForeground(new java.awt.Color(255, 255, 255));
        jtProE17.setText("Proceso en ejecución");
        jPanel9.add(jtProE17);
        jtProE17.setBounds(90, 0, 160, 40);

        txtQuantum.setBackground(new java.awt.Color(234, 234, 234));
        txtQuantum.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtQuantum.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQuantum.setEnabled(false);
        jPanel9.add(txtQuantum);
        txtQuantum.setBounds(140, 170, 100, 25);

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        txtnumLP.setBackground(new java.awt.Color(234, 234, 234));
        txtnumLP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtnumLP.setEnabled(false);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo.setText("Autor: Diana Zepeda Tatengo");

        lblNumPro.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblNumPro.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPro.setText("Valor del Quantum:");

        jPanel12.setBackground(new java.awt.Color(58, 58, 58));
        jPanel12.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(58, 58, 58));
        jPanel13.setLayout(null);
        jPanel12.add(jPanel13);
        jPanel13.setBounds(134, 178, 0, 0);

        jpTerminado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ope", "Res"
            }
        ));
        jpTerminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpTerminadoKeyPressed(evt);
            }
        });
        jpTer.setViewportView(jpTerminado);
        if (jpTerminado.getColumnModel().getColumnCount() > 0) {
            jpTerminado.getColumnModel().getColumn(0).setPreferredWidth(45);
        }

        jPanel12.add(jpTer);
        jpTer.setBounds(10, 46, 280, 140);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Procesos terminados");
        jPanel12.add(jLabel15);
        jLabel15.setBounds(80, 0, 153, 50);

        txtContG.setBackground(new java.awt.Color(234, 234, 234));
        txtContG.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtContG.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(58, 58, 58));
        jPanel2.setLayout(null);

        jtBloqueados.setBackground(new java.awt.Color(204, 204, 204));
        jtBloqueados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TT"
            }
        ));
        jScrollPane3.setViewportView(jtBloqueados);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 40, 270, 110);

        lblProBloqueados.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        lblProBloqueados.setForeground(new java.awt.Color(255, 255, 255));
        lblProBloqueados.setText("Procesos Bloqueados");
        jPanel2.add(lblProBloqueados);
        lblProBloqueados.setBounds(70, 0, 170, 40);

        jPanel4.setBackground(new java.awt.Color(58, 58, 58));
        jPanel4.setLayout(null);

        jtBloqueados1.setBackground(new java.awt.Color(204, 204, 204));
        jtBloqueados1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TT"
            }
        ));
        jScrollPane5.setViewportView(jtBloqueados1);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(10, 40, 270, 110);

        lblProBloqueados1.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        lblProBloqueados1.setForeground(new java.awt.Color(255, 255, 255));
        lblProBloqueados1.setText("Procesos Bloqueados");
        jPanel4.add(lblProBloqueados1);
        lblProBloqueados1.setBounds(70, 0, 170, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(30, 380, 290, 170);

        lblPause.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        lblPause.setForeground(new java.awt.Color(236, 64, 86));

        jPanel3.setBackground(new java.awt.Color(58, 58, 58));
        jPanel3.setLayout(null);

        jtEjecucion.setBackground(new java.awt.Color(204, 204, 204));
        jtEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TME", "TT", "Tam"
            }
        ));
        jtEjecucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEjecucionKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jtEjecucion);
        if (jtEjecucion.getColumnModel().getColumnCount() > 0) {
            jtEjecucion.getColumnModel().getColumn(1).setHeaderValue("TME");
            jtEjecucion.getColumnModel().getColumn(2).setHeaderValue("TT");
        }

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(10, 40, 270, 190);

        lblProLis1.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        lblProLis1.setForeground(new java.awt.Color(255, 255, 255));
        lblProLis1.setText("Procesos listos");
        jPanel3.add(lblProLis1);
        lblProLis1.setBounds(90, 0, 120, 40);

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));

        lblNumPro1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblNumPro1.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPro1.setText("No. Procesos Suspendidos:");

        txtValQuantum.setBackground(new java.awt.Color(234, 234, 234));
        txtValQuantum.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtValQuantum.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MEMORIA");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(200, 10, 80, 20);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("N. macro");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(320, 40, 60, 30);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ID");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(380, 40, 30, 30);

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("N. macro");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(10, 40, 50, 30);

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 255));
        jLabel22.setText("4");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(30, 160, 30, 30);

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ID");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(70, 40, 30, 30);

        lblMem19.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem19.setForeground(new java.awt.Color(255, 255, 255));
        lblMem19.setText("-");
        jPanel1.add(lblMem19);
        lblMem19.setBounds(230, 100, 30, 30);
        jPanel1.add(pbar36);
        pbar36.setBounds(410, 110, 50, 12);

        jLabel43.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(153, 153, 255));
        jLabel43.setText("1");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(30, 70, 30, 30);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 255));
        jLabel24.setText("2");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(30, 100, 30, 30);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 255));
        jLabel25.setText("5");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(30, 190, 30, 30);

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 255));
        jLabel26.setText("6");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(30, 220, 30, 30);

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 255));
        jLabel27.setText("7");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(30, 250, 30, 30);

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 255));
        jLabel28.setText("8");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(30, 280, 30, 30);

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 255));
        jLabel29.setText("9");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(30, 310, 30, 30);

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 255));
        jLabel30.setText("11");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(30, 370, 30, 30);

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 255));
        jLabel31.setText("3");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(30, 130, 30, 30);

        jLabel32.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 153, 255));
        jLabel32.setText("12");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(30, 400, 30, 30);

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 255));
        jLabel33.setText("13");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(30, 430, 30, 30);

        jLabel35.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 255));
        jLabel35.setText("14");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(30, 460, 30, 30);

        jLabel36.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 255));
        jLabel36.setText("15");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(30, 490, 30, 30);

        jLabel38.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 153, 255));
        jLabel38.setText("18");
        jPanel1.add(jLabel38);
        jLabel38.setBounds(190, 70, 30, 30);

        jLabel39.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 153, 255));
        jLabel39.setText("19");
        jPanel1.add(jLabel39);
        jLabel39.setBounds(190, 100, 30, 30);

        jLabel40.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 255));
        jLabel40.setText("20");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(190, 130, 30, 30);

        jLabel41.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 153, 255));
        jLabel41.setText("22");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(190, 190, 30, 30);

        jLabel42.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(153, 153, 255));
        jLabel42.setText("10");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(30, 340, 30, 30);

        jLabel44.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(153, 153, 255));
        jLabel44.setText("16");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(30, 520, 30, 30);

        jLabel45.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 153, 255));
        jLabel45.setText("17");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(30, 550, 30, 30);

        jLabel46.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(153, 153, 255));
        jLabel46.setText("23");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(190, 220, 30, 30);

        jLabel47.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 153, 255));
        jLabel47.setText("24");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(190, 250, 30, 30);

        jLabel48.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 153, 255));
        jLabel48.setText("25");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(190, 280, 30, 30);

        jLabel49.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 153, 255));
        jLabel49.setText("26");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(190, 310, 30, 30);

        jLabel50.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(153, 153, 255));
        jLabel50.setText("27");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(190, 340, 30, 30);

        jLabel51.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(153, 153, 255));
        jLabel51.setText("28");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(190, 370, 30, 30);

        jLabel52.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(153, 153, 255));
        jLabel52.setText("29");
        jPanel1.add(jLabel52);
        jLabel52.setBounds(190, 400, 30, 30);

        jLabel53.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 255));
        jLabel53.setText("30");
        jPanel1.add(jLabel53);
        jLabel53.setBounds(190, 430, 30, 30);

        jLabel54.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(153, 153, 255));
        jLabel54.setText("31");
        jPanel1.add(jLabel54);
        jLabel54.setBounds(190, 460, 30, 30);

        jLabel55.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(153, 153, 255));
        jLabel55.setText("32");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(190, 490, 30, 30);

        jLabel56.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(153, 153, 255));
        jLabel56.setText("33");
        jPanel1.add(jLabel56);
        jLabel56.setBounds(190, 520, 30, 30);

        jLabel57.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(153, 153, 255));
        jLabel57.setText("34");
        jPanel1.add(jLabel57);
        jLabel57.setBounds(190, 550, 30, 30);

        jLabel58.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(153, 153, 255));
        jLabel58.setText("35");
        jPanel1.add(jLabel58);
        jLabel58.setBounds(330, 70, 30, 30);

        jLabel59.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(153, 153, 255));
        jLabel59.setText("37");
        jPanel1.add(jLabel59);
        jLabel59.setBounds(330, 130, 30, 30);

        jLabel60.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(153, 153, 255));
        jLabel60.setText("21");
        jPanel1.add(jLabel60);
        jLabel60.setBounds(190, 160, 30, 30);
        jPanel1.add(pbar3);
        pbar3.setBounds(110, 140, 50, 12);

        lblMem2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem2.setForeground(new java.awt.Color(255, 255, 255));
        lblMem2.setText("-");
        jPanel1.add(lblMem2);
        lblMem2.setBounds(70, 100, 30, 30);

        jLabel61.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 153, 255));
        jLabel61.setText("38");
        jPanel1.add(jLabel61);
        jLabel61.setBounds(330, 160, 30, 30);

        jLabel62.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 153, 255));
        jLabel62.setText("39");
        jPanel1.add(jLabel62);
        jLabel62.setBounds(330, 190, 30, 30);

        jLabel63.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 153, 255));
        jLabel63.setText("40");
        jPanel1.add(jLabel63);
        jLabel63.setBounds(330, 220, 30, 30);

        jLabel64.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(153, 153, 255));
        jLabel64.setText("41");
        jPanel1.add(jLabel64);
        jLabel64.setBounds(330, 250, 30, 30);

        jLabel65.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(153, 153, 255));
        jLabel65.setText("42");
        jPanel1.add(jLabel65);
        jLabel65.setBounds(330, 280, 30, 30);

        jLabel66.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(153, 153, 255));
        jLabel66.setText("43");
        jPanel1.add(jLabel66);
        jLabel66.setBounds(330, 310, 30, 30);

        jLabel67.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(153, 153, 255));
        jLabel67.setText("44");
        jPanel1.add(jLabel67);
        jLabel67.setBounds(330, 340, 30, 30);

        jLabel68.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(153, 153, 255));
        jLabel68.setText("45");
        jPanel1.add(jLabel68);
        jLabel68.setBounds(330, 370, 30, 30);

        jLabel69.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 153, 255));
        jLabel69.setText("46");
        jPanel1.add(jLabel69);
        jLabel69.setBounds(330, 400, 30, 30);

        jLabel70.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 153, 255));
        jLabel70.setText("47");
        jPanel1.add(jLabel70);
        jLabel70.setBounds(330, 430, 30, 30);

        jLabel71.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 153, 255));
        jLabel71.setText("48");
        jPanel1.add(jLabel71);
        jLabel71.setBounds(330, 460, 30, 30);

        jLabel72.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(153, 153, 255));
        jLabel72.setText("49");
        jPanel1.add(jLabel72);
        jLabel72.setBounds(330, 490, 30, 30);

        jLabel73.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 255));
        jLabel73.setText("50");
        jPanel1.add(jLabel73);
        jLabel73.setBounds(330, 520, 30, 30);

        jLabel74.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 153, 255));
        jLabel74.setText("36");
        jPanel1.add(jLabel74);
        jLabel74.setBounds(330, 100, 30, 30);

        jLabel75.setFont(new java.awt.Font("Microsoft YaHei", 1, 10)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("N. macro");
        jPanel1.add(jLabel75);
        jLabel75.setBounds(170, 40, 60, 30);

        jLabel76.setFont(new java.awt.Font("Microsoft YaHei", 1, 13)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("ID");
        jPanel1.add(jLabel76);
        jLabel76.setBounds(230, 40, 30, 30);
        jPanel1.add(pbar2);
        pbar2.setBounds(110, 110, 50, 12);
        jPanel1.add(pbar4);
        pbar4.setBounds(110, 170, 50, 12);
        jPanel1.add(pbar5);
        pbar5.setBounds(110, 200, 50, 12);
        jPanel1.add(pbar6);
        pbar6.setBounds(110, 230, 50, 12);
        jPanel1.add(pbar7);
        pbar7.setBounds(110, 260, 50, 12);
        jPanel1.add(pbar8);
        pbar8.setBounds(110, 290, 50, 12);
        jPanel1.add(pbar9);
        pbar9.setBounds(110, 320, 50, 12);
        jPanel1.add(pbar10);
        pbar10.setBounds(110, 350, 50, 12);
        jPanel1.add(pbar11);
        pbar11.setBounds(110, 380, 50, 12);
        jPanel1.add(pbar12);
        pbar12.setBounds(110, 410, 50, 12);
        jPanel1.add(pbar13);
        pbar13.setBounds(110, 440, 50, 12);
        jPanel1.add(pbar14);
        pbar14.setBounds(110, 470, 50, 12);
        jPanel1.add(pbar16);
        pbar16.setBounds(110, 530, 50, 12);
        jPanel1.add(pbar19);
        pbar19.setBounds(260, 110, 50, 12);
        jPanel1.add(pbar20);
        pbar20.setBounds(260, 140, 50, 12);
        jPanel1.add(pbar21);
        pbar21.setBounds(260, 170, 50, 12);
        jPanel1.add(pbar22);
        pbar22.setBounds(260, 200, 50, 12);
        jPanel1.add(pbar23);
        pbar23.setBounds(260, 230, 50, 12);
        jPanel1.add(pbar24);
        pbar24.setBounds(260, 260, 50, 12);
        jPanel1.add(pbar25);
        pbar25.setBounds(260, 290, 50, 12);
        jPanel1.add(pbar26);
        pbar26.setBounds(260, 320, 50, 12);
        jPanel1.add(pbar27);
        pbar27.setBounds(260, 350, 50, 12);
        jPanel1.add(pbar29);
        pbar29.setBounds(260, 410, 50, 12);
        jPanel1.add(pbar1);
        pbar1.setBounds(110, 80, 50, 12);

        lblMem3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem3.setForeground(new java.awt.Color(255, 255, 255));
        lblMem3.setText("-");
        jPanel1.add(lblMem3);
        lblMem3.setBounds(70, 130, 30, 30);

        lblMem4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem4.setForeground(new java.awt.Color(255, 255, 255));
        lblMem4.setText("-");
        jPanel1.add(lblMem4);
        lblMem4.setBounds(70, 160, 30, 30);

        lblMem5.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem5.setForeground(new java.awt.Color(255, 255, 255));
        lblMem5.setText("-");
        jPanel1.add(lblMem5);
        lblMem5.setBounds(70, 190, 30, 30);

        lblMem6.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem6.setForeground(new java.awt.Color(255, 255, 255));
        lblMem6.setText("-");
        jPanel1.add(lblMem6);
        lblMem6.setBounds(70, 220, 30, 30);

        lblMem7.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem7.setForeground(new java.awt.Color(255, 255, 255));
        lblMem7.setText("-");
        jPanel1.add(lblMem7);
        lblMem7.setBounds(70, 250, 30, 30);

        lblMem8.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem8.setForeground(new java.awt.Color(255, 255, 255));
        lblMem8.setText("-");
        jPanel1.add(lblMem8);
        lblMem8.setBounds(70, 280, 30, 30);

        lblMem9.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem9.setForeground(new java.awt.Color(255, 255, 255));
        lblMem9.setText("-");
        jPanel1.add(lblMem9);
        lblMem9.setBounds(70, 310, 30, 30);

        lblMem10.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem10.setForeground(new java.awt.Color(255, 255, 255));
        lblMem10.setText("-");
        jPanel1.add(lblMem10);
        lblMem10.setBounds(70, 340, 30, 30);

        lblMem12.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem12.setForeground(new java.awt.Color(255, 255, 255));
        lblMem12.setText("-");
        jPanel1.add(lblMem12);
        lblMem12.setBounds(70, 400, 30, 30);

        lblMem1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem1.setForeground(new java.awt.Color(255, 255, 255));
        lblMem1.setText("-");
        jPanel1.add(lblMem1);
        lblMem1.setBounds(70, 70, 30, 30);
        jPanel1.add(pbar17);
        pbar17.setBounds(110, 560, 50, 12);
        jPanel1.add(pbar15);
        pbar15.setBounds(110, 500, 50, 12);

        lblMem13.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem13.setForeground(new java.awt.Color(255, 255, 255));
        lblMem13.setText("-");
        jPanel1.add(lblMem13);
        lblMem13.setBounds(70, 430, 30, 30);

        lblMem14.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem14.setForeground(new java.awt.Color(255, 255, 255));
        lblMem14.setText("-");
        jPanel1.add(lblMem14);
        lblMem14.setBounds(70, 460, 30, 30);

        lblMem15.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem15.setForeground(new java.awt.Color(255, 255, 255));
        lblMem15.setText("-");
        jPanel1.add(lblMem15);
        lblMem15.setBounds(70, 490, 30, 30);

        lblMem16.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem16.setForeground(new java.awt.Color(255, 255, 255));
        lblMem16.setText("-");
        jPanel1.add(lblMem16);
        lblMem16.setBounds(70, 520, 30, 30);

        lblMem17.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem17.setForeground(new java.awt.Color(255, 255, 255));
        lblMem17.setText("-");
        jPanel1.add(lblMem17);
        lblMem17.setBounds(70, 550, 30, 30);

        lblMem11.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem11.setForeground(new java.awt.Color(255, 255, 255));
        lblMem11.setText("-");
        jPanel1.add(lblMem11);
        lblMem11.setBounds(70, 370, 30, 30);
        jPanel1.add(pbar30);
        pbar30.setBounds(260, 440, 50, 12);
        jPanel1.add(pbar31);
        pbar31.setBounds(260, 470, 50, 12);
        jPanel1.add(pbar32);
        pbar32.setBounds(260, 500, 50, 12);
        jPanel1.add(pbar33);
        pbar33.setBounds(260, 530, 50, 12);
        jPanel1.add(pbar34);
        pbar34.setBounds(260, 560, 50, 12);
        jPanel1.add(pbar28);
        pbar28.setBounds(260, 380, 50, 12);

        lblMem20.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem20.setForeground(new java.awt.Color(255, 255, 255));
        lblMem20.setText("-");
        jPanel1.add(lblMem20);
        lblMem20.setBounds(230, 130, 30, 30);

        lblMem21.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem21.setForeground(new java.awt.Color(255, 255, 255));
        lblMem21.setText("-");
        jPanel1.add(lblMem21);
        lblMem21.setBounds(230, 160, 30, 30);

        lblMem22.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem22.setForeground(new java.awt.Color(255, 255, 255));
        lblMem22.setText("-");
        jPanel1.add(lblMem22);
        lblMem22.setBounds(230, 190, 30, 30);

        lblMem23.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem23.setForeground(new java.awt.Color(255, 255, 255));
        lblMem23.setText("-");
        jPanel1.add(lblMem23);
        lblMem23.setBounds(230, 220, 30, 30);

        lblMem24.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem24.setForeground(new java.awt.Color(255, 255, 255));
        lblMem24.setText("-");
        jPanel1.add(lblMem24);
        lblMem24.setBounds(230, 250, 30, 30);

        lblMem25.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem25.setForeground(new java.awt.Color(255, 255, 255));
        lblMem25.setText("-");
        jPanel1.add(lblMem25);
        lblMem25.setBounds(230, 280, 30, 30);

        lblMem26.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem26.setForeground(new java.awt.Color(255, 255, 255));
        lblMem26.setText("-");
        jPanel1.add(lblMem26);
        lblMem26.setBounds(230, 310, 30, 30);

        lblMem27.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem27.setForeground(new java.awt.Color(255, 255, 255));
        lblMem27.setText("-");
        jPanel1.add(lblMem27);
        lblMem27.setBounds(230, 340, 30, 30);

        lblMem29.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem29.setForeground(new java.awt.Color(255, 255, 255));
        lblMem29.setText("-");
        jPanel1.add(lblMem29);
        lblMem29.setBounds(230, 400, 30, 30);

        lblMem35.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem35.setForeground(new java.awt.Color(255, 255, 255));
        lblMem35.setText("-");
        jPanel1.add(lblMem35);
        lblMem35.setBounds(380, 70, 30, 30);

        lblMem30.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem30.setForeground(new java.awt.Color(255, 255, 255));
        lblMem30.setText("-");
        jPanel1.add(lblMem30);
        lblMem30.setBounds(230, 430, 30, 30);

        lblMem31.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem31.setForeground(new java.awt.Color(255, 255, 255));
        lblMem31.setText("-");
        jPanel1.add(lblMem31);
        lblMem31.setBounds(230, 460, 30, 30);

        lblMem32.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem32.setForeground(new java.awt.Color(255, 255, 255));
        lblMem32.setText("-");
        jPanel1.add(lblMem32);
        lblMem32.setBounds(230, 490, 30, 30);

        lblMem33.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem33.setForeground(new java.awt.Color(255, 255, 255));
        lblMem33.setText("-");
        jPanel1.add(lblMem33);
        lblMem33.setBounds(230, 520, 30, 30);

        lblMem28.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem28.setForeground(new java.awt.Color(255, 255, 255));
        lblMem28.setText("-");
        jPanel1.add(lblMem28);
        lblMem28.setBounds(230, 370, 30, 30);

        lblMem34.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem34.setForeground(new java.awt.Color(255, 255, 255));
        lblMem34.setText("-");
        jPanel1.add(lblMem34);
        lblMem34.setBounds(230, 550, 30, 30);

        lblMem36.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem36.setForeground(new java.awt.Color(255, 255, 255));
        lblMem36.setText("-");
        jPanel1.add(lblMem36);
        lblMem36.setBounds(380, 100, 30, 30);

        lblMem37.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem37.setForeground(new java.awt.Color(255, 255, 255));
        lblMem37.setText("-");
        jPanel1.add(lblMem37);
        lblMem37.setBounds(380, 130, 30, 30);

        lblMem38.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem38.setForeground(new java.awt.Color(255, 255, 255));
        lblMem38.setText("-");
        jPanel1.add(lblMem38);
        lblMem38.setBounds(380, 160, 30, 30);

        lblMem40.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem40.setForeground(new java.awt.Color(255, 255, 255));
        lblMem40.setText("-");
        jPanel1.add(lblMem40);
        lblMem40.setBounds(380, 220, 30, 30);

        lblMem18.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem18.setForeground(new java.awt.Color(255, 255, 255));
        lblMem18.setText("-");
        jPanel1.add(lblMem18);
        lblMem18.setBounds(230, 70, 30, 30);

        lblMem41.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem41.setForeground(new java.awt.Color(255, 255, 255));
        lblMem41.setText("-");
        jPanel1.add(lblMem41);
        lblMem41.setBounds(380, 250, 30, 30);

        lblMem42.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem42.setForeground(new java.awt.Color(255, 255, 255));
        lblMem42.setText("-");
        jPanel1.add(lblMem42);
        lblMem42.setBounds(380, 280, 30, 30);

        lblMem43.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem43.setForeground(new java.awt.Color(255, 255, 255));
        lblMem43.setText("-");
        jPanel1.add(lblMem43);
        lblMem43.setBounds(380, 310, 30, 30);

        lblMem44.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem44.setForeground(new java.awt.Color(255, 255, 255));
        lblMem44.setText("-");
        jPanel1.add(lblMem44);
        lblMem44.setBounds(380, 340, 30, 30);

        lblMem45.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem45.setForeground(new java.awt.Color(255, 255, 255));
        lblMem45.setText("-");
        jPanel1.add(lblMem45);
        lblMem45.setBounds(380, 370, 30, 30);

        lblMem46.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem46.setForeground(new java.awt.Color(255, 255, 255));
        lblMem46.setText("-");
        jPanel1.add(lblMem46);
        lblMem46.setBounds(380, 400, 30, 30);

        lblMem47.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem47.setForeground(new java.awt.Color(255, 255, 255));
        lblMem47.setText("SO");
        jPanel1.add(lblMem47);
        lblMem47.setBounds(380, 430, 30, 30);

        lblMem48.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem48.setForeground(new java.awt.Color(255, 255, 255));
        lblMem48.setText("SO");
        jPanel1.add(lblMem48);
        lblMem48.setBounds(380, 460, 30, 30);

        lblMem50.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem50.setForeground(new java.awt.Color(255, 255, 255));
        lblMem50.setText("SO");
        jPanel1.add(lblMem50);
        lblMem50.setBounds(380, 520, 30, 30);

        lblMem39.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem39.setForeground(new java.awt.Color(255, 255, 255));
        lblMem39.setText("-");
        jPanel1.add(lblMem39);
        lblMem39.setBounds(380, 190, 30, 30);

        lblMem49.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblMem49.setForeground(new java.awt.Color(255, 255, 255));
        lblMem49.setText("SO");
        jPanel1.add(lblMem49);
        lblMem49.setBounds(380, 490, 30, 30);
        jPanel1.add(pbar18);
        pbar18.setBounds(260, 80, 50, 12);
        jPanel1.add(pbar37);
        pbar37.setBounds(410, 140, 50, 12);
        jPanel1.add(pbar38);
        pbar38.setBounds(410, 170, 50, 12);
        jPanel1.add(pbar39);
        pbar39.setBounds(410, 200, 50, 12);
        jPanel1.add(pbar41);
        pbar41.setBounds(410, 260, 50, 12);
        jPanel1.add(pbar35);
        pbar35.setBounds(410, 80, 50, 12);
        jPanel1.add(pbar42);
        pbar42.setBounds(410, 290, 50, 12);
        jPanel1.add(pbar43);
        pbar43.setBounds(410, 320, 50, 12);
        jPanel1.add(pbar44);
        pbar44.setBounds(410, 350, 50, 12);
        jPanel1.add(pbar45);
        pbar45.setBounds(410, 380, 50, 12);
        jPanel1.add(pbar46);
        pbar46.setBounds(410, 410, 50, 12);
        jPanel1.add(pbar47);
        pbar47.setBounds(410, 440, 50, 12);
        jPanel1.add(pbar48);
        pbar48.setBounds(410, 470, 50, 12);
        jPanel1.add(pbar49);
        pbar49.setBounds(410, 500, 50, 12);
        jPanel1.add(pbar50);
        pbar50.setBounds(410, 530, 50, 12);
        jPanel1.add(pbar40);
        pbar40.setBounds(410, 230, 50, 12);

        jLabel37.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));

        btnFin.setText("Ver Terminados");
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(58, 58, 58));
        jPanel5.setLayout(null);

        lblProLis.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        lblProLis.setForeground(new java.awt.Color(255, 255, 255));
        lblProLis.setText("Proximo listo");
        jPanel5.add(lblProLis);
        lblProLis.setBounds(100, 0, 120, 40);

        jtProxListo.setBackground(new java.awt.Color(204, 204, 204));
        jtProxListo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tam", "NumMacros"
            }
        ));
        jtProxListo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtProxListoKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jtProxListo);

        jPanel5.add(jScrollPane6);
        jScrollPane6.setBounds(10, 40, 270, 50);

        jPanel6.setBackground(new java.awt.Color(58, 58, 58));
        jPanel6.setLayout(null);

        lblProLis2.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        lblProLis2.setForeground(new java.awt.Color(255, 255, 255));
        lblProLis2.setText("Proximo a Memoria");
        jPanel6.add(lblProLis2);
        lblProLis2.setBounds(80, 0, 150, 40);

        jtProxMemSus.setBackground(new java.awt.Color(204, 204, 204));
        jtProxMemSus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tam", "NumMacros"
            }
        ));
        jtProxMemSus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtProxMemSusKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(jtProxMemSus);

        jPanel6.add(jScrollPane7);
        jScrollPane7.setBounds(10, 40, 270, 50);

        lblNumPro2.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblNumPro2.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPro2.setText("No. Procesos nuevos:");

        txtnumProSus.setBackground(new java.awt.Color(234, 234, 234));
        txtnumProSus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtnumProSus.setEnabled(false);

        lblTittulo1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo1.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo1.setText("PROCESOS SUSPENDIDOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(lblPause, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(txtValQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(140, 140, 140)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(txtnumProSus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNumPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(1140, 1140, 1140)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPause, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumProSus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpTerminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpTerminadoKeyPressed
        //jLabel1.setText("El caracter pulsado: "+evt.getKeyChar());
    }//GEN-LAST:event_jpTerminadoKeyPressed

    private void jtEjecucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEjecucionKeyPressed
        
    }//GEN-LAST:event_jtEjecucionKeyPressed

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinActionPerformed
        Terminado ven=new Terminado();
        ven.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btnFinActionPerformed

    private void jtProxListoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProxListoKeyPressed
        if(evt.getKeyChar() == 'P'){
            t.stop();
            lblPause.setText("PAUSE");
            tecla='P';
            System.out.println("Tecla P");
        }  
        if(evt.getKeyChar() == 'A'){
            t.stop();
            lblPause.setText("PAUSE MEMORIA");
            tecla='A';
            System.out.println("Tecla A");
        }  
        if(evt.getKeyChar() == 'C'){
            
            lblPause.setText(" ");
            tecla='C';
            Terminado ven=new Terminado();
            ven.setVisible(false);
            t.start();
            System.out.println("Tecla C");
        } 
        if(evt.getKeyChar() == 'E'){
            if(tecla != 'P' && tecla != 'A'){
                error = true;
                error2 = true;
                procesos[lista.get(i)-1][14] = s; 
                /*
                procesos[lista.get(i)-1][10] = txtContG.getText();                            
                procesos[lista.get(i)-1][11] = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][10]))-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                procesos[lista.get(i)-1][13] = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][11]))-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][14]));
                   */         
                s=tme;          
                quantum = 0;
            }
            System.out.println("Tecla E");
        }
        if(evt.getKeyChar() == 'I'){
            if(tecla != 'P' && tecla != 'A'){
                interrup = true;
                inte = true;
            }
            System.out.println("Tecla I");
        }
        if(evt.getKeyChar() == 'N'){
            procesos[numPro2][0] = numPro2+1;
            procesos[numPro2][1] = (int)(Math.random()*(1000+1));
            procesos[numPro2][2] = (int)(Math.random()*(1000+1));
            procesos[numPro2][3] = (int)(Math.random()*(4+0));
            procesos[numPro2][5] = (int)(Math.random()*(10+0)+6);
            procesos[numPro2][18] = procesos[numPro2][5];
            procesos[numPro2][12] = -1;
            procesos[numPro2][19] = (int)(Math.random()*(21+0)+5);
            //procesos[numPro2][6] = 0;
            proListo();
            operacion(numPro2);
            procesos[numPro2][3] = operacion;
            //lista.add(Integer.parseInt(String.valueOf(procesos[numPro2][0])));
            //pendientes();
            
            numPro2++;
            
            
            txtnumLP.setText(String.valueOf(Integer.parseInt(txtnumLP.getText())+1));
            
            System.out.println("Tecla N");            
        }
        if(evt.getKeyChar() == 'T'){
            lblPause.setText("PAUSE");
            tecla='P';
            t.stop();
            te = true;
            System.out.println("Tecla T");
            Terminado ven=new Terminado();
            ven.setVisible(true);
            //dispose();
        }
        int auxiliar = 0;
        if(evt.getKeyChar() == 'S'){
            if(tecla != 'P' && tecla != 'A'){
            suspendidos = 0;            
            bloqueados.clear();
            auxiliar = 0;
            for(int i = 0; i<numPro2; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 3){
                    auxiliar++; 
                    bloqueados.add(Integer.parseInt(String.valueOf(procesos[i][0])));
                }
            } 
            /*System.out.println("SIN ORDENAR");
            for(int i = 0; i<bloqueados.size(); i++){
                System.out.println("ID: "+bloqueados.get(i)+"         "+"TT: "+(Integer.parseInt(String.valueOf(procesos[bloqueados.get(i)-1][8]))));             
            }*/            
            int remp = 0;
            for(int i=1; i<auxiliar;i++){
                for(int j=0; j<auxiliar-1;j++){
                    //System.out.println((Integer.parseInt(String.valueOf(procesos[bloqueados.get(j)-1][8])))+" > "+(Integer.parseInt(String.valueOf(procesos[bloqueados.get(j+1)-1][8]))))    ;                
                    if((Integer.parseInt(String.valueOf(procesos[bloqueados.get(j)-1][8]))) < (Integer.parseInt(String.valueOf(procesos[bloqueados.get(j+1)-1][8])))){
                        remp = bloqueados.get(j);
                        bloqueados.set(j, bloqueados.get(j+1));
                        bloqueados.set(j+1, remp);
                    }
                }
            }
            /*System.out.println("ORDENADO");
            for(int i = 0; i<bloqueados.size(); i++){
                System.out.println("ID: "+bloqueados.get(i)+"                 "+"TT: "+(Integer.parseInt(String.valueOf(procesos[bloqueados.get(i)-1][8]))));                
            }*/
            if(bloqueados.size()>0){
                procesos[bloqueados.get(0)-1][6] = 5; 

                bloqueados2();   
                for(int j=0; j<46; j++){       
                    if(Integer.parseInt(String.valueOf(procesos[bloqueados.get(0)-1][0])) == barras.get(j).getId()){
                        barras.get(j).setColor(Color.GRAY);
                        barras.get(j).setEstado(4);                        
                    }
                }
                actualizarBarras();
                for(int j=0; j<46; j++){       
                    if(Integer.parseInt(String.valueOf(procesos[bloqueados.get(0)-1][0])) == barras.get(j).getId()){                        
                        barras.get(j).setVacio(true);
                        listaBarras.set(j, false);
                    }
                }
                actualizarBarras();
            /*
                for(int a=0; a<cola.size(); a++){
                    if(Integer.parseInt(String.valueOf(procesos[cola.element()-1][6])) == 1 || Integer.parseInt(String.valueOf(procesos[cola.element()][6])) == 2 || Integer.parseInt(String.valueOf(procesos[cola.element()][6])) == 3){
                        colaAux.add(cola.peek());
                    }else if(Integer.parseInt(String.valueOf(procesos[cola.element()-1][6])) == 5){
                        cola.remove();                    
                    }
                }
                cola = colaAux;
                for(int a=0;a<lista.size(); a++){
                    if(Integer.parseInt(String.valueOf(procesos[lista.get(a)-1][6])) == 5){
                        lista.remove(a);
                    }
                }  */          
                        
            
            FileWriter fichero = null;
            PrintWriter pw = null;            
                try {
                    fichero = new FileWriter("SUSPENDIDOS.txt");
                } catch (IOException ex) {}
                pw = new PrintWriter(fichero);
                pw.println(" PROCESOS SUSPENDIDOS");
                for(int i = 0; i<numPro2; i++){
                    if(Integer.parseInt(String.valueOf(procesos[i][6])) == 5){
                        operacion(i);
                        pw.println("-------------------------------------");
                        pw.println("ID: "+procesos[i][0]);
                        pw.println("Operacion: "+operacion);
                        pw.println("TME: "+procesos[i][5]);
                        pw.println("Tamaño: "+procesos[i][19]);
                    }                    
                } 

                System.out.println("Suspendidos: "+auxiliar);
                try {
                    fichero.close();
                } catch (IOException ex) {}
                colaSus.clear();
                for(int i = 0; i<numPro2; i++){
                    if(Integer.parseInt(String.valueOf(procesos[i][6])) == 5){
                        suspendidos++;
                        colaSus.add(Integer.parseInt(String.valueOf(procesos[i][0])));
                    }                    
                } 
                txtnumProSus.setText(""+colaSus.size());
                DefaultTableModel modelo = (DefaultTableModel) jtProxMemSus.getModel();        
                modelo.setNumRows(0);                                               
                float numA = 0;
                if(colaSus.size()>0){
                    numA = Integer.parseInt(String.valueOf(procesos[colaSus.element()-1][19]));          
                    numA = (int)Math.ceil(numA/4);
                    modelo.addRow(new Object[]{procesos[colaSus.element()-1][0],procesos[colaSus.element()-1][19],numA});                    
                }  
            }
            }
            }        
        if(evt.getKeyChar() == 'R'){
            if(tecla != 'P' && tecla != 'A'){
            numVacios = vaciosBarra();            
            try{
                if(colaSus.size()>0 && numVacios>0){                    
                    a = colaSus.element()-1;
                                                                               
                    numVacios = vaciosBarra();                        
                    vbarra();                                                                                         
                    numeroAux = Integer.parseInt(String.valueOf(procesos[a][19]));            
                    numeroAux = (int)Math.ceil(numeroAux/4);
                    if(numeroAux<=numVacios){
                        espacioQueda = Integer.parseInt(String.valueOf(procesos[a][19]));
                        for(int d=0;d<numeroAux;d++){                    
                            numVacios = vaciosBarra();  
           //                  System.out.println(colaBarra.size());
                            vbarra();
                            if(colaBarra.size()>0){
                                bar = colaBarra.poll();                    
                                listaBarras.set(bar, true);
                                vbarra();
                                       
                                barras.get(bar).setId(Integer.parseInt(String.valueOf(procesos[a][0])));
                                barras.get(bar).setEstado(1);
                                barras.get(bar).setVacio(false);
                                barras.get(bar).setColor(Color.red);
                                
                                if(espacioQueda>=4){
                                    barras.get(bar).setEspacio(100);                 
                                }else if(espacioQueda==3){
                                    barras.get(bar).setEspacio(75);
                                }else if(espacioQueda==2){
                                    barras.get(bar).setEspacio(50);
                                }else if(espacioQueda==1){
                                    barras.get(bar).setEspacio(25);
                                }  
                                espacioQueda = espacioQueda - 4;
                                }
                            }                                      
                            //cola.add(Integer.parseInt(String.valueOf(procesos[a][0])));
                            //lista.add(Integer.parseInt(String.valueOf(procesos[a][0])));
                            colaSus.remove();
                            procesos[a][6] = 3;                                                                                    
                        }
                                                               
                    actualizarBarras();                    
                    
                    //cont++;
                }
            
            }catch(Exception e){}
            txtnumProSus.setText(""+colaSus.size());
                DefaultTableModel modelo = (DefaultTableModel) jtProxMemSus.getModel();        
                modelo.setNumRows(0);                 
                boolean auxi = true;                
                float numA = 0;
                if(colaSus.size()>0){
                    numA = Integer.parseInt(String.valueOf(procesos[colaSus.element()-1][19]));          
                    numA = (int)Math.ceil(numA/4);
                    modelo.addRow(new Object[]{procesos[colaSus.element()-1][0],procesos[colaSus.element()-1][19],numA});                   
                }
                FileWriter fichero = null;
                PrintWriter pw = null;            
                    try {
                        fichero = new FileWriter("SUSPENDIDOS.txt");
                    } catch (IOException ex) {}
                    pw = new PrintWriter(fichero);
                    pw.println(" PROCESOS SUSPENDIDOS");
                    for(int i = 0; i<numPro2; i++){
                        if(Integer.parseInt(String.valueOf(procesos[i][6])) == 5){
                            operacion(i);
                            pw.println("-------------------------------------");
                            pw.println("ID: "+procesos[i][0]);
                            pw.println("Operacion: "+operacion);
                            pw.println("TME: "+procesos[i][5]);
                            pw.println("Tamaño: "+procesos[i][19]);
                        }                    
                    } 
                    try {
                        fichero.close();
                    } catch (IOException ex) {}
                    
            }
        }
    }//GEN-LAST:event_jtProxListoKeyPressed

    private void jtProxMemSusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProxMemSusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtProxMemSusKeyPressed
    
    private Timer t;
    private int s, cs, s2, cs2, cs3,s3, aux5;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {             
            /*for(int i = 0; i<lista.size(); i++){            
                System.out.println("lista: "+lista.get(i));
            }   
            System.out.println("");*/             
            if(lista.isEmpty()){ 
                ++cs2; 
                if(cs2==100){
                    cs2 = 0;
                    ++s2;
                }
                actualizarLabel2();
            }
            for(int i = 0; i<numPro2; i++){
                if(txtContG.getText().equals("")){
                    aux5 = 0;
                }else{
                aux5 = Integer.parseInt(txtContG.getText());  }              
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 || Integer.parseInt(String.valueOf(procesos[i][6])) == 3){
                    procesos[i][11] = aux5-Integer.parseInt(String.valueOf(procesos[i][9]));
                    procesos[i][13] = Integer.parseInt(String.valueOf(procesos[i][11]))-Integer.parseInt(String.valueOf(procesos[i][14]));                    
                }
            }
            for(int e=0; e<numPro2; e++){                  
                if(Integer.parseInt(String.valueOf(procesos[e][6])) == 3){                    
                    if(Integer.parseInt(String.valueOf(procesos[e][8]))<=8){
                        s3 = Integer.parseInt(String.valueOf(procesos[e][8]));
                        cs3 = Integer.parseInt(String.valueOf(procesos[e][16]));                        
                        //System.out.println(s3);
                        ++cs3; 
                        if(cs3==100){
                            cs3 = 0;
                            ++s3;
                        }
                        procesos[e][8] = s3;  
                        procesos[e][16] = cs3;
                        bloqueados2();
                    }
                    if(Integer.parseInt(String.valueOf(procesos[e][8]))>8){                        
                        procesos[e][6] = 1;    
                        for(int j=0; j<46; j++){       
                            if(Integer.parseInt(String.valueOf(procesos[e][0])) == barras.get(j).getId()){
                                barras.get(j).setEstado(1);
                                barras.get(j).setColor(Color.yellow);
                            }
                        }
                        actualizarBarras();
                        if(lista.isEmpty()){ es = true;}
                        lista.add(Integer.parseInt(String.valueOf(procesos[e][0])));
                        if(es){
                            procesos[e][6] = 2;
                            for(int j=0; j<46; j++){       
                                if(Integer.parseInt(String.valueOf(procesos[e][0])) == barras.get(j).getId()){
                                    barras.get(j).setEstado(2);
                                    barras.get(j).setColor(Color.green);
                                }
                            }
                            actualizarBarras();
                            procesoAct2();
                            es = false;
                        }
                        pendientes();
                        bloqueados2();
                    }                    
                }
            }
            if(cola.isEmpty()){
                t.stop();
                limpiarP();
                btnFin.setVisible(true);
            }else if(interrup){
                procesos[lista.get(i)-1][7] = txtPTT.getText();
                procesos[lista.get(i)-1][6] = 3;
                for(int j=0; j<46; j++){       
                if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                        barras.get(j).setEstado(3);
                        barras.get(j).setColor(Color.red);
                    }
                }
                actualizarBarras();
                procesos[lista.get(i)-1][15] = 1;
                procesos[lista.get(i)-1][8] = 0;
                interrup = false;
                //cola2.remove();
                lista.remove(0);
                
                bloqueados();
                quantum = 0;
                pro++;
                aux5++;
                s=0;
                a++;
                try{
                    procesos[lista.get(i)-1][6] = 2;
                    for(int j=0; j<46; j++){       
                        if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                            barras.get(j).setEstado(2);
                            barras.get(j).setColor(Color.green);
                        }
                    }
                    actualizarBarras();
                    if(String.valueOf(procesos[lista.get(i)-1][12]).equals("-1")){
                        procesos[lista.get(i)-1][12] = Integer.parseInt(txtContG.getText())-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                    }
                }catch(Exception e){}
                pendientes();
                procesoAct();                 
            }else{  
                //try{                    
                    if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6]))==2){
                        if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][15]))==1){
                            s = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][7]));
                            procesos[lista.get(i)-1][15] = 0;
                        }
                        pendientes();                        
                        ++cs2; 
                        if(cs2==100){
                            cs2 = 0;
                            ++s2;
                        }
                        if(s2==60){
                            //s2 = 0;                    
                        }                
                        actualizarLabel2();

                        tme = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][5]));   
                        tr = tme - s;                            
                        
                        if(s<=tme && quantum<Integer.parseInt(txtValQuantum.getText())){                        
                            ++cs; 
                            
                            if(cs==100){
                                cs = 0;
                                ++s;
                                quantum++;
                                tr=tr-1;
                            }
                            if(s==60){
                               s = 0;              
                            } 
                            actualizarLabel();  
                           // procesos[lista.get(i)-1][14] = s;
                            if(tr!=-1 && tr<Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][5])) && !error){
                                procesos[lista.get(i)-1][14] = txtPTT.getText();
                                procesos[lista.get(i)-1][11] = Integer.parseInt(txtContG.getText())-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                                procesos[lista.get(i)-1][18] = txtPTR.getText();
                                
                            }
                        }else{
                            if(quantum == Integer.parseInt(txtValQuantum.getText()) && s<tme){        
                                //System.out.println("Dentro");
                                procesos[lista.get(i)-1][6] = 1; 
                                for(int j=0; j<46; j++){       
                                    if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                                        barras.get(j).setEstado(1);
                                        barras.get(j).setColor(Color.yellow);
                                    }
                                }
                                actualizarBarras();
                                procesos[lista.get(i)-1][7] = txtPTT.getText();
                                procesos[lista.get(i)-1][15]=1;
                                quantum = 0;                                
                                cola.add(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])));
                                lista.add(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])));
                                cola.remove();
                                lista.remove(0);
                                procesos[lista.get(i)-1][6] = 2;
                                for(int j=0; j<46; j++){       
                                    if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                                        barras.get(j).setEstado(2);
                                        barras.get(j).setColor(Color.green);
                                    }
                                }
                                actualizarBarras();
                                if(String.valueOf(procesos[lista.get(i)-1][12]).equals("-1")){
                                    procesos[lista.get(i)-1][12] = Integer.parseInt(txtContG.getText())-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                                }
                                pendientes();  
                                procesoAct();                                                                                             
                            }else{
                                 System.out.println("FIN");
                            procesos[lista.get(i)-1][6] = 4; 
                            for(int j=0; j<46; j++){       
                                if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                                    barras.get(j).setEstado(4);
                                    barras.get(j).setColor(Color.blue);
                                    
                                }
                            }
                            actualizarBarras();
                            for(int j=0; j<46; j++){       
                                if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                                    barras.get(j).setVacio(true);
                                    listaBarras.set(j, false);
                                }
                            }
                            actualizarBarras();
                            procesos[lista.get(i)-1][10] = txtContG.getText();
                            procesos[lista.get(i)-1][3] = txtPOp.getText();
                            if(error2){                                  
                                error2 = false;
                            }else{
                                procesos[lista.get(i)-1][14] = procesos[lista.get(i)-1][5];
                            }
                            procesos[lista.get(i)-1][11] = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][10]))-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                            procesos[lista.get(i)-1][13] = Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][11]))-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][14]));
                            cola.remove();
                            //cola.add(Integer.parseInt(String.valueOf(procesos[cont][0])));
                            //cola2.remove();
                            terminados(lista.get(i)-1);
                            //System.out.println(lista.get(i)-1);
                            lista.remove(0);
                            quantum = 0;
                            //System.out.println(lista.get(i)-1);
                            if(!lista.isEmpty()){
                               // if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6]))==1 || Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6]))==2){
                                    procesos[lista.get(i)-1][6] = 2; 
                                    for(int j=0; j<46; j++){       
                                        if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][0])) == barras.get(j).getId()){
                                            barras.get(j).setEstado(2);
                                            barras.get(j).setColor(Color.green);
                                        }
                                    }
                                    actualizarBarras();
                                    if(String.valueOf(procesos[lista.get(i)-1][12]).equals("-1")){
                                        procesos[lista.get(i)-1][12] = s2-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                                        System.out.println(procesos[lista.get(i)-1][12]);
                                        procesos[lista.get(i)-1][17] = s2;
                                    }
                                //}
                            }
                            }
                            /*for(int i=0; i<numPro; i++){
                                if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6])) == 2){
                                    System.out.println("ID "+String.valueOf(procesos[lista.get(i)-1][0]));
                                }
                            }*/
                            s=0;
                            
                            pro++;
                            aux5++;
                            procesoAct(); 
                            
                        }                                
                    }                                         
                /*}catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }catch(Exception e){
                    pro = 0;
                    System.out.println(e);
                }*/
            }
            numVacios = vaciosBarra();
            //System.out.println("NUM VACIOS: "+ numVacios);
            try{
                if(numVacios>0){                    
                    a = cont;
                    if(!String.valueOf(procesos[cont][0]).equals("-1")){                                        
                    numVacios = vaciosBarra();
                        
                    vbarra();                                                                                         
                        numeroAux = Integer.parseInt(String.valueOf(procesos[a][19]));            
                        numeroAux = (int)Math.ceil(numeroAux/4);
                        //System.out.println("NUEVO  id: "+String.valueOf(procesos[a][0])+"tam: "+String.valueOf(procesos[a][19])+" macros: "+numeroAux);
                        if(numeroAux<=numVacios){
                            espacioQueda = Integer.parseInt(String.valueOf(procesos[a][19]));
                            for(int d=0;d<numeroAux;d++){                    
                                numVacios = vaciosBarra();  
                                System.out.println(colaBarra.size());
                                vbarra();
                                if(colaBarra.size()>0){
                                bar = colaBarra.poll();                    
                                listaBarras.set(bar, true);
                                vbarra();
                               // System.out.println("NUEVO numVacios: "+numVacios+" bar: "+ bar);         

                                barras.get(bar).setId(Integer.parseInt(String.valueOf(procesos[a][0])));
                                barras.get(bar).setEstado(1);
                                barras.get(bar).setVacio(false);
                                barras.get(bar).setColor(Color.yellow);
                                //barras.get(bar).setEspacio(75);
                                if(espacioQueda>=4){
                                    barras.get(bar).setEspacio(100);                 
                                }else if(espacioQueda==3){
                                    barras.get(bar).setEspacio(75);
                                }else if(espacioQueda==2){
                                    barras.get(bar).setEspacio(50);
                                }else if(espacioQueda==1){
                                    barras.get(bar).setEspacio(25);
                                }  
                                espacioQueda = espacioQueda - 4;
                                }
                            }          
                            
                            //procesos[i][12] = 0;                            
                            //a++;
                            cola.add(Integer.parseInt(String.valueOf(procesos[cont][0])));
                            lista.add(Integer.parseInt(String.valueOf(procesos[cont][0])));
                            procesos[cont][6] = 1;
                            procesos[cont][9] = txtContG.getText();
                            procesos[lista.get(i)-1][11] = Integer.parseInt(txtContG.getText())-Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][9]));
                            txtnumLP.setText(String.valueOf(Integer.parseInt(txtnumLP.getText())-1));
                            cont++;
                            proListo();
                        }
                        //System.out.println("a--"+a);
                        //a++;                                           
                    actualizarBarras();                    
                    }
                    //cont++;
                }
            }catch(Exception e){}
        }
        
    };
    
    private void actualizarLabel() {
        String tiempo = (s<=9?"":"")+s;              
        txtPTT.setText(tiempo);        
        txtPTR.setText(String.valueOf(tr));
        txtQuantum.setText(String.valueOf(quantum));
        /*DefaultTableModel modelo = (DefaultTableModel) jtBloqueados.getModel(); 
        modelo.setNumRows(0);
        modelo.addRow(new Object[]{tiempo, String.valueOf(tr)});*/
    }
    
    private void actualizarLabel2() {
        String tiempo = (s2<=9?"":"")+s2;              
        txtContG.setText(tiempo);               
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFin;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jpTer;
    private javax.swing.JTable jpTerminado;
    public static javax.swing.JTable jtBloqueados;
    public static javax.swing.JTable jtBloqueados1;
    public static javax.swing.JTable jtEjecucion;
    private javax.swing.JLabel jtProE16;
    private javax.swing.JLabel jtProE17;
    private javax.swing.JLabel jtProE18;
    private javax.swing.JLabel jtProE19;
    private javax.swing.JLabel jtProE20;
    private javax.swing.JLabel jtProE21;
    private javax.swing.JLabel jtProE22;
    private javax.swing.JLabel jtProE23;
    private javax.swing.JLabel jtProE24;
    private javax.swing.JLabel jtProE8;
    public static javax.swing.JTable jtProxListo;
    public static javax.swing.JTable jtProxMemSus;
    private javax.swing.JLabel lblMem1;
    private javax.swing.JLabel lblMem10;
    private javax.swing.JLabel lblMem11;
    private javax.swing.JLabel lblMem12;
    private javax.swing.JLabel lblMem13;
    private javax.swing.JLabel lblMem14;
    private javax.swing.JLabel lblMem15;
    private javax.swing.JLabel lblMem16;
    private javax.swing.JLabel lblMem17;
    private javax.swing.JLabel lblMem18;
    private javax.swing.JLabel lblMem19;
    private javax.swing.JLabel lblMem2;
    private javax.swing.JLabel lblMem20;
    private javax.swing.JLabel lblMem21;
    private javax.swing.JLabel lblMem22;
    private javax.swing.JLabel lblMem23;
    private javax.swing.JLabel lblMem24;
    private javax.swing.JLabel lblMem25;
    private javax.swing.JLabel lblMem26;
    private javax.swing.JLabel lblMem27;
    private javax.swing.JLabel lblMem28;
    private javax.swing.JLabel lblMem29;
    private javax.swing.JLabel lblMem3;
    private javax.swing.JLabel lblMem30;
    private javax.swing.JLabel lblMem31;
    private javax.swing.JLabel lblMem32;
    private javax.swing.JLabel lblMem33;
    private javax.swing.JLabel lblMem34;
    private javax.swing.JLabel lblMem35;
    private javax.swing.JLabel lblMem36;
    private javax.swing.JLabel lblMem37;
    private javax.swing.JLabel lblMem38;
    private javax.swing.JLabel lblMem39;
    private javax.swing.JLabel lblMem4;
    private javax.swing.JLabel lblMem40;
    private javax.swing.JLabel lblMem41;
    private javax.swing.JLabel lblMem42;
    private javax.swing.JLabel lblMem43;
    private javax.swing.JLabel lblMem44;
    private javax.swing.JLabel lblMem45;
    private javax.swing.JLabel lblMem46;
    private javax.swing.JLabel lblMem47;
    private javax.swing.JLabel lblMem48;
    private javax.swing.JLabel lblMem49;
    private javax.swing.JLabel lblMem5;
    private javax.swing.JLabel lblMem50;
    private javax.swing.JLabel lblMem6;
    private javax.swing.JLabel lblMem7;
    private javax.swing.JLabel lblMem8;
    private javax.swing.JLabel lblMem9;
    private javax.swing.JLabel lblNumPro;
    private javax.swing.JLabel lblNumPro1;
    private javax.swing.JLabel lblNumPro2;
    private javax.swing.JLabel lblPause;
    private javax.swing.JLabel lblProBloqueados;
    private javax.swing.JLabel lblProBloqueados1;
    private javax.swing.JLabel lblProLis;
    private javax.swing.JLabel lblProLis1;
    private javax.swing.JLabel lblProLis2;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo1;
    private javax.swing.JProgressBar pbar1;
    private javax.swing.JProgressBar pbar10;
    private javax.swing.JProgressBar pbar11;
    private javax.swing.JProgressBar pbar12;
    private javax.swing.JProgressBar pbar13;
    private javax.swing.JProgressBar pbar14;
    private javax.swing.JProgressBar pbar15;
    private javax.swing.JProgressBar pbar16;
    private javax.swing.JProgressBar pbar17;
    private javax.swing.JProgressBar pbar18;
    private javax.swing.JProgressBar pbar19;
    private javax.swing.JProgressBar pbar2;
    private javax.swing.JProgressBar pbar20;
    private javax.swing.JProgressBar pbar21;
    private javax.swing.JProgressBar pbar22;
    private javax.swing.JProgressBar pbar23;
    private javax.swing.JProgressBar pbar24;
    private javax.swing.JProgressBar pbar25;
    private javax.swing.JProgressBar pbar26;
    private javax.swing.JProgressBar pbar27;
    private javax.swing.JProgressBar pbar28;
    private javax.swing.JProgressBar pbar29;
    private javax.swing.JProgressBar pbar3;
    private javax.swing.JProgressBar pbar30;
    private javax.swing.JProgressBar pbar31;
    private javax.swing.JProgressBar pbar32;
    private javax.swing.JProgressBar pbar33;
    private javax.swing.JProgressBar pbar34;
    private javax.swing.JProgressBar pbar35;
    private javax.swing.JProgressBar pbar36;
    private javax.swing.JProgressBar pbar37;
    private javax.swing.JProgressBar pbar38;
    private javax.swing.JProgressBar pbar39;
    private javax.swing.JProgressBar pbar4;
    private javax.swing.JProgressBar pbar40;
    private javax.swing.JProgressBar pbar41;
    private javax.swing.JProgressBar pbar42;
    private javax.swing.JProgressBar pbar43;
    private javax.swing.JProgressBar pbar44;
    private javax.swing.JProgressBar pbar45;
    private javax.swing.JProgressBar pbar46;
    private javax.swing.JProgressBar pbar47;
    private javax.swing.JProgressBar pbar48;
    private javax.swing.JProgressBar pbar49;
    private javax.swing.JProgressBar pbar5;
    private javax.swing.JProgressBar pbar50;
    private javax.swing.JProgressBar pbar6;
    private javax.swing.JProgressBar pbar7;
    private javax.swing.JProgressBar pbar8;
    private javax.swing.JProgressBar pbar9;
    public static javax.swing.JTextField txtContG;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPOp;
    private javax.swing.JTextField txtPTME;
    private javax.swing.JTextField txtPTR;
    private javax.swing.JTextField txtPTT;
    private javax.swing.JTextField txtQuantum;
    private javax.swing.JTextField txtValQuantum;
    private javax.swing.JTextField txtnumLP;
    private javax.swing.JTextField txtnumProSus;
    // End of variables declaration//GEN-END:variables

   
}
