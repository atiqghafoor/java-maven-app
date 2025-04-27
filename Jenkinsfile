pipeline {
  agent any
  tools {
    maven 'maven-3.9'
  }
  stages {
    stage("build jar") {
      steps {
        script {
          echo "building the application..."
          sh 'mvn package'
        }   
      }      
    }
    stage("build image") {
      steps {
        script {
          echo "building the docker image..."
          withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'USER', usernameVariable: 'PASS')])
          sh 'echo ----- $USER $PASS'
          sh 'docker build -t 137.202.47.31:8083/jma_jenkinsfile:1.1 .'
          sh 'echo $PASS | docker login -u $USER --password-stdin 137.202.47.31:8083'
          //sh 'echo 'admin' | docker login -u 'admin' --password-stdin 137.202.47.31:8083'
          sh 'docker push 137.202.47.31:8083/jma_jenkinsfile:1.1'
        }       
      }      
    }
    stage("Deploy") {
      steps {
        script {
          echo "deploying the application..."
        }
      }    
    }
  }
}
