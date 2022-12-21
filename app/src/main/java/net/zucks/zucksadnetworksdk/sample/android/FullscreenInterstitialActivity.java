package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.zucks.listener.AdFullscreenInterstitialListener;
import net.zucks.view.AdFullscreenInterstitial;

public class FullscreenInterstitialActivity extends AppCompatActivity {

    private AdFullscreenInterstitial mAdInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_interstitial);

        this.mAdInterstitial = new AdFullscreenInterstitial(this, "_3f0019f713", new AdFullscreenInterstitialListener() {
            @Override
            public void onReceiveAd() {
                super.onReceiveAd();
            }

            @Override
            public void onShowAd() {
                super.onShowAd();
            }

            @Override
            public void onCancelDisplayRate() {
                super.onCancelDisplayRate();
            }

            @Override
            public void onTapAd() {
                super.onTapAd();
            }

            @Override
            public void onCloseAd() {
                super.onCloseAd();
            }

            @Override
            public void onLoadFailure(Exception e) {
                super.onLoadFailure(e);
            }

            @Override
            public void onShowFailure(Exception e) {
                super.onShowFailure(e);
            }
        });

        // 広告情報のロード
        mAdInterstitial.load();

        // 表示ボタンの設定
        Button button = (Button) findViewById(R.id.button_show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 広告の表示
                mAdInterstitial.show();
            }
        });
    }
}
