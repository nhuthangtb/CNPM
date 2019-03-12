package com.cnpm.letcook.View;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cnpm.letcook.Controller.MainActivityController;
import com.cnpm.letcook.R;

import org.w3c.dom.Text;

public class FlashScreenActivity extends AppCompatActivity {

    TextView txtVersion, txtDeverlopTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flashscreen);
        txtVersion = findViewById(R.id.txtVersion);
        txtDeverlopTeam = findViewById(R.id.txtDeverlopTeam);
        txtDeverlopTeam.setText("Power by" + getString(R.string.team));
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            txtVersion.setText(getString(R.string.version) + " " + packageInfo.versionName);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent iLogin = new Intent(FlashScreenActivity.this,LoginActivity.class);
                    startActivity(iLogin);
                    finish();
                }
            },3000);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
