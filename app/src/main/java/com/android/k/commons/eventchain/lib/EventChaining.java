package com.android.k.commons.eventchain.lib;

/**
 * Created by ken-maki on 2017/10/16.
 */

public interface EventChaining {

    /**
     * execute an event.
     *
     * @return returns true if it event succeeds.
     */
    boolean action();
}
