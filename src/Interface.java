
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin Alberto Perez
 */
public class Interface extends javax.swing.JFrame {

    DefaultTableModel tabla = new DefaultTableModel();
    public int cuenta = 0;

    /**
     * Creates new form NewJFrame
     */
    public Interface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCodigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextOutput = new javax.swing.JTextArea();
        btnGualdal = new javax.swing.JButton();
        BtnAnalizador = new javax.swing.JButton();
        jTextAreaLinea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaCodigo.setColumns(20);
        jTextAreaCodigo.setRows(5);
        jTextAreaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaCodigoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaCodigo);

        jTextOutput.setColumns(20);
        jTextOutput.setRows(5);
        jTextOutput.setEnabled(false);
        jTextOutput.setOpaque(false);
        jScrollPane2.setViewportView(jTextOutput);

        btnGualdal.setText("Guardar");
        btnGualdal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGualdalActionPerformed(evt);
            }
        });

        BtnAnalizador.setText("Leer y Analizar");
        BtnAnalizador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAnalizadorMouseClicked(evt);
            }
        });

        jTextAreaLinea.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaLinea.setColumns(20);
        jTextAreaLinea.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaLinea.setRows(5);
        jTextAreaLinea.setEnabled(false);
        jTextAreaLinea.setFocusable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnGualdal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(BtnAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextAreaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGualdal)
                            .addComponent(BtnAnalizador))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAreaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGualdalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGualdalActionPerformed
        System.out.println("Gualdado");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Codigo"))) {
            writer.write(jTextAreaCodigo.getText());
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGualdalActionPerformed

    private void BtnAnalizadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnalizadorMouseClicked
        AnalizadorLexico analizador;
    try {
        // Instancia el analizador léxico con el nombre del archivo.
        analizador = new AnalizadorLexico("codigo");

        // Obtiene los tokens del analizador léxico.
        List<Token> tokens = analizador.analizar(analizador.cargarCodigoDesdeArchivo("codigo"));

        // Construye la cadena de salida usando el método toString de cada token.
        StringBuilder salida = new StringBuilder();
        for (Token token : tokens) {
            salida.append(token.toString()).append("\n");
        }

        // Establece el texto del JTextArea con la salida generada.
        jTextOutput.setText(salida.toString());

        System.out.println("Archivo Analizado");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_BtnAnalizadorMouseClicked

    private void jTextAreaCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaCodigoKeyTyped
        // TODO add your handling code here:
        char keyChar = evt.getKeyChar();
        System.out.println("Key Typed: " + keyChar);

        if (keyChar == '\n') {
            System.out.println("Enter.");

            // Incrementar el contador solo si la última línea no está vacía
            String[] lineas = jTextAreaCodigo.getText().split("\\n");
            if (lineas.length > 0 && !lineas[lineas.length - 1].trim().isEmpty()) {
                cuenta++;

                // Agregar el número al JTextArea de números
                jTextAreaLinea.setText("");
                for (int i = 1; i <= cuenta; i++) {
                    jTextAreaLinea.append(i + "\n");
                }
            }
        }
    }//GEN-LAST:event_jTextAreaCodigoKeyTyped

    public static String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");

            }
            System.out.println("File read successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
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
            java.util.logging.Logger.getLogger(Interface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnalizador;
    private javax.swing.JButton btnGualdal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaCodigo;
    public static javax.swing.JTextArea jTextAreaLinea;
    public static javax.swing.JTextArea jTextOutput;
    // End of variables declaration//GEN-END:variables
}
