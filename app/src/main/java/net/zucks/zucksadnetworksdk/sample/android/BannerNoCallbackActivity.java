package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.zucks.view.AdBanner;

public class BannerNoCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_no_callback);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_banner);

        // 通常バナー テキスト
        TextView normal = new TextView(this);
        normal.setId(R.id.text_normal);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        normal.setLayoutParams(textParams);
        normal.setText("通常バナー");
        layout.addView(normal);

        // 通常バナー 本体
        // コードで記述する場合（コールバックなし）
        // 管理画面から取得したFrame IDを設定してください
        AdBanner banner = new AdBanner(this, "_833b45aa06");

        // ページ上部中央に寄せて配置する
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) banner.getLayoutParams();
        params.addRule(RelativeLayout.BELOW, R.id.text_normal);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(banner);
        banner.load();

        // サイズアジャスト
        // サイズアジャスト テキスト
        TextView sizeAdjust = new TextView(this);
        sizeAdjust.setId(R.id.text_size_adjust);
        RelativeLayout.LayoutParams textParams2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams2.addRule(RelativeLayout.CENTER_VERTICAL);
        sizeAdjust.setLayoutParams(textParams2);
        sizeAdjust.setText("サイズアジャストバナー");
        layout.addView(sizeAdjust);

        // サイズアジャスト 本体
        // コードで記述する場合（コールバックなし）
        // 管理画面から取得したFrame IDを設定してください
        AdBanner sizeAdjustBanner = new AdBanner(this, "_833b45aa06", true);

        // ページ中央に寄せて配置する
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) sizeAdjustBanner.getLayoutParams();
        params2.addRule(RelativeLayout.BELOW, R.id.text_size_adjust);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(sizeAdjustBanner);
        sizeAdjustBanner.load();
    }
}
