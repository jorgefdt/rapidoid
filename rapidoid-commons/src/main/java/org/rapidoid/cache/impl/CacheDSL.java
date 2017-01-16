package org.rapidoid.cache.impl;

/*
 * #%L
 * rapidoid-commons
 * %%
 * Copyright (C) 2014 - 2017 Nikolche Mihajlovski and contributors
 * %%
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
 * #L%
 */

import org.rapidoid.RapidoidThing;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.cache.Cached;

@Authors("Nikolche Mihajlovski")
@Since("5.3.0")
public class CacheDSL<K, V> extends RapidoidThing {

	private volatile org.rapidoid.lambda.Mapper<K, V> of = null;

	private volatile int capacity = 1024;

	private volatile long ttl = 0;

	public CacheDSL<K, V> of(org.rapidoid.lambda.Mapper<K, V> of) {
		this.of = of;
		return this;
	}

	public org.rapidoid.lambda.Mapper<K, V> of() {
		return this.of;
	}

	public CacheDSL<K, V> capacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public int capacity() {
		return this.capacity;
	}

	public CacheDSL<K, V> ttl(long ttl) {
		this.ttl = ttl;
		return this;
	}

	public long ttl() {
		return this.ttl;
	}

	public Cached<K, V> build() {
		return CacheFactory.create(this);
	}

}
