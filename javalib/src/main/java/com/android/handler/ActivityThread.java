package com.android.handler;

public class ActivityThread {
	final H mH = new H();
	
	public void attach(boolean b) {
		Activity mainActivity = new MainActivity();
		mainActivity.onCreate();
		
		// // 通过 Handler 去执行Activity的生命周期
		Message message = new Message();
		message.obj = mainActivity;
		mH.sendMessage(message);
	}

	private class H extends Handler {
		public void handleMessage(Message msg) {
			Activity mainActivity = (Activity) msg.obj;
			mainActivity.onResume();
		}
	}
}
