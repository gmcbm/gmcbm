pipeline {
    agent {
      label 'maven-jdk11-openj9'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -U -DskipTests -P jenkins clean install'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
