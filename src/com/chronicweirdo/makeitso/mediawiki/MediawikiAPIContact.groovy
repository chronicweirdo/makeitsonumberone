package com.chronicweirdo.makeitso.mediawiki

import javax.net.ssl.HttpsURLConnection
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathFactory

import org.w3c.dom.Document
import org.xml.sax.InputSource

class MediawikiAPIContact {
	
	private static final String ENCODING = "UTF-8";
	private static final String MEDIAWIKI_API = "https://bbp.epfl.ch/project/smwtesting/w/api.php";
	
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static String AUTHORIZATION_TOKEN = "Basic Y2Fjb3ZlYW46VDRwcGl0aWthcnI0NTU=";

	static URL url(address, params) {
		StringBuilder builder = new StringBuilder(address)
		if (params) {
			builder.append("?");
			builder.append(encode(params));
		}
		return new URL(builder.toString());
	}
	
	static String encode(params) {
		StringBuilder builder = new StringBuilder();
		if (params) {
			def prefix = ""
			params.each { key, value ->
				builder.append(prefix)
					.append(key)
					.append("=")
					.append(URLEncoder.encode(value, ENCODING));
				prefix = "&";
			}
		}
		return builder.toString();
	}
	
	static Map convertCookie(String cookie) {
		def result = [:]
		String[] cookies = cookie.split(";");
		cookies.each { cook ->
			String[] data = cook.split("=");
			//String[] res = data.collect{it.trim()}
			if (data.length == 2) {
				result[data[0]] = data[1]
			} else {
				result[data[0]] = ""
			}
		}
		return result
	}
	
	static Map findCookies(URLConnection connection) {
		String headerName=null;
		def result = [:];
		for (int i=1; (headerName = connection.getHeaderFieldKey(i))!=null; i++) {
			 if (headerName.equals("Set-Cookie")) {
				 String cookie = connection.getHeaderField(i);
				 result.putAll(convertCookie(cookie))
			 }
		}
		return result;
	}
	
	static class Response {
		String content;
		Map cookies; 
	}
	
	static Response request(String baseUrl, Map getParams, Map postParams, String method, Map cookies) {
		URL url = url(baseUrl, getParams);
		println url.toString()
		HttpsURLConnection connection = url.openConnection();
		connection.setRequestProperty(AUTHORIZATION_PROPERTY, AUTHORIZATION_TOKEN);
		connection.setRequestMethod(method);
		connection.setFollowRedirects(true);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		if (cookies) {
			StringBuilder builder = new StringBuilder();
			String prefix = "";
			cookies.each { key, value ->
				builder.append(prefix)
					.append(key)
					.append("=")
					.append(value)
				prefix = ";"
			}
			connection.setRequestProperty("Cookie", builder.toString());
		}
		
		if (postParams) {
			String query = encode(postParams);
			connection.setRequestProperty("Content-length",String.valueOf (query.length()));
			DataOutputStream output = new DataOutputStream(connection.getOutputStream());
			output.writeBytes(query);
		}
		
		connection.connect();
		
		Response response = new Response();
		
		response.cookies = findCookies(connection);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		reader.eachLine { line ->
			builder.append(line).append("\n");
		}
		reader.close();
		response.content = builder.toString();
		
		return response;
	}
	
	static String xpathFromXml(String xml, String expression) {
		InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes("UTF-8")))
		
		def xpath = XPathFactory.newInstance().newXPath()
		
		//DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder builder = factory.newDocumentBuilder();
		//Document doc = builder.parse(inputSource);
		//XPathFactory xPathfactory = XPathFactory.newInstance();
		//XPath xpath = xPathfactory.newXPath();
		//XPathExpression expr = xpath.compile(/api/login@result);
		//println xpath.evaluate("api/login/@result", inputSource);
		return xpath.evaluate(expression, inputSource);
	}
	
	static auth() {
		def postParams = ["action": "login", "lgname": "silviu.cacoveanu@epfl.ch", "lgpassword": "T4ppitikar455", "format": "xml"]
		Response response = request(MEDIAWIKI_API, null, postParams, "POST", null);
		println response.cookies
		println response.content
		
		String token = xpathFromXml(response.content.trim(), "/api/login/@token");
		postParams["lgtoken"] = token
		println postParams
		def sessionCookie = ["labspace_session":response.cookies["labspace_session"]];
		response = request(MEDIAWIKI_API, null, postParams, "POST", 
			sessionCookie);
		println response.cookies
		println response.content
		
		def getParams = [
			"action": "parse",
			"titles": "Mt080224a1-1",
			];
/*		postParams = [
		              "action": "query",
		              "titles": "Mt080224a1-1",
		              "prop": "revisions",
		              "format": "xml"
		            	  ];
*/		
		sessionCookie.putAll(response.cookies)
		response = request(MEDIAWIKI_API, getParams, null, "GET",
			sessionCookie);
		println response.cookies
		println response.content
		//String cookie = 'labspace_session=c47b35a65a6dc49a615fee823b7610ae; is_returning=1'
		//connection.setRequestProperty("Cookie", cookie)
				
		//connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		//BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
	}
	
	static read(URL url) {
		HttpsURLConnection connection = url.openConnection();
		connection.setRequestMethod("POST");
		connection.setFollowRedirects(true);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		DataOutputStream output = new DataOutputStream( connection.getOutputStream() );
		//connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		//BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getOutputStream()));
		reader.eachLine { line ->
			println line;
		}
		reader.close();
	}
	
	static main(args) {
		auth();
	}

}
