
package com.example.wackamongus;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.widget.ConstraintLayout;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.ScaleAnimation;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.util.Timer;
        import java.util.TimerTask;
        import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity2 extends AppCompatActivity {
    ImageView vent1, vent2, vent3, vent4, vent5, vent6, vent7, vent8, vent9;
    ImageView sus1, sus2, sus3, sus4, sus5, sus6, sus7, sus8, sus9, imposter, goldensus,sustally;
    ImageView ovent1, ovent2, ovent3, ovent4, ovent5, ovent6, ovent7, ovent8, ovent9;
    TextView timeText, scoreText;
    Boolean onedown,twodown,threedown,fourdown,fivedown,sixdown,sevendown,eightdown,ninedown,click1,click2,click3,click4,click5,click6,click7,click8,click9,imp1,imp2,imp3,imp4,imp5,imp6,imp7,imp8,imp9;
    Timer timer,timer2;
    Button button;
    int i,current;
    static int score;
    Handler handler;
    Intent intent;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = 1;
        imp1 = false;
        imp2 = false;
        imp3 = false;
        imp4 = false;
        imp5 = false;
        imp6 = false;
        imp7 = false;
        imp8 = false;
        imp9 = false;
        layout = findViewById(R.id.layout);
        vent1 = findViewById(R.id.vent9);
        vent2 = findViewById(R.id.vent8);
        vent3 = findViewById(R.id.vent7);
        vent4 = findViewById(R.id.vent6);
        vent5 = findViewById(R.id.vent5);
        vent6 = findViewById(R.id.vent4);
        vent7 = findViewById(R.id.vent3);
        vent8 = findViewById(R.id.vent2);
        vent9 = findViewById(R.id.vent1);
        sus1 = findViewById(R.id.sus1);
        sus2 = findViewById(R.id.sus2);
        sus3 = findViewById(R.id.sus3);
        sus4 = findViewById(R.id.sus4);
        sus5 = findViewById(R.id.sus5);
        sus6 = findViewById(R.id.sus6);
        sus7 = findViewById(R.id.sus7);
        sus8 = findViewById(R.id.sus8);
        sus9 = findViewById(R.id.sus9);
        sus1.setVisibility(View.INVISIBLE);
        sus2.setVisibility(View.INVISIBLE);
        sus3.setVisibility(View.INVISIBLE);
        sus4.setVisibility(View.INVISIBLE);
        sus5.setVisibility(View.INVISIBLE);
        sus6.setVisibility(View.INVISIBLE);
        sus7.setVisibility(View.INVISIBLE);
        sus8.setVisibility(View.INVISIBLE);
        sus9.setVisibility(View.INVISIBLE);
        timeText = findViewById(R.id.textView);
        scoreText = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1.0f, 0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);
        ScaleAnimation descaleAnimation = new ScaleAnimation(1.0f, 0f, 1.0f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        descaleAnimation.setDuration(500);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLoad = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intentToLoad);
            }
        });
        timer =new Timer();

        timer2 = new Timer();
        current = 60 ;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if(current>0) {
                    current--;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            timeText.setText(current + "");
                        }
                    });
                }
                else{
                    timer.cancel();
                    timer.purge();
                    this.cancel();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            timeText.setTextSize(25);
                            timeText.setText("Game Over");
                        }
                    });
                }
            }
        };
        timer.schedule(tt, 0, 1000);
        TimerTask tt2 = new TimerTask() {
            @Override
            public void run() {

                if(current>0) {
                    int choice = (int)(Math.random()*9)+1;
                    int imp = (int)(Math.random()*5)+1;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(choice==1){
                                if(imp==5){
                                    imp1=true;
                                    sus1.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus1.setImageResource(R.drawable.sus);
                                    imp1=false;
                                }
                                vent1.setImageResource(R.drawable.ventopen);
                                sus1.startAnimation(scaleAnimation);
                                sus1.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                new Handler().postDelayed(new Runnable(){
                                    public void run() {
                                        if(click1=true) {
                                            sus1.startAnimation(descaleAnimation);
                                            sus1.setVisibility(View.INVISIBLE);
                                            vent1.setImageResource(R.drawable.vent);
                                        }
                                    }
                                }, 1000);

                                //sus1.setImageResource(R.drawable.sus);
                            }
                            else if(choice ==2){
                                vent2.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp2=true;
                                    sus2.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus2.setImageResource(R.drawable.sus);
                                }
                                sus2.startAnimation(scaleAnimation);
                                sus2.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click2=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus2.startAnimation(descaleAnimation);
                                            sus2.setVisibility(View.INVISIBLE);
                                            vent2.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus2.setImageResource(R.drawable.sus);

                            }
                            else if(choice ==3){
                                vent3.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp3=true;
                                    sus3.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus3.setImageResource(R.drawable.sus);
                                }
                                sus3.startAnimation(scaleAnimation);
                                sus3.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click3=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus3.startAnimation(descaleAnimation);
                                            sus3.setVisibility(View.INVISIBLE);
                                            vent3.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus3.setImageResource(R.drawable.sus);



                            }
                            else if(choice ==4){
                                vent4.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp4=true;
                                    sus4.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus4.setImageResource(R.drawable.sus);
                                }
                                sus4.startAnimation(scaleAnimation);
                                sus4.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click4=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus4.startAnimation(descaleAnimation);
                                            sus4.setVisibility(View.INVISIBLE);
                                            vent4.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus4.setImageResource(R.drawable.sus);



                            }
                            else if(choice ==5){
                                vent5.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp5=true;
                                    sus5.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus5.setImageResource(R.drawable.sus);
                                }
                                sus5.startAnimation(scaleAnimation);
                                sus5.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click5=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus5.startAnimation(descaleAnimation);
                                            sus5.setVisibility(View.INVISIBLE);
                                            vent5.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus5.setImageResource(R.drawable.sus);



                            }
                            else if(choice ==6){
                                vent6.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp6=true;
                                    sus6.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus6.setImageResource(R.drawable.sus);
                                }
                                sus6.startAnimation(scaleAnimation);
                                sus6.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click6=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus6.startAnimation(descaleAnimation);
                                            sus6.setVisibility(View.INVISIBLE);
                                            vent6.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus6.setImageResource(R.drawable.sus);



                            }
                            else if(choice ==7){
                                vent7.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp7=true;
                                    sus7.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus7.setImageResource(R.drawable.sus);
                                }
                                sus7.startAnimation(scaleAnimation);
                                sus7.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click7=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus7.startAnimation(descaleAnimation);
                                            sus7.setVisibility(View.INVISIBLE);
                                            vent7.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus7.setImageResource(R.drawable.sus);

                            }
                            else if(choice ==8){
                                vent8.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp8=true;
                                    sus8.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus8.setImageResource(R.drawable.sus);
                                }
                                sus8.startAnimation(scaleAnimation);
                                sus8.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click8=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus8.startAnimation(descaleAnimation);
                                            sus8.setVisibility(View.INVISIBLE);
                                            vent8.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus8.setImageResource(R.drawable.sus);



                            }
                            else if(choice ==9){
                                vent9.setImageResource(R.drawable.ventopen);
                                if(imp==5){
                                    imp9=true;
                                    sus9.setImageResource(R.drawable.imposter);
                                }
                                else{
                                    sus9.setImageResource(R.drawable.sus);
                                }
                                sus9.startAnimation(scaleAnimation);
                                sus9.setVisibility(View.VISIBLE);
                                checkDown(descaleAnimation);
                                if(click9=true){
                                    new Handler().postDelayed(new Runnable(){
                                        public void run() {
                                            sus9.startAnimation(descaleAnimation);
                                            sus9.setVisibility(View.INVISIBLE);
                                            vent9.setImageResource(R.drawable.vent);
                                        }
                                    }, 1000);
                                }
                                //sus9.setImageResource(R.drawable.sus);



                            }
                        }
                    });

                }
            }
        };
        timer2.schedule(tt2, 0, 3000);






    }
    public void checkDown(Animation animation){
        sus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click1 = false;
                if(imp1){
                    sus1.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus1.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus1.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp1 = false;


            }
        });
        sus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click2 = false;
                if(imp2){
                    sus2.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus2.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus2.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp2 = false;

            }
        });
        sus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click3 = false;
                if(imp3){
                    sus1.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus3.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus3.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp3 = false;

            }
        });
        sus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click4 = false;
                if(imp4){
                    sus4.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus4.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus4.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp4 = false;

            }
        });
        sus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click5 = false;
                if(imp5){
                    sus5.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");

                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus5.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus5.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp5 = false;

            }
        });
        sus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click6 = false;
                if(imp6){
                    sus6.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus6.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus6.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp6 = false;

            }
        });
        sus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click7 = false;
                if(imp7){
                    sus7.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus7.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus7.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp7 = false;

            }
        });
        sus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click8 = false;
                if(imp8){
                    sus8.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus8.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus8.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp8 = false;

            }
        });
        sus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click9 = false;
                if(imp9){
                    sus9.setImageResource(R.drawable.explos);
                    if(current<5){
                        current=0;
                        timeText.setText("Game Over");
                    }
                    else{
                        current-=5;
                    }
                }
                else {

                    sus9.setClickable(false);
                    addMethod(1);
                    ImageView imageView = new ImageView(MainActivity2.this);
                    imageView.setImageResource(R.drawable.deadsus);
                    tally(imageView, 30, 30);

                    sus9.setImageResource(R.drawable.deadsus);
                    scoreText.setText("Score:" + score);
                }
                imp9 = false;
            }
        });


    }

    private void tally(ImageView imageView, int width, int height) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);
        layoutParams.setMargins(10,0,10,0);
        imageView.setLayoutParams(layoutParams);
        layout.addView(imageView);

    }
    public static synchronized void addMethod(int k){
        score += k;
    }




}
