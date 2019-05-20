package com.selvaganesh.alarmtask;

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
    @BindView(R.id.txt_msg_2)
    TextView txtMsg2;

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
                break;
        }
    }
}
