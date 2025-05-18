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
        echo "groovy script uploaded sucessfully"
      }
    }
    stage("build jar") {
      steps {
        echo "Branch $BRANCH_NAME"
        script {
          gv.buildJar()
        }   
      }      
    }
    stage("build image") {
      steps {
        script {
           gv.buildImage()         
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
