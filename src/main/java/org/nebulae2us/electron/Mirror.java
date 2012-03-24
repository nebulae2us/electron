/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nebulae2us.electron;

import java.util.List;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public interface Mirror {
	
	public boolean exists(String fieldName);
	
	public <T> T to(Class<T> objectClass, String fieldName);
	
	public <T> List<T> toListOf(Class<T> objectClass, String fieldName);

	public <T> Set<T> toSetOf(Class<T> objectClass, String fieldName);
	
	public Object toObject(String fieldName);

	public String toString(String fieldName);

	public Integer toInteger(String fieldName);
	
	public int toIntValue(String fieldName);

	public Long toLong(String fieldName);
	
	public long toLongValue(String fieldName);

	public Short toShort(String fieldName);
	
	public short toShortValue(String fieldName);

	public Byte toByte(String fieldName);
	
	public byte toByteValue(String fieldName);

	public Double toDouble(String fieldName);
	
	public double toDoubleValue(String fieldName);

	public Float toFloat(String fieldName);
	
	public float toFloatValue(String fieldName);

	public Boolean toBoolean(String fieldName);
	
	public boolean toBooleanValue(String fieldName);

	public Character toCharacter(String fieldName);
	
	public char toCharValue(String fieldName);

	public void register(Object object);	
	
}
