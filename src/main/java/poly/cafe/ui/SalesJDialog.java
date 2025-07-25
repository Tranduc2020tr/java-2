/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package poly.cafe.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.Timer;
import poly.cafe.dao.BillDAO;
import poly.cafe.dao.impl.BillDAOImpl;
import poly.cafe.entity.Bill;
import poly.cafe.ui.SalesController.SalesController;
import poly.cafe.dao.CardDAO;
import poly.cafe.dao.impl.CardDAOImpl;
import poly.cafe.entity.Card;

/**
 *
 * @author hang
 */
public class SalesJDialog extends JDialog implements SalesController{
    
    private Timer reloadTimer;

    /**
     * Creates new form SaleJDialog
     */
    public SalesJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.open();
        startReloadTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCards = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlCards.setLayout(new java.awt.GridLayout(0, 6, 5, 5));

        jButton1.setText("jButton1");
        pnlCards.add(jButton1);

        jButton2.setText("jButton2");
        pnlCards.add(jButton2);

        jButton3.setText("jButton3");
        pnlCards.add(jButton3);

        jButton4.setText("jButton4");
        pnlCards.add(jButton4);

        jButton5.setText("jButton5");
        pnlCards.add(jButton5);

        jButton6.setText("jButton6");
        pnlCards.add(jButton6);

        jButton7.setText("jButton7");
        pnlCards.add(jButton7);

        jButton8.setText("jButton8");
        pnlCards.add(jButton8);

        jButton9.setText("jButton9");
        pnlCards.add(jButton9);

        jButton10.setText("jButton10");
        pnlCards.add(jButton10);

        jButton11.setText("jButton11");
        pnlCards.add(jButton11);

        jButton12.setText("jButton12");
        pnlCards.add(jButton12);

        jButton13.setText("jButton13");
        pnlCards.add(jButton13);

        jButton14.setText("jButton14");
        pnlCards.add(jButton14);

        jButton15.setText("jButton15");
        pnlCards.add(jButton15);

        jButton16.setText("jButton16");
        pnlCards.add(jButton16);

        jButton17.setText("jButton17");
        pnlCards.add(jButton17);

        jButton18.setText("jButton18");
        pnlCards.add(jButton18);

        jButton19.setText("jButton19");
        pnlCards.add(jButton19);

        jButton20.setText("jButton20");
        pnlCards.add(jButton20);

        jButton21.setText("jButton21");
        pnlCards.add(jButton21);

        jButton22.setText("jButton22");
        pnlCards.add(jButton22);

        jButton23.setText("jButton23");
        pnlCards.add(jButton23);

        jButton24.setText("jButton24");
        pnlCards.add(jButton24);

        jButton25.setText("jButton25");
        pnlCards.add(jButton25);

        jButton26.setText("jButton26");
        pnlCards.add(jButton26);

        jButton27.setText("jButton27");
        pnlCards.add(jButton27);

        jButton28.setText("jButton28");
        pnlCards.add(jButton28);

        jButton29.setText("jButton29");
        pnlCards.add(jButton29);

        jButton30.setText("jButton30");
        pnlCards.add(jButton30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.open();
    }//GEN-LAST:event_formWindowOpened

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SalesJDialog dialog = new SalesJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel pnlCards;
    // End of variables declaration//GEN-END:variables
@Override
    public void open() {
        this.setLocationRelativeTo(null);
        this.loadCards();
    }

    @Override
    public void showBillJDialog(int cardId) {
        BillDAO dao = new BillDAOImpl();
        Bill bill = dao.findServicingByCardId(cardId); // Lấy hóa đơn đang phục vụ theo thẻ
        BillJDialog dialog = new BillJDialog((Frame) this.getOwner(), true);
        dialog.setill(bill); 
        dialog.setVisible(true);
    }

    private void loadCards() { // Tải và hiển thị các thẻ lên giao diện
        CardDAO dao = new CardDAOImpl();
        List<Card> cards = dao.findAll();
        pnlCards.removeAll();
        cards.forEach(card -> pnlCards.add(this.createButton(card)));
        pnlCards.revalidate(); // Cập nhật lại panel
        pnlCards.repaint();    // Vẽ lại giao diện
    }

    private JButton createButton(Card card) { // Tạo JButton cho mỗi thẻ
        JButton btnCard = new JButton();
        btnCard.setText(String.format("Card #%d", card.getId()));
        btnCard.setPreferredSize(new Dimension(0, 80));
        btnCard.setEnabled(card.getStatus() == 1 || card.getStatus() == 3); // Chỉ bật nếu trạng thái là 1 (còn trống)
        
        // Set màu dựa vào trạng thái
        switch(card.getStatus()) {
            case 1: // Còn trống
                btnCard.setBackground(Color.GREEN);
                break;
            case 2: // Đang phục vụ
                btnCard.setBackground(Color.YELLOW);
                break;
            case 3: // Lỗi
                btnCard.setBackground(Color.RED);
                break;
            default:
                btnCard.setBackground(Color.GRAY);
        }
        
        btnCard.setActionCommand(String.valueOf(card.getId()));
        btnCard.addActionListener((ActionEvent e) -> {
            int cardId = Integer.parseInt(e.getActionCommand());
            SalesJDialog.this.showBillJDialog(cardId);
        });
        return btnCard;
    }

    private void startReloadTimer() {
        // Tạo timer để reload mỗi 5 giây
        reloadTimer = new Timer(100, (e) -> {
            loadCards();
        });
        reloadTimer.start();
    }

    @Override
    public void dispose() {
        if (reloadTimer != null) {
            reloadTimer.stop();
        }
        super.dispose();
    }
}



