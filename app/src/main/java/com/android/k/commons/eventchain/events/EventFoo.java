package com.android.k.commons.eventchain.events;

import android.content.Context;
import android.widget.Toast;

import com.android.k.commons.eventchain.lib.EventChaining;

/**
 * Created by ken-maki on 2017/10/16.
 */

public class EventFoo implements EventChaining {
    Context mContext;

    public EventFoo(final Context context) {
        mContext = context;
    }

    @Override
    public boolean action() {
        Toast.makeText(mContext, "EventFoo executed.", Toast.LENGTH_SHORT).show();
        return true;
    }
}
