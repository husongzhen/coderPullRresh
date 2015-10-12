package com.coder.pullrefresh;

import com.coder.pullrefresh.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {

		findViewById(R.id.listview).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				goIntent(ListViewActivity.class);
			}
		});

		findViewById(R.id.recycleView).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						goIntent(RecyclerViewActivity.class);
					}
				});

	}

	protected void goIntent(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		
		Intent intent = new Intent(this, clazz);
		startActivity(intent);
		

	}

}
