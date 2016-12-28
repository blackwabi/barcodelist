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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        mListAdapter = createListAdapter();
        recyclerView.setAdapter(mListAdapter);
        initCreatedView(view);

        return view;
    }

    protected abstract A createListAdapter();

    protected abstract @LayoutRes int getLayout();

    protected abstract void initCreatedView(View view);

    public void setList(List<I> list) {
        mListAdapter.setList(list);
    }
}
