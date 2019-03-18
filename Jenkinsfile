pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/jpabbisetty/intelligentsearch.git', branch: 'master', credentialsId: 'b5e9b61f75309dd948247102753de3b241dd11a6')
      }
    }
  }
}