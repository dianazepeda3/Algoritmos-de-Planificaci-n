
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 * @author diana
 */
public class Interfaz extends javax.swing.JFrame {

    ImageIcon icon;
    JLabel moto = new JLabel();
    ProductorCosumidor productor;
    ProductorCosumidor consumidor;
    ArrayList<Boolean> lista = new ArrayList<Boolean>();
    int total = 0;
    
    public Interfaz() {
        initComponents();
        setTitle("PRODUCTOR-CONSUMIDOR");
        
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fondo 
        
        productor = new ProductorCosumidor();
        consumidor = new ProductorCosumidor();
        productor.setTipo(false);
        productor.setTes((int)(Math.random()*(11-5))+5);
        productor.setElementos((int)(Math.random()*(6-2))+2);
        productor.setElementosRes(productor.getElementos());
        productor.setUltElemento(0);
        consumidor.setTipo(false);        
        consumidor.setTes((int)(Math.random()*(11-5))+5);
        consumidor.setElementos((int)(Math.random()*(6-2))+2);
        consumidor.setElementosRes(consumidor.getElementos());
        consumidor.setUltElemento(0);
        
        lblTdorPro.setText("Tiempo: "+productor.getTes());
        lblElePro.setText("Elementos: "+productor.getElementos());
        lblTdorCon.setText("Timepo: "+consumidor.getTes());
        lblEleCon.setText("Elementos: "+consumidor.getElementos());
       
        for(int i=0; i<20; i++){
            lista.add(false);
        }
        tickets();        
        t = new Timer(10, acciones);         
        t.start();
    }
    
