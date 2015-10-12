package com.coder.pullrefresh.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.coder.pullrefresh.util.CodeCheck;

/**
 * Created by husongzhen on 15/7/23.
 */
public abstract class SuperRecyclerAdapter<M> extends
		RecyclerView.Adapter<SuperRecyclerAdapter.SuperViewHolder> {

	private List<M> dataList = new ArrayList<M>();
	protected Activity activity;

	public SuperRecyclerAdapter(Activity activity) {
		this.activity = activity;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public void onBindViewHolder(SuperViewHolder holder, int i) {
		onBindView(holder.item, dataList.get(i), i);
	}

	@Override
	public SuperViewHolder onCreateViewHolder(ViewGroup parent, int p) {
		SuperViewHolder holder = new SuperViewHolder(onCreateView(parent, p));
		return holder;
	}

	public void reloadData(List<M> data) {
		// TODO Auto-generated method stub
		if (!CodeCheck.isNotNullList(data)) {
			data = new ArrayList<M>();
		}
		dataList = data;
		notifyDataSetChanged();
	}

	public void appendData(List<M> data) {
		// TODO Auto-generated method stub

		if (!CodeCheck.isNotNullList(data)) {
			return;
		}

		dataList.addAll(data);
		int startIndex = getItemCount() + 1;
		notifyItemRangeInserted(startIndex, data.size());
	}

	public static class SuperViewHolder extends RecyclerView.ViewHolder {

		public View item;

		public SuperViewHolder(View item) {
			super(item);
			this.item = item;
		}
	}

	public void remove(int p) {
		dataList.remove(p);
		notifyItemRemoved(p);
	}

	public M getItem(int p) {
		return dataList.get(p);
	}

	// ab
	public abstract void onBindView(View item, M m, int i);

	public abstract View onCreateView(ViewGroup parent, int p);

}
