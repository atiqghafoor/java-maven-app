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
        echo 'Atiq Branch $BRANCH_NAME'
        script {
          sh 'mvn package'
          //gv.buildJar()
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
