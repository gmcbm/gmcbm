pipeline {
    agent none

    stages {
        stage('Build Java 8') {
            agent {
                docker {
                    image 'maven:3-openjdk-8'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                echo 'Building..'
                sh 'mvn -pl . clean install'
                dir('core') {
                    echo "Building Core..."
                    sh 'mvn clean install -Djar.finalName=GMCBM_Core-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
                dir('bukkit') {
                    echo "Building Bukkit Plugin..."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Bukkit-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
                dir('bungee') {
                    echo "Building Bungee Plugin..."
                    sh 'mvn clean package -Djar.finalName=GMCBM_Bungee-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
            }
        }

        stage('Build Java 11') {
            agent {
                docker {
                    image 'maven:3-openjdk-11'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                echo 'Building..'
                sh 'mvn -pl . clean install'
                dir('core') {
                    echo "Building Core..."
                    sh 'mvn clean verify'
                }
                dir('bukkit') {
                    echo "Building Bukkit Plugin..."
                    sh 'mvn clean verify'
                }
                dir('bungee') {
                    echo "Building Bungee Plugin..."
                    sh 'mvn clean verify'
                }
            }
        }
    }
}
