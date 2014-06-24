###Camel and CXF demo

This demo shows a frontend REST service that sends messages through a Content Based Router that routes messages either
to a backend REST service, or a backend SOAP service depending on the message content.

To try it out point your browser at:

####Call the backend SOAP Service
[http://localhost:9090/route/restservice/getsomething/callSoapService](http://localhost:9090/route/restservice/getsomething/callSoapService)

####Call the backend REST Service
[http://localhost:9090/route/restservice/getsomething/callRestService](http://localhost:9090/route/restservice/getsomething/callRestService)
