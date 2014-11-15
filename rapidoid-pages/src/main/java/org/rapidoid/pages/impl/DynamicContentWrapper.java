package org.rapidoid.pages.impl;

/*
 * #%L
 * rapidoid-pages
 * %%
 * Copyright (C) 2014 Nikolche Mihajlovski
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

import org.rapidoid.html.Tag;
import org.rapidoid.html.TagProcessor;
import org.rapidoid.html.Tags;
import org.rapidoid.html.impl.UndefinedTag;
import org.rapidoid.http.HttpExchange;
import org.rapidoid.pages.DynamicContent;

public class DynamicContentWrapper extends UndefinedTag<Tag<?>> {

	private static final long serialVersionUID = 3180185069262405035L;

	private final DynamicContent dynamic;

	private Object content;

	public DynamicContentWrapper(DynamicContent dynamic) {
		this.dynamic = dynamic;
	}

	public DynamicContent getDynamic() {
		return dynamic;
	}

	@Override
	public Tag<?> copy() {
		return new DynamicContentWrapper(dynamic);
	}

	@Override
	public String tagKind() {
		return "dynamic";
	}

	@Override
	public void traverse(TagProcessor<Tag<?>> processor) {
		Tags.traverse(content, processor);
	}

	public Object generateContent(HttpExchange x) {
		content = dynamic.eval(x);
		return content;
	}

}
