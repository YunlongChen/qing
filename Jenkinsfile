pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
      reuseNode true
    }

  }
  stages {
    stage('阶段-1 拉取代码') {
      steps {
        checkout([
          $class: 'GitSCM',
          branches: [[name: env.GIT_BUILD_REF]],
          userRemoteConfigs: [[
            url: env.GIT_REPO_URL,
            credentialsId: env.CREDENTIALS_ID
          ]]])
        }
      }
      stage('打包') {
        steps {
          script {
            if (isUnix() == true) {
              echo '这里linux系统'
              sh "mvn -pl '!zhangli-service-natcross-provider' clean package -DskipTests=true"
            } else {
              echo '这是windows系统'
              bat "mvn -pl '!zhangli-service-natcross-provider' clean package -DskipTests=true"
            }
          }
        }
      }
    stage('单元测试') {
      steps {
        sh "mvn -pl '!zhangli-service-natcross-provider' test"
      }
      post {
        always {
          // 收集测试报告
          junit 'target/surefire-reports/*.xml'
        }
      }
    }
      stage('收集构建物') {
        steps {
          echo '收集构建物'
          archiveArtifacts(artifacts: '**/target/*.jar', onlyIfSuccessful: true, defaultExcludes: true)
        }
      }
      stage('构建成功通知') {
        steps {
          echo 'Build successfully !'
        }
      }
    }
  }