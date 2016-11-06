package org.androidtown.memo_sample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MemoListAdapter extends BaseAdapter {

	private Context mContext;

	private List<MemoListItem> mItems = new ArrayList<MemoListItem>();

	public MemoListAdapter(Context context) {
		mContext = context;
	}

	public void clear() {
		mItems.clear();
	}

	public void addItem(MemoListItem it) {
		mItems.add(it);
	}

	public void setListItems(List<MemoListItem> lit) {
		mItems = lit;
	}

	public int getCount() {
		return mItems.size();
	}

	public Object getItem(int position) {
		return mItems.get(position);
	}

	public boolean areAllItemsSelectable() {
		return false;
	}

	public boolean isSelectable(int position) {
		try {
			return mItems.get(position).isSelectable();
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		MemoListItemView itemView;
		if (convertView == null) {
			itemView = new MemoListItemView(mContext);
		} else {
			itemView = (MemoListItemView) convertView;
		}

		// 현재아이템 불러오기
		itemView.setContents(0, ((String) mItems.get(position).getData(0)));
		itemView.setContents(1, ((String) mItems.get(position).getData(1)));
		itemView.setContents(3, ((String) mItems.get(position).getData(3)));


		return itemView;
	}

}
