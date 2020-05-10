def call(body) {
	node{
		sh 'mvn clean install -DskipTests'
	}
}	
