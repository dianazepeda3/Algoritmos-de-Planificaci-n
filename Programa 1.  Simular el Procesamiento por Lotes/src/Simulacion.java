import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 * @author diana
 */
public class Simulacion extends javax.swing.JFrame {
    ArrayList<String> ids = new ArrayList();
    Object[][] procesos = new Object[100][8];
    int numPro, aux, aux2;
    int loteP = 1, pro = 0;
    int tr = 0, tme, contador = 0;
    String operacion="", op="";
    Boolean sig = false;
    public Simulacion() {
        initComponents();
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo
        inicio();
        setLocationRelativeTo(null);
        t = new Timer(10, acciones);                
    }
    
    public void inicio(){
        ids = CapturarDatos.ids;
        procesos = CapturarDatos.procesos;
        numPro = Integer.parseInt(CapturarDatos.txtnumP1.getText());
        DefaultTableModel modelo = (DefaultTableModel) jtEjecucion.getModel();
        aux = numPro/5;        
        if(numPro%5!=0){
            aux++;
        }        
        aux--;
        txtnumLP.setText(String.valueOf(aux));
        procesos[pro][8]=1;
        for(int i = 0; i<numPro; i++){
            if(Integer.parseInt(String.valueOf(procesos[i][7])) == loteP && Integer.parseInt(String.valueOf(procesos[i][8])) == 0){
                modelo.addRow(new Object[]{procesos[i][5],procesos[i][4]});           
            }
        }   
        procesoAct();            
    }    
    
    public void procesoAct(){
            if(pro!=numPro){
            txtPNombre.setText(String.valueOf(procesos[pro][0]));
            txtPID.setText(String.valueOf(procesos[pro][5]));                     
            operacion(pro);
            txtPOp.setText(String.valueOf(operacion));
            txtPTME.setText(String.valueOf(procesos[pro][4]));                    
            tr = Integer.parseInt(String.valueOf(procesos[pro][4]));
            txtPTT.setText("0");
            txtPTR.setText(String.valueOf(tr));      
        }  
    }    
    
    public void operacion(int pro){
        if(String.valueOf(procesos[pro][3]).equals("0")){
            op = " + ";
            procesos[pro][6] = Integer.parseInt(String.valueOf(procesos[pro][1])) + Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("1")){
            op = " - ";
            procesos[pro][6] = Integer.parseInt(String.valueOf(procesos[pro][1])) - Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("2")){
            op = " * ";
            procesos[pro][6] = Integer.parseInt(String.valueOf(procesos[pro][1])) * Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("3")){
            op = " / ";
            procesos[pro][6] = Integer.parseInt(String.valueOf(procesos[pro][1])) / Integer.parseInt(String.valueOf(procesos[pro][2]));
        }else if(String.valueOf(procesos[pro][3]).equals("4")){
            op = " % ";
            procesos[pro][6] = Integer.parseInt(String.valueOf(procesos[pro][1])) % Integer.parseInt(String.valueOf(procesos[pro][2]));
        }
        operacion = String.valueOf(procesos[pro][1]+op+procesos[pro][2]);
    }
    
