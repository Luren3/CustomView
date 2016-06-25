package sflin.open.customview01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by a9951 on 2016/6/22.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CheckView(View view){
        startActivity(new Intent(this,CheckActivity.class));
    }

    public void Zombie(View view){
        startActivity(new Intent(this,ZombieActivity.class));
    }

    public void MyQQSport(View view){
        startActivity(new Intent(this,MyQQSportActivity.class));
    }
}
