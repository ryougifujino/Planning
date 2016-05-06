package link.ebbinghaus.planning.app.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import com.yurikami.lib.util.DateUtils;

import link.ebbinghaus.planning.app.receiver.SyncLocalDatabaseReceiver;
import link.ebbinghaus.planning.core.db.DBHelper;

/**
 * 用于同步本地数据库（按照系统时间同步计划的状态）
 */
public class SyncLocalDatabaseService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DBHelper.syncLocalDatabase();

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long todayStart = DateUtils.dateTimestampOfToday();
        long triggerAtTime = todayStart + DateUtils.DAY_MILLISECONDS;
        Intent i = new Intent(this, SyncLocalDatabaseReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);

        //确保执行的准确性
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            manager.setExact(AlarmManager.RTC_WAKEUP, triggerAtTime, pi);
        }else {
            manager.set(AlarmManager.RTC_WAKEUP, triggerAtTime, pi);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
