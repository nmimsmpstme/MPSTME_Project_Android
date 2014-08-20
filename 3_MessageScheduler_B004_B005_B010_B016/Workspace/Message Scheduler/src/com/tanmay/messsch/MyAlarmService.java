package com.tanmay.messsch;

import java.util.ArrayList;

import com.obscuresoftware.texttimer.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.net.Uri;
import android.content.ContentValues;
import android.app.Activity;
                           

public class MyAlarmService extends Service 
{
     
  private NotificationManager mManager;
 
  
   @Override
   public IBinder onBind(Intent arg0)
   {
       return null;
   }

   @Override
   public void onCreate() 
   { 
      super.onCreate();
   }

  @SuppressWarnings("static-access")
  @Override
  public void onStart(Intent intent, int startId)
  {
      super.onStart(intent, startId);
      
      mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
      Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);
      Notification notification = new Notification(R.drawable.ic_launcher,"This is a test message!", System.currentTimeMillis());
      intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
      PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
      notification.flags |= Notification.FLAG_AUTO_CANCEL;
      
      //Testing messaging
      String SENT = "SMS_SENT";
      String DELIVERED = "SMS_DELIVERED";
      PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
      PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);
      //---when the SMS has been sent---
      registerReceiver(new BroadcastReceiver(){
          @Override
          public void onReceive(Context arg0, Intent arg1) 
          {
              switch (getResultCode())
              {
                  case Activity.RESULT_OK:
                      //Toast.makeText(getBaseContext(), "SMS sent", Toast.LENGTH_SHORT).show();
                	  mManager = (NotificationManager) getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                      Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                      Notification notification = new Notification(R.drawable.ic_launcher,"Scheduled Message Sent!", System.currentTimeMillis());
                      intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      PendingIntent pendingNotificationIntent = PendingIntent.getActivity( getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                      notification.flags |= Notification.FLAG_AUTO_CANCEL;
                      notification.setLatestEventInfo(getApplicationContext(), "Message Scheduler", "Text Sent Successfully", pendingNotificationIntent);
                	  mManager.notify(0, notification);
                	  System.out.println("SMS Sent");
                      break;
                  case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                      Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                      break;
                  case SmsManager.RESULT_ERROR_NO_SERVICE:
                      Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT).show();
                      break;
                  case SmsManager.RESULT_ERROR_NULL_PDU:
                      Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                      break;
                  case SmsManager.RESULT_ERROR_RADIO_OFF:
                      Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_SHORT).show();
                      break;
              }
          }
      }, new IntentFilter(SENT));

      //---when the SMS has been delivered---
      registerReceiver(new BroadcastReceiver(){
          @Override
          public void onReceive(Context arg0, Intent arg1) 
          {
              switch (getResultCode())
              {
                  case Activity.RESULT_OK:
                      Toast.makeText(getBaseContext(), "SMS delivered", Toast.LENGTH_SHORT).show();
                      break;
                  case Activity.RESULT_CANCELED:
                      Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
                      break;                        
              }
          }
      }, new IntentFilter(DELIVERED));
      SmsManager sms = SmsManager.getDefault();
      if (MainActivity.getMessage(startId-1).length() >160)
      {
    	  ArrayList<String> parts = sms.divideMessage(MainActivity.getMessage(startId-1));
    	  ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
          ArrayList<PendingIntent> deliveredIntents = new ArrayList<PendingIntent>();
          for (int num = 0; num < parts.size(); num++) 
          { 
                  sentIntents.add(sentPI);
                  deliveredIntents.add(deliveredPI);
          }
    	  sms.sendMultipartTextMessage(MainActivity.getContact(startId-1),null, parts, sentIntents, deliveredIntents);
    	  ContentValues values = new ContentValues(); 
          values.put("address", MainActivity.getContact(startId-1));          
          values.put("body", MainActivity.getMessage(startId-1)); 
          getContentResolver().insert(Uri.parse("content://sms/sent"), values);
      }
      else
      {
    	  sms.sendTextMessage(MainActivity.getContact(startId-1), null, MainActivity.getMessage(startId-1), sentPI, deliveredPI);
    	  ContentValues values = new ContentValues(); 
          values.put("address", MainActivity.getContact(startId-1));          
          values.put("body", MainActivity.getMessage(startId-1)); 
          getContentResolver().insert(Uri.parse("content://sms/sent"), values);
      }
      //messaging test end
   }

   @Override
   public void onDestroy() 
   {
       super.onDestroy();
   } 
}