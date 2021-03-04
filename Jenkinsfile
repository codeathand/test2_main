pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
     }
    stages {
        stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
        }
        stage('Clone repo') {
            steps {
                bat "git clone https://github.com/codeathand/test2_main.git"
            }
        }
        stage('Test') {
            steps {
                echo "Testing"
                dir ("test2_main") {
                    bat 'java -version'
                    bat 'mvn clean install'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying"
            }
        }
    }
}