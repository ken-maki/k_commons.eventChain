package com.android.k.commons.eventchain.events;

import android.content.Context;
import android.widget.Toast;

import com.android.k.commons.eventchain.lib.EventChaining;

/**
 * Created by ken-maki on 2017/10/16.
 */

public class EventBar implements EventChaining {
    Context mContext;

    public EventBar(final Context context) {
        mContext = context;
    }

    @Override
    public boolean action() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            return false;
        }
        Toast.makeText(mContext, "EventBar executed.", Toast.LENGTH_SHORT).show();
        return false;
    }
}
