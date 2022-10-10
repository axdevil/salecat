package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

import database.productDB;
import salecat.global;

/**
 *
 * @author axdevil
 */
public class sale extends javax.swing.JPanel {
    
    /**
     * Creates new form sale
     */
    public sale() {
        initComponents();
        notCode.setVisible(false);
        remove.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        code = new javax.swing.JTextField();
        amount = new javax.swing.JSpinner();
        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        cancel = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        notCode = new javax.swing.JLabel();
        remove = new javax.swing.JButton();

        code.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        code.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeKeyPressed(evt);
            }
        });

        amount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        amount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 256, 1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Producto", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
        });
        scrollTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(64);
            table.getColumnModel().getColumn(2).setMaxWidth(512);
        }

        cancel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        confirm.setBackground(new java.awt.Color(41, 121, 255));
        confirm.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirmar");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Roboto", 0, 28)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("$0");

        notCode.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        notCode.setForeground(new java.awt.Color(255, 68, 41));
        notCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        notCode.setText("Codigo no existente");

        remove.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        remove.setText("Eliminar");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notCode, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notCode, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirm)
                        .addComponent(remove))
                    .addComponent(cancel)
                    .addComponent(total))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyPressed
        if(evt.getKeyCode() == 10){
            try {
                addProduct(productDB.getByCode(code.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_codeKeyPressed

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        remove.setVisible(true);
    }//GEN-LAST:event_tableFocusGained

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        tableModel().removeRow(table.getSelectedRow());
        getTotal();
    }//GEN-LAST:event_removeActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        String[] buttons = {"No","Si"};
        int option = JOptionPane.showOptionDialog(null, "¿Seguro que quieres cancelar a la venta?","Confirmacion",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, buttons, buttons[1]);
        
        if(option == 1){
            tableModel().setNumRows(0);
            getTotal();
        }else{
            return;
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        lap w = new lap();
        menu.changeContent(w, "Cambio", null);
        w.received.requestFocusInWindow();
        
    }//GEN-LAST:event_confirmActionPerformed

    private void addProduct(ResultSet query) throws SQLException{
        String[] data = new String[3];
        
        while(query.next()){
            data[0] = amount.getValue().toString();
            data[1] = query.getString("description");
            data[2] = query.getString("price");
            tableModel().addRow(data);
        }
        
        if(data[0] == null){
            notCode.setVisible(true);
        }else{
            notCode.setVisible(false);
            table.setModel(tableModel());
            getTotal();
        }
        code.setText("");
    }

    private void getTotal(){
        DecimalFormat limit = new DecimalFormat("#.##");

        float totalVar = 0;
        
        for(int i = 0;i < table.getRowCount();i++){
            totalVar += Integer.parseInt(table.getValueAt(i, 0).toString()) * Float.parseFloat(table.getValueAt(i, 2).toString());
        }
        
        total.setText("$" + limit.format(totalVar));
    }
    
    private DefaultTableModel tableModel(){
        return (DefaultTableModel)table.getModel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amount;
    private javax.swing.JButton cancel;
    public static javax.swing.JTextField code;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel notCode;
    private javax.swing.JButton remove;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable table;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
