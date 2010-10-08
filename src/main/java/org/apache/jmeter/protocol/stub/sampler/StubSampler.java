/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.jmeter.protocol.thrift.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;

/**
 * A Stub Sampler that calls functions and returns the corresponding result
 */
public class StubSampler extends AbstractSampler implements TestBean {
	
	private String hostname = "";
	private int port = 9090;

	private String command = "ping";
	private String payload = "";
	
	private String failureReason = "Unknown";
	
	public ThriftSampler() {
		super();
		setName("Stub Sampler");
	}
	
	/**
	 * Returns last line of output from the command
	 */
	public SampleResult sample(Entry e) {
		SampleResult res = new SampleResult();
		res.setSampleLabel(hostname + ":" + port);
		
		// Set up sampler return types
		res.setSamplerData(command);
		res.setDataType(SampleResult.TEXT);
		res.setContentType("text/plain");
		
		String response = "";
		
		try {
			res.sampleStart();
			
			// Do something here
			Thread.sleep(1000)
			
			res.sampleEnd();
			res.setResponseData(response.getBytes());
			res.setSuccessful(true);
			res.setResponseCodeOK();
	        res.setResponseMessageOK();
		} catch (Exception e1) {
			res.setSuccessful(false);
			res.setResponseCode("Exception");
			res.setResponseMessage(e1.getMessage());
		}
		return res;
	}
	
	
	// Accessors
	public String getCommand() {
		return command;
	}

	public void setCommand(String payload) {
		this.command = command;
	}
	
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String server) {
		this.hostname = server;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
