pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(branch: 'master', credentialsId: '1417418bd68ec8c3c4e45372b6ce0cb553d3fd18', url: 'https://github.com/jpabbisetty/intelligentsearch.git')
      }
    }
  }
}