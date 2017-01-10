# The Disease Web Server

--------------------------------------
## INTRODUCTION
This project is a web front-end of the disease data - a web service to providing the API 

--------------------------------------
## METHOD

### 1. disease id mapping

### 2. disease data retrieve

### 3. disease similarity matrix computer

### 4. disease-*(gene,lncRNA,microRNA,drug) prediction
 - [LDAP](http://bioinformatics.csu.edu.cn/ldap/) lncRNA-disease association predictor

### 5. data integration 
 - [disease.process](https://github.com/kayzhao/Disease.Process)

--------------------------------------
## Datasets

### 1. Disease Data Sources
- [UMLS](https://uts.nlm.nih.gov/home.html)
- [CTDBase](http://ctdbase.org/)
- [Disease Ontoloy](http://disease-ontology.org/)
- [DisGeNet](http://www.disgenet.org/web/DisGeNET/menu)
- [Human Phenotype Ontology](http://human-phenotype-ontology.github.io/)
- [MeSH](https://www.nlm.nih.gov/mesh/)
- [NDF-RT](https://www.nlm.nih.gov/research/umls/sourcereleasedocs/current/NDFRT/)
- [Orphanet](http://www.orpha.net/consor/cgi-bin/index.php)
- [PharmacotherapyDB](https://thinklab.com/discussion/announcing-pharmacotherapydb-the-open-catalog-of-drug-therapies-for-disease)
- [KEGG](http://www.kegg.jp/kegg/disease/)
- [HPO](http://human-phenotype-ontology.github.io/)


--------------------------------------
## WORKFLOW


--------------------------------------
## Keywords
- Spring
- ElsaticSearch
- Hibernate
- Mongodb
- Disease Web Server

--------------------------------------
## Contacts
- Kaijie Zhao:kay.zkj@csu.edu.cn
- Jianxin Wang: jxwang@mail.csu.edu.cn
- Min Li: limin@mail.csu.edu.cn

## Our Group
- [NetLab](http://netlab.csu.edu.cn/)
- [BioGroup](http://bioinformatics.csu.edu.cn/)

--------------------------------------
## Note

### 1. Spring Mongodb xml Configure

- spring dependency 

		<!-- Spring data mongodb -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-mongodb</artifactId>
			<version>1.8.4.RELEASE</version>
		</dependency>
		<!-- MongoDB Java Driver -->
		<dependency>
			<groupId>org.mongodb</groupId>
			<artifactId>mongo-java-driver</artifactId>
			<version>3.3.0</version>
		</dependency>

- the full mongo-client config(spring-data-mongodb V1.7+)

		<mongo:mongo-client id="mongoClient" host="${mongo.host}"
			port="${mongo.port}">
			<mongo:client-options connections-per-host="${mongo.connectionsPerHost}"
				min-connections-per-host="${mongo.minConnectionsPerHost}"
				threads-allowed-to-block-for-connection-multiplier="${mongo.threadsAllowedToBlockForConnectionMultiplier}"
				connect-timeout="${mongo.connectTimeout}" max-wait-time="${mongo.maxWaitTime}"
				socket-keep-alive="${mongo.socketKeepAlive}" socket-timeout="${mongo.socketTimeout}"
				description="${mongo.description}" max-connection-idle-time="${mongo.maxConnectionIdleTime}"
				max-connection-life-time="${mongo.maxConnectionLifeTime}"
				heartbeat-socket-timeout="${mongo.heartbeatSocketTimeout}"
				heartbeat-connect-timeout="${mongo.heartbeatConnectTimeout}"
				min-heartbeat-frequency="${mongo.minHeartbeatFrequency}"
				heartbeat-frequency="${mongo.heartbeatFrequency}" />
		</mongo:mongo-client>

- the mini mongo-client config

		<!--if auth check, mongo-client attributes add: credentials="${mongo.user}:${mongo.pwd}@${mongo.defaultDbName}" -->
		<!-- mini client -->
		<mongo:mongo-client id="mongoClient" host="${mongo.host}"
			port="${mongo.port}">
			<mongo:client-options write-concern="SAFE" />
		</mongo:mongo-client>

### 2. Spring ElasticSearch xml Configure
- the spring dependency

		<!-- ELASTICSEARCH -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-elasticsearch</artifactId>
			<version>1.2.0.RELEASE</version>
		</dependency>

### 3. Spring Properties xml Configure
- configure the properties files to spring bean  

		<!-- all properties -->
		<bean id="apiProperties" class="com.csu.bio.util.PropertyConfigurer">
			<property name="locations">
				<list>
					<value>classpath:umls.properties</value>
					<value>classpath:mygene.properties</value>
					<value>classpath:mongo.properties</value>
				</list>
			</property>
		</bean>
		

### 4. Encoding of UTF-8
- html page 

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		</head>
- web.xml

		<filter>
			<filter-name>encodingFilter</filter-name>
			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>UTF-8</param-value>
			</init-param>
			<init-param>
				<param-name>forceEncoding</param-name>
				<param-value>true</param-value>
			</init-param>
		</filter>
		<filter-mapping>
			<filter-name>encodingFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
	
- spring-mvc.xml

		<bean id="velocityConfigurer"
			class="org.springframework.web.servlet.view.velocity.VelocityConfigurer">
			<property name="resourceLoaderPath" value="/WEB-INF/views" />
			<property name="velocityProperties">
				<props>
					<prop key="input.encoding">UTF-8</prop>
					<prop key="output.encoding">UTF-8</prop>
					<prop key="contentType">text/html;charset=UTF-8</prop>
				</props>
			</property>
		</bean>


- mysql encoding

		mysql> show variables like 'character%';
		+--------------------------+----------------------------+
		| Variable_name            | Value                      |
		+--------------------------+----------------------------+
		| character_set_client     | utf8                       |
		| character_set_connection | utf8                       |
		| character_set_database   | utf8                       |
		| character_set_filesystem | binary                     |
		| character_set_results    | utf8                       |
		| character_set_server     | utf8                       |
		| character_set_system     | utf8                       |
		| character_sets_dir       | /usr/share/mysql/charsets/ |
		+--------------------------+----------------------------+
		8 rows in set

- tomcat server.xml

		<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"　redirectPort="8443" URIEncoding="UTF-8" />
		<Connector port="8009" protocol="AJP/1.3" redirectPort="8443"  URIEncoding="UTF-8"/>	
		
- eclipse workspace
	
		 1. Window -> Preference -> Content types
		 	UTF-8
		 2. Java source code
			Window -> Preference -> Workspace -> Text file encoding
			Windows default is GBK，Linux default is UTF-8