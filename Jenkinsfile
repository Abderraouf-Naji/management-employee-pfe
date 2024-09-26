pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id') // Add your Docker Hub credentials ID
        DOCKER_HUB_REPO = 'najiabderraouf2'

    }

    stages {
        stage('Build Frontend Image') {
            steps {
                script {
                    // Build Docker image for frontend
                    dir('frontend') {
                        sh 'docker build -t $DOCKER_HUB_REPO/frontend:2 .'
                    }
                }
            }
        }
        stage('Build Backend Image') {
            steps {
                script {
                    // Build Docker image for backend
                    dir('backend') {
                        sh 'docker build -t $DOCKER_HUB_REPO/backend:2 .'
                    }
                }
            }
        }
        stage('Push Frontend Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials-id') {
                        sh 'docker push $DOCKER_HUB_REPO/frontend:2'
                    }
                }
            }
        }
        stage('Push Backend Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials-id') {
                        sh 'docker push $DOCKER_HUB_REPO/backend:2'
                    }
                }
            }
        }
        stage('Deploy to kuberntes (production)') {
            steps {
                script {
                    dir('kubernetes') {
                        sh 'kubectl apply -f frontend/ -n production'
                        sh 'kubectl apply -f backend/ -n production'
                        sh 'kubectl apply -f database/ -n production'
                    }
                    
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
