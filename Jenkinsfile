pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/jpabbisetty/intelligentsearch.git', branch: 'master', credentialsId: '70593cd5d515abc7e05095feb200f7b4f0e847c2', changelog: true)
        echo 'Hi This is first Build with Pipeline'
      }
    }
  }
}