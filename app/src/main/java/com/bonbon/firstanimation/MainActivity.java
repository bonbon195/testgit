package com.bonbon.firstanimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    final int ALPHA = 1;
    final int COMBO = 2;
    final int ROTATE = 3;
    final int SCALE = 4;
    final int TRANS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setOnCreateContextMenuListener(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("points", 50);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView:
                menu.add(0, ALPHA, 0, "прозрачность");
                menu.add(0, COMBO, 0, "КОМБО");
                menu.add(0, ROTATE, 0, "крутилка");
                menu.add(0, SCALE, 0, "размер");
                menu.add(0, TRANS, 0, "перемещение");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation animation = null;
        switch (item.getItemId()){
            case ALPHA:
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            case COMBO:
                animation = AnimationUtils.loadAnimation(this, R.anim.combo);
                break;
            case ROTATE:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case SCALE:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case TRANS:
                animation = AnimationUtils.loadAnimation(this, R.anim.trans);
                break;
        }
        textView.startAnimation(animation);
        return super.onContextItemSelected(item);
    }
}