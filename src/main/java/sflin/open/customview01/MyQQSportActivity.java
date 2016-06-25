package sflin.open.customview01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by a9951 on 2016/6/22.
 */

public class MyQQSportActivity extends AppCompatActivity {

    private MyQQSport mMyQQSport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myqqsport);
        mMyQQSport = (MyQQSport) findViewById(R.id.custom_myqqsport);
        mMyQQSport.setData(2532,3125,20,getNowTime(),avgStep(getDayStepNum()),getDayStepNum(),getDate());
        mMyQQSport.startAnimator();
    }

    public String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        return df.format(new Date());
    }

    public int[] getDayStepNum(){
        int[] stepNum = {1000,1500,400,3000,5000,3654,125};
        return stepNum;
    }

    public int avgStep(int[] steps){
        int total = 0;
        for(int step:steps){
            total +=step;
        }
        int avg = total/steps.length;
        return avg;
    }

    public String[] getDate(){
        String[] dates = new String[7];
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        for (int i=0;i<7;i++){
            dates[i] = (day-(7-i))+"日";
        }
        return dates;
    }
}
