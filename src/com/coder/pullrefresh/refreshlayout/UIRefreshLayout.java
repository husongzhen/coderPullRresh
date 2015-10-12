package com.coder.pullrefresh.refreshlayout;

import android.view.View;

/**
 * 作者：husongzhen on 15/7/29 12:45
 * 邮箱：husongzhen@musikid.com
 */
public interface UIRefreshLayout {

    View getContentView();
    

    void setLoadMoreAble(boolean able);

    void setRefreshListener(OnRefreshListener refreshListener);

    void endLoading();

    void doPullRefreshing();

}
