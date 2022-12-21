package net.zucks.zucksadnetworksdk.sample.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.zucks.nativead.NativeAd;
import net.zucks.nativead.NativeAdClient;
import net.zucks.nativead.NativeAdListener;

public class NativeAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);

        final RelativeLayout itemView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.item_native_ad, null);

        NativeAdClient client = new NativeAdClient(this, "_6222295ed3", new NativeAdListener() {
            @Override
            public void onLoadAd(final NativeAd nativeAd) {
                // 広告情報のロードが成功した場合
                ((TextView) itemView.findViewById(R.id.text_title)).setText(nativeAd.title);
                ((TextView) itemView.findViewById(R.id.text_body)).setText(nativeAd.bodyText);
                ((TextView) itemView.findViewById(R.id.text_advertiser_name)).setText(nativeAd.advertiserName);
                ((TextView) itemView.findViewById(R.id.text_product_name)).setText(nativeAd.productName);
                Picasso.get().load(nativeAd.imageSrc).fit().centerCrop()
                        .into((ImageView) itemView.findViewById(R.id.image_main));
                Button linkButton = ((Button) itemView.findViewById(R.id.button_link));
                linkButton.setText(nativeAd.linkButtonText);
                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(nativeAd.landingUrl);
                        Intent i = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(i);
                    }
                };
                linkButton.setOnClickListener(listener);
                itemView.setOnClickListener(listener);
            }

            @Override
            public void onNotExistAd() {
                // 広告情報が存在しない場合
                Toast.makeText(NativeAdActivity.this, "onNotExistAd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Exception e) {
                // 広告情報のロードに失敗した場合
                Toast.makeText(NativeAdActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });

        // 広告情報のロード
        client.load();

        ViewGroup rootView = (ViewGroup) findViewById(R.id.root_native_ad);
        rootView.addView(itemView);
    }
}
