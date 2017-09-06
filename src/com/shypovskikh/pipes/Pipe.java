package com.shypovskikh.pipes;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Pipe implements Runnable {
   private final PipedOutputStream pipedOutput2 = new PipedOutputStream();
   
	@Override
	public void run() {
		try {
			pipedOutput2.write(("Hello from thread ").getBytes());
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public PipedOutputStream  getPipe() {
		return this.pipedOutput2;
	}
	
}
