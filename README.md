# Deployment

`$ git clone https://gitlab.dke.univie.ac.at/omilab-tutorials/ServiceTemplate.git`


`$ cd ServiceTemplate`


`$ vim src/main/resources/config/application-distribution.properties`


`$ mvn clean -Pdistribution package`


`$ java -jar target/template-0.1.0-SNAPSHOT.jar`

To keep the jar running in the background, a tool like "screen" can be used.

Instead of the last step, the application can also be deployed on a Tomcat application server. See [here](https://gitlab.dke.univie.ac.at/omilab-tutorials/ServiceTemplate/tags/WAR)