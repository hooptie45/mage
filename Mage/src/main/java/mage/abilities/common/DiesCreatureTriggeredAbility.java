package mage.abilities.common;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.AnotherPredicate;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.ZoneChangeEvent;
import mage.target.targetpointer.FixedTarget;

/**
 * @author North
 */
public class DiesCreatureTriggeredAbility extends TriggeredAbilityImpl {

    protected FilterCreaturePermanent filter;
    private boolean setTargetPointer;

    public DiesCreatureTriggeredAbility(Effect effect, boolean optional) {
        this(effect, optional, new FilterCreaturePermanent("a creature"));
    }

    public DiesCreatureTriggeredAbility(Effect effect, boolean optional, boolean another) {
        this(effect, optional, new FilterCreaturePermanent(optional ? "another creature" : "a creature"));
        filter.add(new AnotherPredicate());
    }

    public DiesCreatureTriggeredAbility(Effect effect, boolean optional, boolean another, boolean setTargetPointer) {
        this(effect, optional, new FilterCreaturePermanent(optional ? "another creature" : "a creature"));
        filter.add(new AnotherPredicate());
        this.setTargetPointer = setTargetPointer;
    }

    public DiesCreatureTriggeredAbility(Effect effect, boolean optional, FilterCreaturePermanent filter) {
        this(effect, optional, filter, false);
    }

    public DiesCreatureTriggeredAbility(Effect effect, boolean optional, FilterCreaturePermanent filter, boolean setTargetPointer) {
        this(Zone.BATTLEFIELD, effect, optional, filter, setTargetPointer);
    }

    public DiesCreatureTriggeredAbility(Zone zone, Effect effect, boolean optional, FilterCreaturePermanent filter, boolean setTargetPointer) {
        super(zone, effect, optional);
        this.filter = filter;
        this.setTargetPointer = setTargetPointer;
    }

    public DiesCreatureTriggeredAbility(final DiesCreatureTriggeredAbility ability) {
        super(ability);
        this.filter = ability.filter;
        this.setTargetPointer = ability.setTargetPointer;
    }

    @Override
    public DiesCreatureTriggeredAbility copy() {
        return new DiesCreatureTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.ZONE_CHANGE;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        ZoneChangeEvent zEvent = (ZoneChangeEvent) event;
        if (zEvent.getFromZone().equals(Zone.BATTLEFIELD) && zEvent.getToZone().equals(Zone.GRAVEYARD)) {
            if (filter.match(zEvent.getTarget(), sourceId, controllerId, game)) {
                if (setTargetPointer) {
                    for (Effect effect : this.getEffects()) {
                        effect.setTargetPointer(new FixedTarget(event.getTargetId()));
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever " + filter.getMessage() + " dies, " + super.getRule();
    }
}
