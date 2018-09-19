package kr.co.company.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 각 알림을 식별하는 정수
    public static final int NOTIFICATION_ID = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {

        // NotificationCompat.Builder를 사용하여서 알림을 설정한다.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this);

        // 알림에 나타나는 아이콘
        builder.setSmallIcon(R.drawable.android);

        // 알림이 클릭되면 이 인텐트가 보내진다.
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);

        // 사용자가 알림을 터치하면 인텐트가 보내진다.
        builder.setContentIntent(pendingIntent);

        // 알림에 표시되는 큰 아이콘
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.android));

        // 알림 제목
        builder.setContentTitle("알려드립니다.");

        // 알림 콘텐츠
        builder.setContentText("이것은 시험적인 알림입니다.");

        // 4.2 이상인 경우에 보여지는 서브 텍스트
        builder.setSubText("클릭하면 구글의 홈페이지로 이동합니다.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 알림바에 알림을 표시한다.
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
