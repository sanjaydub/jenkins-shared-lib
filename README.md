# Jenkins Pipeline Shared Library Sample

This project provides easy example of shared library which can be used into Jenkins pipeline.

Setup instructions

1. In Jenkins, go to Manage Jenkins → Configure System. Under Global Pipeline Libraries, add a library with the following settings:
  * Library name: my-jenkins-shared-lib
  * Default version: Specify a Git reference (branch or commit SHA), e.g. master
  * Retrieval method: Modern SCM
  * Select the Git type
  * Project repository: 
  * Credentials: (leave blank)
  * You may have to turn off ssl verification using:     git.exe config --global http.sslVerify false

2. Then create a Jenkins job with the following pipeline (note that the underscore _ is not a typo):

```
@Library('my-jenkins-shared-lib')_

stage('Check Maven an Java') {
    checkMavenJava

Run job!
