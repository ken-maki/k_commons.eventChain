package com.android.k.commons.eventchain;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.k.commons.eventchain.events.EventBar;
import com.android.k.commons.eventchain.events.EventBaz;
import com.android.k.commons.eventchain.events.EventFoo;
import com.android.k.commons.eventchain.lib.EventChainManager;

public class MainActivity extends AppCompatActivity {

    EventChainManager eventChainManager = new EventChainManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventChainManager
                        .chain(new EventFoo(context))
                        .chainForce(new EventBar(context))
                        .chain(new EventBaz(context))
                        .execute();
            }
        });


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventChainManager
                        .chain(new EventFoo(context))
                        .chain(new EventBar(context))
                        .chain(new EventBaz(context))
                        .execute();
            }
        });
    }
}
