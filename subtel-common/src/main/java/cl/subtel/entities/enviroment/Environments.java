package cl.subtel.entities.enviroment;

public enum Environments {
	
	Local, //Developer's desktop/workstation
	Development, //Development server acting as a sandbox where unit testing may be performed by the developer
	Integration, //CI build target, or for developer testing of side effects
	Testing, //Acceptance The environment where interface testing is performed. A quality control team ensures that the new code will not have any impact on the existing functionality and tests major functionalities of the system after deploying the new code in the test environment.
	Staging, //External-Client Acceptance/Demo	Mirror of production environment
	Production //Live Serves end-users/clients

}