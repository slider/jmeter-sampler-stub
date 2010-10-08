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

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;

public class StubSamplerBeanInfo extends BeanInfoSupport {

	public StubSamplerBeanInfo() {
		super(StubSampler.class);
		
		createPropertyGroup("host", // $NON-NLS-1$
				new String[]{
				"hostname", // $NON-NLS-1$
				"port" // $NON-NLS-1$
		});
		
		createPropertyGroup("execute", new String[]{
				"command", // $NON-NLS-1$
				"payload" // $NON-NLS-1$
		});
		
		PropertyDescriptor p;
		p = property("hostname"); // $NON-NLS-1$
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "");
		
		p = property("port"); // $NON-NLS-1$
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, new Integer(9090));
		
		p = property("command"); // $NON-NLS-1$
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "ping");
		
		p = property("payload"); // $NON-NLS-1$
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "payload");
	}
}
