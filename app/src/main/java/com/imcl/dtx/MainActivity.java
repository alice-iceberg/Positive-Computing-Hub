package com.imcl.dtx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mindscopeButton;
    Button focusAidButton;
    Button goldenTimeButton;
    Button beActiveButton;
    Button stressTrendmeterButton;
    Button routinAidButton;

    SharedPreferences configPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configPrefs = getSharedPreferences("Configurations", MODE_PRIVATE);

        mindscopeButton = findViewById(R.id.getOpenMainMindScopeBtn);
        focusAidButton = findViewById(R.id.getOpenMainFocusAidBtn);
        goldenTimeButton = findViewById(R.id.getOpenMainGoldenTimeBtn);
        beActiveButton = findViewById(R.id.getOpenMainBeActiveBtn);
        stressTrendmeterButton = findViewById(R.id.getOpenMainStressTrendmeterBtn);
        routinAidButton = findViewById(R.id.getOpenMainRoutinAidBtn);

        if (Utils.isPackageInstalled(getString(R.string.mindscope_package_name), getApplicationContext().getPackageManager())) {
            mindscopeButton.setText(getString(R.string.open));
        } else {
            mindscopeButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.focusaid_package_name), getApplicationContext().getPackageManager())) {
            focusAidButton.setText(getString(R.string.open));
        } else {
            focusAidButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.goldentime_package_name), getApplicationContext().getPackageManager())) {
            goldenTimeButton.setText(getString(R.string.open));
        } else {
            goldenTimeButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.beactive_package_name), getApplicationContext().getPackageManager())) {
            beActiveButton.setText(getString(R.string.open));
        } else {
            beActiveButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.stresstrendmeter_package_name), getApplicationContext().getPackageManager())) {
            stressTrendmeterButton.setText(getString(R.string.open));
        } else {
            stressTrendmeterButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.routineaid_package_name), getApplicationContext().getPackageManager())) {
            routinAidButton.setText(getString(R.string.open));
        } else {
            routinAidButton.setText(getString(R.string.get));
        }



    }

    public void onGetOpenMindscopeClick(View view) {
        String link = getString(R.string.mindscope_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (mindscopeButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.mindscope_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewMindscopeClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.mindscope_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onGetOpenFocusAidClick(View view) {
        String link = getString(R.string.focusaid_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (focusAidButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.focusaid_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewFocusAidClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.focusaid_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onGetOpenGoldenTimeClick(View view) {
        String link = getString(R.string.goldentime_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (goldenTimeButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.goldentime_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewGoldenTimeClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.goldentime_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onGetOpenBeActiveClick(View view) {
        String link = getString(R.string.beactive_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (beActiveButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.beactive_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewBeActiveClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.beactive_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onGetOpenStressTrendmeterClick(View view) {
        String link = getString(R.string.stresstrendmeter_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (stressTrendmeterButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.stresstrendmeter_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewStressTrendmeterClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.stresstrendmeter_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onGetOpenRoutinAidClick(View view) {
        String link = getString(R.string.routineaid_link);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (routinAidButton.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.routineaid_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }
    public void onViewRoutinAidClick(View view) {
        SharedPreferences.Editor editor = configPrefs.edit();
        editor.putString("app", getString(R.string.routineaid_title));
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (Utils.isPackageInstalled(getString(R.string.mindscope_package_name), getApplicationContext().getPackageManager())) {
            mindscopeButton.setText(getString(R.string.open));
        } else {
            mindscopeButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.focusaid_package_name), getApplicationContext().getPackageManager())) {
            focusAidButton.setText(getString(R.string.open));
        } else {
            focusAidButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.goldentime_package_name), getApplicationContext().getPackageManager())) {
            goldenTimeButton.setText(getString(R.string.open));
        } else {
            goldenTimeButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.beactive_package_name), getApplicationContext().getPackageManager())) {
            beActiveButton.setText(getString(R.string.open));
        } else {
            beActiveButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.stresstrendmeter_package_name), getApplicationContext().getPackageManager())) {
            stressTrendmeterButton.setText(getString(R.string.open));
        } else {
            stressTrendmeterButton.setText(getString(R.string.get));
        }
        if (Utils.isPackageInstalled(getString(R.string.routineaid_package_name), getApplicationContext().getPackageManager())) {
            routinAidButton.setText(getString(R.string.open));
        } else {
            routinAidButton.setText(getString(R.string.get));
        }
    }
}