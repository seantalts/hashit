/*
 * This file is part of Password Genie.
 * 
 * Copyright (C) 2009 Thilo-Alexander Ginkel.
 * 
 * Password Genie is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Password Genie is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Password Genie.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ginkel.passwordhasher;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabbedMainActivity extends TabActivity {

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Create tabs */
		Resources resources = getResources();
		TabHost tabHost = getTabHost();

		/* Create home tab */
		TabSpec tab = tabHost.newTabSpec("home");
		Intent mainIntent = new Intent(this, MainActivity.class);
		mainIntent.fillIn(getIntent(), Intent.FILL_IN_DATA
				| Intent.FILL_IN_ACTION);
		tab.setContent(mainIntent);
		tab.setIndicator(null, resources.getDrawable(R.drawable.tabicon));
		tabHost.addTab(tab);

		/* Create contact tab */
		tab = tabHost.newTabSpec("contact");
		Intent hiddenAgenda = new Intent(this, SettingsActivity.class);
		hiddenAgenda.setAction(Constants.ACTION_SITE_PREFS);
		tab.setContent(hiddenAgenda);
		tab.setIndicator(null, resources
				.getDrawable(android.R.drawable.ic_menu_preferences));
		tabHost.addTab(tab);
	}
}
