pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(branch: 'master', credentialsId: '00f858db652d119c663c85832c9039b2bb34c92a', url: 'https://github.com/jpabbisetty/intelligentsearch.git')
      }
    }
  }
}
