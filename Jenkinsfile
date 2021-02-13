pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build Core') {
            steps {
                dir('core') {
                    echo 'Building..'
                    sh 'mvn clean package -Djar.finalName=GMCBM_Core-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
            }
        }
    }
}

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build Spigot') {
            steps {
                dir('spigot') {
                    echo "Building.."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Spigot-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
            }
        }
    }
}

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build Bungeecord') {
            steps {
                dir('bungeecord') {
                    echo "Building.."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Bungeecord-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
            }
        }
    }
}