    public void limpiarP(){
        txtPNombre.setText(null);
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
            if(Integer.parseInt(String.valueOf(procesos[i][7])) == loteP && Integer.parseInt(String.valueOf(procesos[i][8])) == 0){
                modelo.addRow(new Object[]{procesos[i][5],procesos[i][4]});           
            }
        }   
    }
    
    public void terminados(int i){
        DefaultTableModel modelo3 = (DefaultTableModel) jpTerminado.getModel();        
        while(i<numPro){
            if(Integer.parseInt(String.valueOf(procesos[i][8])) == 2 && Integer.parseInt(String.valueOf(procesos[i][7])) == loteP){
                operacion(pro);
                modelo3.addRow(new Object[]{procesos[i][5],operacion, procesos[i][6],procesos[i][7]});                  
            }              
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOp2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtTME = new javax.swing.JTextField();
        txtOp1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtnumLP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtContG = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtEjecucion = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTittulo = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jpTer = new javax.swing.JScrollPane();
        jpTerminado = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jtProE = new javax.swing.JLabel();
        jtProE9 = new javax.swing.JLabel();
        jtProE10 = new javax.swing.JLabel();
        jtProE11 = new javax.swing.JLabel();
        jtProE12 = new javax.swing.JLabel();
        jtProE13 = new javax.swing.JLabel();
        jtProE14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtProE8 = new javax.swing.JLabel();
        jtProE16 = new javax.swing.JLabel();
        jtProE17 = new javax.swing.JLabel();
        jtProE18 = new javax.swing.JLabel();
        jtProE19 = new javax.swing.JLabel();
        jtProE20 = new javax.swing.JLabel();
        jtProE21 = new javax.swing.JLabel();
        txtPOp = new javax.swing.JTextField();
        txtPNombre = new javax.swing.JTextField();
        txtPTR = new javax.swing.JTextField();
        txtPID = new javax.swing.JTextField();
        txtPTME = new javax.swing.JTextField();
        txtPTT = new javax.swing.JTextField();
        jtProE22 = new javax.swing.JLabel();
        jtProE23 = new javax.swing.JLabel();
        jtProE24 = new javax.swing.JLabel();
        lblTittulo3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 40, 120, 30);

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-", "*", "/", "%" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(256, 90, 60, 30);

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

        jTextField2.setBackground(new java.awt.Color(234, 234, 234));
        jTextField2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jTextField2.setEnabled(false);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(340, 140, 100, 30);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("seg");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(240, 140, 70, 30);

        jPanel3.setBackground(new java.awt.Color(58, 58, 58));
        jPanel3.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(58, 58, 58));
        jPanel11.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtnumLP.setBackground(new java.awt.Color(234, 234, 234));
        txtnumLP.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("No. Lotes pendientes:");

        txtContG.setBackground(new java.awt.Color(234, 234, 234));
        txtContG.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(58, 58, 58));
        jPanel2.setLayout(null);

        jtEjecucion.setBackground(new java.awt.Color(204, 204, 204));
        jtEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TME"
            }
        ));
        jScrollPane3.setViewportView(jtEjecucion);
        if (jtEjecucion.getColumnModel().getColumnCount() > 0) {
            jtEjecucion.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtEjecucion.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 40, 310, 110);

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lote en ejecución");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(100, 0, 120, 40);

        jPanel4.setBackground(new java.awt.Color(58, 58, 58));
        jPanel4.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(58, 58, 58));
        jPanel5.setLayout(null);
        jPanel4.add(jPanel5);
        jPanel5.setBounds(20, 90, 160, 350);

        jPanel6.setBackground(new java.awt.Color(58, 58, 58));
        jPanel6.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(58, 58, 58));
        jPanel7.setLayout(null);
        jPanel6.add(jPanel7);
        jPanel7.setBounds(20, 90, 160, 350);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(190, 90, 310, 0);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("SIMULADOR DE PROCESAMIENTO POR LOTES ");

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
        jpTer.setViewportView(jpTerminado);
        if (jpTerminado.getColumnModel().getColumnCount() > 0) {
            jpTerminado.getColumnModel().getColumn(0).setPreferredWidth(20);
            jpTerminado.getColumnModel().getColumn(1).setPreferredWidth(40);
            jpTerminado.getColumnModel().getColumn(2).setPreferredWidth(20);
            jpTerminado.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel12.add(jpTer);
        jpTer.setBounds(10, 46, 250, 290);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Procesos terminados");
        jPanel12.add(jLabel13);
        jLabel13.setBounds(63, 0, 153, 40);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contador global:");

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(58, 58, 58));
        jPanel8.setLayout(null);

        jtProE.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE.setForeground(new java.awt.Color(255, 255, 255));
        jtProE.setText("Operación");
        jPanel8.add(jtProE);
        jtProE.setBounds(20, 100, 70, 40);

        jtProE9.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jtProE9.setForeground(new java.awt.Color(255, 255, 255));
        jtProE9.setText("Proceso en ejecución");
        jPanel8.add(jtProE9);
        jtProE9.setBounds(80, 0, 150, 40);

        jtProE10.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE10.setForeground(new java.awt.Color(255, 255, 255));
        jtProE10.setText("Nombre:");
        jPanel8.add(jtProE10);
        jtProE10.setBounds(20, 40, 70, 40);

        jtProE11.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE11.setForeground(new java.awt.Color(255, 255, 255));
        jtProE11.setText("ID:");
        jPanel8.add(jtProE11);
        jtProE11.setBounds(20, 70, 70, 40);

        jtProE12.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE12.setForeground(new java.awt.Color(255, 255, 255));
        jtProE12.setText("TT");
        jPanel8.add(jtProE12);
        jtProE12.setBounds(240, 80, 70, 40);

        jtProE13.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE13.setForeground(new java.awt.Color(255, 255, 255));
        jtProE13.setText("TME");
        jPanel8.add(jtProE13);
        jtProE13.setBounds(170, 110, 70, 40);

        jtProE14.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE14.setForeground(new java.awt.Color(255, 255, 255));
        jtProE14.setText("TR");
        jPanel8.add(jtProE14);
        jtProE14.setBounds(200, 100, 70, 40);

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

        jtProE17.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE17.setForeground(new java.awt.Color(255, 255, 255));
        jtProE17.setText("Nombre:");
        jPanel9.add(jtProE17);
        jtProE17.setBounds(20, 30, 70, 50);

        jtProE18.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE18.setForeground(new java.awt.Color(255, 255, 255));
        jtProE18.setText("seg");
        jPanel9.add(jtProE18);
        jtProE18.setBounds(290, 120, 30, 40);

        jtProE19.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE19.setForeground(new java.awt.Color(255, 255, 255));
        jtProE19.setText("Operacion:");
        jPanel9.add(jtProE19);
        jtProE19.setBounds(20, 60, 70, 40);

        jtProE20.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE20.setForeground(new java.awt.Color(255, 255, 255));
        jtProE20.setText("TME:");
        jPanel9.add(jtProE20);
        jtProE20.setBounds(20, 120, 40, 40);

        jtProE21.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE21.setForeground(new java.awt.Color(255, 255, 255));
        jtProE21.setText("TT:");
        jPanel9.add(jtProE21);
        jtProE21.setBounds(180, 90, 30, 40);

        txtPOp.setBackground(new java.awt.Color(234, 234, 234));
        txtPOp.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPOp.setEnabled(false);
        jPanel9.add(txtPOp);
        txtPOp.setBounds(100, 70, 200, 25);

        txtPNombre.setBackground(new java.awt.Color(234, 234, 234));
        txtPNombre.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPNombre.setEnabled(false);
        jPanel9.add(txtPNombre);
        txtPNombre.setBounds(100, 40, 200, 25);

        txtPTR.setBackground(new java.awt.Color(234, 234, 234));
        txtPTR.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTR.setEnabled(false);
        jPanel9.add(txtPTR);
        txtPTR.setBounds(210, 130, 70, 25);

        txtPID.setBackground(new java.awt.Color(234, 234, 234));
        txtPID.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPID.setEnabled(false);
        jPanel9.add(txtPID);
        txtPID.setBounds(60, 100, 70, 25);

        txtPTME.setBackground(new java.awt.Color(234, 234, 234));
        txtPTME.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTME.setEnabled(false);
        jPanel9.add(txtPTME);
        txtPTME.setBounds(60, 130, 70, 25);

        txtPTT.setBackground(new java.awt.Color(234, 234, 234));
        txtPTT.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPTT.setEnabled(false);
        jPanel9.add(txtPTT);
        txtPTT.setBounds(210, 100, 70, 25);

        jtProE22.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE22.setForeground(new java.awt.Color(255, 255, 255));
        jtProE22.setText("ID:");
        jPanel9.add(jtProE22);
        jtProE22.setBounds(30, 90, 30, 40);

        jtProE23.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE23.setForeground(new java.awt.Color(255, 255, 255));
        jtProE23.setText("seg");
        jPanel9.add(jtProE23);
        jtProE23.setBounds(140, 120, 30, 40);

        jtProE24.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jtProE24.setForeground(new java.awt.Color(255, 255, 255));
        jtProE24.setText("seg");
        jPanel9.add(jtProE24);
        jtProE24.setBounds(290, 90, 30, 40);

        lblTittulo3.setFont(new java.awt.Font("Microsoft YaHei", 2, 14)); // NOI18N
        lblTittulo3.setForeground(new java.awt.Color(255, 204, 0));
        lblTittulo3.setText("Autor: Diana Zepeda Tatengo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTittulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnumLP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(lblTittulo3))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        t.start();
    }//GEN-LAST:event_formWindowOpened

    private Timer t;
    private int s, cs, s2, cs2;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {                         
            if(pro==numPro){
                t.stop();
                limpiarP();
            }else{
                ++cs2; 
                if(cs2==100){
                    cs2 = 0;
                    ++s2;
                }
                if(s2==60){
                    s2 = 0;                    
                }                
                actualizarLabel2();
                tme = Integer.parseInt(String.valueOf(procesos[pro][4]));
                pendientes();
                if(Integer.parseInt(String.valueOf(procesos[pro][7]))==loteP){
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
                        procesos[pro][8] = 2;
                        procesos[pro+1][8] = 1;                                        
                        s=0;
                        terminados(pro);
                        pro++;
                        procesoAct(); 
                    }
                }else{
                    loteP++;
                    aux--;
                    txtnumLP.setText(String.valueOf(aux));
                    pendientes();
                }            
            }
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane jpTer;
    private javax.swing.JTable jpTerminado;
    public static javax.swing.JTable jtEjecucion;
    private javax.swing.JLabel jtProE;
    private javax.swing.JLabel jtProE10;
    private javax.swing.JLabel jtProE11;
    private javax.swing.JLabel jtProE12;
    private javax.swing.JLabel jtProE13;
    private javax.swing.JLabel jtProE14;
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
    private javax.swing.JLabel jtProE9;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo3;
    private javax.swing.JTextField txtContG;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOp1;
    private javax.swing.JTextField txtOp2;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtPOp;
    private javax.swing.JTextField txtPTME;
    private javax.swing.JTextField txtPTR;
    private javax.swing.JTextField txtPTT;
    private javax.swing.JTextField txtTME;
    private javax.swing.JTextField txtnumLP;
    // End of variables declaration//GEN-END:variables
}
