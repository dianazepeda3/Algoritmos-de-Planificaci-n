import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author diana
 */
public class CapturarDatos extends javax.swing.JFrame {

    int numPro;
    int cont = 0;
    int lote = 1;
    int aux = 0;

    public static Object[][] procesos = new Object[100][9];
    public static ArrayList<String> ids = new ArrayList();
    
    public CapturarDatos() {
        initComponents();        
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTittulo = new javax.swing.JLabel();
        txtnumPC = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOp2 = new javax.swing.JTextField();
        jbOp = new javax.swing.JComboBox<>();
        txtTME = new javax.swing.JTextField();
        txtOp1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtnumP1 = new javax.swing.JTextField();
        btnAcep = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTittulo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("SIMULADOR DE PROCESAMIENTO POR LOTES ");

        txtnumPC.setBackground(new java.awt.Color(234, 234, 234));
        txtnumPC.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Informacion del proceso");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(160, 0, 200, 40);

        txtNombre.setBackground(new java.awt.Color(234, 234, 234));
        txtNombre.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(130, 40, 310, 30);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Operación:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 90, 120, 30);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TME:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 140, 50, 30);

        txtOp2.setBackground(new java.awt.Color(234, 234, 234));
        txtOp2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtOp2.setEnabled(false);
        jPanel1.add(txtOp2);
        txtOp2.setBounds(330, 90, 110, 30);

        jbOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-", "*", "/", "%" }));
        jPanel1.add(jbOp);
        jbOp.setBounds(256, 90, 60, 30);

        txtTME.setBackground(new java.awt.Color(234, 234, 234));
        txtTME.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtTME.setEnabled(false);
        jPanel1.add(txtTME);
        txtTME.setBounds(130, 140, 100, 30);

        txtOp1.setBackground(new java.awt.Color(234, 234, 234));
        txtOp1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtOp1.setEnabled(false);
        jPanel1.add(txtOp1);
        txtOp1.setBounds(130, 90, 110, 30);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 140, 50, 30);

        txtID.setBackground(new java.awt.Color(234, 234, 234));
        txtID.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtID.setEnabled(false);
        jPanel1.add(txtID);
        txtID.setBounds(340, 140, 100, 30);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("seg");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(240, 140, 70, 30);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(40, 40, 120, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("No. Procesos:");

        txtnumP1.setBackground(new java.awt.Color(234, 234, 234));

        btnAcep.setText("Aceptar");
        btnAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcepActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Procesos Capturados:");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        lblTittulo3.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo3.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo3.setText("Autor: Diana Zepeda Tatengo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtnumP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAcep, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(txtnumPC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblTittulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumP1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumPC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTittulo3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcepActionPerformed
        if(txtnumP1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Introduce el numero de procesos");
        }else if(!isNumeric(txtnumP1.getText())){
            JOptionPane.showMessageDialog(null, "Solo debes ingresar numeros");
            txtnumP1.setText(null);
        }else{
            numPro = Integer.parseInt(txtnumP1.getText());
            txtnumPC.setText("0");
            txtnumP1.setEnabled(false);
            btnAcep.setEnabled(false);
            btnAgregar.setEnabled(true);
            txtNombre.setEnabled(true);
            txtOp1.setEnabled(true);
            txtOp2.setEnabled(true);
            txtTME.setEnabled(true);
            txtID.setEnabled(true);
        }
    }//GEN-LAST:event_btnAcepActionPerformed

    private static boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
}
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        boolean flag = false;
        if(txtNombre.getText().isEmpty() || txtOp1.getText().isEmpty() || txtOp2.getText().isEmpty() || txtTME.getText().isEmpty() || txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ningun campo puede quedar vacio");
        }else if(!isNumeric(txtOp1.getText()) || !isNumeric(txtOp2.getText()) || !isNumeric(txtTME.getText()) || !isNumeric(txtID.getText())){
            JOptionPane.showMessageDialog(null, "Debes ingresar solo numeros en la operacion, tiempo e ID");
        }else if(Integer.parseInt(txtTME.getText())<=0){
            JOptionPane.showMessageDialog(null, "El TME debe ser mayor a 0");
        }else if(jbOp.getSelectedIndex() == 3 && txtOp2.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
        }else{
            for(int i=0; i<ids.size(); i++){
                if(Integer.parseInt(ids.get(i)) == Integer.parseInt(txtID.getText())){
                    flag = true;                        
                } 
            }
            if(flag){
                JOptionPane.showMessageDialog(null, "ID repetido"); 
            }else{                               
                aux++;      
                procesos[cont][0] = txtNombre.getText();
                procesos[cont][1] = Integer.parseInt(txtOp1.getText());
                procesos[cont][2] = Integer.parseInt(txtOp2.getText());
                procesos[cont][3] = jbOp.getSelectedIndex();
                procesos[cont][4] = Integer.parseInt(txtTME.getText());
                procesos[cont][5] = Integer.parseInt(txtID.getText());
                procesos[cont][8] = 0;
                if(aux<=5){
                    procesos[cont][7] = lote;
                }
                if(aux == 5){
                    aux = 0;
                    lote++;
                }
                                
                ids.add(txtID.getText());
                cont++;
                txtnumPC.setText(String.valueOf(cont));
                txtNombre.setText(null);
                txtOp1.setText(null);
                txtOp2.setText(null);
                txtTME.setText(null);
                txtID.setText(null);        
                if(cont == numPro){
                    Simulacion ven=new Simulacion();
                    ven.setVisible(true);
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(CapturarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcep;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jbOp;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo3;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOp1;
    private javax.swing.JTextField txtOp2;
    private javax.swing.JTextField txtTME;
    public static javax.swing.JTextField txtnumP1;
    private javax.swing.JTextField txtnumPC;
    // End of variables declaration//GEN-END:variables
}
