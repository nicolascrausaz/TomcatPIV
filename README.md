# PIV Card Authentication Documentation

Documentation created by Ben Nordin and updated by Nicolas Crausaz

This documentation goes through the steps to make Smart Card Authentication possible on a tomcat server. More specifically, this documentation will show how to authenticate clients with government PIV (Personal Identity Verification) cards. The application created will give two options for authentication. One is a regular username and password form, and the other is with an X.509 certificate.

### Required Technologies

This authentication process can of course be done with a number of different technologies, but for this documentation, Tomcat will be used with Java Spring. Before beginning, the following technologies should be understood and prepared:

 - Tomcat 9
 - Java Spring
 - Maven
 - Keytool

## Step by step

The steps to be taken are explained in the word document.
