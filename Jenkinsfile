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
          BRANCH_NAME == 'multibranch_test'
        }
      }
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
