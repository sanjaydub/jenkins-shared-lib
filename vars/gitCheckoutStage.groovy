def call(Map config) {
	node{
		git url: '${config.name}'
	}
}	
