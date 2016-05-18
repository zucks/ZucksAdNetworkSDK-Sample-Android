package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.zucks.listener.AdBannerListener;
import net.zucks.view.AdBanner;

public class BannerCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_callback);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_banner);

        // 通常バナー テキスト
        TextView normal = new TextView(this);
        normal.setId(R.id.text_normal);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        normal.setLayoutParams(textParams);
        normal.setText("通常バナー");
        layout.addView(normal);

        // バナー本体
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
        params.addRule(RelativeLayout.BELOW, R.id.text_normal);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(adBanner);
        adBanner.load();

        // サイズアジャスト
        // サイズアジャスト テキスト
        TextView sizeAdjust = new TextView(this);
        sizeAdjust.setId(R.id.text_size_adjust);
        RelativeLayout.LayoutParams textParams2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams2.addRule(RelativeLayout.CENTER_VERTICAL);
        sizeAdjust.setLayoutParams(textParams2);
        sizeAdjust.setText("サイズアジャストバナー");
        layout.addView(sizeAdjust);

        // バナー本体
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
        params2.addRule(RelativeLayout.BELOW, R.id.text_size_adjust);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(sizeAdjustBanner);
        sizeAdjustBanner.load();
    }
}
