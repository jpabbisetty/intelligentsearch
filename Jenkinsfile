pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(branch: 'master', credentialsId: '08576372-f1e5-470c-9890-37ad5f6f8a6c', url: 'https://git.digitalharbor.us/set/set-fusion.git')
      }
    }
  }
}