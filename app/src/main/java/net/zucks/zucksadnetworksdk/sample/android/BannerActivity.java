package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.zucks.listener.AdBannerListener;
import net.zucks.view.AdBanner;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_banner);

        // コードで記述する場合（コールバックなし）
        AdBanner banner = new AdBanner(this, "_833b45aa06");
        layout.addView(banner);
        banner.load();

        // コードで記述する場合（コールバックあり）
        AdBanner adBanner = new AdBanner(this, "_833b45aa06", new AdBannerListener() {
            @Override
            public void onReceiveAd(AdBanner adBanner) {
                // 広告の取得が完了した場合
                Toast.makeText(BannerActivity.this, "onReceiveAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTapAd(AdBanner adBanner) {
                // 広告がタップされた場合
                Toast.makeText(BannerActivity.this, "onTapAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(AdBanner adBanner, Exception e) {
                // 広告の取得に失敗した場合
                Toast.makeText(BannerActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
        layout.addView(adBanner);
        adBanner.load();
    }
}
