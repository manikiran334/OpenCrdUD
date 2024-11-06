pipeline {
    agent any  // Runs the pipeline on any available agent

    triggers {
        pollSCM('H/5 * * * *')  // Polls the source code every 5 minutes for changes
    }

    environment {
        // Set environment variables, if needed
        PROJECT_NAME = 'YourProjectName'
        BUILD_VERSION = '1.0'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm  // Checks out the code from the configured SCM
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh './build.sh'  // Replace with your build command
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './run_tests.sh'  // Replace with your test command
            }
        }

        stage('Deploy') {
            when {
                branch 'main'  // Only deploy when changes are merged to main
            }
            steps {
                echo 'Deploying the project...'
                sh './deploy.sh'  // Replace with your deployment command
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()  // Cleans up the workspace after the job is done
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}
