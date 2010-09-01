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

package mage.game;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mage.cards.Card;
import mage.game.events.GameEvent;
import mage.util.Copyable;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class Exile implements Serializable, Copyable<Exile> {

	private static final UUID PERMANENT = UUID.randomUUID();

	private Map<UUID, ExileZone> exileZones = new HashMap<UUID, ExileZone>();

	public Exile() {
		createZone(PERMANENT, "Permanent");
	}

	public Exile(final Exile exile) {
		for (UUID exileId: exile.exileZones.keySet()) {
			exileZones.put(exileId, exile.exileZones.get(exileId).copy());
		}
	}

	public Collection<ExileZone> getExileZones() {
		return exileZones.values();
	}

	public ExileZone getPermanentExile() {
		return exileZones.get(PERMANENT);
	}
	
	public ExileZone createZone(UUID id, String name) {
		return createZone(id, name + " - Exile", false);
	}

	public ExileZone createZone(UUID id, String name, boolean hidden) {
		if (!exileZones.containsKey(id)) {
			ExileZone exile = new ExileZone(id, name, hidden);
			exileZones.put(id, exile);
		}
		return exileZones.get(id);
	}

	public ExileZone getExileZone(UUID id) {
		return exileZones.get(id);
	}

	public void checkTriggers(GameEvent event, Game game) {
		for (ExileZone exile: exileZones.values()) {
			exile.checkTriggers(event, game);
		}
	}

	public Card getCard(UUID cardId, Game game) {
		for (ExileZone exile: exileZones.values()) {
			if (exile.contains(cardId))
				return game.getCard(cardId);
		}
		return null;
	}

	@Override
	public Exile copy() {
		return new Exile(this);
	}
}
