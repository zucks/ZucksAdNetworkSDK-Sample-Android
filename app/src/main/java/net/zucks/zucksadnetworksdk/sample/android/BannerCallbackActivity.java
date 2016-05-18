package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.zucks.listener.AdBannerListener;
import net.zucks.view.AdBanner;

public class BannerCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_callback);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_banner);

        // コードで記述する場合（コールバックあり）
        // 管理画面から取得したFrame IDを設定してください
        AdBanner adBanner = new AdBanner(this, "_833b45aa06", new AdBannerListener() {
            @Override
            public void onReceiveAd(AdBanner adBanner) {
                // 広告情報のロードが成功した場合
                Toast.makeText(BannerCallbackActivity.this, "onReceiveAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTapAd(AdBanner adBanner) {
                // 広告がタップされた場合
                Toast.makeText(BannerCallbackActivity.this, "onTapAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(AdBanner adBanner, Exception e) {
                // 広告情報のロードに失敗した場合
                Toast.makeText(BannerCallbackActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });

        // ページ上部中央に寄せて配置する
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) adBanner.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(adBanner);
        adBanner.load();

        // サイズアジャスト
        AdBanner sizeAdjustBanner = new AdBanner(this, "_833b45aa06", new AdBannerListener() {
            @Override
            public void onReceiveAd(AdBanner adBanner) {
                // 広告情報のロードが成功した場合
                Toast.makeText(BannerCallbackActivity.this, "onReceiveAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTapAd(AdBanner adBanner) {
                // 広告がタップされた場合
                Toast.makeText(BannerCallbackActivity.this, "onTapAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(AdBanner adBanner, Exception e) {
                // 広告情報のロードに失敗した場合
                Toast.makeText(BannerCallbackActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        }, true);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) sizeAdjustBanner.getLayoutParams();
        params2.addRule(RelativeLayout.CENTER_VERTICAL);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(sizeAdjustBanner);
        sizeAdjustBanner.load();
    }
}
