pipeline {
	agent any

	stages {
	    
	    stage('Build Agent Svc application') {
	                         
	           steps {
	               build 'AgentSvc_Build'
	           }
              
	     }
	     stage('Publish to Registry') {
	                         
	           steps {
	              
	               build 'AgentSvc_PublishArtifacts'

            
	           }
              
	     }
	     stage('Deploy To Cluster') {
	                         
	           steps {
	               build 'AgentSvc_DeployToCluster'
            
	           }
              
	     }

	}

}