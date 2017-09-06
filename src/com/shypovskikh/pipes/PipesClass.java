package com.shypovskikh.pipes;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipesClass {
	
	public static void main(String[] args) throws IOException {
		final PipedOutputStream pipedOutput = new PipedOutputStream();
		final PipedInputStream pipedInput = new PipedInputStream(pipedOutput);
	
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pipedOutput.write(("Hello from thread "+Thread.currentThread()+"").getBytes());
				}catch(IOException e) {
					System.out.println(e);
				}
				
			}
			
		});
		
	
		Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = pipedInput.read();
                    while(data != -1){
                        System.out.print((char) data);
                        data = pipedInput.read();
                    }
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
        thread2.start();

	}

}
