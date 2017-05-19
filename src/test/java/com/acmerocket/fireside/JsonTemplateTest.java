/**
 * Copyright 2017 Acme Rocket Company [acmerocket.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acmerocket.fireside;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author philion
 *
 */
public class JsonTemplateTest {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JsonTemplateTest.class);
	
	@Test
	public void testArmorIng() throws IOException {
		JsonTemplate template = JsonTemplate.load(this.getClass().getResourceAsStream("/json-template.json"));
		
		Map<String,String> map = template.fill("item");
		String result = map.get("value");
		String tmplValue = template.get("item");
		List<String> keys = JsonTemplate.keys(tmplValue);
		for (String key : keys) {
			String check = map.get(key);
			if (check != null  && check.length() > 0) {
				assertTrue("'" + result + "' doesn't contain '" + check + "'", result.contains(check));
			}
		}
	}
}
