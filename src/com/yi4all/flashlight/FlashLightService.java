package com.yi4all.flashlight;

import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;

public class FlashLightService extends IntentService{

	public FlashLightService() {
		super("FlashLightService");
	}

	private Camera cam;
	private boolean isTurnOn;
	
	@Override
	protected void onHandleIntent(Intent intent) {
		PackageManager pm = this.getPackageManager();
		 
		// if device support camera?
		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			Log.e("err", "Device has no camera!");
			return;
		}
		
		if(!isTurnOn){
			//turn on
			cam = Camera.open(); 
			Parameters p = cam.getParameters();
			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
			cam.setParameters(p);
			cam.startPreview();
		}else{
			//turn off
			Parameters p = cam.getParameters();
			p.setFlashMode(Parameters.FLASH_MODE_OFF);
			cam.stopPreview();
			  cam.release();
		}
		
	}

}
