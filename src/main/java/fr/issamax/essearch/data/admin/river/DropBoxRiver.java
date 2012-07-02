/*
 * Licensed to David Pilato and Malloum Laya (the "Authors") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Authors licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package fr.issamax.essearch.data.admin.river;

import fr.issamax.essearch.util.StringTools;




/**
 * Manage DropBoxRiver Rivers metadata
 * @author PILATO
 *
 */
public class DropBoxRiver extends AbstractRiver {
	private static final long serialVersionUID = 1L;
	
	private String token;
	private String secret;
	private String url;
	private Long updateRate;
	private String includes;
	private String excludes;
	private String analyzer;
	
	/**
	 * We implement here a "dropbox" river
	 */
	@Override
	public String getType() {
		return "dropbox";
	}

	public DropBoxRiver() {
		this(null, null, "tmp", "/tmp", 60L);
	}
	
	/**
	 * @param id The unique id of this river
	 * @param token Dropbox Token
	 * @param secret Dropbox Secret
	 * @param url URL where to fetch content
	 * @param updateRate Update Rate (in seconds)
	 */
	public DropBoxRiver(String id, String token, String secret, String url, Long updateRate) {
		super(id);
		this.token = token;
		this.secret = secret;
		this.url = url;
		this.updateRate = updateRate;
		this.analyzer = "standard";
	}


	/**
	 * @param id The unique id of this river
	 * @param indexname The ES index where we store our docs
	 * @param typename The ES type we use to store docs
	 * @param name The human readable name for this river
	 * @param token Dropbox Token
	 * @param secret Dropbox Secret
	 * @param url URL where to fetch content
	 * @param updateRate Update Rate (in seconds)
	 * @param analyzer Analyzer to use
	 * @param started Is the river already started ?
	 */
	public DropBoxRiver(String id, String indexname, String typename, String name,
			String token, String secret, String url, Long updateRate, String analyzer, boolean started) {
		this(id, indexname, typename, name, token, secret, url, updateRate, null, null, analyzer, started);
	}

	/**
	 * @param id The unique id of this river
	 * @param indexname The ES index where we store our docs
	 * @param typename The ES type we use to store docs
	 * @param name The human readable name for this river
	 * @param token Dropbox Token
	 * @param secret Dropbox Secret
	 * @param url URL where to fetch content
	 * @param updateRate Update Rate (in seconds)
	 * @param includes Include list (comma separator)
	 * @param excludes Exclude list (comma separator)
	 * @param analyzer Analyzer to use
	 * @param started Is the river already started ?
	 */
	public DropBoxRiver(String id, String indexname, String typename, String name,
			String token, String secret, String url, Long updateRate, String includes, String excludes, String analyzer, boolean started) {
		super(id, indexname, typename, name, started);
		this.token = token;
		this.secret = secret;
		this.url = url;
		this.updateRate = updateRate;
		this.includes = includes;
		this.excludes = excludes;
		this.analyzer = analyzer;
	}

	/**
	 * @return URL where to fetch content
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url URL where to fetch content
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return Update Rate (in seconds)
	 */
	public Long getUpdateRate() {
		return updateRate;
	}
	
	/**
	 * @param updateRate Update Rate (in seconds)
	 */
	public void setUpdateRate(Long updateRate) {
		this.updateRate = updateRate;
	}

	/**
	 * @return Include list (comma separator)
	 */
	public String getIncludes() {
		return includes;
	}

	/**
	 * @param includes Include list (comma separator)
	 */
	public void setIncludes(String includes) {
		this.includes = includes;
	}

	/**
	 * @return Exclude list (comma separator)
	 */
	public String getExcludes() {
		return excludes;
	}

	/**
	 * @param excludes Exclude list (comma separator)
	 */
	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}
	
	/**
	 * @return DropBox Token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token DropBox Token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return DropBox Secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret DropBox Secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return StringTools.toString(this);
	}

}