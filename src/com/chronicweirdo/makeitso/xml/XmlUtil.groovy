package com.chronicweirdo.makeitso.xml

import java.util.Map;

class XmlUtil {

	static Map extract(String xml, Map paths) {
		def api = new XmlSlurper().parseText(xml);
		Map result = [:];
		paths.each { name, path ->
			def el = api;
			path.each {
				el = el[it];
			}
			result.put(name, el);
		}
		return result;
	}
	
	static main(args) {
		String xml = '<?xml version="1.0"?><api><login result="NeedToken" token="717ce8debc51353611e7b0ea3b971a90" cookieprefix="labspace" sessionid="d7971863abf69f3ff5c301e2861c8950" /></api>';
		println extract(xml, ['cookieprefix': ['login', '@cookieprefix'], 'token': ['login', '@token'], 'sessionid': ['login', '@sessionid']]);
	}

}
