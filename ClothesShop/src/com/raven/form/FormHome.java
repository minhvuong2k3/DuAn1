package com.raven.form;

import com.raven.component.Item;
import com.raven.event.EventItem;
import com.raven.model.ModelItem;
import com.raven.swing.ScrollBar;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;

public class FormHome extends javax.swing.JPanel {

    public void setEvent(EventItem event) {
        this.event = event;
    }

    private EventItem event;

    public FormHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }

    public void addItem(ModelItem data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }

    public void setSelected(Component item) {
        for (Component com : panelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }

    public void showItem(ModelItem data) {
//        lbItemName.setText(data.getItemName());
//        txtDescription.setText(data.getDescription());
//        lbBrand.setText(data.getBrandName());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
//        lbPrice.setText(df.format(data.getPrice()));
    }

    public Point getPanelItemLocation() {
        Point p = scroll.getLocation();
        return new Point(p.x, p.y - scroll.getViewport().getViewPosition().y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelItem = new com.raven.swing.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new com.raven.swing.RoundPanel();
        textField6 = new textfield.TextField();
        textField4 = new textfield.TextField();
        textField3 = new textfield.TextField();
        textField2 = new textfield.TextField();
        textField1 = new textfield.TextField();
        button1 = new button.Button();
        button2 = new button.Button();
        textField7 = new textfield.TextField();
        button3 = new button.Button();
        lbBrand1 = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textField6.setText("textField1");
        textField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField6.setLabelText("");
        textField6.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField6.setRound(0);

        textField4.setText("textField1");
        textField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField4.setLabelText("Sale");
        textField4.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField4.setRound(0);

        textField3.setText("textField1");
        textField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField3.setLabelText("Price ");
        textField3.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField3.setRound(0);

        textField2.setText("textField1");
        textField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField2.setLabelText("Product's Name");
        textField2.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField2.setRound(0);

        textField1.setText("textField1");
        textField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField1.setLabelText("Product's ID");
        textField1.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField1.setRound(0);

        button1.setText("Save");

        button2.setText("Delete");

        textField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textField7.setLabelText("");
        textField7.setMargin(new java.awt.Insets(0, 6, 0, 6));
        textField7.setRound(0);

        button3.setText("Choose Image");

        lbBrand1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbBrand1.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand1.setText("Product");

        lbBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("  Type ");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(textField6, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbBrand)
                            .addComponent(lbBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                            .addComponent(textField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textField1, textField2, textField3, textField4, textField6});

        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrand)
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button button1;
    private button.Button button2;
    private button.Button button3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbBrand1;
    private com.raven.swing.PanelItem panelItem;
    private com.raven.swing.RoundPanel roundPanel1;
    private javax.swing.JScrollPane scroll;
    private textfield.TextField textField1;
    private textfield.TextField textField2;
    private textfield.TextField textField3;
    private textfield.TextField textField4;
    private textfield.TextField textField6;
    private textfield.TextField textField7;
    // End of variables declaration//GEN-END:variables
}
