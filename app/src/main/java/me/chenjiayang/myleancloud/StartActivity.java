package me.chenjiayang.myleancloud;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.io.IOException;

public class StartActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private VideoView myVideoView;
    private BootstrapButton start_login;
    private BootstrapButton start_register;
    private TextView Start_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window=StartActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);

        setContentView(R.layout.activity_start);

        initView();

        final String videoPath = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.aston_martin).toString();
        myVideoView.setVideoPath(videoPath);
        myVideoView.start();
        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);

            }
        });

        myVideoView
                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        myVideoView.setVideoPath(videoPath);
                        myVideoView.start();

                    }
                });
    }

    private void initView() {

        myVideoView = (VideoView) findViewById(R.id.videoView);
        start_login = (BootstrapButton) findViewById(R.id.start_login);
        start_register = (BootstrapButton) findViewById(R.id.start_register);
        Start_name = (TextView) findViewById(R.id.start_name);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Tondu_Beta.otf");
        Start_name.setTypeface(typeface);

        start_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                finish();
            }
        });

        start_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,RegisterActivity.class));
                finish();
            }
        });

    }

}
