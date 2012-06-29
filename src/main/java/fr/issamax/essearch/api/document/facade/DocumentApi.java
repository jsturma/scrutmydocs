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

package fr.issamax.essearch.api.document.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.issamax.essearch.api.document.data.Document;
import fr.issamax.essearch.api.document.data.RestResponseDocument;
import fr.issamax.essearch.api.document.service.RestDocumentService;
import fr.issamax.essearch.constant.ESSearchProperties;

@Controller
@RequestMapping("/doc")
public class DocumentApi {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	RestDocumentService restDocumentService;

	/**
	 * Add a new document
	 * @param doc
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	RestResponseDocument push(@RequestBody Document doc) {
		doc = restDocumentService.push(doc);
		RestResponseDocument response = new RestResponseDocument(doc);
		return response;
	}

	/**
	 * Delete an existing document
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public @ResponseBody
	RestResponseDocument delete(@PathVariable String id) {
		restDocumentService.delete(id);
		return new RestResponseDocument();
	}

	/**
	 * Get a document with its coordinates (index, type, id)
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{index}/{type}/{id}")
	public @ResponseBody
	Document get(@PathVariable String index, @PathVariable String type,
			@PathVariable String id) {
		return restDocumentService.get(index, type, id);
	}

	/**
	 * Get a document of type "doc" in a given index knowing its id
	 * @param index
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{index}/{id}")
	public @ResponseBody
	Document get(@PathVariable String index, @PathVariable String id) {
		return get(index, ESSearchProperties.INDEX_TYPE_DOC, id);
	}

	/**
	 * Get a document in the default index/type (docs/doc) knowing its id
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody
	Document get(@PathVariable String id) {
		return get(ESSearchProperties.INDEX_NAME, ESSearchProperties.INDEX_TYPE_DOC, id);
	}

}