pipeline {
	agent any

	stages {
	

	    
	    stage('Build Agent Svc application') {
	                         
	           steps {
	           
	               build 'AgentSvc_buildNew'
	           }
              
	     }
	     stage('Publish to Registry') {
	                         
	           steps {
	              
	               build 'AgentSvc_PublishArtifacts'

            
	           }
              
	     }
	     stage('Deploy To Kubernetes Cluster') {
	                         
	           steps {
	               build 'AgentSvc_DeployToCluster'
            
	           }
              
	     }

	}

}