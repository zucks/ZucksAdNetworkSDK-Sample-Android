package net.zucks.zucksadnetworksdk.sample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.zucks.listener.AdInterstitialListener;
import net.zucks.view.AdInterstitial;

public class InterstitialActivity extends AppCompatActivity {

    private AdInterstitial mAdInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        // 初期化およびコールバックの設定
        mAdInterstitial = new AdInterstitial(this, "_0c5006f5a8", new AdInterstitialListener() {
            @Override
            public void onReceiveAd() {
                // 広告のロードが成功した場合
                Toast.makeText(InterstitialActivity.this, "onReceiveAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShowAd() {
                // 広告が表示された場合
                Toast.makeText(InterstitialActivity.this, "onShowAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelDisplayRate() {
                // 広告が表示率でキャンセルされた場合
                Toast.makeText(InterstitialActivity.this, "onCancelDisplayRate", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTapAd() {
                // 広告がタップされた場合
                Toast.makeText(InterstitialActivity.this, "onTapAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCloseAd() {
                // 広告がクローズされた場合
                Toast.makeText(InterstitialActivity.this, "onCloseAd", Toast.LENGTH_SHORT).show();
                // 再ロード
                mAdInterstitial.load();
            }

            @Override
            public void onLoadFailure(Exception e) {
                // 広告のロードに失敗した場合
                Toast.makeText(InterstitialActivity.this, "onLoadFailure=" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShowFailure(Exception e) {
                // 広告の表示に失敗した場合
                Toast.makeText(InterstitialActivity.this, "onShowFailure=" + e.getMessage(), Toast.LENGTH_SHORT).show();
                // 再ロード
                mAdInterstitial.load();
            }
        });
        // 広告のロード
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
