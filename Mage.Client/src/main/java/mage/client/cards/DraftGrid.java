/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DraftGrid.java
 *
 * Created on 7-Jan-2011, 6:23:39 PM
 */

package mage.client.cards;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.UUID;
import mage.cards.MageCard;
import mage.client.MageFrame;
import mage.client.plugins.impl.Plugins;
import mage.client.util.Config;
import mage.view.CardView;
import mage.view.CardsView;
import mage.client.util.Event;
import mage.client.util.Listener;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class DraftGrid extends javax.swing.JPanel implements MouseListener {

	protected CardEventSource cardEventSource = new CardEventSource();
	protected BigCard bigCard;

    /** Creates new form DraftGrid */
    public DraftGrid() {
        initComponents();
    }

	public void loadBooster(CardsView booster, BigCard bigCard) {
		this.bigCard = bigCard;
		this.removeAll();
		int numColumns = 5;
		int curColumn = 0;
		int curRow = 0;
		Rectangle rectangle = new Rectangle(Config.dimensions.frameWidth, Config.dimensions.frameHeight);
		for (CardView card: booster.values()) {
			MageCard cardImg = Plugins.getInstance().getMageCard(card, bigCard, Config.dimensions, null);
			cardImg.addMouseListener(this);
			add(cardImg);
			cardImg.update(card);
			rectangle.setLocation(curColumn * Config.dimensions.frameWidth, curRow * Config.dimensions.frameHeight);
			cardImg.setBounds(rectangle);
			cardImg.setCardBounds(rectangle.x, rectangle.y, Config.dimensions.frameWidth, Config.dimensions.frameHeight);
			curColumn++;
			if (curColumn == numColumns) {
				curColumn = 0;
				curRow++;
			}
		}
		
	}

	public void addCardEventListener(Listener<Event> listener) {
		cardEventSource.addListener(listener);
	}

	public void clearCardEventListeners() {
		cardEventSource.clearListeners();
	}


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();
			Object obj = e.getSource();
			if (obj instanceof MageCard) {
				this.cardEventSource.doubleClick(((MageCard)obj).getOriginal().getId(), "double-click");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
