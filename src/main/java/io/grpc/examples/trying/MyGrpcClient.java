package io.grpc.examples.trying;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
	
	public static void main(String[] args) throws InterruptedException {
	    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8089)
	        .usePlaintext(true)
	        .build();

	    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
	        GreetingServiceGrpc.newBlockingStub(channel);

	    HelloResponse helloResponse = stub.greeting(
	        HelloRequest.newBuilder()
	            .setName("Priyanka")
	            .setAge(18)
	            .setSentiment(Sentiment.HAPPY)
	            .build());

	    System.out.println(helloResponse);

	    channel.shutdown();
	  }

}
