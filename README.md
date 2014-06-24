###Camel and CXF demo

This demo shows a frontend REST service that sends messages through a Content Based Router that routes messages either
to a backend REST service, or a backend SOAP service depending on the message content.

![alt text](https://raw.githubusercontent.com/jonmwalton/cxf-demo/master/cxf-demo-route.png "Demo route")

To try it out point your browser at:

####Call the backend SOAP Service
[http://localhost:9090/route/restservice/getsomething/callSoapService](http://localhost:9090/route/restservice/getsomething/callSoapService)

####Call the backend REST Service
[http://localhost:9090/route/restservice/getsomething/callRestService](http://localhost:9090/route/restservice/getsomething/callRestService)

####Demo Steps

1. Before the demo, delete just the route from the blueprint.xml. Also start Fuse and execute fabric:create

1. Create the route

1. Run the unit test (right-click pom.xml > Run as... > Maven Tests

1. Run on Local Camel Context (right-click blueprint.xml > Run as... > Local Camel Context without tests

1. Enable tracing

1. Exercise the route from a browser using the URL's above and show the message tracing

1. **IMPORTANT** make sure you stop the Local Camel Context

1. Deploy to Fabric. Open a terminal in the demo directory and execute mvn fabric8:deploy -DskipTests

1. Open the Fuse Management Console

1. Show the new Profile in the Wiki

1. Create a new container using the new Profile

1. Show the three services in the API tab and the WADL form for calling the services

1. Connect to the container and show the Camel tab etc

1. Enable Debugging and insert a breakpoint

1. Exercise the route via the WADL in the API tab

1. Step through the route and show the message state

1. Go back to the IDE and modify the route by adding a Log message somewhere

1. Edit the pom.xml at the end and change to version 2.0

1. Re-deploy the new version by executing mvn fabric8:deploy -DskipTests

1. Open the Manage tab in the Fabric

1. Select version 2.0 and apply it to the container

1. Show the new version 2.0 services in the API tab and the new route in the container

1. Exercise version 2.0 from the WADL

1. Show the revised route in the container and the new log message appearing
