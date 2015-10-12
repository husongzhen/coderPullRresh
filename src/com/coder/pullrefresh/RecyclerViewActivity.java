package com.coder.pullrefresh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.coder.pullrefresh.R;
import com.coder.pullrefresh.adapter.RAdapter;
import com.coder.pullrefresh.refreshlayout.MRefreshLayout;
import com.coder.pullrefresh.refreshlayout.OnRefreshListener;
import com.coder.pullrefresh.refreshlayout.UIRefreshLayout;
import com.coder.pullrefresh.refreshlayout.lib.BGAMoocStyleRefreshViewHolder;
import com.coder.pullrefresh.refreshlayout.lib.BGARefreshViewHolder;

public class RecyclerViewActivity extends Activity implements OnRefreshListener {

	public static final String REFRESHING_TYPE = "refreshing_type";
	public static final String LOADMORE_TYPE = "loadmore_type";
	private RAdapter adapter;
	private MRefreshLayout refreshLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recycler_layout);
		refreshLayout = (MRefreshLayout) findViewById(R.id.refreshLayout);
		// 设置是否可以加载更多
		refreshLayout.setLoadMoreAble(true);
		BGARefreshViewHolder refreshViewHolder = new BGAMoocStyleRefreshViewHolder(
				this, true);
		// 设置加载样式
		refreshLayout.setRefreshViewHolder(refreshViewHolder);
		refreshLayout.setRefreshListener(this);
		RecyclerView recyclerView = (RecyclerView) refreshLayout
				.getContentView();
		LayoutManager manager = new StaggeredGridLayoutManager(2,
				StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(manager);
		adapter = new RAdapter(this);
		recyclerView.setAdapter(adapter);
		// adapter.reloadData(getData());
		refreshLayout.doPullRefreshing();

	}

	private List<String> getData() {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>(100);

		for (int i = 0; i < 100; i++) {
			list.add("item" + i);
		}

		return list;
	}

	@Override
	public void onRefreshing(UIRefreshLayout content) {
		// TODO Auto-generated method stub

		new LoaderMoreTask().execute(REFRESHING_TYPE);

	}

	@Override
	public void onMoreLoading(UIRefreshLayout content) {
		// TODO Auto-generated method stub
		new LoaderMoreTask().execute(LOADMORE_TYPE);
	}

	private class LoaderMoreTask extends AsyncTask<String, Void, List<String>> {

		private String type;

		@Override
		protected List<String> doInBackground(String... arg0) {
			// TODO Auto-generated method stub

			type = arg0[0];
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return getData();
		}

		@Override
		protected void onPostExecute(List<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (type.endsWith(REFRESHING_TYPE)) {
				adapter.reloadData(result);
			}

			if (type.endsWith(LOADMORE_TYPE)) {
				adapter.appendData(result);
			}

			refreshLayout.endLoading();

		}
	}

}
