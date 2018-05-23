package com.android.handler;

public class Looper {
	// sThreadLocal.get() will return null unless you've called prepare().
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    
	public static void prepare() {
        sThreadLocal.set(new Looper());
	}

	MessageQueue mQueue;
	
	public Looper() {
		mQueue = new MessageQueue();
	}

	public static void loop() {
		Looper looper = myLooper();
		for(;;){
			MessageQueue queue = looper.mQueue;
			
			Message message = queue.next();
			
			if(message == null){
				return;
			}
			
			message.target.handleMessage(message);
		}
	}

	static Looper myLooper() {
		return sThreadLocal.get();
	}

}
