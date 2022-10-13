pipeline {
	agent any

	stages {
	    
	    stage('Build the application') {
	                         
	           steps {
	               build 'AgentSvc_Build'
	           }
              
	     }
	     stage('Build the container image') {
	                         
	           steps {
	              
	               build 'AgentSvc_PublishArtifacts'

            
	           }
              
	     }
	     stage('Deploy the changes to server') {
	                         
	           steps {
	               build 'AgentSvc_DeployToCluster'
            
	           }
              
	     }

	}

}