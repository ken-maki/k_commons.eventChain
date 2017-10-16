package com.android.k.commons.eventchain.lib;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ken-maki on 2017/10/16.
 */

public class EventChainManager {

    List<Pair<EventChaining, Boolean>> mEvents = new ArrayList<Pair<EventChaining, Boolean>>();

    /**
     * add event.
     * <p>
     * added event is serial executed.if event failed, break execute.
     * </p>
     *
     * @param event executable event
     * @return this EventChainManager instance
     */
    public EventChainManager chain(final EventChaining event) {
        mEvents.add(Pair.create(event, false));
        return this;
    }

    /**
     * add event.
     * <p>
     * added event is serial executed.if event failed,  forward next event.
     * </p>
     *
     * @param event executable event
     * @return this EventChainManager instance
     */
    public EventChainManager chainForce(final EventChaining event) {
        mEvents.add(Pair.create(event, true));
        return this;
    }

    /**
     * execute chain events.
     * <p>
     * delete the event after execution
     * </p>
     *
     * @return returns true if it event all succeeds.
     */
    public boolean execute() {
        boolean result = executeAndLeave();
        removeAll();

        return result;
    }

    /**
     * execute chain events.
     * <p>
     * leave the event after execution
     * </p>
     *
     * @return returns true if it event all succeeds.
     */
    public boolean executeAndLeave() {
        for (Pair<EventChaining, Boolean> event : mEvents) {
            EventChaining chainEvent = event.first;
            boolean isForced = event.second;
            if (!chainEvent.action() && !isForced) {
                return false;
            }
        }

        return true;
    }

    /**
     * remove all added Event.
     *
     * @param event event to removed
     */
    public void remove(final EventChaining event) {
        mEvents.remove(event);
    }

    /**
     * remove all added Events.
     */
    public void removeAll() {
        mEvents.clear();
    }
}
