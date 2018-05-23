package com.android.handler;

public class MainActivity extends Activity {
	private TextView mTextView;

	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg) {
			mTextView.setText((String)msg.obj);
			System.out.println("Thread 2--  "+Thread.currentThread());
		};
	};

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("onCreate run");
		mTextView = findViewById(R.id.text_view);


		new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1-- "+Thread.currentThread());

				Message message = new Message();
				message.obj = "message obj--";
				mHandler.sendMessage(message);
			};
		}.start();
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("onResume run--");
	}
}
