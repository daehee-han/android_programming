public class DownloadService extends IntentService {

  private int result = Activity.RESULT_CANCELED;

  public DownloadService() {
    super("DownloadService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {

보내온 URL 주소에서 100바이트만을 읽는다. 
    Uri data = intent.getData();
    String urlPath = intent.getStringExtra("urlpath");
    String buffer=" ";
    
    InputStream stream = null;
    try {

      URL url = new URL(urlPath);
      stream = url.openConnection().getInputStream();
      InputStreamReader reader = new InputStreamReader(stream);
      int i = 0, next = -1;
      while ((next = reader.read()) != -1) {
        buffer += " " + (char)next;
        if( ++i > 100 ) break;
      }
      result = Activity.RESULT_OK;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();

URL에서 읽은 100바이트를 Message 객체에 넣어서 액티비티로 반환한다. 
        }
      }
    }

    Bundle extras = intent.getExtras();
    if (extras != null) {
      Messenger messenger = (Messenger) extras.get("MESSENGER");
      Message msg = Message.obtain();
      msg.arg1 = result;
      msg.obj = buffer;
      try {
        messenger.send(msg);
      } catch (android.os.RemoteException e1) {
        Log.w(getClass().getName(), "Exception sending message", e1);
      }

    }
  }
} 