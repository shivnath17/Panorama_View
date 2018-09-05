package com.example.shivnath.panorama;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lespinside.simplepanorama.view.SphericalView;
import com.panoramagl.utils.PLUtils;

public class MainActivity extends AppCompatActivity {

    private SphericalView sphericalView;
    private Bitmap[] bitmaps = new Bitmap[2];

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmaps[0] = PLUtils.getBitmap(this, R.drawable.sunset_at_pier);
        bitmaps[1] = PLUtils.getBitmap(this, R.drawable.sunset_at_pier_grey);

        sphericalView = (SphericalView) findViewById(R.id.spherical_view);
        sphericalView.setPanorama(bitmaps[0], true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sphericalView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sphericalView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sphericalView.onDestroy();
    }

    private void changePanorama(int index) {
        sphericalView.setPanorama(bitmaps[index], true);
    }
}
