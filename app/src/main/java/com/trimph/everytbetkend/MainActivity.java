package com.trimph.everytbetkend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.trimph.everytbetkend.model.Picture;
import com.trimph.everytbetkend.model.PictureUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public PictureUtil pictureUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.save);
        Button getData = (Button) findViewById(R.id.getData);
        Button update = (Button) findViewById(R.id.update);
        Button getVersion = (Button) findViewById(R.id.getVersion);
        pictureUtil = PictureUtil.getInstance(MainActivity.this, "MyPicture");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picture picture = new Picture(1, "Http://baidu.com");
                pictureUtil.saveToDb(picture);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picture picture = new Picture(1, "Http://taotao.com");
                pictureUtil.updateDb(picture);
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Picture> list = pictureUtil.getDb();
                if (list != null) {
                    Toast.makeText(MainActivity.this, list.get(0).getUrl(), Toast.LENGTH_LONG).show();
                }
            }
        });

        getVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureUtil.getVersion();
            }
        });
    }
}
