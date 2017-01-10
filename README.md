# Panda-Vault
Secure storage of PANs using tokens and pads.

Do the following to get the project, build and run.

1. Clone from git https://github.com/Ranx0r0x/Panda-Vault
2. Use Maven to run install on the assembly project POM.xml
--This should result in the projects compiling, running tests and creating the karaf zip
3. Open the pandaAppliance/pandavault/target folder.
4. Unzip the pandavault-4.0.6.zip.
5. Navigate to the bin directory and run the karaf.bat or karaf.sh script.
--This should run the script and bring up the karaf console.  If you type "list" you should see
all the bundles listed as Active.  If some are still in a grace period, retype list until it is ready.
6. Open your browser and enter: http://localhost:8080/cxf/whitevault/?wsdl
--This should show the WSDL associated with the project.
7. In the soapui folder there is a pre-created soapui project that can
   be loaded in SOAP UI.  
   a. Run the addPan request and copy the token recieved back.
   b. Open the getPan and paste the token in to the request.
   c. Run the request and note that the original PAN is returned.
   
   If you run the add multiple times with the same PAN it will always return the same token. In organizations
   with multiple systems that might add the same PAN from various sources this will ensure syncrhonization.