pipeline {
    agent any

    options {
      timestamps()
    }

    stages {
        stage('checkout') {
            steps {
                git url: 'https://github.com/xiangyu123/greeter.git'
            }
        }

        stage('build') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }

        stage('test') {
            steps {
                echo 'testing'
            }
        }

        stage('build_image') {
            steps {
                sh """
			        docker build --no-cache --force-rm=true -t greet-${env.JOB_NAME}:${env.BUILD_ID} .
			        docker tag greet-${env.JOB_NAME}:${env.BUILD_ID} greet:latest
                    delete_images=\$(docker images -f "dangling=true" -q)
                    [[ ! -z "\${delete_images}" ]] && docker rmi -f \${delete_images} || echo "No images to delete"
		        """
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose -p test_project up -d --force-recreate --build greeter'
            }
        }
    }
}
