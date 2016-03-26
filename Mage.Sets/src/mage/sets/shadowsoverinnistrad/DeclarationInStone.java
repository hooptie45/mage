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
package mage.sets.shadowsoverinnistrad;

import java.util.UUID;
import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.game.permanent.token.ClueArtifactToken;
import mage.game.permanent.token.Token;
import mage.players.Player;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author escplan9 (Derek Monturo - dmontur1 at gmail dot com)
 */
public class DeclarationInStone extends CardImpl {
    
    public DeclarationInStone(UUID ownerId) {
        super(ownerId, 12, "Declaration in Stone", Rarity.RARE, new CardType[]{CardType.SORCERY}, "{1}{W}");
        this.expansionSetCode = "SOI";

        // Exile target creature and all other creatures its controller controls with the same name as that creature.
        // That player investigates for each nontoken creature exiled this way.
        this.getSpellAbility().addEffect(new DeclarationInStoneEffect());
        this.getSpellAbility().addTarget(new TargetCreaturePermanent());        
    }

    public DeclarationInStone(final DeclarationInStone card) {
        super(card);
    }

    @Override
    public DeclarationInStone copy() {
        return new DeclarationInStone(this);
    }
}

class DeclarationInStoneEffect extends OneShotEffect {

    public DeclarationInStoneEffect() {
        super(Outcome.Exile);
        staticText = "Exile target creature and all other creatures its controller controls with the same name as that creature. That player investigates for each nontoken creature exiled this way.";
    }

    public DeclarationInStoneEffect(final DeclarationInStoneEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        UUID exileId = source.getSourceId();
        Permanent targetPermanent = game.getPermanent(getTargetPointer().getFirst(game, source));
        if (targetPermanent != null) {
            UUID controllerPermanentId = targetPermanent.getControllerId();
            Player you = game.getPlayer(source.getControllerId());
            MageObject sourceObject = game.getObject(source.getSourceId());
            if (sourceObject != null && exileId != null && you != null) {

                int exiledCount = 0;
                if (targetPermanent.getName().isEmpty()) { // face down creature
                    you.moveCardToExileWithInfo(targetPermanent, exileId, sourceObject.getIdName(), source.getSourceId(), game, Zone.BATTLEFIELD, true);
                    exiledCount = 1; // will always be 1 with a face down creature (has no name)
                } else {
                    String name = targetPermanent.getName();
                    for (Permanent permanent : game.getBattlefield().getAllActivePermanents(controllerPermanentId)) {
                        if (permanent != null && permanent.getName().equals(name)) {
                            you.moveCardToExileWithInfo(permanent, exileId, sourceObject.getIdName(), source.getSourceId(), game, Zone.BATTLEFIELD, true);
                            exiledCount++;
                        }
                    }
                }
                
                if (exiledCount > 0) {
                    Token token = new ClueArtifactToken();
                    token.putOntoBattlefield(exiledCount, game, source.getSourceId(), controllerPermanentId, false, false);
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public DeclarationInStoneEffect copy() {
        return new DeclarationInStoneEffect(this);
    }
}

/*
class ClueArtifactToken extends Token {

    ClueArtifactToken() {
        super("Clue", "colorless Clue artifact token onto the battlefield with \"{2}, Sacrifice this artifact: Draw a card.\"");
        this.setOriginalExpansionSetCode("SOI");
        this.cardType.add(CardType.ARTIFACT);
        this.subtype.add("Clue");

        // {2}, Sacrifice this artifact: Draw a card.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DrawCardSourceControllerEffect(1), new GenericManaCost(2));
        SacrificeSourceCost cost = new SacrificeSourceCost();
        cost.setText("Sacrifice this artifact");
        ability.addCost(cost);
        this.addAbility(ability);
    }
}
*/