    public void tickets(){  
        icon = new ImageIcon(getClass().getResource("ticket.png"));              
        if(lista.get(0)){ticket1.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket1.getWidth(), ticket1.getHeight(), WIDTH)));
        }else{ticket1.setIcon(null);}
        if(lista.get(1)){ticket2.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket2.getWidth(), ticket2.getHeight(), WIDTH)));
        }else{ticket2.setIcon(null);}
        if(lista.get(2)){ticket3.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket3.getWidth(), ticket3.getHeight(), WIDTH)));
        }else{ticket3.setIcon(null);}
        if(lista.get(3)){ticket4.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket4.getWidth(), ticket4.getHeight(), WIDTH)));
        }else{ticket4.setIcon(null);}
        if(lista.get(4)){ticket5.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket5.getWidth(), ticket5.getHeight(), WIDTH)));
        }else{ticket5.setIcon(null);}
        if(lista.get(5)){ticket6.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket6.getWidth(), ticket6.getHeight(), WIDTH)));
        }else{ticket6.setIcon(null);}
        if(lista.get(6)){ticket7.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket7.getWidth(), ticket7.getHeight(), WIDTH)));
        }else{ticket7.setIcon(null);}
        if(lista.get(7)){ticket8.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket8.getWidth(), ticket8.getHeight(), WIDTH)));
        }else{ticket8.setIcon(null);}
        if(lista.get(8)){ticket9.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket9.getWidth(), ticket9.getHeight(), WIDTH)));
        }else{ticket9.setIcon(null);}
        if(lista.get(9)){ticket10.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket10.getWidth(), ticket10.getHeight(), WIDTH)));
        }else{ticket10.setIcon(null);}
        if(lista.get(10)){ticket11.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket11.getWidth(), ticket11.getHeight(), WIDTH)));
        }else{ticket11.setIcon(null);}
        if(lista.get(11)){ticket12.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket12.getWidth(), ticket12.getHeight(), WIDTH)));
        }else{ticket12.setIcon(null);}
        if(lista.get(12)){ticket13.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket13.getWidth(), ticket13.getHeight(), WIDTH)));
        }else{ticket13.setIcon(null);}
        if(lista.get(13)){ticket14.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket14.getWidth(), ticket14.getHeight(), WIDTH)));
        }else{ticket14.setIcon(null);}
        if(lista.get(14)){ticket15.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket15.getWidth(), ticket15.getHeight(), WIDTH)));
        }else{ticket15.setIcon(null);}
        if(lista.get(15)){ticket16.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket16.getWidth(), ticket16.getHeight(), WIDTH)));
        }else{ticket16.setIcon(null);}
        if(lista.get(16)){ticket17.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket17.getWidth(), ticket17.getHeight(), WIDTH)));
        }else{ticket17.setIcon(null);}
        if(lista.get(17)){ticket18.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket18.getWidth(), ticket18.getHeight(), WIDTH)));
        }else{ticket18.setIcon(null);}
        if(lista.get(18)){ticket19.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket19.getWidth(), ticket19.getHeight(), WIDTH)));
        }else{ticket19.setIcon(null);}
        if(lista.get(19)){ticket20.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ticket20.getWidth(), ticket20.getHeight(), WIDTH)));
        }else{ticket20.setIcon(null);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ticket1 = new javax.swing.JLabel();
        ticket2 = new javax.swing.JLabel();
        ticket3 = new javax.swing.JLabel();
        ticket4 = new javax.swing.JLabel();
        ticket5 = new javax.swing.JLabel();
        ticket6 = new javax.swing.JLabel();
        ticket7 = new javax.swing.JLabel();
        ticket8 = new javax.swing.JLabel();
        ticket9 = new javax.swing.JLabel();
        ticket10 = new javax.swing.JLabel();
        ticket11 = new javax.swing.JLabel();
        ticket12 = new javax.swing.JLabel();
        ticket13 = new javax.swing.JLabel();
        ticket14 = new javax.swing.JLabel();
        ticket15 = new javax.swing.JLabel();
        ticket16 = new javax.swing.JLabel();
        ticket17 = new javax.swing.JLabel();
        ticket18 = new javax.swing.JLabel();
        ticket19 = new javax.swing.JLabel();
        ticket20 = new javax.swing.JLabel();
        Productor = new javax.swing.JLabel();
        Consumidor = new javax.swing.JLabel();
        lblTittulo = new javax.swing.JLabel();
        lblTittulo1 = new javax.swing.JLabel();
        lblTittulo2 = new javax.swing.JLabel();
        lblElePro = new javax.swing.JLabel();
        lblTdorCon = new javax.swing.JLabel();
        lblTdorPro = new javax.swing.JLabel();
        lblEleCon = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        lblEstadoPro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblEstadoCon = new javax.swing.JLabel();
        lblTittulo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        ticket1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        ticket20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        Productor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/louis2.png"))); // NOI18N

        Consumidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/harry.png"))); // NOI18N

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTittulo.setText("Consumidor");

        lblTittulo1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo1.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo1.setText("PRODUCTOR-CONSUMIDOR");

        lblTittulo2.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTittulo2.setText("Productor");

        lblElePro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblElePro.setForeground(new java.awt.Color(204, 204, 204));
        lblElePro.setText("Elementos: 0");

        lblTdorCon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTdorCon.setForeground(new java.awt.Color(204, 204, 204));
        lblTdorCon.setText("Tiempo: 0");

        lblTdorPro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTdorPro.setForeground(new java.awt.Color(204, 204, 204));
        lblTdorPro.setText("Tiempo: 0");

        lblEleCon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEleCon.setForeground(new java.awt.Color(204, 204, 204));
        lblEleCon.setText("Elementos: 0");

        lblFin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblFin.setForeground(new java.awt.Color(204, 204, 204));

        lblEstadoPro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEstadoPro.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("2");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("3");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("4");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("5");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("6");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("7");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("8");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("9");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("10");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("11");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("12");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("13");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("14");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("15");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("16");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("17");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("18");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("19");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("20");

        lblEstadoCon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEstadoCon.setForeground(new java.awt.Color(204, 204, 204));

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
                    .addComponent(lblTittulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(Productor)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lblTittulo1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTdorPro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblElePro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(206, 206, 206)
                        .addComponent(Consumidor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTdorCon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEleCon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lblTittulo2)
                .addGap(375, 375, 375)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket14, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket15, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket18, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket19, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ticket20, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(1010, 1010, 1010)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTittulo3)
                        .addGap(25, 25, 25)
                        .addComponent(Productor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblTdorPro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lblElePro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lblEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Consumidor)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblTdorCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblEleCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblEstadoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTittulo2)
                    .addComponent(lblTittulo))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2))))
                    .addComponent(ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addComponent(ticket3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel4))))
                    .addComponent(ticket5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel6))
                    .addComponent(ticket6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticket7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel10))
                            .addComponent(ticket10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel11))
                            .addComponent(ticket11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel12))
                    .addComponent(ticket12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel13))
                            .addComponent(ticket13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel14)))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel16))
                            .addComponent(ticket16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticket18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel19))
                            .addComponent(ticket19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel21))
                    .addComponent(ticket20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyChar() == 27){            
            lblFin.setForeground(Color.CYAN);
            lblFin.setText("EL PROGRAMA TERMINO"); 
            t.stop();
        }  
    }//GEN-LAST:event_formKeyPressed

    private Timer t;
    private int s, cs, s2, cs2, cs3,s3, aux5;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) { 
            ++cs; 
            if(cs==100){
                cs = 0;
                ++s;
                if(productor.getTes() != 0 && !consumidor.isTipo()){
                    productor.setTes(productor.getTes()-1);
                    lblTdorPro.setText("Tiempo: "+productor.getTes());                                       
                }
                if(consumidor.getTes() != 0 && !productor.isTipo()){
                    consumidor.setTes(consumidor.getTes()-1);
                    lblTdorCon.setText("Tiempo: "+consumidor.getTes());                    
                }
            }
            if(!productor.isTipo()){
                lblEstadoPro.setForeground(Color.red);
                lblEstadoPro.setText("DORMIDO"); 
            }
            if(!consumidor.isTipo()){
                lblEstadoCon.setForeground(Color.red);
                lblEstadoCon.setText("DORMIDO");
            }
            if(productor.getTes() == 0 && total<20 && !consumidor.isTipo()){                
                productor.setTipo(true);
                lblEstadoPro.setForeground(Color.green);
                lblEstadoPro.setText("TRABAJANDO"); 
                ++cs2; 
                if(cs2==80){
                    cs2 = 0;                      
                    if(s2 < productor.getElementos()){
                        lista.set(productor.getUltElemento(), true);
                    } 
                    s2++;
                    total++;                    
                    productor.setUltElemento(productor.getUltElemento()+1);
                    productor.setElementosRes(productor.getElementosRes()-1);
                    lblElePro.setText("Elementos: "+productor.getElementosRes());
                    if(productor.getUltElemento() == 20){
                        productor.setUltElemento(0);
                    }
                }                
                if(productor.getElementosRes()==0){
                    productor.setTipo(false);
                    productor.setTes((int)(Math.random()*(11-5))+5);
                    productor.setElementos((int)(Math.random()*(6-2))+2);
                    productor.setElementosRes(productor.getElementos());
                    //consumidor.setTes((int)(Math.random()*(11-5))+5);
                    lblTdorPro.setText("Tiempo: "+productor.getTes());
                    lblElePro.setText("Elementos: "+productor.getElementos());
                    //lblTdorCon.setText("Tiempo: "+consumidor.getTes());
                    s2=0;
                }
                if(total==20){
                    productor.setTipo(false);                    
                }
                tickets();
            }
            if(consumidor.getTes() == 0 && total>0 && !productor.isTipo()){
                consumidor.setTipo(true);
                consumidor.setAux(true);
                lblEstadoCon.setForeground(Color.green);
                lblEstadoCon.setText("TRABAJANDO"); 
                 ++cs3; 
                if(cs3==80){
                    cs3 = 0;                      
                    if(s3 < consumidor.getElementos()){
                        lista.set(consumidor.getUltElemento(), false);
                    } 
                    s3++;
                    total--;
                    
                    consumidor.setUltElemento(consumidor.getUltElemento()+1);
                    consumidor.setElementosRes(consumidor.getElementosRes()-1);
                    lblEleCon.setText("Elementos: "+consumidor.getElementosRes());
                    if(consumidor.getUltElemento() == 20){
                        consumidor.setUltElemento(0);
                    }
                }                
                if(consumidor.getElementosRes()==0){
                    consumidor.setTipo(false);
                    consumidor.setAux(false);
                    consumidor.setTes((int)(Math.random()*(11-5))+5);
                    consumidor.setElementos((int)(Math.random()*(6-2))+2);
                    consumidor.setElementosRes(consumidor.getElementos());
                    //productor.setTes((int)(Math.random()*(11-5))+5);
                   // productor.setElementos((int)(Math.random()*(6-2))+2);
                    //productor.setElementosRes(consumidor.getElementos());
                    lblTdorCon.setText("Tiempo: "+consumidor.getTes());
                    lblEleCon.setText("Elementos: "+consumidor.getElementos());
                    //lblTdorPro.setText("Tiempo: "+productor.getTes());
                    s3=0;
                }
                if(total==0){
                    consumidor.setTipo(false);                    
                }
                if(total==0  && consumidor.isAux()){
                    productor.setTes(0);
                    lblTdorPro.setText("Tiempo: "+productor.getTes());
                }
                tickets();
                
            }
            if(consumidor.getTes() == 0 && total==0 && !productor.isTipo() && !consumidor.isAux()){
                consumidor.setTes((int)(Math.random()*(11-5))+5);                
                lblTdorCon.setText("Tiempo: "+consumidor.getTes());
            }
        }
    };
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Consumidor;
    private javax.swing.JLabel Productor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblEleCon;
    private javax.swing.JLabel lblElePro;
    private javax.swing.JLabel lblEstadoCon;
    private javax.swing.JLabel lblEstadoPro;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblTdorCon;
    private javax.swing.JLabel lblTdorPro;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo1;
    private javax.swing.JLabel lblTittulo2;
    private javax.swing.JLabel lblTittulo3;
    private javax.swing.JLabel ticket1;
    private javax.swing.JLabel ticket10;
    private javax.swing.JLabel ticket11;
    private javax.swing.JLabel ticket12;
    private javax.swing.JLabel ticket13;
    private javax.swing.JLabel ticket14;
    private javax.swing.JLabel ticket15;
    private javax.swing.JLabel ticket16;
    private javax.swing.JLabel ticket17;
    private javax.swing.JLabel ticket18;
    private javax.swing.JLabel ticket19;
    private javax.swing.JLabel ticket2;
    private javax.swing.JLabel ticket20;
    private javax.swing.JLabel ticket3;
    private javax.swing.JLabel ticket4;
    private javax.swing.JLabel ticket5;
    private javax.swing.JLabel ticket6;
    private javax.swing.JLabel ticket7;
    private javax.swing.JLabel ticket8;
    private javax.swing.JLabel ticket9;
    // End of variables declaration//GEN-END:variables
}
