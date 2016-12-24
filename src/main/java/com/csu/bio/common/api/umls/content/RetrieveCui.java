/*This example allows you to retrieve information about a known UMLS CUI.
Examples are at https://github.com/jayway/rest-assured/tree/master/examples/rest-assured-itest-umls/src/test/umls/com/jayway/restassured/itest/umls
You can run this class as a Junit4 test case - be sure and put each of the arguments as VM arguments 
in your runtime configuration, such as -Dapikey=12345-abcdef -Did=C0018787
 */

package com.csu.bio.common.api.umls.content;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.csu.bio.common.api.umls.ConceptLite;
import com.csu.bio.common.api.umls.RestTicketClient;
import com.csu.bio.common.constants.PropertyConfigurer;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static org.apache.commons.lang.StringUtils.join;

public class RetrieveCui {

	// String username = System.getProperty("username");
	// String password = System.getProperty("password");
	String apiKey = PropertyConfigurer.getProperty("umls.user.apikey");

	String id = PropertyConfigurer.getProperty("umls.user.apikey");;

	String version = PropertyConfigurer.getProperty("umls.user.apikey");;

	RestTicketClient ticketClient = new RestTicketClient(apiKey);
	// get a ticket granting ticket for this session.
	String tgt = ticketClient.getTgt();

	public void retrieveCui() throws Exception {

		System.out.println(apiKey);

		// if you omit the -Dversion parameter, use 'current' as the default.
		version = version == null ? "current" : version;
		String path = "/rest/content/" + version + "/CUI/" + id;
		RestAssured.baseURI = "https://uts-ws.nlm.nih.gov";
		Response response = given().log().all().request().with().param("ticket", ticketClient.getST(tgt)).expect()
				.statusCode(200).when().get(path);
		// response.then().log().all();;
		String output = response.getBody().asString();
		Configuration config = Configuration.builder().mappingProvider(new JacksonMappingProvider()).build();
		ConceptLite conceptLite = JsonPath.using(config).parse(output).read("$.result", ConceptLite.class);

		System.out.println(conceptLite.getUi() + ": " + conceptLite.getName());
		System.out.println("Semantic Type(s): " + join(conceptLite.getSemanticTypes(), ","));
		System.out.println("Number of Atoms: " + conceptLite.getAtomCount());
		System.out.println("Atoms: " + conceptLite.getAtoms());
		System.out.println("Definitions: " + conceptLite.getDefinitions());
		System.out.println("Relations: " + conceptLite.getRelations());
		System.out.println("Highest Ranking Atom: " + conceptLite.getDefaultPreferredAtom());

	}

	public static void main(String[] args) {
		System.out.println(PropertyConfigurer.getProperty("umls.user.apikey"));
	}
}
