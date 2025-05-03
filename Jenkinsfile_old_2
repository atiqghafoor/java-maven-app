#!/user/bin/env groovy

@Library('jenkins-shared-library')
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
          buildImage '137.202.47.31:8083/demo-app:jma-6.0'
          dockerLogin()
          dockerPush '137.202.47.31:8083/demo-app:jma-6.0'
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
