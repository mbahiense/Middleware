# Middleware
Middleware between the GSAN system and Asterisk, to mediate communication.

Intermediate middleware responsible for communication via `SOAP` protocol and the `AGI` communication interface,
respectively to interconnect the ``GSAN`` and ``Asterisk`` systems


## How to Works
The communication between the components can be seen below, where the flow starts from a phone call.

[![Flow](https://github.com/mbahiense/tcc_integration/blob/master/image/representacao.PNG?raw=true)](https://github.com/mbahiense/tcc_integration)

In this proposed architecture, each component has the following responsibilities:

* GSAN - Implements Web-service
    * Exposing Access APIs
* Asterisk - Implements call flow
    * Identification rules
    * Data reception
* Middleware - Communication intermediation
    * GSAN consumer - SOAP Protocol
    * Asterisk consumer - FastAGI Protocol


## Article
For more details about this project read this [article](https://github.com/mbahiense/tcc_integration/blob/master/TCC%20-%20Integracao%20GSAN%20x%20URA.pdf?raw=true).


## Live action
[![Middleware in Action](https://img.youtube.com/vi/uJ64RK2m4G8/0.jpg)](https://www.youtube.com/watch?v=uJ64RK2m4G8)
