
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 * @author diana
 */
public class Terminado extends javax.swing.JFrame {

    Object[][] procesos = new Object[100][19];
    public static boolean te;   
    String operacion="", op="";
    
    public Terminado() {
        initComponents();
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo   
        this.setTitle("ALGORITMO DE PLANIFICACIÓN FCFS CONTINUACIÓN");   
        te = Simulacion.te;       
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();
        procesos = Simulacion.procesos;
        txtContG.setText(Simulacion.txtContG.getText());
        int numPro = Simulacion.numPro2;        
        try{
            /*for(int i = 0; i<numPro; i++){                 
                    System.out.println(procesos[i][0]+" "+procesos[i][3]+" "+procesos[i][4]+" "+procesos[i][5]+" "+procesos[i][9]+" "+procesos[i][10]+" "+procesos[i][11]+" "+procesos[i][12]+" "+procesos[i][13]+" "+procesos[i][14]);                                             
            }*/
            modelo3.addRow(new Object[]{"------","TERMINADOS","-------------","---------","---------","----------","----------","----------","----------","----------","---------------","--------------"});              
            for(int i = 0; i<numPro; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 4){ 
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], procesos[i][4], procesos[i][5], procesos[i][9], procesos[i][10], procesos[i][11], procesos[i][12], procesos[i][13], procesos[i][14], 0, "N/A"});                  
                }            
            }
            modelo3.addRow(new Object[]{"------","BLOQUEADOS","-------------","---------","---------","----------","----------","----------","----------","----------","-------------","--------------"});        
            for(int i = 0; i<numPro; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 3){ 
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], "N/A", procesos[i][5], procesos[i][9], "N/A", procesos[i][11], procesos[i][12], procesos[i][13], procesos[i][14], procesos[i][18], 8-Integer.parseInt(String.valueOf(procesos[i][8]))});                  
                }            
            }
            modelo3.addRow(new Object[]{"------","-- EJECUCION --","-------------","---------","---------","----------","----------","----------","----------","----------","-------------","--------------"});        
            for(int i = 0; i<numPro; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 2){ 
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], "N/A", procesos[i][5], procesos[i][9], "N/A", procesos[i][11], procesos[i][12], procesos[i][13], procesos[i][14], procesos[i][18], "N/A"});                  
                }            
            }
            modelo3.addRow(new Object[]{"------","------ LISTOS ------","-------------","---------","---------","----------","----------","----------","----------","----------","-------------","--------------"});        
            for(int i = 0; i<numPro; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 1 && String.valueOf(procesos[i][12]).equals("-1")){ 
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], "N/A", procesos[i][5], procesos[i][9], "N/A", procesos[i][11], "N/A", procesos[i][13], procesos[i][7], procesos[i][18], "N/A"});                  
                }else if (Integer.parseInt(String.valueOf(procesos[i][6])) == 1){
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], "N/A", procesos[i][5], procesos[i][9], "N/A", procesos[i][11], procesos[i][12], procesos[i][13], procesos[i][7], procesos[i][18], "N/A"});                                  
                }            
            }
            modelo3.addRow(new Object[]{"------","----- NUEVOS -----","-------------","---------","---------","----------","----------","----------","----------","----------","-------------","--------------"});        
            for(int i = 0; i<numPro; i++){
                if(Integer.parseInt(String.valueOf(procesos[i][6])) == 0){ 
                    modelo3.addRow(new Object[]{procesos[i][0],procesos[i][3], "N/A", procesos[i][5], "N/A", "N/A", procesos[i][11], "N/A", procesos[i][13], procesos[i][7], procesos[i][18], "N/A"});                  
                }            
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTittulo = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jpTer = new javax.swing.JScrollPane();
        jpTerminado = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtContG = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTittulo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("ALGORITMO DE PLANIFICACIÓN FCFS");

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
                "ID", "Ope", "Res", "TME", "TLL", "TF", "TRet", "TRes", "TE", "TS", "TRestante", "TRes Bloq"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jpTerminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpTerminadoKeyPressed(evt);
            }
        });
        jpTer.setViewportView(jpTerminado);
        if (jpTerminado.getColumnModel().getColumnCount() > 0) {
            jpTerminado.getColumnModel().getColumn(0).setPreferredWidth(50);
            jpTerminado.getColumnModel().getColumn(1).setPreferredWidth(150);
            jpTerminado.getColumnModel().getColumn(2).setPreferredWidth(100);
            jpTerminado.getColumnModel().getColumn(3).setPreferredWidth(70);
            jpTerminado.getColumnModel().getColumn(4).setPreferredWidth(70);
            jpTerminado.getColumnModel().getColumn(5).setPreferredWidth(70);
            jpTerminado.getColumnModel().getColumn(6).setPreferredWidth(70);
            jpTerminado.getColumnModel().getColumn(7).setPreferredWidth(70);
            jpTerminado.getColumnModel().getColumn(8).setPreferredWidth(60);
            jpTerminado.getColumnModel().getColumn(9).setPreferredWidth(60);
            jpTerminado.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        jPanel12.add(jpTer);
        jpTer.setBounds(20, 40, 860, 290);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Procesos terminados");
        jPanel12.add(jLabel13);
        jLabel13.setBounds(400, 0, 153, 40);

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));

        txtContG.setBackground(new java.awt.Color(234, 234, 234));
        txtContG.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtContG.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contador global:");

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));

        lblTittulo3.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo3.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo3.setText("Autor: Diana Zepeda Tatengo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTittulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(lblTittulo)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel17)
                        .addGap(7, 7, 7)
                        .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(390, 390, 390)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTittulo3))
                    .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpTerminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpTerminadoKeyPressed
        if(evt.getKeyChar() == 'C'){                 
            System.out.println("Tecla C");
            Terminado ven=new Terminado();
            ven.setVisible(false);
            dispose();
        } 
    }//GEN-LAST:event_jpTerminadoKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Terminado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jpTer;
    private javax.swing.JTable jpTerminado;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo3;
    public static javax.swing.JTextField txtContG;
    // End of variables declaration//GEN-END:variables
}
