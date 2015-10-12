package com.coder.pullrefresh.refreshlayout;

/**
 * 作者：husongzhen on 15/7/29 12:40
 * 邮箱：husongzhen@musikid.com
 */
public interface OnRefreshListener {
    void onRefreshing(UIRefreshLayout content);


    void onMoreLoading(UIRefreshLayout content);
}
