package com.reactive.example;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

import com.reactive.example.processer.MyTransformProcessor;
import com.reactive.example.subscriber.PrintSubscriber;

public class TestReactiveStream {
	public static void main(String[] args) throws InterruptedException {
		SubmissionPublisher<Integer> publisher= new SubmissionPublisher<>();
		//Initialising processor which will square input number(Transform the data)
		MyTransformProcessor<Integer, String> processor=new MyTransformProcessor<>(x->String.valueOf(x*x));
		//Creating final subscriber which is going to print the message
		PrintSubscriber<String> subscriber= new PrintSubscriber<>();
		//publisher will publish to processor
		publisher.subscribe(processor);
		//processor will transform the data and finally publish to end subscriber
		processor.subscribe(subscriber);
		System.out.println("publishing item");
		IntStream.range(1, 10).forEach(publisher::submit);
		publisher.close();
		Thread.sleep(3000);;
		
	}
}
