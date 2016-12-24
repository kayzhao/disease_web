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
 - [LDAP](http://bioinformatics.csu.edu.cn/ldap/)

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