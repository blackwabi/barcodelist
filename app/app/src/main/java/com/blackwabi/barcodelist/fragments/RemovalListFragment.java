package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.presenters.CheckedListItem;
import com.blackwabi.barcodelist.presenters.RemovalListPresenter;

import java.util.List;

import static com.blackwabi.barcodelist.R.id.add_fab;
import static com.blackwabi.barcodelist.R.id.cancel_fab;
import static com.blackwabi.barcodelist.R.id.remove_fab;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public abstract class RemovalListFragment<I, A extends RemovalListAdapter<I, ? extends RecyclerView.ViewHolder>, P extends RemovalListPresenter> extends BaseFragment<P> {

    private A mListAdapter;
    private FloatingActionButton mAddFab;
    private FloatingActionButton mRemoveFab;
    private FloatingActionButton mCancelFab;
    private boolean mShowFabs;
    private boolean mRemoveState;

    public RemovalListFragment() {
        mListAdapter = createListAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(mListAdapter);
        mAddFab = (FloatingActionButton) view.findViewById(add_fab);
        mAddFab.setOnClickListener(fabView -> mPresenter.onAddClicked());
        mAddFab.setOnLongClickListener(fabView -> mPresenter.onAddLongClicked());
        mRemoveFab = (FloatingActionButton) view.findViewById(remove_fab);
        mRemoveFab.setOnClickListener(fabView -> mPresenter.onRemoveClicked());
        mCancelFab = (FloatingActionButton) view.findViewById(cancel_fab);
        mCancelFab.setOnClickListener(fabView -> mPresenter.onCancelClicked());
        initCreatedView(view, savedInstanceState);
        showRemoveState(false);

        return view;
    }

    protected abstract A createListAdapter();

    public void setOnItemClickListener(ItemClickListener<I> itemClickListener) {
        mListAdapter.setOnItemClickListener(itemClickListener);
    }

    public void setOnItemRemoveClickListener(ItemClickListener<CheckedListItem<I>> itemRemoveClickListener) {
        mListAdapter.setOnItemRemoveClickListener(itemRemoveClickListener);
    }

    protected abstract @LayoutRes int getLayout();

    protected abstract void initCreatedView(View view, Bundle savedInstanceState);

    public void showRemoveState(boolean remove) {
        mRemoveState = remove;

        mAddFab.setVisibility(View.GONE);
        mRemoveFab.setVisibility(View.GONE);
        mCancelFab.setVisibility(View.GONE);

        mListAdapter.setRemovalState(remove);
        if (mShowFabs) {
            if (remove) {
                mRemoveFab.setVisibility(View.VISIBLE);
                mCancelFab.setVisibility(View.VISIBLE);
            } else {
                mAddFab.setVisibility(View.VISIBLE);
            }
        }
    }

    public void setShowFabs(boolean show) {
        mShowFabs = show;
    }

    public void update() {
        mListAdapter.setList(mPresenter.getCheckedItems());
    }

    public interface ItemClickListener<ITEM> {
        void onItemClicked(int position, ITEM item);
    }

    @Override
    public void onResume() {
        super.onResume();
        update();
    }
}
