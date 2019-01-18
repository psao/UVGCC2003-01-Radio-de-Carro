
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/*
 * ===========================================================================================
 * Modifico: Pablo Sao
 * Fecha: 17/01/2019
 * Descripción:  se agregan los estados de la interfac para manejar la radio. Se incorpora
 *               el almacenamiento de favoritos para AM y FM por medio de la identificación 
 *               de los clicks en los botones, quedando de la siguiente forma:
 *               
 *               <> 1 Click: coloca el favorito
 *               <> 2 Clicks: guarda el favorito
 * ===========================================================================================
 * Modifico: Pablo Sao
 * Fecha: 16/01/2019
 * Descripción:  se agrega boton de frecuencia, visualización de recuencia e identificador de
 *               emisora al lado de la recuensia que se esta sintonizando. Se continua con el
 *               dinamismo que tendra la interfaz, conforme a las acciones de los botones
 * ===========================================================================================
 * Modifico: Pablo Sao
 * Fecha: 14/01/2019
 * Descripción: se crea la ventana y se agregan los botones de favoritos
 * ===========================================================================================
 */

/**
 * Se crea el maquetado de la interfaz de la radio
 * @author Pablo Sao
 * @version 1.2
 */
public class radioGUI extends javax.swing.JFrame {

    
    private iRadio  controlador = new Controlador(); //controlador para implementar la interfaz de la radio
    private int     favoritoSeleccionado = -1; // se inicializa la variable que contendra el favorito
    private int     MAX_AM = 1610; //Variable estatica para la frecuencia maxima de AM
    private double  MAX_FM = 107.9; //Variable estatica para la frecuencia maxima de FM
    
    private Timer timer = new Timer(300, new ActionListener() { //control de clicks en botones de favoritos
        public void actionPerformed(ActionEvent e) {
            // El timmer ha sido apagado, por lo que es un click al boton
            singleClick();
            timer.stop();
        }
    });
    
