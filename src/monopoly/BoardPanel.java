/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ashutosh
 */
public class BoardPanel extends javax.swing.JPanel {

    /**
     * Creates new form BoardPanel
     */
    public BoardPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyT = new javax.swing.JTable();
        buttonP = new javax.swing.JPanel();
        diceB = new javax.swing.JButton();
        addCompanyB = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        diceL = new javax.swing.JLabel();
        shuffleB = new javax.swing.JButton();
        dealB = new javax.swing.JButton();
        labelP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgTP = new javax.swing.JTextPane();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(780, 640));
        setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 200));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)), jScrollPane1.getBorder()));

        companyT.setModel(new CompanyTableModel());
        companyT.setDefaultRenderer(String.class, new CompanyTableCellRenderer());
        jScrollPane1.setViewportView(companyT);

        jPanel1.add(jScrollPane1);

        diceB.setText("Roll Dice");
        diceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceBActionPerformed(evt);
            }
        });

        addCompanyB.setText("Add Company");
        addCompanyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompanyBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nimbus Sans L", 0, 24)); // NOI18N
        jLabel1.setText("Dice:");

        diceL.setFont(new java.awt.Font("Nimbus Sans L", 0, 24)); // NOI18N
        diceL.setText("0");

        shuffleB.setText("Shuffle");
        shuffleB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleBActionPerformed(evt);
            }
        });

        dealB.setText("Deal");
        dealB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPLayout = new javax.swing.GroupLayout(buttonP);
        buttonP.setLayout(buttonPLayout);
        buttonPLayout.setHorizontalGroup(
            buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(diceL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(shuffleB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCompanyB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diceB, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(dealB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79))
        );
        buttonPLayout.setVerticalGroup(
            buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diceB)
                    .addComponent(addCompanyB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shuffleB)
                    .addComponent(dealB))
                .addGap(30, 30, 30)
                .addGroup(buttonPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diceL))
                .addGap(128, 128, 128))
        );

        jPanel1.add(buttonP);

        add(jPanel1);

        labelP.setLayout(new java.awt.BorderLayout());

        StyledDocument doc = msgTP.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        msgTP.setFont(new java.awt.Font("Nimbus Sans L", 0, 24)); // NOI18N
        jScrollPane3.setViewportView(msgTP);

        labelP.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        add(labelP);
    }// </editor-fold>//GEN-END:initComponents

    private void addCompanyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompanyBActionPerformed
        String str = JOptionPane.showInputDialog(this, "Enter New Company Name", "Creating New Company", JOptionPane.QUESTION_MESSAGE);
        if (str == null || str.isEmpty()) {
            return;
        }
        Company c = new Company(str);
        Board.getInstance().addCompany(c);
    }//GEN-LAST:event_addCompanyBActionPerformed

    private void diceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diceBActionPerformed
        Board b = Board.getInstance();
        final Company c = b.getNextCompany();
        String val = c.rollDice();
        diceL.setText(val);

        final BoardColorBlock col = b.getBlock(c.getPositionOnBoard());

        (new SwingWorker<String, Object>() {

            @Override
            public String doInBackground() {
                return col.getOperation().perform(c);
            }

            @Override
            protected void done() {
                try {
                    msgTP.setText(get());
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }).execute();
    }//GEN-LAST:event_diceBActionPerformed

    private void shuffleBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleBActionPerformed
        BoardColorBlock.shuffleOperations();
    }//GEN-LAST:event_shuffleBActionPerformed

    private void dealBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealBActionPerformed
        (new SwingWorker<String, Object>() {

            @Override
            public String doInBackground() {
                Board b = Board.getInstance();
                Company companies[] = b.getCompanies();
                Company c = (Company) JOptionPane.showInputDialog(BoardPanel.this,
                        "Select company to sell to...", "Patent Deal",
                        JOptionPane.QUESTION_MESSAGE, null, companies, companies[0]);

                if (c == null) {
                    return "Deal cancelled";
                }

                String str = JOptionPane.showInputDialog(BoardPanel.this,
                        "Enter your agreement amount ", "Patent Deal", JOptionPane.QUESTION_MESSAGE);
                if (str == null || str.isEmpty()) {
                    return "Deal cancelled";
                }

                try {
                    int amt = Integer.parseInt(str);
                    c.decrMoney(amt);
                    c.incrPatentCount();

                    Company co = b.getCompany(b.getSelectIndex());
                    co.incrMoney(amt);
                    c.decrPatentCount();
                    return co + " sold 1 patent to " + c;
                } catch (NumberFormatException e) {
                    return "Deal cancelled";
                }
            }

            @Override
            protected void done() {
                try {
                    msgTP.setText(get());
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }).execute();
    }//GEN-LAST:event_dealBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCompanyB;
    private javax.swing.JPanel buttonP;
    private javax.swing.JTable companyT;
    private javax.swing.JButton dealB;
    private javax.swing.JButton diceB;
    private javax.swing.JLabel diceL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel labelP;
    private javax.swing.JTextPane msgTP;
    private javax.swing.JButton shuffleB;
    // End of variables declaration//GEN-END:variables
    static class CompanyTableModel extends AbstractTableModel implements PropertyChangeListener {

        public CompanyTableModel() {
            Board.getInstance().addPropertyChangeListener(this);
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Board Idx";
                case 1:
                    return "Company Name";
                case 2:
                    return "Net Worth";
                case 3:
                    return "Patents";
                default:
                    return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public int getRowCount() {
            return Board.getInstance().getCompanyCount();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Board b = Board.getInstance();
            Company c = b.getCompany((rowIndex + b.getSelectIndex() + b.getCompanyCount()) % b.getCompanyCount());
            System.out.println(c + " is displayed at " + rowIndex);
            switch (columnIndex) {
                case 0:
                    return c.getPositionOnBoard() + 1;
                case 1:
                    return c.getName();
                case 2:
                    return "Rs. " + c.getMoney() + "k";
                case 3:
                    return c.getPatents();
                default:
                    return null;
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(Board.COMPANY_COUNT_PROPERTY)) {
                int idx = (Integer) evt.getNewValue();
                Board.getInstance().getCompany(idx - 1).addPropertyChangeListener(this);
                fireTableRowsInserted((Integer) evt.getOldValue(), idx);
            } else if (evt.getPropertyName().equals(Board.COMPANY_ORDER_PROPERTY)
                    || evt.getPropertyName().equals(Company.MONEY_VALUE_CHANGED_PROPERTY)) {
                fireTableDataChanged();
            }
        }

    }

    static class CompanyTableCellRenderer extends JLabel implements TableCellRenderer {

        public CompanyTableCellRenderer() {
            setOpaque(true);
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Board b = Board.getInstance();
            int n = b.getCompanyCount();
            Company c = b.getCompany((row + b.getSelectIndex() + n) % n);
            System.out.println(c);
            setText(value.toString());
            setBackground(b.getBlock(c.getPositionOnBoard()).getColor());
            return this;
        }

    }
}
