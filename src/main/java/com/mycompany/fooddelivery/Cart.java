/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fooddelivery;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.util.*;
/**
 *
 * @author mahad
 */
public class Cart extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    static double totalamount=0.0;
    static int discount12=0;
    /**
     * Creates new form Cart
     */
    public Cart(String[] stringArray) {
        
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            JOptionPane.showMessageDialog(this,"Driver Loaded!");
            try{
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                        "system","dbms");
                st=con.createStatement();
                JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
                
            }catch(SQLException ex){
                Logger.getLogger(com.mycompany.fooddelivery.Cart.class.getName()).log(Level.SEVERE,null, ex); //Add FoodDelivery before .Cart
JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(com.mycompany.fooddelivery.Cart.class.getName()).log(Level.SEVERE,null, ex);  //Add FoodDelivery before .Cart
JOptionPane.showMessageDialog(this,ex.getMessage());

        }
        initComponents(stringArray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String[] stringArray) {

        CartUpperPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        CartLowerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CartUpperPanel.setBackground(new java.awt.Color(255, 128, 0));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 32)); // NOI18N
        jLabel1.setText("Cart");

        jButton1.setText("Check-Out");
        final int n=stringArray.length;
        
        jButton1.addActionListener(e->{
            String[]temp={stringArray[n-3],stringArray[n-2],stringArray[n-1],String.valueOf(totalamount),String.valueOf(discount12)};
            PaymentPage callpay=new PaymentPage(temp);
            callpay.setVisible(true);
            this.dispose();
        });
        jButton2.setText("Add Items");

        javax.swing.GroupLayout CartUpperPanelLayout = new javax.swing.GroupLayout(CartUpperPanel);
        CartUpperPanel.setLayout(CartUpperPanelLayout);
        CartUpperPanelLayout.setHorizontalGroup(
            CartUpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartUpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(CartUpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        CartUpperPanelLayout.setVerticalGroup(
            CartUpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartUpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CartUpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CartUpperPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CartLowerPanelLayout = new javax.swing.GroupLayout(CartLowerPanel);
        CartLowerPanel.setLayout(CartLowerPanelLayout);
        CartLowerPanelLayout.setHorizontalGroup(
            CartLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CartLowerPanelLayout.setVerticalGroup(
            CartLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CartUpperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CartLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CartUpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    
            CartLowerPanel.setLayout(new BoxLayout(CartLowerPanel, BoxLayout.Y_AXIS));

             
            
            for (int i=0;i<n-3;i+=3){
                JPanel eachCityPanel1= new JPanel();
                eachCityPanel1.setBackground(new java.awt.Color(255, 253, 203));
                eachCityPanel1.setPreferredSize(new Dimension(615,80));
                eachCityPanel1.setLayout(null);
                eachCityPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    
                JLabel itemName=new JLabel(stringArray[i]);
                itemName.setFont(new Font("Sitka Text", Font.PLAIN, 20));
                itemName.setBounds(10, 25, 125, 25);
                itemName.setHorizontalAlignment(SwingConstants.LEFT);
    
                JLabel price=new JLabel("₹"+stringArray[i+1]);
                price.setFont(new Font("Sitka Text", Font.PLAIN, 20));
                price.setBounds(170, 25, 75, 25);
                price.setHorizontalAlignment(SwingConstants.LEFT);

                JLabel qty=new JLabel(stringArray[i+2]);
                qty.setFont(new Font("Sitka Text", Font.PLAIN, 20));
                qty.setBounds(280,25, 20, 25);
                qty.setHorizontalAlignment(SwingConstants.CENTER);

                final int index=i;
                double tprice=Double.parseDouble(stringArray[i+1])*Double.parseDouble(stringArray[i+2]);
                totalamount+=tprice;
                JLabel totalPrice=new JLabel("₹"+String.valueOf(tprice));
                totalPrice.setFont(new Font("Sitka Text", Font.PLAIN, 20));
                totalPrice.setBounds(350, 25, 75, 25);
                totalPrice.setHorizontalAlignment(SwingConstants.LEFT);
    
                eachCityPanel1.add(itemName);
                eachCityPanel1.add(price);
                eachCityPanel1.add(qty);
                eachCityPanel1.add(totalPrice);
                    
                CartLowerPanel.add(eachCityPanel1);
            }
            ArrayList<ArrayList<Object>> discounts=new ArrayList<ArrayList<Object>>();

        try{

            String rest_id=stringArray[n-1];
            String statement="select min_amount,discount_amount from offers where rest_id='"+rest_id+"'";
            rs=st.executeQuery(statement);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
              
            // Process each row
            while (rs.next()) {
                ArrayList<Object> offer_row=new ArrayList<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    offer_row.add(String.valueOf(rs.getObject(i))); // Add column value to the row
                }
                discounts.add(offer_row); // Add the row to the nested list
            }
            int discount=0;
             for (ArrayList<Object> row : discounts) {
                if(totalamount>(Integer)row.get(0)){
                   discount=(Integer)row.get(1);
                }
            }
            discount12=discount; 
        }catch(Exception u){
           System.out.println(u);
        }
            JScrollPane scrollItems= new JScrollPane(CartLowerPanel);
            scrollItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollItems.setBounds(0, 150, 475, 200);
    
            this.getContentPane().add(scrollItems);

        getContentPane().setLayout(null);
        CartUpperPanel.setBounds(0, 0, 475, 150);
        getContentPane().add(CartUpperPanel);  // Add upper panel

        this.setSize(485,350);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart(args).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CartLowerPanel;
    private javax.swing.JPanel CartUpperPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
