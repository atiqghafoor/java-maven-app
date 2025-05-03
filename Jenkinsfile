#!/user/bin/env groovy

library identifier: 'jenkins-shared-library@own-starting-code', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/atiqghafoor/jenkins-shared-library.git',
         credentialsId: 'github-credentials'])


def gv

pipeline {
  agent any
  tools {
    maven 'maven-3.9'
  }
  stages {
    stage ("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage("build jar") {
      steps {
        echo "Branch $BRANCH_NAME"
        script {
          buildJar()
        }   
      }      
    }
    stage("build image") {
      steps {
        script {
          buildImage '137.202.47.31:8083/demo-app:jma-7.0'
          dockerLogin()
          dockerPush '137.202.47.31:8083/demo-app:jma-7.0'
        }
      }       
    }
    stage("Deploy") {
      steps {
        script {
          gv.deployApp()
        }
      }    
    }
  }
}
