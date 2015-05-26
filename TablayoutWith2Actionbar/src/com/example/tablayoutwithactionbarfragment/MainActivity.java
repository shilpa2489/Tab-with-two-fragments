package com.example.tablayoutwithactionbarfragment;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;

import android.widget.TextView;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


public class MainActivity extends Activity  {

	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 
		
		actionBar = getActionBar();

		// Hide the action bar title
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		String label1 = getResources().getString(R.string.label1);
		Tab tab = actionBar.newTab();
		tab.setText(label1);
		TabListener<Tab1Fragment> t1 = new TabListener<Tab1Fragment>(this, label1, Tab1Fragment.class);
		tab.setTabListener(t1);
		actionBar.addTab(tab);
		
		String label2 = getResources().getString(R.string.label2);
		tab = actionBar.newTab();
		tab.setText(label2);
		TabListener<Tab2Fragment> t2 = new TabListener<Tab2Fragment>(this, label2, Tab2Fragment.class);
		tab.setTabListener(t2);
		actionBar.addTab(tab);
		
		
		
		
	}

	private class TabListener<T extends Fragment> implements ActionBar.TabListener {

		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
		public TabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			if(mFragment == null)
			{
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				ft.attach(mFragment);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			if(mFragment != null)
			{
				ft.detach(mFragment);
			}
		}
		
	}

	
	
	}

