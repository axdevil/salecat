package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;

import salecat.global;
import database.providerDB;
import database.productDB;
import javax.swing.JOptionPane;
/**
 *
 * @author axdevil
 */
public class newProduct extends javax.swing.JPanel {
    
    ArrayList<Integer> idProviders = new ArrayList<>();
    int mode;
    int idProduct;
    
    
    /**
     * Creates new form newProduct
     * 0=create
     * 1=create from inventory
     * 2=edit
     */
    public newProduct(int mode, int idProduct) {
        initComponents();
        
        this.mode = mode;
        this.idProduct = idProduct;
        
        try {
            fillProvider(providerDB.get());
        } catch (SQLException ex) {
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(mode != 0){
            exit.setText("Cancelar");
        }
        if(mode == 2){
            save.setText("Editar");
            
            try {
                ResultSet query = productDB.getProduct(idProduct);
                while(query.next()){
                    code.setText(query.getString("code"));
                    description.setText(query.getString("description"));
                    price.setValue(query.getFloat("price"));
                    wholesalePrice.setValue(query.getFloat("wholesalePrice"));
                    gain.setValue(query.getFloat("gain"));
                    amount.setValue(query.getInt("amount"));
                    for(int i = 0;i < idProviders.size();i++){
                        if(idProviders.get(i) == query.getInt("providerFK")){
                            provider.setSelectedIndex(i + 1);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        wholesalePrice.addChangeListener((ChangeEvent e) -> {
            getGain(); 
        });
        price.addChangeListener((ChangeEvent e) -> {
            getGain(); 
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codeTitle = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        descriptionTitle = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        priceTitle = new javax.swing.JLabel();
        price = new javax.swing.JSpinner();
        MXN = new javax.swing.JLabel();
        wholesalePriceTitle = new javax.swing.JLabel();
        wholesalePrice = new javax.swing.JSpinner();
        MXN1 = new javax.swing.JLabel();
        gainTitle = new javax.swing.JLabel();
        gain = new javax.swing.JSpinner();
        MXN2 = new javax.swing.JLabel();
        providerTitle = new javax.swing.JLabel();
        provider = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        amountTitle = new javax.swing.JLabel();
        amount = new javax.swing.JSpinner();

        codeTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        codeTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codeTitle.setText("* Codigo:");

        code.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeKeyPressed(evt);
            }
        });

        descriptionTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        descriptionTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descriptionTitle.setText("Descripcion:");

        description.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        priceTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        priceTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceTitle.setText("* Precio:");

        price.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        price.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        MXN.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        MXN.setText("MXN");

        wholesalePriceTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        wholesalePriceTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wholesalePriceTitle.setText("Precio mayoreo:");

        wholesalePrice.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        wholesalePrice.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        MXN1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        MXN1.setText("MXN");

        gainTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gainTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gainTitle.setText("Ganancia:");

        gain.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gain.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        gain.setEnabled(false);

        MXN2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        MXN2.setText("MXN");

        providerTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        providerTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        providerTitle.setText("Proveedor:");
        providerTitle.setToolTipText("");

        provider.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        save.setBackground(new java.awt.Color(41, 121, 255));
        save.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Guardar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        amountTitle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        amountTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountTitle.setText("Cantidad:");

        amount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        amount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descriptionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wholesalePriceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(providerTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(provider, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(price)
                                            .addComponent(wholesalePrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(gain)
                                            .addComponent(amount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MXN1)
                                            .addComponent(MXN2)
                                            .addComponent(MXN, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(code)
                    .addComponent(codeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MXN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wholesalePriceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wholesalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MXN1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MXN2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(exit))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        if(mode == 0){
            sale w = new sale();
            menu.changeContent(w, "Punto de venta", w.code);
        }else{
            menu.changeContent(new inventory(), "Inventario", null);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        global.validation(codeTitle, false);
        global.validation(priceTitle, false);
        
        boolean existCode = false;
        
        try {
            while(productDB.existCode(code.getText()).next()){
                existCode = true;
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(code.getText().length() == 0){
            global.validation(codeTitle, true);
            code.requestFocusInWindow();
        }else if(existCode && mode == 0){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese codigo","Error",1);
            global.validation(codeTitle, true);
            code.requestFocusInWindow();
        }else if((float) price.getValue() == 0){
            global.validation(priceTitle, true);
        }else{
            String id;
            if(!"Ninguno".equals(provider.getSelectedItem().toString())){
                id = idProviders.get(provider.getSelectedIndex() - 1).toString();
            }else{
                id = "NULL";
            }
            
            try {
                if(mode < 2){
                    productDB.add(code.getText(), description.getText(), price.getValue().toString(), wholesalePrice.getValue().toString(), gain.getValue().toString(), id, (int) amount.getValue());
                }else{
                    productDB.edit(idProduct,code.getText(), description.getText(), price.getValue().toString(), wholesalePrice.getValue().toString(), gain.getValue().toString(), id, (int) amount.getValue());
                }
            } catch (SQLException ex) {
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(mode == 0){
                clean();
                code.requestFocusInWindow();
            }else{
                menu.changeContent(new inventory(), "Inventario", null);
            }
            
        }

    }//GEN-LAST:event_saveActionPerformed

    private void codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyPressed
        if(evt.getKeyCode() == 10){
            description.requestFocusInWindow();
        }
    }//GEN-LAST:event_codeKeyPressed
        
    private void getGain(){
        float total = (float) price.getValue() - (float) wholesalePrice.getValue();
        
        gain.setValue(total);
    }
    
    private void fillProvider(ResultSet query) throws SQLException{
        provider.removeAllItems();
        
        provider.addItem("Ninguno");
        while(query.next()){
            idProviders.add(query.getInt("id"));
            provider.addItem(query.getString("name") + " " + query.getString("appat") + " " + query.getString("apmat"));
        }
    }
    
    private void clean(){
        code.setText("");
        description.setText("");
        price.setValue((float) 0);
        wholesalePrice.setValue((float) 0);
        gain.setValue((float) 0);
        amount.setValue((int) 0);
        provider.setSelectedIndex(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MXN;
    private javax.swing.JLabel MXN1;
    private javax.swing.JLabel MXN2;
    private javax.swing.JSpinner amount;
    private javax.swing.JLabel amountTitle;
    public javax.swing.JTextField code;
    private javax.swing.JLabel codeTitle;
    private javax.swing.JTextField description;
    private javax.swing.JLabel descriptionTitle;
    private javax.swing.JButton exit;
    private javax.swing.JSpinner gain;
    private javax.swing.JLabel gainTitle;
    private javax.swing.JSpinner price;
    private javax.swing.JLabel priceTitle;
    private javax.swing.JComboBox<String> provider;
    private javax.swing.JLabel providerTitle;
    private javax.swing.JButton save;
    private javax.swing.JSpinner wholesalePrice;
    private javax.swing.JLabel wholesalePriceTitle;
    // End of variables declaration//GEN-END:variables
}
