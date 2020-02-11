pipeline {
    agent {
            docker {
                image 'maven:3-alpine'
                args '-v /root/.m2:/root/.m2'
            }
        }
    stages {
         stage('编译') { 
             steps {
                 sh "mvn -B -DskipTests clean package"
             }
        }
        stage('测试'){
            steps{
                sh "mvn test"
            }
        }
        stage('构建'){
            steps{
                sh "mvn dockerfile:build"
            }
        }
        stage('分发'){
            steps{
                sh "mvn dockerfile:push"
            }
        }

    }
}
