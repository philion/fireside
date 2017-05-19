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

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author philion
 *
 */
public class Thesaurus {
    private static final Logger LOG = LoggerFactory.getLogger(Thesaurus.class);
    
    private static final String THESAURUS_FILE = "/thesaurus.csv";

	private final Map<String,Set<String>> index = new HashMap<>();
	
	public static synchronized Thesaurus instance() {
		return new Thesaurus(Thesaurus.class.getResourceAsStream(THESAURUS_FILE));
	}
	
	public Thesaurus(InputStream in) {
		Scanner scanner = new Scanner(in);
		while(scanner.hasNextLine()) {
			String line= scanner.nextLine();
			String[] words = line.split(",");
			//LOG.debug("Loading: {}[{}]", words[0], words.length);
			
			Set<String> synonyms = new HashSet<String>();
			Collections.addAll(synonyms, words);
			
			for (String word : words) {
				this.index.put(word, synonyms);
			}
		}
		scanner.close();
		LOG.debug("Loaded {} words", this.index.size());
	}
	
	public String get(String word) {
		Set<String> synonyms = this.index.get(word);
		if (synonyms == null) {
			return word;
		}
		else {
			LOG.debug("Checking {}", synonyms);
			return random(synonyms);
		}
	}
	
	private static int random(int size) {
		return (int) (Math.random() * size);
	}
	
	private static String random(String[] arry) {
		return arry[random(arry.length)];
	}
	
	private static String random(Set<String> coll) { // TODO generify
		if (coll != null) {
			return random(coll.toArray(new String[coll.size()]));
		}
		return null;
	}
	
	public static void main(String[] args) {
		Thesaurus thes = Thesaurus.instance();
		LOG.info("Synonym for beautiful: {}", thes.get("beautiful"));
	}
}
