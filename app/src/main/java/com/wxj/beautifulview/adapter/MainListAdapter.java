package com.wxj.beautifulview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wxj.beautifulview.R;

import java.util.List;

/**
 * User: W03673
 * Date: 2017/4/5.
 * Time: 10:07.
 * Descriptions: 主页数据适配器
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.SecondTypeHolder> {
    public static final int HEAD_TYPE = 0;
    public static final int NORMAL_TYPE = 1;
    private List<String> beanList;
    private View headView;
    private Context context;

    public MainListAdapter(Context context) {
        this.context = context;
    }

    public MainListAdapter(Context context, View headView) {
        this.context = context;
        this.headView = headView;
    }

    @Override
    public SecondTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_TYPE) {
            return new SecondTypeHolder(headView);
        } else {
            return new SecondTypeHolder(LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(SecondTypeHolder holder, int position) {
        if (getItemViewType(position) == NORMAL_TYPE) {
            holder.tvContent.setText(beanList.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        if (null != headView)
            return beanList == null ? 1 : beanList.size() + 1;
        else
            return beanList == null ? 0 : beanList.size();
    }

    @Override
    public void onViewAttachedToWindow(SecondTypeHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    public List<String> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<String> beanList) {
        this.beanList = beanList;
    }

    public View getHeadView() {
        return headView;
    }

    public void setHeadView(View headView) {
        this.headView = headView;
    }

    @Override
    public int getItemViewType(int position) {
        return (null != headView && position == 0) ? HEAD_TYPE : NORMAL_TYPE;
    }

    class SecondTypeHolder extends RecyclerView.ViewHolder {
        /**
         * 内容
         */
        private TextView tvContent;

        public SecondTypeHolder(View itemView) {
            super(itemView);
            if (itemView != headView)
                tvContent = (TextView) itemView.findViewById(R.id.tv_main_list_content);
        }
    }
}
