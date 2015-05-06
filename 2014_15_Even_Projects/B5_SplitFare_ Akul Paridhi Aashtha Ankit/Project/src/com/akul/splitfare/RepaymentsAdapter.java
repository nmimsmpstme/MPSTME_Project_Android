package com.akul.splitfare;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RepaymentsAdapter extends ArrayAdapter<Repayment> 
{

	private TextView tv;
	private List<Repayment> repayments= new ArrayList<Repayment>();
	private LinearLayout wrapper;

	@Override
	public void add(Repayment object)
	{
		repayments.add(object);
		super.add(object);
	}
	public void add(int i ,Repayment object)
	{
		repayments.add(i,object);
		super.add(object);
	}

	public RepaymentsAdapter(Context context, int textViewResourceId)
	{
		super(context, textViewResourceId);
	}

	public int getCount() 
	{
		return this.repayments.size();
	}

	public Repayment getItem(int index)
	{
		return this.repayments.get(index);
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		if (row == null) 
		{
			LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.listitem_rep, parent, false);
		}

		Repayment coment = getItem(position);
		((TextView) row.findViewById(R.id.rep_To)).setText(coment.name);
		((TextView) row.findViewById(R.id.replv_amt)).setText(coment.amt+ConfigHandler.getcurr());
		tv = (TextView) row.findViewById(R.id.replv_date);
		if(!ConfigHandler.getd())
		{
		tv.setTextColor(Color.parseColor("#000000"));
		((TextView) row.findViewById(R.id.rep_To)).setTextColor(Color.parseColor("#000000"));
		((TextView) row.findViewById(R.id.replv_amt)).setTextColor(Color.parseColor("#000000"));
		}
		tv.setText(coment.date);
		return row;
	}
	public Bitmap decodeToBitmap(byte[] decodedByte) 
	{
		return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
	}
}