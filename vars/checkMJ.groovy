def call(body) {
	node{
		echo 'Hello World'
		sh 'mvn -version'
		sh 'java -version'
		//return this
	}
}	
