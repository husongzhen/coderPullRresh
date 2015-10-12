package com.coder.pullrefresh.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;

import com.coder.pullrefresh.refreshlayout.lib.BGAMoocStyleRefreshViewHolder;
import com.coder.pullrefresh.refreshlayout.lib.BGARefreshLayout;
import com.coder.pullrefresh.refreshlayout.lib.BGARefreshViewHolder;

/**
 * 作者：husongzhen on 15/7/29 12:47 邮箱：husongzhen@musikid.com
 */
public class MRefreshLayout extends BGARefreshLayout implements
		UIRefreshLayout, BGARefreshLayout.BGARefreshLayoutDelegate {

	private OnRefreshListener refreshListener;

	public MRefreshLayout(Context context) {
		super(context);
	}

	public MRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private boolean isLoadMore = false;

	@Override
	public void setLoadMoreAble(boolean able) {
		// BGARefreshViewHolder refreshViewHolder = new
		// BGAMoocStyleRefreshViewHolder(getContext(), able);
		// setRefreshView(refreshViewHolder);
		isLoadMore = able;
	}

//	public void setRefreshView(BGARefreshViewHolder refreshViewHolder) {
//		isLoadMore = refreshViewHolder.ismIsLoadingMoreEnabled();
//		setRefreshViewHolder(refreshViewHolder);
//	}

	public void setRefreshListener(OnRefreshListener refreshListener) {
		this.refreshListener = refreshListener;
		setDelegate(this);
	}

	@Override
	public void endLoading() {
		endLoadingMore();
		endRefreshing();
	}

	@Override
	public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
		refreshListener.onRefreshing(this);
	}

	@Override
	public boolean onBGARefreshLayoutBeginLoadingMore(
			BGARefreshLayout refreshLayout) {
		refreshListener.onMoreLoading(this);
		return isLoadMore;
	}

}
