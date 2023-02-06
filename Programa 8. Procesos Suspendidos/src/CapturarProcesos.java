
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author diana
 */
public class CapturarProcesos extends javax.swing.JFrame {

    int numPro, id = 1;
    int cont = 0;
    int lote = 1;
    int aux = 0;

    public static Object[][] procesos = new Object[100][20];
    public static ArrayList<String> ids = new ArrayList();
    Random aleatorio = new Random(System.currentTimeMillis());
    
    /*
    procesos[cont][0] --> ID
    procesos[cont][1] --> Num1
    procesos[cont][2] --> Num2
    procesos[cont][3] --> Operacion
    procesos[cont][4] --> Resultado
    procesos[cont][5] --> TME 
    procesos[cont][6] --> Estado 
                           - 0 nuevo
                           - 1 listo
                           - 2 ejecución
                           - 3 bloqueado
                           - 4 terminado
                           - 5 suspendido
    procesos[cont][7] --> TT 
    procesos[cont][8] --> TT en bloqueado
    procesos[cont][9] --> Tiempo de Llegada
    procesos[cont][10] --> Tiempo de Finalización
    procesos[cont][11] --> Tiempo de Retorno
    procesos[cont][12] --> Tiempo de Respuesta
    procesos[cont][13] --> Tiempo de Espera
    procesos[cont][14] --> Tiempo de Servicio
    
    procesos[cont][15] --> Interrumpida 
                            - 0 No
                            - 1 Si
                            - 2 Si y terminada
    procesos[cont][16] --> aux -- milisegundos    
    procesos[cont][17] --> aux -- contador
    procesos[cont][18] --> Tiempo Restante
    procesos[cont][19] --> Tamaño
    */
    
    public CapturarProcesos() {
        initComponents();
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo   
        this.setTitle("PROCESOS SUSPENDIDOS");
    }

    public void GenerarInformacion(int num){    
        for(int i =0; i<100; i++){            
            procesos[i][6] = 0;
            procesos[i][7] = 0;
            procesos[i][8] = 0;
            procesos[i][9] = 0;
            procesos[i][10] = 0;
            procesos[i][11] = 0;
            procesos[i][12] = -1;
            procesos[i][13] = 0;
            procesos[i][14] = 0;
            procesos[i][15] = 0;
            procesos[i][16] = 0;
            procesos[i][17] = 0;
        }
        for(int i =0; i<num; i++){
            aux++;
            procesos[i][0] = id;
            procesos[i][1] = (int)(Math.random()*(1000+1));
            procesos[i][2] = (int)(Math.random()*(1000+1));
            procesos[i][3] = (int)(Math.random()*(4+0));
            procesos[i][5] = (int)(Math.random()*(10+0)+6);
            procesos[i][18] = procesos[i][5];
            procesos[i][19] = (int)(Math.random()*(21+0)+5);
            
            id++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnumP1 = new javax.swing.JTextField();
        btnAcep = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblTittulo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQuantum = new javax.swing.JTextField();
        lblTittulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtnumP1.setBackground(new java.awt.Color(234, 234, 234));

        btnAcep.setText("Aceptar");
        btnAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcepActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("PROCESOS SUSPENDIDOS");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 255));
        jLabel11.setText("Ingrese los siguientes datos");

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantum:");

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("No. Procesos:");

        txtQuantum.setBackground(new java.awt.Color(234, 234, 234));

        lblTittulo1.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo1.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo1.setText("Autor: Diana Zepeda Tatengo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnAcep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnumP1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(lblTittulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAcep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtnumP1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    
    
    private void btnAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcepActionPerformed
        if(txtnumP1.getText().isEmpty() || txtQuantum.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ningún dato puede quedar vacío");
        }else if(!isNumeric(txtnumP1.getText()) || !isNumeric(txtQuantum.getText())){
            JOptionPane.showMessageDialog(null, "Solo debes ingresar numeros");
            txtnumP1.setText(null);
            txtQuantum.setText(null);
        }else{
            numPro = Integer.parseInt(txtnumP1.getText());
            GenerarInformacion(numPro);
            Simulacion ven=new Simulacion();
            ven.setVisible(true);
            dispose(); 
            
        }
    }//GEN-LAST:event_btnAcepActionPerformed

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
            java.util.logging.Logger.getLogger(CapturarProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturarProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturarProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturarProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturarProcesos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcep;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo1;
    public static javax.swing.JTextField txtQuantum;
    public static javax.swing.JTextField txtnumP1;
    // End of variables declaration//GEN-END:variables
}
