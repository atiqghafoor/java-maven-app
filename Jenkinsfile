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
      when {
        expression {
          BRANCH_NAME == 'own-starting-code'
        }
      }
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
          buildImage()
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
