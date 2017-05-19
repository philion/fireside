package com.acmerocket.fireside;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTemplate {
	private static final Logger LOG = LoggerFactory.getLogger(JsonTemplate.class);

	public static String DEFAULT_ROOT_NAME = "template";
	
	// TODO Add external files, overlay.

	private static final String KEY = "@";
	private static final Pattern KEY_PATTERN = Pattern.compile(KEY + "(\\w+)");

	private final JsonNode root;

	public JsonTemplate(JsonNode root) {
		this.root = root;
	}

	public static JsonTemplate load(String filename) throws IOException {
		return load(new File(filename));
	}
	
	public static JsonTemplate load(File file) throws IOException {
		return load(new FileInputStream(file));
	}

	public static JsonTemplate load(InputStream in) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(in);
		// LOG.info("Loaded JSON: {}", root);
		// LOG.info("Template: {}", root.get("template").get(0));
		return new JsonTemplate(root);
	}

	public String getTmpl() {
		return this.get(DEFAULT_ROOT_NAME);
	}

	public String get(String name) {
		JsonNode node = this.root.get(name);

		if (node.isArray()) {
			int idx = Utils.random(node.size());
			node = node.get(idx);
		}

		return node.textValue();
	}

	public static List<String> keys(String str) {
		List<String> found = new ArrayList<>();

		// parse out @ words
		// LOG.info("Searching {}", str);
		Matcher matcher = KEY_PATTERN.matcher(str);
		while (matcher.find()) {
			found.add(matcher.group(1));
		}

		return found;
	}

	public Map<String, String> fill() {
		return this.fill(DEFAULT_ROOT_NAME);
	}
	
	public Map<String, String> fill(String tmplName) {
		HashMap<String, String> attrs = new HashMap<>();
		String value = this.fill(this.get(tmplName), attrs);
		attrs.put("value", value);
		return attrs;
	}
	
	// ---

	private String fill(String tmpl, Map<String, String> attrs) {
		String result = "";

		for (String token : tmpl.split("\\s")) {
			if (token.startsWith(KEY)) {
				String key = token.substring(KEY.length());
				String value = this.get(key);

				value = this.fill(value, attrs);

				String oldValue = attrs.put(key, value);
				if (LOG.isDebugEnabled() && oldValue != null) {
					LOG.debug("COLLISION {}: old:{}, new:{}", key, oldValue, value);
				}
				// LOG.debug("{} == {}", key, value);

				result += value + " ";
			} else {
				result += token + " ";
			}
		}

		// LOG.debug("result: {}", result);
		return result.trim();
	}
}
