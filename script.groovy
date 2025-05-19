def buildJar() {
  echo 'Building the application....'
  sh 'mvn package'
}

def buildImage() {
  echo 'Building the application...'
  withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
    sh 'docker build -t atiqghafoor/demo-app:jma-1.3 .'  
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push atiqghafoor/demo-app:1.2'
  }
  //withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
  //  sh 'docker build -t 137.202.47.31:8083/jma_jenkinsfile:1.6 .'  
 //   sh 'echo $PASS | docker login -u $USER --password-stdin 137.202.47.31:8083'
 //   sh 'docker push 137.202.47.31:8083/jma_jenkinsfile:1.6'
  //}
}

def deployApp() {
  echo 'Deploying the application...'
}
return this
