//package com.coder.pullrefresh.refreshlayout.impl;
//
//import java.util.List;
//
//import org.apache.http.params.HttpParams;
//
//import com.coder.pullrefresh.R;
//
///**
// * 作者：husongzhen on 15/7/31 12:28
// * 邮箱：husongzhen@musikid.com
// */
//public abstract class ListRefreshListener extends HttpRefreshListener {
//
//    private int page = 0;
//
//    public ListRefreshListener(CoderQueryActivity activity) {
//        super(activity);
//    }
//
//    protected HttpParams moreLoadingParams(HttpParams params) {
//        page += 1;
//        return ((MUrlParams) params).putPage(page).addData();
//    }
//
//    protected HttpParams refreshingParams(HttpParams params) {
//        page = 1;
//        return ((MUrlParams) params).putPage(page).addData();
//    }
//
//
//    protected void moreLoadingView(CodeJSON codeJSON) {
//        List list = getProjects(codeJSON);
//        if (!CodeCheck.isNotNullList(list)){
//            moreLoadNullListener();
//        }
//        getAdapter().appendData(list);
//    }
//
//    protected  void moreLoadNullListener(){ activity.toast(activity.getString(R.string.list_is_not_more));}
//
//    protected abstract UpdateDataListener getAdapter();
//
//
//    protected void refreshView(CodeJSON codeJSON) {
//        List list = getProjects(codeJSON);
//        LogUtils.log(getClass(), "list.size = " + list.size());
//        if (!CodeCheck.isNotNullList(list)) {
//            errorPagerHelper.show(activity.getString(R.string.list_is_null_toast), this);
//            refreshNullListListener();
//        }else{
//            errorPagerHelper.dismiss();
//        }
//        getAdapter().reloadData(list);
//
//    }
//
//    protected  void refreshNullListListener(){}
//
//
//    public abstract List getProjects(CodeJSON codeJSON);
//
//
//}
