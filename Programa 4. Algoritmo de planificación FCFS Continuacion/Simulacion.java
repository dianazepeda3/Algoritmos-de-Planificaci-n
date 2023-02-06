
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 * @author diana
 */
public class Simulacion extends javax.swing.JFrame{
    
    //LinkedList cola=new LinkedList();
    Object[][] procesos = new Object[100][17];
    Queue<Integer> cola=new LinkedList();
    Queue<Integer> cola2=new LinkedList();
    ArrayList<Integer> lista = new ArrayList<Integer>();
    char tecla = 'A';
    int numPro, aux, aux2, a=0, cont = 0;
    int loteP = 1, pro = 0, i = 0;
    int tr = 0, tme, contador = 0;
    String operacion="", op="";
    Boolean sig = false, error = false, interrup = false, inte = false, auxx = false;
    public Simulacion() {
        initComponents();
        this.setTitle("ALGORITMO DE PLANIFICACIÓN FCFS");
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo
        //addKeyListener(this);
        inicio();
        setLocationRelativeTo(null);
        t = new Timer(10, acciones); 
        t.start();        
    }

    public void inicio(){
        procesos = CapturarProcesos.procesos;
        numPro = Integer.parseInt(CapturarProcesos.txtnumP1.getText());
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();   
        aux = numPro;
        aux = aux -5;
        txtnumLP.setText(String.valueOf(aux));  
        procesos[0][6] = 2;
        cont++;
        cola.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        //cola2.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        lista.add(Integer.parseInt(String.valueOf(procesos[0][0])));
        for(int i = 1 ; i<5 ; i++){
            cola.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            //cola2.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            lista.add(Integer.parseInt(String.valueOf(procesos[i][0])));
            modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7]});
            procesos[i][6] = 1;
            cont++;
        }          
        procesoAct();            
    }    
    
    public void procesoAct(){
        if(pro<numPro){
            txtPID.setText(String.valueOf(procesos[pro][0]));                     
            operacion(pro);
            txtPOp.setText(String.valueOf(operacion));
            txtPTME.setText(String.valueOf(procesos[pro][5]));                    
            tr = Integer.parseInt(String.valueOf(procesos[pro][5]));
            txtPTT.setText("0");
            txtPTR.setText(String.valueOf(tr));              
        }  
    }  
    
    public void procesoAct2(){
        if(i!=numPro){
            txtPID.setText(String.valueOf(procesos[i][0]));                     
            operacion(i);
            txtPOp.setText(String.valueOf(operacion));
            txtPTME.setText(String.valueOf(procesos[i][5]));                    
            tr = Integer.parseInt(String.valueOf(procesos[i][5]));
            txtPTT.setText("0");
            txtPTR.setText(String.valueOf(tr));      
        }  
    }
    
    public void operacion(int pro){
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
    }
    
    public void pendientes(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        modelo.setNumRows(0);  
        int auxiliar;        
        for(int i = 0; i<lista.size(); i++){            
            if(Integer.parseInt(String.valueOf(procesos[lista.get(i)-1][6])) == 1){
                modelo.addRow(new Object[]{procesos[lista.get(i)-1][0],procesos[lista.get(i)-1][5],procesos[lista.get(i)-1][7]});           
            }            
        }                  
        
        
    }
    
    public void pendientess(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        modelo.setNumRows(0);        
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 && Integer.parseInt(String.valueOf(procesos[i][15])) == 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7]});           
            }            
        }                  
        
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 && Integer.parseInt(String.valueOf(procesos[i][15])) != 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7]});           
            }            
        } 
    }
    
    public void pendientes2(int i){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        //modelo.setNumRows(0);
         
        //for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][7]});     
                //procesos[i][15] = 1;
                //modelo.removeRow(0);
            }
            
        //} 
    }
    
    public void bloqueados(){
        DefaultTableModel modelo = (DefaultTableModel) jtBloqueados.getModel();        
        //modelo.setNumRows(0);
        //for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[pro][6])) == 3){
                modelo.addRow(new Object[]{procesos[pro][0],procesos[pro][8]});           
            }
        //}           
    }
    
    public void bloqueados2(){
        DefaultTableModel modelo = (DefaultTableModel) jtBloqueados.getModel();        
        modelo.setNumRows(0);
        for(int i = 0; i<numPro; i++){
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
            operacion(pro);
            procesos[i][7] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],operacion, procesos[i][4]});                  
        }              
    }
    
    public void terminados2(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        if(Integer.parseInt(String.valueOf(procesos[i][6])) == 4){
            operacion(i);
            procesos[i][7] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],operacion, procesos[i][4]});                  
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
        jLabel19 = new javax.swing.JLabel();
        txtnumLP = new javax.swing.JTextField();
        lblTittulo = new javax.swing.JLabel();
        lblNumPro = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jpTer = new javax.swing.JScrollPane();
        jpTerminado = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtContG = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtBloqueados = new javax.swing.JTable();
        lblProBloqueados = new javax.swing.JLabel();
        lblPause = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEjecucion = new javax.swing.JTable();
        lblProLis = new javax.swing.JLabel();

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
        jtProE16.setText("Proceso en ejecución");
        jPanel9.add(jtProE16);
        jtProE16.setBounds(90, 0, 160, 40);

        jtProE18.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE18.setForeground(new java.awt.Color(255, 255, 255));
        jtProE18.setText("seg");
        jPanel9.add(jtProE18);
        jtProE18.setBounds(290, 120, 30, 40);

        jtProE19.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
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
        txtPOp.setBounds(100, 50, 200, 25);

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

        jtProE22.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
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

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        txtnumLP.setBackground(new java.awt.Color(234, 234, 234));
        txtnumLP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtnumLP.setEnabled(false);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("ALGORITMO DE PLANIFICACIÓN FCFS");

        lblNumPro.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblNumPro.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPro.setText("No. Procesos nuevos:");

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
        jpTer.setBounds(10, 46, 280, 290);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Procesos terminados");
        jPanel12.add(jLabel13);
        jLabel13.setBounds(63, 0, 153, 40);

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

        lblProBloqueados.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblProBloqueados.setForeground(new java.awt.Color(255, 255, 255));
        lblProBloqueados.setText("Procesos Bloqueados");
        jPanel2.add(lblProBloqueados);
        lblProBloqueados.setBounds(70, 0, 150, 40);

        lblPause.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        lblPause.setForeground(new java.awt.Color(236, 64, 86));

        jPanel3.setBackground(new java.awt.Color(58, 58, 58));
        jPanel3.setLayout(null);

        jtEjecucion.setBackground(new java.awt.Color(204, 204, 204));
        jtEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TME", "TT"
            }
        ));
        jtEjecucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEjecucionKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jtEjecucion);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(10, 40, 270, 110);

        lblProLis.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblProLis.setForeground(new java.awt.Color(255, 255, 255));
        lblProLis.setText("Procesos listos");
        jPanel3.add(lblProLis);
        lblProLis.setBounds(100, 0, 120, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(lblTittulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addComponent(lblPause, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(640, 640, 640)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPause, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpTerminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpTerminadoKeyPressed
        //jLabel1.setText("El caracter pulsado: "+evt.getKeyChar());
    }//GEN-LAST:event_jpTerminadoKeyPressed

    private void jtEjecucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEjecucionKeyPressed
        if(evt.getKeyChar() == 'P'){
            t.stop();
            lblPause.setText("PAUSE");
            tecla='P';
            System.out.println("Tecla P");
        }  
        if(evt.getKeyChar() == 'C'){
            t.start();
            lblPause.setText(" ");
            tecla='C';
            System.out.println("Tecla C");
        } 
        if(evt.getKeyChar() == 'E'){
            if(tecla != 'P'){
                error = true;
                s=tme;          
            }
            System.out.println("Tecla E");
        }
        if(evt.getKeyChar() == 'I'){
            if(tecla != 'P'){
                interrup = true;
                inte = true;
            }
            System.out.println("Tecla I");
        }
    }//GEN-LAST:event_jtEjecucionKeyPressed
    
    private Timer t;
    private int s, cs, s2, cs2, cs3,s3, aux5;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {             
            for(int i = 0; i<lista.size(); i++){            
                System.out.println("lista: "+lista.get(i));
            }   
            System.out.println("");
        
         ///////////////////////////////////////////////////LISTA.SIZE
            for(int e=0; e<numPro; e++){                                
                if(Integer.parseInt(String.valueOf(procesos[e][6])) == 3){                    
                    if(Integer.parseInt(String.valueOf(procesos[e][8]))<=8){
                        s3 = Integer.parseInt(String.valueOf(procesos[e][8]));
                        cs3 = Integer.parseInt(String.valueOf(procesos[e][16]));
                        System.out.println(s3);
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
                        //cola2.add(Integer.parseInt(String.valueOf(procesos[e][0])));
                        lista.add(Integer.parseInt(String.valueOf(procesos[e][0])));
                        //pendientes();
                        System.out.println("hola");
                        pendientes();
                        bloqueados2();
                    }                    
                }
            }
            if(pro==numPro && a==0){
                t.stop();
                limpiarP();
            }else if(interrup){
                procesos[pro][7] = txtPTT.getText();
                procesos[pro][6] = 3;     
                procesos[pro][15] = 1;
                interrup = false;
                //cola2.remove();
                lista.remove(0);
                bloqueados();
                pro++;
                aux5++;
                s=0;
                a++;
                procesos[pro][6] = 2;
                pendientes();
                procesoAct();                 
            }else{  
                try{                    
                    if(Integer.parseInt(String.valueOf(procesos[pro][6]))==2){
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

                        tme = Integer.parseInt(String.valueOf(procesos[pro][5]));                                
                        if(s<=tme){                        
                            ++cs; 
                            if(cs==100){
                                cs = 0;
                                ++s;
                                tr=tr-1;
                            }
                            if(s==60){
                               s = 0;              
                            }                
                            actualizarLabel();                             
                        }else{
                            procesos[pro][6] = 4;                                
                            cola.remove();
                            //cola2.remove();
                            lista.remove(0);
                            try{
                            if(Integer.parseInt(String.valueOf(procesos[pro+1][6]))==1){
                                procesos[pro+1][6] = 2;                                
                            }
                            }catch(Exception e){}
                            s=0;
                            terminados(pro);
                            pro++;
                            aux5++;
                            procesoAct(); 
                        }                                
                    }                                         
                }catch(ArrayIndexOutOfBoundsException e){
                    
                }catch(Exception e){
                    pro = 0;
               
                }
            }
            try{
                if(cola.size()<5){                
                    cola.add(Integer.parseInt(String.valueOf(procesos[cont][0])));
                    lista.add(Integer.parseInt(String.valueOf(procesos[cont][0])));
                    procesos[cont][6] = 1;
                    txtnumLP.setText(String.valueOf(Integer.parseInt(txtnumLP.getText())-1));
                    cont++;
                }
            }catch(Exception e){}
        }
        
    };
    
    private void actualizarLabel() {
        String tiempo = (s<=9?"":"")+s;              
        txtPTT.setText(tiempo);        
        txtPTR.setText(String.valueOf(tr));   
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jpTer;
    private javax.swing.JTable jpTerminado;
    public static javax.swing.JTable jtBloqueados;
    public static javax.swing.JTable jtEjecucion;
    private javax.swing.JLabel jtProE16;
    private javax.swing.JLabel jtProE18;
    private javax.swing.JLabel jtProE19;
    private javax.swing.JLabel jtProE20;
    private javax.swing.JLabel jtProE21;
    private javax.swing.JLabel jtProE22;
    private javax.swing.JLabel jtProE23;
    private javax.swing.JLabel jtProE24;
    private javax.swing.JLabel jtProE8;
    private javax.swing.JLabel lblNumPro;
    private javax.swing.JLabel lblPause;
    private javax.swing.JLabel lblProBloqueados;
    private javax.swing.JLabel lblProLis;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JTextField txtContG;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPOp;
    private javax.swing.JTextField txtPTME;
    private javax.swing.JTextField txtPTR;
    private javax.swing.JTextField txtPTT;
    private javax.swing.JTextField txtnumLP;
    // End of variables declaration//GEN-END:variables

   
}
