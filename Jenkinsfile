pipeline {
  agent any
  stages {
    stage('检出代码') {
      steps {
        checkout(scm: [
          $class: 'GitSCM',
          branches: [[name: env.GIT_BUILD_REF]],
          userRemoteConfigs: [[
            url: env.GIT_REPO_URL,
            credentialsId: env.CREDENTIALS_ID
          ]]], changelog: true, poll: false)
        }
      }
      stage('编译') {
        steps {
          sh 'mvn compile -DskipTests=true'
        }
      }
      stage('部署') {
        steps {
          sh 'mvn package -DskipTests=true -Ddockerfile.skip'
        }
      }
      stage('构建Docker镜像') {
        steps {
          sh 'mvn com.spotify:dockerfile-maven-plugin:1.4.4:build'
        }
      }
      stage('打标签') {
        steps {
          sh 'mvn com.spotify:dockerfile-maven-plugin:1.4.4:tag'
        }
      }
      stage('推送到镜像库') {
        steps {
          sh 'mvn com.spotify:dockerfile-maven-plugin:1.4.4:push'
        }
      }
    }
  }