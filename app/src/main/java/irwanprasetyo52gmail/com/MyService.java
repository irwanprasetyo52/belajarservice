package irwanprasetyo52gmail.com;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {//masuk pada media palyer

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate(){
        mediaPlayer = MediaPlayer.create(this, R.raw.lagu1);
        mediaPlayer.setLooping(true);//pada media player akan mengambil data lagu dari raw, dengan nama lagu lagu1

    }

    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;//ini kita gunakan untuk memulai atau menyetel lagu yang sudah dimasukan
    }
    public void onDestroy(){
        mediaPlayer.stop();//dan pada code ini akan menyetop lagu yang sedang dimainkan.
    }
}
