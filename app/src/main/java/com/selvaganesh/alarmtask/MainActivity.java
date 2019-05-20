package com.selvaganesh.alarmtask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_msg_1)
    TextView txtMsg1;

    public static final int NEW_ALARM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.create_alarm})
    public void mainOnClick(View view) {
        switch (view.getId()) {
            case R.id.create_alarm:
                Intent intent = new Intent(getApplicationContext(), IndicatorActivity.class);
                startActivityForResult(intent, NEW_ALARM);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == NEW_ALARM && data != null) {
            if (data.hasExtra(IndicatorActivity.NEW_ALARM_ADDED)
                    && data.getExtras().getBoolean(IndicatorActivity.NEW_ALARM_ADDED, false)) {
                String title = data.getExtras().getString(IndicatorActivity.STATE_TITLE);
                int hour = data.getExtras().getInt(IndicatorActivity.STATE_TIME_HOUR);
                int minutes = data.getExtras().getInt(IndicatorActivity.STATE_TIME_MINUTES);
                String time = ((hour > 9) ? hour : ("0" + hour))
                        + ":" + ((minutes > 9) ? minutes : ("0" + minutes));
                txtMsg1.setText("Alarm \"" + title + "\" set up at " + time);
            }
        }
    }
}
