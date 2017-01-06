package net.zucks.zucksadnetworksdk.sample.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bannerButton = (Button) findViewById(R.id.button_banner);
        bannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
            }
        });

        Button bannerButtonNocallback = (Button) findViewById(R.id.button_banner_nocallback);
        bannerButtonNocallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerNoCallbackActivity.class));
            }
        });

        Button bannerButtonCallback = (Button) findViewById(R.id.button_banner_callback);
        bannerButtonCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerCallbackActivity.class));
            }
        });

        Button interstitialButton = (Button) findViewById(R.id.button_interstitial);
        interstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InterstitialActivity.class));
            }
        });

        Button fullscreenBanner = (Button) findViewById(R.id.button_fullscreen_banner);
        fullscreenBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullscreenBannerActivity.class));
            }
        });

        Button fullscreenBannerCallback = (Button) findViewById(R.id.button_fullscreen_banner_callback);
        fullscreenBannerCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullscreenBannerCallbackActivity.class));
            }
        });

        Button fullscreenInterstitialButton = (Button) findViewById(R.id.button_fullscreen_interstitial);
        fullscreenInterstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullscreenInterstitialActivity.class));
            }
        });

    }
}
