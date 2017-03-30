package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.presenters.BasePresenter;

import java.util.List;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public abstract class ListFragment<I, A extends ListAdapter<I, ? extends RecyclerView.ViewHolder>, P extends BasePresenter> extends BaseFragment<P> {

    private A mListAdapter;

    public ListFragment() {
        mListAdapter = createListAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(mListAdapter);
        initCreatedView(view, savedInstanceState);

        return view;
    }

    protected abstract A createListAdapter();

    public void setOnItemClickListener(ItemClickListener<I> itemClickListener) {
        mListAdapter.setOnItemClickListener(itemClickListener);
    }

    public void setOnItemLongClickListener(ItemLongClickListener<I> itemLongClickListener) {
        mListAdapter.setOnItemLongClickListener(itemLongClickListener);
    }

    protected abstract @LayoutRes int getLayout();

    protected abstract void initCreatedView(View view, Bundle savedInstanceState);

    public void setList(List<I> list) {
        mListAdapter.setList(list);
    }

    public interface ItemClickListener<ITEM> {
        void onItemClicked(int position, ITEM item);
    }

    public interface ItemLongClickListener<ITEM> {
        boolean onItemLongClicked(int position, ITEM item);
    }
}
