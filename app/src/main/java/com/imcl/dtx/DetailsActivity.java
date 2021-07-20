package com.imcl.dtx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imcl.dtx.HelperClasses.adapterphone;
import com.imcl.dtx.HelperClasses.phonehelper;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements adapterphone.ListItemClickListener {

    RecyclerView screensRecycler;
    RecyclerView.Adapter adapter;

    ImageView appIconImageView;
    TextView appTitleTextView;
    TextView appSubtitleTextView;
    TextView descriptionTextView;
    TextView goldenTimeLossTextView;
    TextView goldenTimeControlTextView;
    TextView goldenTimeAdditionalTextView;

    Button button;

    SharedPreferences configPrefs;

    String app;
    String packageName;
    String title;
    String subtitle;
    String description;
    String link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        appIconImageView = findViewById(R.id.detailsAppIconImageView);
        appTitleTextView = findViewById(R.id.detailsAppTitleTextView);
        appSubtitleTextView = findViewById(R.id.detailsSubtitleTextView);
        descriptionTextView = findViewById(R.id.detailsDescriptionTextView);
        goldenTimeLossTextView = findViewById(R.id.goldenTimeAdditionalTextLoss);
        goldenTimeControlTextView = findViewById(R.id.goldenTimeAdditionalTextControl);
        goldenTimeAdditionalTextView = findViewById(R.id.goldenTimeAdditionalText);

        button = findViewById(R.id.detailsButton);

        configPrefs = getApplicationContext().getSharedPreferences("Configurations", MODE_PRIVATE);
        app = configPrefs.getString("app", "null");

        switch (app) {
            case "MindScope":
                packageName = getString(R.string.mindscope_package_name);
                appIconImageView.setImageResource(R.drawable.mindscope_icon);
                title = getString(R.string.mindscope_title);
                subtitle = getString(R.string.mindscope_subtitle);
                description = getString(R.string.mindscope_description);
                link = getString(R.string.mindscope_link);
                break;
            case "FocusAid":
                packageName = getString(R.string.focusaid_package_name);
                appIconImageView.setImageResource(R.drawable.focus_aid_icon);
                title = getString(R.string.focusaid_title);
                subtitle = getString(R.string.focusaid_subtitle);
                description = getString(R.string.focusaid_description);
                link = getString(R.string.focusaid_link);
                break;
            case "GoldenTime":
                packageName = getString(R.string.goldentime_package_name);
                appIconImageView.setImageResource(R.drawable.goldentime_icon);
                title = getString(R.string.goldentime_title);
                subtitle = getString(R.string.goldentime_subtitle);
                description = getString(R.string.goldentime_description);
                link = getString(R.string.goldentime_link);
                goldenTimeControlTextView.setMovementMethod(LinkMovementMethod.getInstance());
                goldenTimeLossTextView.setMovementMethod(LinkMovementMethod.getInstance());
                goldenTimeControlTextView.setVisibility(View.VISIBLE);
                goldenTimeLossTextView.setVisibility(View.VISIBLE);
                goldenTimeAdditionalTextView.setVisibility(View.VISIBLE);
                break;
            case "BeActive":
                packageName = getString(R.string.beactive_package_name);
                appIconImageView.setImageResource(R.drawable.be_active_logo);
                title = getString(R.string.beactive_title);
                subtitle = getString(R.string.beactive_subtitle);
                description = getString(R.string.beactive_description);
                link = getString(R.string.beactive_link);
                break;
            case "MyButler":
                packageName = getString(R.string.mybutler_package_name);
                appIconImageView.setImageResource(R.drawable.mybutler_logo);
                title = getString(R.string.mybutler_title);
                subtitle = getString(R.string.mybutler_subtitle);
                description = getString(R.string.mybutler_description);
                link = getString(R.string.mybutler_link);
                break;
            case "RoutinAid":
                packageName = getString(R.string.routineaid_package_name);
                appIconImageView.setImageResource(R.drawable.routinaid_icon);
                title = getString(R.string.routineaid_title);
                subtitle = getString(R.string.routineaid_subtitle);
                description = getString(R.string.routineaid_description);
                link = getString(R.string.routineaid_link);
                break;
            default:
                packageName = getString(R.string.mindscope_package_name);
                appIconImageView.setImageResource(R.drawable.mindscope_icon);
                title = getString(R.string.mindscope_title);
                subtitle = getString(R.string.mindscope_subtitle);
                description = getString(R.string.mindscope_description);
                link = getString(R.string.mindscope_link);
                break;
        }


        if (Utils.isPackageInstalled(packageName, getApplicationContext().getPackageManager())) {
            button.setText(getString(R.string.open));
        } else {
            button.setText(getString(R.string.get));
        }

        appTitleTextView.setText(title);
        appSubtitleTextView.setText(subtitle);
        descriptionTextView.setText(description);

        screensRecycler = findViewById(R.id.my_recycler);
        screensRecycler();
    }

    private void screensRecycler() {
        screensRecycler.setHasFixedSize(true);
        screensRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();


        switch (title) {
            case "MindScope":
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen1));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen2));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen3));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen4));
                break;
            case "FocusAid":
                phonelocations.add(new phonehelper(R.drawable.focus_screen1));
                phonelocations.add(new phonehelper(R.drawable.focus_screen2));
                phonelocations.add(new phonehelper(R.drawable.focus_screen3));
                phonelocations.add(new phonehelper(R.drawable.focus_screen4));
                break;
            case "GoldenTime":
                phonelocations.add(new phonehelper(R.drawable.golden_screen1));
                phonelocations.add(new phonehelper(R.drawable.golden_screen2));
                break;
            case "BeActive":
                phonelocations.add(new phonehelper(R.drawable.beactive_screen1));
                phonelocations.add(new phonehelper(R.drawable.beactive_screen2));
                phonelocations.add(new phonehelper(R.drawable.beactive_screen3));
                break;
            case "MyButler":
                phonelocations.add(new phonehelper(R.drawable.mybutler_screen1));
                break;
            case "RoutinAid":
                phonelocations.add(new phonehelper(R.drawable.routin_screen1));
                phonelocations.add(new phonehelper(R.drawable.routin_screen2));
                phonelocations.add(new phonehelper(R.drawable.routin_screen3));
                phonelocations.add(new phonehelper(R.drawable.routin_screen4));
                break;
            default:
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen1));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen2));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen3));
                phonelocations.add(new phonehelper(R.drawable.mindscope_screen4));
                break;
        }

        adapter = new adapterphone(phonelocations, this);
        screensRecycler.setAdapter(adapter);

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onButtonClicked(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (button.getText().equals(getString(R.string.get))) {
            startActivity(browserIntent);
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                startActivity(browserIntent);
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (Utils.isPackageInstalled(packageName, getApplicationContext().getPackageManager())) {
            button.setText(getString(R.string.open));
        } else {
            button.setText(getString(R.string.get));
        }
    }
}
