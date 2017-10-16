package com.android.k.commons.eventchain.events;

import android.content.Context;
import android.widget.Toast;

import com.android.k.commons.eventchain.lib.EventChaining;

/**
 * Created by ken-maki on 2017/10/16.
 */

public class EventBaz implements EventChaining {
    Context mContext;

    public EventBaz(final Context context) {
        mContext = context;
    }

    @Override
    public boolean action() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            return false;
        }
        Toast.makeText(mContext, "EventBaz executed.", Toast.LENGTH_SHORT).show();
        return true;
    }
}
