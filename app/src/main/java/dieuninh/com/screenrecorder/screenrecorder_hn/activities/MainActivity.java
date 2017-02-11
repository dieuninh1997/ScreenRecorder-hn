package dieuninh.com.screenrecorder.screenrecorder_hn.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import dieuninh.com.screenrecorder.screenrecorder_hn.R;

public class MainActivity extends AppCompatActivity {

    private CardView cv_record_start, cv_record_stop, cv_stored_video, cv_settings;
    private TextView txv_thongbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventClick();

    }

    private void eventClick() {
        cv_record_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_record_start.setVisibility(View.GONE);
                cv_record_stop.setVisibility(View.VISIBLE);
                txv_thongbao.setText(getString(R.string.thong_bao_is_running));
            }
        });

        cv_record_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_record_start.setVisibility(View.VISIBLE);
                cv_record_stop.setVisibility(View.GONE);
                txv_thongbao.setText(getString(R.string.thong_bao_has_stop));
            }
        });
        cv_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        cv_stored_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListVideoActivity.class));
            }
        });

    }

    private void init() {
        cv_record_start = (CardView) findViewById(R.id.cv_record_start);
        cv_record_stop = (CardView) findViewById(R.id.cv_record_stop);
        cv_stored_video = (CardView) findViewById(R.id.cv_stored_video);
        cv_settings = (CardView) findViewById(R.id.cv_settings);
        txv_thongbao= (TextView) findViewById(R.id.txv_thongbao);
    }
}

