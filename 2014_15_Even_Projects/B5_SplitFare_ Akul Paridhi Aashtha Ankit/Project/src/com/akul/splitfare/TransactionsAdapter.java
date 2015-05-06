package com.akul.splitfare;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TransactionsAdapter extends ArrayAdapter<Transaction> 
{

	private TextView tv;
	private List<Transaction> transactions= new ArrayList<Transaction>();
	private LinearLayout wrapper;

	public void remove(int index)
	{
		transactions.remove(index);
	}
	@Override
	public void remove(Transaction object)
	{
		transactions.remove(object);
		super.remove(object);
	}
	@Override
	public void add(Transaction object)
	{
		transactions.add(object);
		super.add(object);
	}
	public void add(int i ,Transaction object)
	{
		transactions.add(i,object);
		super.add(object);
	}

	public TransactionsAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
	}

	public int getCount() 
	{
		return this.transactions.size();
	}

	public Transaction getItem(int index)
	{
		return this.transactions.get(index);
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		if (row == null) 
		{
			LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.listitem_transac, parent, false);
		}

		wrapper = (LinearLayout) row.findViewById(R.id.wrapper);
		LinearLayout w2 = (LinearLayout) row.findViewById(R.id.wrapper_top);
		Transaction coment = getItem(position);
		((TextView) row.findViewById(R.id.transaclv_name)).setText(coment.name);
		((TextView) row.findViewById(R.id.transaclv_amt)).setText(coment.amt+ConfigHandler.getcurr());
		tv = (TextView) row.findViewById(R.id.comment);
		tv.setText(coment.comment);
		wrapper.setBackgroundResource(coment.left ? R.drawable.bubble_b : R.drawable.bubble_a);
		w2.setGravity(coment.left ? Gravity.LEFT : Gravity.RIGHT);
		if(coment.left)
		{
			
		}
		else
		{
			
		}
		return row;
	}
	public Bitmap decodeToBitmap(byte[] decodedByte) 
	{
		return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
	}
}