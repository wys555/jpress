def label = "jenkins-slave-${UUID.randomUUID().toString()}"

podTemplate(cloud: 'kubernetes',namespace: 'k8s-ops',label: label,containers: [
  containerTemplate(name: 'git', image: '192.168.48.139/base/git:latest', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'maven', image: '192.168.48.139/base/maven:3.6.1-alpine', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'podman', image: '192.168.48.139/base/podman:3.4.2', command: 'cat', ttyEnabled: true,privileged: true),
  containerTemplate(name: 'kubectl', image: '192.168.48.139/base/kubectl:1.20.14', command: 'cat', ttyEnabled: true)
], serviceAccount: 'jenkins', volumes: [
  persistentVolumeClaim(mountPath: '/root/.m2', claimName: 'maven-repo'),
]) {
  node(label) {
    def imageTag = "111"
    def harborURL = "192.168.48.139"    
    stage('下载代码') {
      container('git') {
        echo "1.git clone代码"
        sh "pwd"
        sh "ls -a ~/"
        sh "ls /home/jenkins/agent/workspace/jpress"
        git credentialsId: '7a0695bf-9455-4b78-a4a6-9c7961a37295', url: 'http://192.168.48.139:81/root/jpress.git'
      }
    }
    stage('代码编译打包') {
      container('maven') {
        echo "2.代码编译打包阶段"
        sh "pwd"
        sh "ls /home/jenkins/agent/workspace/jpress"
        sh """
        mvn clean package
        """
      }
    }
    stage('构建和推送 Docker 镜像') {
      container('podman') {
        sh "pwd"
        sh "ls -a ~/"
        sh "ls /home/jenkins/agent/workspace/jpress"
        sh "cat /proc/sys/user/max_user_namespaces"
        sh "cat /etc/containers/registries.conf"
        sh "cat /etc/containers/storage.conf"
        sh "ls /var/lib/containers"
        sh "ls -l /dev/fuse"
        withCredentials([usernamePassword(credentialsId: 'harbor', passwordVariable: 'HARBOR_PASSWD', usernameVariable: 'HARBOR_USERNAME')]) {
        sh """
        echo "3.构建 Docker 镜像阶段"
        podman login -u admin -p Harbor12345 ${harborURL}
        podman build -t 'jpress:${imageTag}' .
        podman images
        podman tag 'localhost/jpress:${imageTag}' '${harborURL}/jpress/jpress:${imageTag}'
        echo "4.推送 Docker 镜像阶段"
        podman push ${harborURL}/jpress/jpress:${imageTag}
        """
        }
      }
    }
    stage('运行 Kubectl') {
      container('kubectl') {
        echo "5.查看 K8S 集群 Pod 列表"
        sh "pwd"
        sh "ls -a ~/"
        sh "ls -a /root"
        sh "ls -a /home/jenkins"
        sh "ls /home/jenkins/agent/workspace/jpress"
        withKubeConfig([credentialsId: "kubeconfig",serverUrl: "https://kubernetes.default.svc.cluster.local"]) {
        sh "kubectl get pods -n k8s-ops"
        }
      }
    }
  }
}
