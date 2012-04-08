/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 * 
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 * 
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 * 
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

/*
 * TablePlayerPanel.java
 *
 * Created on 9-May-2010, 11:43:03 AM
 */

package mage.client.table;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import mage.client.MageFrame;
import mage.cards.decks.importer.DeckImporterUtil;
import mage.client.util.Config;
import mage.client.util.Event;
import mage.client.util.Listener;
import mage.remote.Session;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class TablePlayerPanel extends javax.swing.JPanel {

	protected PlayerTypeEventSource playerTypeEventSource = new PlayerTypeEventSource();

	private Session session;

    /** Creates new form TablePlayerPanel */
    public TablePlayerPanel() {
        initComponents();
		this.newPlayerPanel.setVisible(false);
    }

	public void init(int playerNum) {
		session = MageFrame.getSession();
		cbPlayerType.setModel(new DefaultComboBoxModel(session.getPlayerTypes()));
		this.lblPlayerNum.setText("Player " + playerNum);
		if (Config.defaultOtherPlayerIndex != null) {
			if (Integer.valueOf(Config.defaultOtherPlayerIndex) >= cbPlayerType.getItemCount())
				cbPlayerType.setSelectedIndex(cbPlayerType.getItemCount() - 1);
			else {
				Integer index = Integer.parseInt(Config.defaultOtherPlayerIndex); 
				cbPlayerType.setSelectedIndex(index);
			}
		}
	}

	public boolean joinTable(UUID roomId, UUID tableId) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (!this.cbPlayerType.getSelectedItem().equals("Human")) {
			return session.joinTable(roomId, tableId, this.newPlayerPanel.getPlayerName(), (String)this.cbPlayerType.getSelectedItem(), this.newPlayerPanel.getLevel(), DeckImporterUtil.importDeck(this.newPlayerPanel.getDeckFile()));
 		}
		return true;
	}

	public String getPlayerType() {
		return (String) this.cbPlayerType.getSelectedItem();
	}

	public void addPlayerTypeEventListener(Listener<Event> listener) {
		playerTypeEventSource.addListener(listener);
	}

	public void clearPlayerTypeEventListeners() {
		playerTypeEventSource.clearListeners();
	}


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPlayerType = new javax.swing.JLabel();
        cbPlayerType = new javax.swing.JComboBox();
        newPlayerPanel = new mage.client.table.NewPlayerPanel();
        lblPlayerNum = new javax.swing.JLabel();

        lbPlayerType.setText("Type:");

        cbPlayerType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlayerTypeActionPerformed(evt);
            }
        });

        lblPlayerNum.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblPlayerNum.setText("Player #");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayerNum)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPlayerType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPlayerType, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPlayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlayerNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPlayerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPlayerType)))
                    .addComponent(newPlayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void cbPlayerTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlayerTypeActionPerformed
		if (!this.cbPlayerType.getSelectedItem().equals("Human")) {
			this.newPlayerPanel.setVisible(true);
		}
		else {
			this.newPlayerPanel.setVisible(false);
		}
		this.revalidate();
		this.repaint();
		this.playerTypeEventSource.playerTypeChanged();
	}//GEN-LAST:event_cbPlayerTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbPlayerType;
    private javax.swing.JLabel lbPlayerType;
    private javax.swing.JLabel lblPlayerNum;
    private mage.client.table.NewPlayerPanel newPlayerPanel;
    // End of variables declaration//GEN-END:variables

}
