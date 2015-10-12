package com.coder.pullrefresh;
//package mobile.musikid.com.musikid.view.fragment;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import com.coder.box.client.CodeJSON;
//import com.coder.box.core.adapter.UpdateDataListener;
//import com.coder.box.utils.LogUtils;
//
//import java.util.List;
//import java.util.Map;
//
//import mobile.musikid.com.musikid.ProjectDetailActivity;
//import mobile.musikid.com.musikid.R;
//import mobile.musikid.com.musikid.ScreeningActivity;
//import mobile.musikid.com.musikid.framwork.adapter.ProjectAdapter;
//import mobile.musikid.com.musikid.framwork.app.MFragment;
//import mobile.musikid.com.musikid.framwork.click.impl.ProjectDetailHomeClickListener;
//import mobile.musikid.com.musikid.framwork.click.impl.ScreeningClickListener;
//import mobile.musikid.com.musikid.framwork.click.impl.SearchMainClickListener;
//import mobile.musikid.com.musikid.framwork.constant.URLConstant;
//import mobile.musikid.com.musikid.framwork.helper.ScreenDataHelper;
//import mobile.musikid.com.musikid.framwork.http.MUrlParams;
//import mobile.musikid.com.musikid.framwork.model.ScreeningModel;
//import mobile.musikid.com.musikid.framwork.utils.IntentBundle;
//import mobile.musikid.com.musikid.framwork.view.pull_refresh.OnRefreshListener;
//import mobile.musikid.com.musikid.framwork.view.pull_refresh.UIRefreshLayout;
//import mobile.musikid.com.musikid.framwork.view.pull_refresh.impl.ListRefreshListener;
//import mobile.musikid.com.musikid.view.helper.RecyclerViewHelper;
//
//
///**
// * 众筹
// * Created by husongzhen on 15/7/22.
// * <p/>
// * <p/>
// * http://api.musikid.net/projects?page=1&num=10
// */
//public class MainProjectFragment extends MFragment implements AdapterView.OnItemClickListener {
//
//    private RecyclerViewHelper recyclerViewHelper;
//    private ProjectAdapter adapter;
//    private ListRefreshListener refreshListener;
//    private MUrlParams data;
//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getIntExtra("code", 0) == getId()) {
//                reSearchProjects();
//            }
//        }
//    };
//
//    private void reSearchProjects() {
//        Map<Integer, ScreeningModel> result = (Map<Integer, ScreeningModel>) IntentBundle.getInstance().get("result");
//        for (Map.Entry<Integer, ScreeningModel> e : result.entrySet()) {
//            LogUtils.log(getClass(), "key = " + e.getValue().getType() + ", value = " + e.getValue().getIndex());
//            data.putDataParams(e.getValue().getType(), e.getValue().getIndex());
//            refreshListener.setHttpParams(data);
//        }
//        recyclerViewHelper.setSelection(0);
//        recyclerViewHelper.doPullRefreshing();
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        setContentView(R.layout.f_crowdfunding);
//        getActivity().registerReceiver(receiver, new IntentFilter(ScreeningActivity.class.getName()));
//        initView();
//    }
//
//    private void initView() {
//        initHeader();
//        initRefreshView();
//    }
//
//
//    private void initRefreshView() {
//        data = new MUrlParams(URLConstant.HOME_PROJECTS_URL)
//                .putDataParams("music_style", "0")
//                .putDataParams("category", "0")
//                .putDataParams("order_by", "0");
//        refreshListener = (ListRefreshListener) new ListRefreshListener(this) {
//
//
//            @Override
//            protected UpdateDataListener getAdapter() {
//                return adapter;
//            }
//
//            @Override
//            public List getProjects(CodeJSON codeJSON) {
//                return codeJSON.getList("result");
//            }
//        }.setHttpParams(data);
//        adapter = new ProjectAdapter(this);
//        recyclerViewHelper = new RecyclerViewHelper(this);
//        recyclerViewHelper.setRefreshListener(refreshListener);
//        recyclerViewHelper.setAdapter(adapter);
//        recyclerViewHelper.doPullRefreshing();
//    }
//
//
//    private void initHeader() {
//        id(R.id.header_crowding).heightCode(27).paddingCode(2).bgResource(R.mipmap.header_project_bg);
//        id(R.id.music).rect(6).bgResource(R.mipmap.header_music_icon)
//                .click(new ScreeningClickListener(this) {
//                    @Override
//                    protected int getCode() {
//                        return getId();
//                    }
//                }.setParams(ScreenDataHelper.PROJECT_TYPE));
//        id(R.id.search).rect(6).bgResource(R.mipmap.search_white).click(new SearchMainClickListener(this));
//
//
//        id(R.id.header_line).paddingCode(2);
//        id(R.id.icon).rect(5).marginCode(1).bgResource(R.mipmap.music_icon_0);
//        id(R.id.title).textRes(R.string.crowding_title);
//
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Map<String, Object> item = adapter.getItem(i);
//        new ProjectDetailHomeClickListener(this).setId(item.get("project_id") + "").onClick(view);
//    }
//}
