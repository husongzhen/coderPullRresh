package com.coder.pullrefresh.adapter;

import com.coder.pullrefresh.R;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RAdapter extends SuperRecyclerAdapter<String> {

	private LayoutInflater inflater;

	public RAdapter(Activity activity) {
		super(activity);
		inflater = activity.getLayoutInflater();
	}

	@Override
	public void onBindView(View item, String m, int i) {
		// TODO Auto-generated method stub
		TextView title = (TextView) item.findViewById(R.id.title);
		int height = getRandom();
		title.getLayoutParams().height = height;
		title.setGravity(Gravity.CENTER);
		title.setText(m);

	}

	private int getRandom() {
		// TODO Auto-generated method stub
		return (int) (Math.random() * 100 + 200);
	}

	@Override
	public View onCreateView(ViewGroup parent, int p) {
		View view = inflater.inflate(R.layout.adapter_item, null);
		return view;
	}

}
