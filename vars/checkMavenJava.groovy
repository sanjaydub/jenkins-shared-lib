def call() {
	steps {
                echo 'Hello World'
                sh 'mvn -version'
                sh 'java -version'
            }
}	
