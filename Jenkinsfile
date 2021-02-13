pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir('core') {
                    echo "Building Core..."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Core-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
                dir('spigot') {
                    echo "Building Spigot Plugin..."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Spigot-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
                dir('bungeecord') {
                    echo "Building Bungeecord Plugin..."
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
