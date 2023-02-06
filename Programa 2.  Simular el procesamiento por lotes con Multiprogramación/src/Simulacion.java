
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 * @author diana
 */
public class Simulacion extends javax.swing.JFrame{
    
    LinkedList cola=new LinkedList();
    Object[][] procesos = new Object[100][10];
    char tecla = 'A';
    int numPro, aux, aux2, a=0;
    int loteP = 1, pro = 0, i = 0;
    int tr = 0, tme, contador = 0;
    String operacion="", op="";
    Boolean sig = false, error = false, interrup = false, inte = false, auxx = false;
    public Simulacion() {
        initComponents();
        txtnumLP.getText();
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
        aux = numPro/5;        
        if(numPro%5!=0){
            aux++;
        }        
        aux--;
        txtnumLP.setText(String.valueOf(aux));
        procesos[pro][7]=1;
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == loteP && Integer.parseInt(String.valueOf(procesos[i][7])) == 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][8]});           
            }
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
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == loteP && Integer.parseInt(String.valueOf(procesos[i][7])) == 0 && Integer.parseInt(String.valueOf(procesos[i][8])) == 0){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][8]});           
            }
        }   
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == loteP && Integer.parseInt(String.valueOf(procesos[i][7])) == 0 && Integer.parseInt(String.valueOf(procesos[i][8])) != 0 && Integer.parseInt(String.valueOf(procesos[i][9])) == 1){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][8]});           
            }
        } 
    }
    
    public void pendientes2(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        //modelo.setNumRows(0);
         
        //for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][6])) == loteP && Integer.parseInt(String.valueOf(procesos[i][7])) == 0 && Integer.parseInt(String.valueOf(procesos[i][8])) != 0 && Integer.parseInt(String.valueOf(procesos[i][9])) == 3 ){
                modelo.addRow(new Object[]{procesos[i][0],procesos[i][5],procesos[i][8]});     
                procesos[i][9] = 1;
                modelo.removeRow(0);
            }
            
        //} 
    }
    
    public void primera(){
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();        
        
                modelo.removeRow(0);
            

    }
    
    public void terminados(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        if(Integer.parseInt(String.valueOf(procesos[i][7])) == 2 && Integer.parseInt(String.valueOf(procesos[i][6])) == loteP){
            operacion(pro);
            procesos[i][8] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],operacion, procesos[i][4],procesos[i][6]});                  
        }              
    }
    
    public void terminados2(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        if(Integer.parseInt(String.valueOf(procesos[i][7])) == 2 && Integer.parseInt(String.valueOf(procesos[i][6])) == loteP){
            operacion(i);
            procesos[i][8] = -1;
            modelo3.addRow(new Object[]{procesos[i][0],operacion, procesos[i][4],procesos[i][6]});                  
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
        jtEjecucion = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTittulo3 = new javax.swing.JLabel();

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
        lblTittulo.setText("SIMULADOR DE PROCESAMIENTO POR LOTES CON MULTIPROGRAMACIÓN  ");

        lblNumPro.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblNumPro.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPro.setText("No. Lotes pendientes:");

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
                "ID", "Ope", "Res", "No. Lote"
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
            jpTerminado.getColumnModel().getColumn(3).setPreferredWidth(60);
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
        jScrollPane3.setViewportView(jtEjecucion);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 40, 310, 110);

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lote en ejecución");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(100, 0, 120, 40);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 64, 86));

        lblTittulo3.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo3.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo3.setText("Autor: Diana Zepeda Tatengo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTittulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTittulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTittulo3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpTerminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpTerminadoKeyPressed
        //jLabel1.setText("El caracter pulsado: "+evt.getKeyChar());
    }//GEN-LAST:event_jpTerminadoKeyPressed

    private void jtEjecucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEjecucionKeyPressed
        if(evt.getKeyChar() == 'P'){
            t.stop();
            jLabel1.setText("PAUSE");
            tecla='P';
            System.out.println("Tecla P");
        }  
        if(evt.getKeyChar() == 'C'){
            t.start();
            jLabel1.setText(" ");
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
    private int s, cs, s2, cs2, aux5;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {                
            if(pro==numPro && a==0){
                t.stop();
                limpiarP();
            }else if(interrup && auxx == false){
                procesos[pro][8] = txtPTT.getText();
                procesos[pro][7] = 0;     
                procesos[pro][9] = 1;
                interrup = false;
                pro++;
                procesos[pro][7] = 1;
                aux5++;
                s=0;
                a++;
                pendientes();
                procesoAct();                                
            }else{  
                try{
                    if(Integer.parseInt(String.valueOf(procesos[pro][6]))==loteP && Integer.parseInt(String.valueOf(procesos[pro][9]))==0){
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
                            procesos[pro][7] = 2;  
                            try{
                            if(Integer.parseInt(String.valueOf(procesos[pro+1][6]))==loteP){
                                procesos[pro+1][7] = 1;                                        
                            }
                            }catch(Exception e){}
                            s=0;
                            terminados(pro);
                            pro++;
                            aux5++;
                            procesoAct(); 
                        }                                
                    }else{ 
                        if(!auxx){
                            primera();
                        }
                        auxx = true;
                        //System.out.println("pro "+i);
                        if(interrup){
                            procesos[i][8] = txtPTT.getText();
                            procesos[i][7] = 0;
                            procesos[i][9] = 3;
                            interrup = false; 
                            //pendientes();                            
                            pendientes2();
                            //primera();
                            i++;                           
                            if(Integer.parseInt(String.valueOf(procesos[i][9])) == 0){
                                i=0;
                            }
                            s=0;                            
                            procesoAct2();                                
                        }else if(Integer.parseInt(String.valueOf(procesos[i][6]))==loteP && Integer.parseInt(String.valueOf(procesos[i][8]))>0 && Integer.parseInt(String.valueOf(procesos[i][9]))==1){
                            if(Integer.parseInt(String.valueOf(procesos[i][7])) == 0){
                                procesos[i][7] = 1;
                                //pendientes();
                                //pendientes2();
                                procesoAct2();
                                tme = Integer.parseInt(String.valueOf(procesos[i][5]));
                                s = Integer.parseInt(String.valueOf(procesos[i][8]));
                                tr = tme - s;
                                }
                                ++cs2; 
                                if(cs2==100){
                                    cs2 = 0;
                                    ++s2;
                                }
                                if(s2==60){
                                    //s2 = 0;                    
                                }                
                                actualizarLabel2();

                                tr = tme - s;                
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
                                    procesos[i][7] = 2;   
                                    procesos[i][9] = 2;                                
                                    s=0;
                                    terminados2(i);                                    
                                    i++;
                                    //procesoAct2();
                                    a--;
                                    primera();
                                    if(a==0){
                                        pro=aux5;
                                        auxx = false;
                                        procesoAct();
                                    }else{
                                        i=0;
                                    }
                                } 
                        }else{
                            i++;
                        }                    
                        if(a==0){
                            loteP++;
                            aux--;
                            txtnumLP.setText(String.valueOf(aux));                            
                            pro=aux5;                            
                            auxx = false;
                            i=0;
                            //pro = aux5;
                            procesos[pro][7] = 1;
                            pendientes2();
                            procesoAct();
                            //System.out.println("pro "+pro);
                            primera();                            
                        }                    
                    }   
                }catch(ArrayIndexOutOfBoundsException e){
                    //loteP++;
                    //pendientes();
                    //System.out.println(e);
                    
                }catch(Exception e){
                    pro = 0;
                    
              //      System.out.println(e);
                }
            }
            //System.out.println(a);
            //System.out.println(loteP);
        }
        
    };
    
    private void actualizarLabel() {
        String tiempo = (s<=9?"":"")+s;              
        txtPTT.setText(tiempo);        
        txtPTR.setText(String.valueOf(tr));        
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jpTer;
    private javax.swing.JTable jpTerminado;
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
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo3;
    private javax.swing.JTextField txtContG;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPOp;
    private javax.swing.JTextField txtPTME;
    private javax.swing.JTextField txtPTR;
    private javax.swing.JTextField txtPTT;
    private javax.swing.JTextField txtnumLP;
    // End of variables declaration//GEN-END:variables

   
}
