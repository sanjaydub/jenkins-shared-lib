def call(body) {
	node{
		sh 'mvn test'
	}
}	
