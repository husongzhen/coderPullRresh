//package com.coder.pullrefresh.refreshlayout.impl;
//
//import android.view.View;
//
//import com.coder.box.app.CoderQueryActivity;
//import com.coder.box.client.CodeJSON;
//import com.coder.box.core.http.HttpParams;
//
//import mobile.musikid.com.musikid.R;
//import mobile.musikid.com.musikid.framwork.http.MAsyncHttp;
//import mobile.musikid.com.musikid.framwork.http.resultHandler.MResultHander;
//import mobile.musikid.com.musikid.framwork.view.pull_refresh.OnRefreshListener;
//import mobile.musikid.com.musikid.framwork.view.pull_refresh.UIRefreshLayout;
//import mobile.musikid.com.musikid.view.helper.ErrorPagerHelper;
//import mobile.musikid.com.musikid.view.loading.LoadingDialog;
//
///**
// * 作者：husongzhen on 15/7/29 14:12
// * 邮箱：husongzhen@musikid.com
// */
//public abstract class HttpRefreshListener implements OnRefreshListener, View.OnClickListener {
//
//
//    private HttpParams params;
//    protected CoderQueryActivity activity;
//    private LoadingDialog loadingDialog = null;
//    protected ErrorPagerHelper errorPagerHelper = null;
//    private boolean isInit = true;
//    private UIRefreshLayout layout;
//
//    public HttpRefreshListener(CoderQueryActivity activity) {
//        this.activity = activity;
//        this.loadingDialog = LoadingDialog.news(activity.getActivity());
//        this.errorPagerHelper = new ErrorPagerHelper(activity);
//        this.isInit = true;
//    }
//
//    public OnRefreshListener setHttpParams(HttpParams params) {
//        this.params = params;
//        return this;
//    }
//
//    @Override
//    public void onRefreshing(final UIRefreshLayout content) {
//        this.layout = content;
//        if (isInit) {
//            loadingDialog.show();
//        }
//        MAsyncHttp.post(refreshingParams(params), new MResultHander(activity) {
//            @Override
//            protected void onHttpSucc(CodeJSON json) {
//                if (isInit) {
//                    errorPagerHelper.dismiss();
//                    loadingDialog.dismiss();
//                    isInit = false;
//                }
//
//                refreshView(json);
//            }
//
//
//            @Override
//            protected void onHttpFail(CodeJSON json) {
//                super.onHttpFail(json);
//                if (isInit) {
//                    errorPagerHelper.show(json.getString("result:info")
//                            , HttpRefreshListener.this);
//                }
//            }
//
//
//            @Override
//            public void onOutNet(Exception obj) {
//                super.onOutNet(obj);
//                if (isInit) {
//                    errorPagerHelper.show(activity.getString(R.string.net_out_msg)
//                            , HttpRefreshListener.this);
//                }
//            }
//
//
//            @Override
//            public void onStart() {
//                super.onStart();
//                if (isInit) {
//                    loadingDialog.show();
//                }
//            }
//
//            @Override
//            public void onEnd() {
//                if (isInit) {
//                    loadingDialog.dismiss();
//                }
//                content.endLoading();
//            }
//        });
//    }
//
//
//    protected HttpParams refreshingParams(HttpParams params) {
//        return params;
//    }
//
//    @Override
//    public void onMoreLoading(final UIRefreshLayout content) {
//        MAsyncHttp.post(moreLoadingParams(params), new MResultHander(activity) {
//            @Override
//            protected void onHttpSucc(CodeJSON json) {
//                moreLoadingView(json);
//            }
//
//            @Override
//            public void onEnd() {
//                content.endLoading();
//            }
//        });
//
//    }
//
//
//    protected HttpParams moreLoadingParams(HttpParams params) {
//        return params;
//    }
//
//
//    protected void moreLoadingView(CodeJSON codeJSON) {
//
//
//    }
//
//    protected void refreshView(CodeJSON codeJSON) {
//
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        errorPagerHelper.dismiss();
//        onRefreshing(layout);
//    }
//}
