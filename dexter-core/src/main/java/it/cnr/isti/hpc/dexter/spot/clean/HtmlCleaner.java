/**
 *  Copyright 2012 Diego Ceccarelli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package it.cnr.isti.hpc.dexter.spot.clean;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * convert javascript strings in ascii
 *
 * @author Diego Ceccarelli, diego.ceccarelli@isti.cnr.it
 * created on 20/lug/2012
 */

public class HtmlCleaner implements Cleaner {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(HtmlCleaner.class);

	
	
	//@Override
	public String clean(String spot) {
		spot = StringEscapeUtils.unescapeHtml(spot);
		try {
			 spot = URLDecoder.decode(spot, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.debug("error trying to convert the text from javascript to string");
		} catch (IllegalArgumentException e){
			logger.debug("error trying to convert the text from javascript to string");
		}
		return spot;
		
	}



	
	public boolean post() {
		return false;
	}



	
	public boolean pre() {
		return true;
	}
	
	
	


	
	

}