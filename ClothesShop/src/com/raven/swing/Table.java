package com.raven.swing;

import com.raven.swing.scroll.ScrollBarCustom;
import com.raven.table.TableCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;

public class Table extends TableCustom {

    public Table() {
    }

    public void addTableStyle(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(214, 214, 214));
        setForeground(new Color(0, 0, 0));
        setSelectionForeground(new Color(0, 0, 0));
        setSelectionBackground(new Color(214, 214, 214));
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
        setRowHeight(47);
        setShowHorizontalLines(true);
        setGridColor(new Color(50, 50, 50));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        Component com = super.prepareRenderer(tcr, i, i1);
        if (!isCellSelected(i, i1)) {
            com.setBackground(new Color(250, 250, 250));
        }
        return com;
    }

}
