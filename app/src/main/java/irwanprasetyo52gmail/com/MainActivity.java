package irwanprasetyo52gmail.com;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

        EditText editWaktu;
        Button tombolPlay, tombolStop;//membuat edittext dengan nama edit waktu dan button dengan nama tombol play dan tombol stop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//akan bermain berdasarkan pada layout activity main.xml

        editWaktu = (EditText)findViewById(R.id.et_Waktu);
        tombolPlay = (Button) findViewById(R.id.bt_Play);
        tombolStop = (Button) findViewById(R.id.bt_stop);
        tombolPlay.setOnClickListener(this);
        tombolStop.setOnClickListener(this);//akan membuat dengan berdasarkan id pada et_waktu,tombol play dan stop.
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_Play :
            callPlay();//akan memulai lagu dengan berdasarkan id pada button play.
            break;
            case R.id.bt_stop :
            stopPlay();//akan menyetop lagu dengan berdasarkan id pada button stop
            break;

        }
    }

    public void stopPlay() {
        stopService(new Intent(MainActivity.this, MyService.class));//stop akan menyetop lagu dengan intent dengan main activity dan pada my service.
    }


    public void callPlay() {
        int detik =Integer.parseInt(editWaktu.getText().toString());
        Intent intent = new Intent(MainActivity.this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity. this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService((ALARM_SERVICE));//dengan int detik pada edit waktu dan intent atau akan menuju ke maina ctivity dan my service lalu pending intent akan menuju pada main dan flag update current.

        if(alarmManager !=null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(detik*1000), pendingIntent);
            Toast.makeText(getApplicationContext(), "Song Play After"+detik+"second !", Toast.LENGTH_LONG).show();//membuat alarm dengan rtc wakeup dengan detik*1000 dan pending intent dengan text song play afetr second.
        }
    }
}
