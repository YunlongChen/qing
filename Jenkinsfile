pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
            reuseNode true
        }
    }
    stages {
        stage('阶段-1 打包') {
            steps {
                script {
                    if (isUnix() == true) {
                        echo '这里linux系统'
                        sh "mvn clean package -DskipTests=true"
                    } else {
                        echo '这是windows系统'
                        bat "mvn clean package -DskipTests=true"
                    }
                }
            }
        }
        stage('阶段-2 单元测试') {
            steps {
                sh "mvn test"
            }
            post {
                always {
                    // 收集测试报告
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('阶段-3 收集构建物') {
            steps {
                echo '收集构建物'
                archiveArtifacts (artifacts: '**/target/*.jar', onlyIfSuccessful: true, defaultExcludes: true)
            }
        }
//        stage('阶段-3 推送zhangli-eureka-service到dockerhub') {
//            steps {
//                sh "mvn -pl zhangli-eureka-service -DskipTests=true clean package dockerfile:build dockerfile:tag dockerfile:push"
//            }
//        }
    }
}