package com.yi4all.flashlight;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class AppWidget extends AppWidgetProvider {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction() == null) {
			// Do Something
		} else {
			super.onReceive(context, intent);
			
			context.startService(new Intent(context,
					FlashLightService.class));
		}
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager
	appWidgetManager, int[] appWidgetIds) { 
	// Do Something
	}

}
