package com.akul.splitfare;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LVAdapter extends BaseAdapter
{
 Activity cntx;
 static Context mcontext;
 private ArrayList<String> array_sort;
 //private ArrayList<Integer> image_sort;
 private ArrayList<Bitmap> bitmap_sort;
// int[] listview_images;
String[] listview_names;
Bitmap[] images;
public LVAdapter(Activity context ,ArrayList<String> a ,ArrayList<Bitmap> b, Bitmap[] c , String[] d)
{
 this.cntx=context;
 array_sort =a;
bitmap_sort =b;
 images = c;
 listview_names = d;
}

public int getCount()
{
 return array_sort.size();
}

public Object getItem(int position)
{
 return array_sort.get(position);
}

public long getItemId(int position)
{
 return array_sort.size();
}

public View getView(final int position, View convertView, ViewGroup parent)
{
View row=null;
LayoutInflater inflater=cntx.getLayoutInflater();
row=inflater.inflate(R.layout.list_item, null);
TextView tv = (TextView) row.findViewById(R.id.title);
ImageView im = (ImageView) row.findViewById(R.id.imageview);
tv.setText(array_sort.get(position));
im.setImageBitmap(images[position]);
return row;
}

public static Bitmap decodeFile(Context context,int resId) 
{
try 
{
mcontext=context;
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeResource(mcontext.getResources(), resId, o);
final int REQUIRED_SIZE = 200;
int width_tmp = o.outWidth, height_tmp = o.outHeight;
int scale = 1;
while (true)
{
 if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
 break;
 width_tmp /= 2;
 height_tmp /= 2;
 scale++;
}
BitmapFactory.Options o2 = new BitmapFactory.Options();
o2.inSampleSize = scale;
return BitmapFactory.decodeResource(mcontext.getResources(), resId, o2);
} 
catch (Exception e) 
{
}
return null;
}

public static Bitmap getRoundedShape(Bitmap scaleBitmapImage,int width) 
{
 int targetWidth = width;
 int targetHeight = width;
 Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
 targetHeight,Bitmap.Config.ARGB_8888);
 Canvas canvas = new Canvas(targetBitmap);
 Path path = new Path();
 path.addCircle(((float) targetWidth - 1) / 2, ((float) targetHeight - 1) / 2,(Math.min(((float) targetWidth),((float) targetHeight)) / 2), Path.Direction.CCW);
 canvas.clipPath(path);
 Bitmap sourceBitmap = scaleBitmapImage;
 canvas.drawBitmap(sourceBitmap,
 new Rect(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight()), new Rect(0, 0, targetWidth, targetHeight), null);
 return targetBitmap;
 }
}