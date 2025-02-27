pipeline {

  agent any
  environment {
    NEW_VERSION = '1.3.0'
    //SERVER_CREDENTIALS = credentials('server-credentials')
  }

  tools {
    maven "maven-3.9"
  }

  parameters {
    string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }

  stages {

    stage("build") {

      steps {
        echo 'Building the application...'
        echo "building version ${NEW_VERSION}"
      }
    }

    stage("test") {
      when {
        expression {
          //env.BRANCH_NAME == 'dev' && CODE_CHNAGES == true
          params.executeTests
        }
      }
      steps {
        echo 'Testing the application...'
      }
    }

    stage("deploy") {
      
      steps {
        echo 'Deploying the application...'
        echo "deploying version ${params.VERSION}"
        withCredentials([
          usernamePassword(credentials: 'server-credentials', usernameVariable: USER,  passwordVariable: PWD)
        ]){
          sh "some script ${USER} ${PWD}"
        }
      }
    }
    
  }
}

post {
  always {
    echo 'Always post block'
  }
  failure {
    echo 'Job has been failed'
  }
}

node {
  // groovy script
}
