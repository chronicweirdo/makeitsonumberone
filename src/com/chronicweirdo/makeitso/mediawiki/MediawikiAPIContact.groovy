package com.chronicweirdo.makeitso.mediawiki

import javax.net.ssl.HttpsURLConnection
import javax.xml.xpath.XPathFactory

import org.xml.sax.InputSource

import com.chronicweirdo.makeitso.xml.XmlUtil

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
		Map result = [:]
		String actual = cookie.substring(0, cookie.indexOf(";"));
		String[] data = actual.split("=");
		if (data.length == 2) {
			result[data[0]] = data[1]
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
				if (value != null && value != "") {
					builder.append("=")
						.append(value)
				}
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
	
	// authenticates and returns cookies to be used in future requests
	static Map auth() {
		// authenticate
		def postParams = ["action": "login", "lgname": "silviu.cacoveanu@epfl.ch", "lgpassword": "T4ppitikar455", "format": "xml"]
		Response response = request(MEDIAWIKI_API, null, postParams, "POST", null);
		String token = XmlUtil.extract(response.content.trim(), ["token": ["login", "@token"]])["token"];
		postParams["lgtoken"] = token
		
		// confirm token
		def sessionCookie = ["labspace_session":response.cookies["labspace_session"]];
		response = request(MEDIAWIKI_API, null, postParams, "POST", 
			sessionCookie);

		return response.cookies;
	}
	
	static get(cookies, getParams) {
		def response = request(MEDIAWIKI_API, getParams, null, "GET",
			cookies);
		println response.cookies
		println response.content
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
		Map cookies = auth();
		def getParams = [
			"action": "query",
			"prop": "revisions",
			"rvprop": "content",
			"format": "xml",
			"titles": "Mt080224a1-1"
			]
		get(cookies, getParams);
		
		//api.php?action=query&prop=revisions&titles=API|Main%20Page&rvprop=timestamp|user|comment|content
		getParams["rvprop"] = "timestamp|user|content";
		getParams["rvlimit"] = "100";
		get(cookies, getParams);
	}

}
