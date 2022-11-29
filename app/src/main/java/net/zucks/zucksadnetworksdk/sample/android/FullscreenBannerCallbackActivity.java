package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RelativeLayout;

import net.zucks.listener.AdFullscreenBannerListener;
import net.zucks.view.AdFullscreenBanner;

public class FullscreenBannerCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_banner_callback);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_fullscreen_banner_callback);

        AdFullscreenBanner adFullscreenBanner = new AdFullscreenBanner(this, "_837f1ac3ed", new AdFullscreenBannerListener() {
            @Override
            public void onReceiveAd(AdFullscreenBanner fullscreenBanner) {
                super.onReceiveAd(fullscreenBanner);
            }

            @Override
            public void onTapAd(AdFullscreenBanner fullscreenBanner) {
                super.onTapAd(fullscreenBanner);
            }

            @Override
            public void onFailure(AdFullscreenBanner fullscreenBanner, Exception e) {
                super.onFailure(fullscreenBanner, e);
            }
        });
        layout.addView(adFullscreenBanner);
        adFullscreenBanner.load();
    }
}
