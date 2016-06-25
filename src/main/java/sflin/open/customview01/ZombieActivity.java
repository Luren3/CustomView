package sflin.open.customview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ZombieActivity extends AppCompatActivity {

    private ZombieView mZombieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombie);
        mZombieView = (ZombieView) findViewById(R.id.custom_zombie);
    }

    public void start(View view){
        mZombieView.start();
    }

    public void sendBack(View view){
        mZombieView.sendBack();
    }
}