    /**
     * Creando la forma de la GUI e inicializando instrucciones con los valores por defecto de la radio
     */
    public radioGUI() {
        initComponents();
        btnOnOff.setSelected(false);
        btnAmFm.setSelected(false);
        hideOptions(false);
        lbFrecuencia.setText("107.9");
        changeLabelEmisora(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOnOff = new javax.swing.JToggleButton();
        btnUno = new javax.swing.JButton();
        btnDos = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnCuatro = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnSiete = new javax.swing.JButton();
        btnOcho = new javax.swing.JButton();
        btnNueve = new javax.swing.JButton();
        btnDiez = new javax.swing.JButton();
        btnOnce = new javax.swing.JButton();
        btnDoce = new javax.swing.JButton();
        pnlFrecuencia = new javax.swing.JPanel();
        lbFrecuencia = new javax.swing.JLabel();
        lbAM = new javax.swing.JLabel();
        lbFM = new javax.swing.JLabel();
        btnAmFm = new javax.swing.JToggleButton();
        btnSubirFrecuencia = new javax.swing.JButton();
        btnBajaFrecuencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radio");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/radio.png")).getImage());
        setMaximumSize(new java.awt.Dimension(412, 328));
        setMinimumSize(new java.awt.Dimension(412, 328));

        btnOnOff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOnOff.setText("Off");
        btnOnOff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOnOff.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnOnOffItemStateChanged(evt);
            }
        });

        btnUno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUno.setText("1");
        btnUno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eventoFavoritos(evt);
            }
        });

        btnDos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDos.setText("2");

        btnTres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTres.setText("3");

        btnCuatro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCuatro.setText("4");

        btnCinco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCinco.setText("5");
        btnCinco.setToolTipText("");

        btnSeis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSeis.setText("6");

        btnSiete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiete.setText("7");

        btnOcho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOcho.setText("8");

        btnNueve.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNueve.setText("9");

        btnDiez.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDiez.setText("10");

        btnOnce.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOnce.setText("11");
        btnOnce.setToolTipText("");

        btnDoce.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDoce.setText("12");

        pnlFrecuencia.setBackground(new java.awt.Color(102, 102, 102));
        pnlFrecuencia.setMinimumSize(new java.awt.Dimension(32767, 32767));

        lbFrecuencia.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbFrecuencia.setForeground(new java.awt.Color(255, 255, 255));
        lbFrecuencia.setText("107.9");

        lbAM.setForeground(new java.awt.Color(255, 255, 255));
        lbAM.setText("AM");

        lbFM.setForeground(new java.awt.Color(255, 255, 255));
        lbFM.setText("FM");

        javax.swing.GroupLayout pnlFrecuenciaLayout = new javax.swing.GroupLayout(pnlFrecuencia);
        pnlFrecuencia.setLayout(pnlFrecuenciaLayout);
        pnlFrecuenciaLayout.setHorizontalGroup(
            pnlFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrecuenciaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbFrecuencia)
                .addGap(26, 26, 26)
                .addGroup(pnlFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAM)
                    .addComponent(lbFM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFrecuenciaLayout.setVerticalGroup(
            pnlFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrecuenciaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAM)
                    .addGroup(pnlFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbFM)))
                .addGap(26, 26, 26))
        );

        btnAmFm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAmFm.setText("FM");
        btnAmFm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAmFm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmFmActionPerformed(evt);
            }
        });

        btnSubirFrecuencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rrow.png"))); // NOI18N
        btnSubirFrecuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFrecuenciaActionPerformed(evt);
            }
        });

        btnBajaFrecuencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lrow.png"))); // NOI18N
        btnBajaFrecuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaFrecuenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAmFm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSiete, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOcho, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNueve, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDiez)
                            .addComponent(btnCuatro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOnce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDoce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnBajaFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnSubirFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOnOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAmFm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubirFrecuencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBajaFrecuencia, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUno)
                    .addComponent(btnDos)
                    .addComponent(btnTres)
                    .addComponent(btnCuatro)
                    .addComponent(btnCinco)
                    .addComponent(btnSeis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiez)
                    .addComponent(btnOnce)
                    .addComponent(btnDoce)
                    .addComponent(btnNueve)
                    .addComponent(btnOcho)
                    .addComponent(btnSiete))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Metodo para colocar la emisora almacenada en favorito al darle click
     */
    protected void singleClick() {
        hideOptions(false);
        double frecuenciaFavorito = controlador.getFavorito(favoritoSeleccionado);
        
        
        if(btnAmFm.isSelected() && (frecuenciaFavorito != 0)){

            lbFrecuencia.setText(Integer.toString((int) frecuenciaFavorito));
        }
        else if(!btnAmFm.isSelected() && (frecuenciaFavorito != 0)){
            DecimalFormat df = new DecimalFormat("#.##");
            lbFrecuencia.setText(df.format(controlador.getFavorito(favoritoSeleccionado)));
        }
        
        hideOptions(true);
    }
    
    /**
     * Metodo para guardar el valor favorito al darle doble click al boton
     */
    protected void doubleClick() {
        
        controlador.setFavorito(favoritoSeleccionado);
        
    }
        
    /**
     * Metodo para cambiar el identificador de la emisora seleccionada en la interfaz
     * @param emisora valor booleano donde true es am y false es fm
     */
    private void changeLabelEmisora(boolean emisora){
        lbAM.setVisible(emisora);
        lbFM.setVisible(!emisora);
    }
    
    /**
     * Metodo para desactivar los botones cuando la radio este apagada
     * @param show valor true para activar botones y false para desactivar botones
     */
    private void hideOptions(boolean show){
        
        //
        lbFrecuencia.setEnabled(show);
        
        //
        lbAM.setEnabled(show);
        lbFM.setEnabled(show);
        
        //boton de recuencia
        btnAmFm.setEnabled(show);
        
        //Botones de cambio de frecuencia
        btnBajaFrecuencia.setEnabled(show);
        btnSubirFrecuencia.setEnabled(show);
        
        //Botones de favoritos
        btnUno.setEnabled(show);
        btnDos.setEnabled(show);
        btnTres.setEnabled(show);
        btnCuatro.setEnabled(show);
        btnCinco.setEnabled(show);
        btnSeis.setEnabled(show);
        btnSiete.setEnabled(show);
        btnOcho.setEnabled(show);
        btnNueve.setEnabled(show);
        btnDiez.setEnabled(show);
        btnOnce.setEnabled(show);
        btnDoce.setEnabled(show);
    }
    
    
    private void btnOnOffItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnOnOffItemStateChanged
        // TODO add your handling code here:
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
            btnOnOff.setText("On");
            hideOptions(true);
        }
        else{
            btnOnOff.setText("Off");
            hideOptions(false);
        }
    }//GEN-LAST:event_btnOnOffItemStateChanged
    
    private void btnSubirFrecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFrecuenciaActionPerformed
        
        if(btnAmFm.isSelected()){
            lbFrecuencia.setText(Integer.toString((int)controlador.subirFrecuencia()));
        }
        else{
            DecimalFormat df = new DecimalFormat("#.##");   
            lbFrecuencia.setText(df.format(controlador.subirFrecuencia()));
        }
               
    }//GEN-LAST:event_btnSubirFrecuenciaActionPerformed

    private void btnBajaFrecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaFrecuenciaActionPerformed
        // TODO add your handling code here:
        if(btnAmFm.isSelected()){
            lbFrecuencia.setText(Integer.toString((int)controlador.bajarFrecuencia()));
        }
        else{
            DecimalFormat df = new DecimalFormat("#.##"); 
            lbFrecuencia.setText(df.format(controlador.bajarFrecuencia()));
        }
    }//GEN-LAST:event_btnBajaFrecuenciaActionPerformed

    private void btnAmFmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmFmActionPerformed
        
        //Si el boton es seleccionado (true) coloca AM
        if(btnAmFm.isSelected()){
            btnAmFm.setText("AM");
            changeLabelEmisora(controlador.cambiarAmFm());
            lbFrecuencia.setText(Integer.toString((int)MAX_AM));
        }
        //Si el boton es deseleccionado (false) coloca FM 
        else{
            btnAmFm.setText("FM");
            changeLabelEmisora(controlador.cambiarAmFm()); 
            lbFrecuencia.setText(Double.toString(MAX_FM)); 
        }
    }//GEN-LAST:event_btnAmFmActionPerformed

    private void eventoFavoritos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventoFavoritos
	
        Object soruce = evt.getSource();
        
		String boton;
        
        if(soruce instanceof JButton){
            //Obtenemos el número del boton que posee de nombre
            boton = ((JButton)soruce).getLabel();  
            favoritoSeleccionado = Integer.parseInt(boton)-1;
        }
        //vemos si el timmer se esta ejecutando y ver si ya ha sido presionado el boton	
        if (timer.isRunning()) {
            timer.stop();
            doubleClick();
        } else {
            //reiniciamos el timmer y quedamos a la espera del segundo click
            timer.restart();
        }
    }//GEN-LAST:event_eventoFavoritos
    
    
    
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
            java.util.logging.Logger.getLogger(radioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(radioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(radioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(radioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new radioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAmFm;
    private javax.swing.JButton btnBajaFrecuencia;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnDiez;
    private javax.swing.JButton btnDoce;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnOcho;
    private javax.swing.JToggleButton btnOnOff;
    private javax.swing.JButton btnOnce;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSiete;
    private javax.swing.JButton btnSubirFrecuencia;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUno;
    private javax.swing.JLabel lbAM;
    private javax.swing.JLabel lbFM;
    private javax.swing.JLabel lbFrecuencia;
    private javax.swing.JPanel pnlFrecuencia;
    // End of variables declaration//GEN-END:variables
}
