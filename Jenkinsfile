pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(branch: 'master', credentialsId: 'QWNzSw_it24H9qzaJ5Cn', url: 'https://git.digitalharbor.us/set/set-fusion.git')
      }
    }
  }
}