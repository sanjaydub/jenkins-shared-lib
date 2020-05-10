# Jenkins Pipeline Shared Library Sample

This project provides easy example of shared library which can be used into Jenkins pipeline.

Setup instructions

1. In Jenkins, go to Manage Jenkins → Configure System. Under Global Pipeline Libraries, add a library with the following settings:
  * Library name: my-jenkins-shared-lib
  * Default version: Specify a Git reference (branch or commit SHA), e.g. master
  * Retrieval method: Modern SCM
  * Select the Git type
  * Project repository: https://github.com/sanjaydub/jenkins-shared-lib.git
  * Credentials: (leave blank)
  * You may have to turn off ssl verification using:     git.exe config --global http.sslVerify false

2. Then create a Jenkins job with the following pipeline (note that the underscore _ is not a typo):

```
////// Example-1 --> call shared lib in stages - as script
@Library('my-jenkins-shared-lib')_
stage('Checkin Maven & Java') {
    checkMJ()
}
stage('Checkout from git') {
	gitCheckoutStage name: 'https://github.com/sanjaydub/Allure_Maven_TestNG.git'
}
stage('Building the code'){
    buildJavaCodeStage()			
}		
stage('CT - Executing Automated Testcases'){
    runTestsStage()
}
stage('Capture Allure report'){
    genAllureTestReportStage()
}

////// Example-2 --> call shared steps in stage --> steps --> script (declarative )
@Library('my-jenkins-shared-lib')_
pipeline {
    agent any
    stages {
        stage('Checkin Maven & Java') {
            steps {
                script{checkMavenJava()}
            }
        }		
		stage('Checkout from git') {
            steps {
                script{checkOutFromGit('https://github.com/sanjaydub/Allure_Maven_TestNG.git')}
            }
        }		
		stage('Building the code'){
            steps{
				script{buildJavaCode()}
            }			
        }		
		stage('CT - Executing Automated Testcases'){
            steps{
                script{runTests()}
            }
        }
		stage('Capture Allure report'){
            steps{
				script{genAllureTestReport()}
			}
        }
    }
}


Run job!
