node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git credentialsId: '945d5dee-98f4-42e3-8057-16b842526713', url: 'http://wuhu@git.meicloud.com/cdp/unit-test-sample.git'
      // Get the Maven tool.
      // ** NOTE: This 'Maven-3.3.9' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'Maven-3.3.9'
   }
   stage('Test'){
        //mvn 测试
	  if (isUnix()) {
         sh "mvn clean cobertura:cobertura"
      } else {
         bat "mvn clean cobertura:cobertura"
      }        
    }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat "mvn -DskipTests package"
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}