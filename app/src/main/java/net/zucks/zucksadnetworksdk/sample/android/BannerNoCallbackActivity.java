package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import net.zucks.view.AdBanner;

public class BannerNoCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_no_callback);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_banner);

        // コードで記述する場合（コールバックなし）
        // 管理画面から取得したFrame IDを設定してください
        AdBanner banner = new AdBanner(this, "_833b45aa06");

        // ページ上部中央に寄せて配置する
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) banner.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(banner);
        banner.load();

        // サイズアジャスト
        AdBanner sizeAdjustBanner = new AdBanner(this, "_833b45aa06", true);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) sizeAdjustBanner.getLayoutParams();
        params2.addRule(RelativeLayout.CENTER_VERTICAL);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(sizeAdjustBanner);
        sizeAdjustBanner.load();
    }
}
