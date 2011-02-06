/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

/*
 * NewPlayerPanel.java
 *
 * Created on 15-Dec-2009, 10:09:46 PM
 */

package mage.client.table;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import mage.client.MageFrame;
import mage.client.deck.generator.DeckGenerator;
import mage.client.util.Config;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class NewPlayerPanel extends javax.swing.JPanel {

	private JFileChooser fcSelectDeck;

    /** Creates new form NewPlayerPanel */
    public NewPlayerPanel() {
        initComponents();
		fcSelectDeck = new JFileChooser();
		fcSelectDeck.setAcceptAllFileFilterUsed(false);
		fcSelectDeck.addChoosableFileFilter(new DeckFilter());
		if (Config.defaultDeckPath != null) this.txtPlayerDeck.setText(Config.defaultDeckPath);
		if (Config.defaultComputerName != null) this.txtPlayerName.setText(Config.defaultComputerName);
    }

    public void setPlayerName(String playerName) {
		this.txtPlayerName.setText(playerName);
		this.txtPlayerName.setEditable(false);
		this.txtPlayerName.setEnabled(false);
    }

	protected void playerLoadDeck() {
		String lastFolder = MageFrame.getPreferences().get("lastDeckFolder", "");
		if (!lastFolder.isEmpty())
			fcSelectDeck.setCurrentDirectory(new File(lastFolder));
		int ret = fcSelectDeck.showDialog(this, "Select Deck");
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fcSelectDeck.getSelectedFile();
			this.txtPlayerDeck.setText(file.getPath());
			try {
				MageFrame.getPreferences().put("lastDeckFolder", file.getCanonicalPath());
			} catch (IOException ex) {	}
		}
		fcSelectDeck.setSelectedFile(null);
	}

	protected void generateDeck() {
		String path = DeckGenerator.generateDeck();
		if (path != null) {
			this.txtPlayerDeck.setText(path);
		}
	}
	
	public String getPlayerName() {
		return this.txtPlayerName.getText();
	}

	public String getDeckFile() {
		return this.txtPlayerDeck.getText();
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    // </editor-fold>                            
    private void initComponents() {

        lblPlayerName = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JTextField();
        lblPlayerDeck = new javax.swing.JLabel();
        txtPlayerDeck = new javax.swing.JTextField();
        btnPlayerDeck = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        
        lblPlayerName.setLabelFor(txtPlayerName);
        lblPlayerName.setText("Name:");

        lblPlayerDeck.setLabelFor(txtPlayerDeck);
        lblPlayerDeck.setText("Deck:");

        btnPlayerDeck.setText("...");
        btnPlayerDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerDeckActionPerformed(evt);
            }
        });
        
        btnGenerate.setText("Generate deck");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPlayerDeck))
                    .addComponent(lblPlayerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(txtPlayerDeck, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlayerDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            )
            .addComponent(btnGenerate)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayerName))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerDeck)
                    .addComponent(txtPlayerDeck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlayerDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
            	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(btnGenerate)
            	)
            )
        );
    }

	private void btnPlayerDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerDeckActionPerformed
		playerLoadDeck();
	}//GEN-LAST:event_btnPlayerDeckActionPerformed

	private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {
		generateDeck();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayerDeck;
    private javax.swing.JLabel lblPlayerDeck;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JTextField txtPlayerDeck;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JButton btnGenerate;
}

class DeckFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory())
			return true;

        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
		return (ext==null)?false:ext.equals("dck");
	}

	@Override
	public String getDescription() {
		return "Deck Files";
	}

}