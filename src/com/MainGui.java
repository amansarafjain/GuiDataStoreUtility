/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import com.FuntionLibrary;
import static com.FuntionLibrary.excelFileName;
import static com.FuntionLibrary.sheetName;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Aman
 */
public class MainGui extends javax.swing.JFrame {
private static String mailId = "";
private static String pass = ""; 
private static String mob = "";
private static  String Mob_Number = "";
private static int rowNum = 0;
public static Boolean EditExistingButtonClicked = false;
public static Boolean SaveEditedButtonClicked = false;
/**
 * 
     * Creates new form MainGui
     */
    public MainGui() {
        initComponents();
        jButton4.setVisible(false);
        jButton3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setText("ENTER MAIL ID");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 80, 190, 14);

        jLabel2.setText("ENTER MOBILE NUMBER ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 160, 180, 14);

        jLabel3.setText("ENTER PASSWORD");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 120, 170, 14);

        jLabel4.setText("ENTER NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 40, 170, 14);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(290, 80, 200, 30);
        jTextField1.addKeyListener(new KeyAdapter() {

            public String str_email= "";
            public void keyTyped(KeyEvent e) {
                str_email += e.getKeyChar();
            }
        });

        jPanel1.add(jTextField3);
        jTextField3.setBounds(290, 120, 200, 30);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(290, 40, 200, 30);

        jButton1.setText("Save Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 240, 200, 30);

        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        jFormattedTextField1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char vChar = e.getKeyChar();
                if (!(Character.isDigit(vChar)
                    || (vChar == KeyEvent.VK_BACK_SPACE)
                    || (vChar == KeyEvent.VK_DELETE))) {
                e.consume();
            }
            if (jFormattedTextField1.getText().length()>9){
                JOptionPane.showMessageDialog(null,"Enter 10 digit Mobile Number");
            }
        }
    });
    jPanel1.add(jFormattedTextField1);
    jFormattedTextField1.setBounds(290, 160, 200, 30);

    jLabel6.setForeground(new java.awt.Color(255, 0, 0));
    jLabel6.setText("*");
    jPanel1.add(jLabel6);
    jLabel6.setBounds(190, 120, 90, 14);

    jLabel7.setForeground(new java.awt.Color(255, 0, 0));
    jLabel7.setText("*");
    jPanel1.add(jLabel7);
    jLabel7.setBounds(220, 160, 60, 14);

    jLabel8.setText("Designed By ASJ Pvt Limited @ 2014");
    jPanel1.add(jLabel8);
    jLabel8.setBounds(30, 330, 280, 14);

    jButton2.setText("Edit Existing Details");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton2);
    jButton2.setBounds(290, 290, 200, 30);

    jButton4.setText("Save Edited Data");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton4);
    jButton4.setBounds(290, 240, 200, 30);

    jButton3.setText("Exit Edit Mode");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton3);
    jButton3.setBounds(510, 290, 140, 30);

    jButton5.setText("Close");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton5);
    jButton5.setBounds(510, 240, 140, 30);

    jLabel9.setText("ENTER EMAIL PASSWORD");
    jPanel1.add(jLabel9);
    jLabel9.setBounds(70, 210, 180, 14);
    jPanel1.add(jTextField2);
    jTextField2.setBounds(290, 200, 200, 30);

    jPanel2.setBackground(new java.awt.Color(255, 204, 0));

    jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
    jLabel5.setText("      DATA STORE UTILITY");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(173, 173, 173)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(235, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addComponent(jLabel5)
            .addContainerGap(44, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>                        

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   // JOptionPane.showMessageDialog(null, evt.getActionCommand());
        if (evt.getActionCommand().equals("Save Details")){
            try {
                FuntionLibrary fb = new FuntionLibrary();
                 File file = new File(excelFileName);
                     XSSFWorkbook wb ;
                        XSSFSheet sheet;
                        if (file.exists()) {
                            FileInputStream fis = new FileInputStream(file);
                            wb = new XSSFWorkbook(fis);
                            sheet = wb.getSheet(sheetName);
                        } else {
                             wb = new XSSFWorkbook();
                            sheet = wb.createSheet(sheetName);
                        }
                mailId = fb.validateEmail(jTextField1.getText(),sheet);
                pass = fb.validatePassword(jTextField3.getText());
                sheet = wb.getSheet(sheetName);
                mob =  fb.validateMobileNO(jFormattedTextField1.getText(),sheet);
                if(mob!=null && mailId !=null && FuntionLibrary.Pflag==true && FuntionLibrary.Mflag == true && FuntionLibrary.Eflag == true)
                {
                     fb.writetoExcel(jTextField4.getText(),mailId,pass,mob,sheet,jTextField2.getText());
                     FileOutputStream fileOut = new FileOutputStream(excelFileName);
                        //write this workbook to an Outputstream.
                        wb.write(fileOut);
                        fileOut.flush();
                        fileOut.close();
                        System.out.println("Your excel file has been generated!");
                        JOptionPane.showMessageDialog(null, " Data Base Updated Successfully !!\n Path of data file is " + excelFileName);
                }
                else {
                JOptionPane.showMessageDialog(null,"Please enter required fields correctly. Thanks !!");
                }
                jTextField1.setText("");
                jTextField3.setText("");
                jTextField2.setText("");
                jTextField4.setText("");
                jFormattedTextField1.setText("");
            } catch (InvalidFormatException | IOException ex) {
                Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error in Saving Data");
            }
    }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        EditExistingButtonClicked = true;
        jButton1.setVisible(false);
        jButton3.setVisible(true);
        jButton4.setVisible(true);
        FileInputStream fis = null;
        try {
                File file = new File(FuntionLibrary.excelFileName);
                if (!(file.exists())){
                JOptionPane.showMessageDialog(null, "Please Create the DataBase !! DataBase not found.");
                }
                fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                Mob_Number = JOptionPane.showInputDialog(null, "Enter Mobile Number to find details");
                FuntionLibrary fb = new FuntionLibrary();
                fb.validateMobileNO(Mob_Number,wb.getSheet(sheetName));
                rowNum = FuntionLibrary.findRow(wb.getSheet(FuntionLibrary.sheetName), Mob_Number);
                String arr[] = FuntionLibrary.getData(rowNum,wb.getSheet(FuntionLibrary.sheetName));
                jTextField4.setText(arr[0]);
                jTextField1.setText(arr[1]);
                jTextField3.setText(arr[2]);
                jFormattedTextField1.setText(arr[3]);
                jTextField2.setText(arr[4]);
               } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        SaveEditedButtonClicked = true;
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        FileInputStream fis = null;
    try {
        File file = new File(FuntionLibrary.excelFileName);
        fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        FuntionLibrary fb = new FuntionLibrary();
        mailId = fb.validateEmail(jTextField1.getText(),wb.getSheet(FuntionLibrary.sheetName));
        pass = fb.validatePassword(jTextField3.getText());
        mob =  fb.validateMobileNO(jFormattedTextField1.getText(),wb.getSheet(FuntionLibrary.sheetName));
        FuntionLibrary.updateExcel(rowNum, wb.getSheet(FuntionLibrary.sheetName), jTextField4.getText(), mailId, pass, mob,jTextField2.getText());
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            fis.close();
             JOptionPane.showMessageDialog(null," Data Base Updated Successfully !!\n Path of data file is " + excelFileName);
        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      jButton4.setVisible(false);
      jButton1.setVisible(true);
      jButton2.setVisible(true);
      jTextField1.setText("");
      jTextField3.setText("");
      jTextField4.setText("");
      jTextField2.setText("");
      jFormattedTextField1.setText("");
      jButton3.setVisible(false);
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();// TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   
}
