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

import java.util.Map;

/**
 * @author philion
 *
 */
public class Thing {
    //private static final Logger LOG = LoggerFactory.getLogger(Thing.class);

    private final String description;
    
    
    public Thing(Map<String, String> attrs) {
        this.description = attrs.get("value");
    }
    
    public String toString() {
    	return this.description();
    }
    
    public String description() {
        return this.description;
    }
}
