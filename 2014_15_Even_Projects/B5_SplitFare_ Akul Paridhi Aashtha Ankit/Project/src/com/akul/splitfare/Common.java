package com.akul.splitfare;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;

public class Common 
{
	public static	boolean tdelflag = false;	
	public static boolean tdialshow = false;
	public static String resp = "";
	public static boolean grpedited = false;
	public static boolean grpmemchanged = false;
	public static boolean grpleft = false;
	public static boolean isNetworkConnected(Context c) 
	{
	    ConnectivityManager conManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = conManager.getActiveNetworkInfo();
	    return ( netInfo != null && netInfo.isConnected() );
	}
	public static Bitmap getBitmap(String uid)
	{
		Bitmap bmp;
		String s = "NULL";
		try{
		 s = Common.APICall("http://akul.cu.cc/getdp.php?u="+uid).substring(4);
		}catch(Exception e){}
		
		if(s.trim().equalsIgnoreCase("NULL"))
    	 {
    		 bmp = BitmapFactory.decodeResource(Reglogin.r.getResources(), R.drawable.user);
    	 }
    	 else
    	 {
    	 byte[] by = Base64.decode(s, 0);
    	 bmp = BitmapFactory.decodeByteArray(by, 0, by.length);
    	 }
		return bmp;
	}
	public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
	 {
	 int width = bm.getWidth();
	 int height = bm.getHeight();
	float scaleWidth = ((float) newWidth) / width;
	float scaleHeight = ((float) newHeight) / height;
	Matrix matrix = new Matrix();
	matrix.postScale(scaleWidth, scaleHeight);
	Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	return resizedBitmap;
	}
	public static Bitmap getCroppedBitmap(Bitmap bitmap) 
	{
	   // bitmap = Bitmap.createScaledBitmap(bitmap, 512, 512, false);
		//bitmap = getResizedBitmap(bitmap,512,512);
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
	            bitmap.getHeight(), Config.ARGB_8888);
	    Canvas canvas = new Canvas(output);
	    final int color = 0xff424242;
	    final Paint paint = new Paint();
	    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
	    paint.setAntiAlias(true);
	    canvas.drawARGB(0, 0, 0, 0);
	    paint.setColor(color);
	    // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
	    canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
	            bitmap.getWidth() / 2, paint);
	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    canvas.drawBitmap(bitmap, rect, rect, paint);
	   // return _bmp;
	    return output;
	    
		//Bitmap output = Bitmap.createBitmap(bitmapimg.getWidth(),
	      //          bitmapimg.getHeight(), Config.ARGB_8888);
		
	/**
		Bitmap srcBmp = bitmapimg;
		if (srcBmp.getWidth() >= srcBmp.getHeight()){

			  bitmapimg = Bitmap.createBitmap(
			     srcBmp, 
			     srcBmp.getWidth()/2 - srcBmp.getHeight()/2,
			     0,
			     srcBmp.getHeight(), 
			     srcBmp.getHeight()
			     );

			}else{

			  bitmapimg = Bitmap.createBitmap(
			     srcBmp,
			     0, 
			     srcBmp.getHeight()/2 - srcBmp.getWidth()/2,
			     srcBmp.getWidth(),
			     srcBmp.getWidth() 
			     );
			}
		bitmapimg = bitmapimg.get
		Bitmap output = Bitmap.createBitmap(512,
	                512, Config.ARGB_8888);
	       
		Canvas canvas = new Canvas(output);

	        final int color = 0xff424242;
	        final Paint paint = new Paint();
	        final Rect rect = new Rect(0, 0, bitmapimg.getWidth(),
	                bitmapimg.getHeight());

	        paint.setAntiAlias(true);
	        canvas.drawARGB(0, 0, 0, 0);
	        paint.setColor(color);
	        canvas.drawCircle(256,256,256, paint);
	        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	        canvas.drawBitmap(bitmapimg, rect, rect, paint);
	        return output;
	        **/
	}
	public static Document getdoc(String uri) throws Exception
	{
		uri = uri.replace(" ", "%20");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
			db = dbf.newDocumentBuilder();
	     	Document doc = db.newDocument();
			doc = db.parse(new URL(uri).openStream());
			if(doc == null || doc.getTextContent() == "")
			{
				throw new Exception();
			}
			else
			return doc;
	}
	
	public static String hash(String pass)
	{
        MessageDigest md = null;
		try 
		{
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
        md.update(pass.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
        {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

	}

	public static void showerrdialog(Context c , String title , String msg )
	{
		new MaterialDialog.Builder(c)
        .title(title)
        .content(msg)
        .positiveText("OK")
        .titleColor(R.color.red_600)
        .positiveColorRes(R.color.red_600)
        .callback(new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog) 
            {
            	dialog.dismiss();
            }
        })
        .cancelable(false)
        .show();
	}
	public static String gt(EditText e)
	{
		return e.getText().toString().trim();
	}
	public static String APICall(String API) throws Exception
	{
		String response = null;
		API = API.replace(" ", "%20").trim();
		DefaultHttpClient client = new DefaultHttpClient();
         HttpGet httpGet = new HttpGet(API);
             HttpResponse execute = client.execute(httpGet);
             InputStream content = execute.getEntity().getContent();
             BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
             String s = "";
             while ((s = buffer.readLine()) != null)
             {
                 response += s;
             }
        return response;
   }
}
