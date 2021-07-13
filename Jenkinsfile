pipeline {
    agent {
      label 'maven-jdk11-openj9'
    }

    environment {
        POM_VERSION = readMavenPom().getVersion()
    }

    stages {
        stage("Checkout") {
            steps {
                scmSkip(deleteBuild: true, skipPattern:'.*\\[ci skip\\].*')
                buildName "#${BUILD_NUMBER} ${POM_VERSION}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building'
                withMaven {
                    sh "mvn -B -U -DskipTests -P jenkins clean install"
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing'
                withMaven {
                    sh "mvn -B test"
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying'
                withMaven {
                    sh 'mvn -B deploy'
                }
            }
        }
    }
}
