package com.reactive.example.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PrintSubscriber<T> implements Subscriber<T> {
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		System.out.println("Inside onSubscribe");
		this.subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		System.out.println("Receive Item : " + item);
		subscription.request(6);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error occured ");
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Item receiving completed");
	}

}
