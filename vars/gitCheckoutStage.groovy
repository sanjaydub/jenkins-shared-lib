def call(Map m) {
	node{
		git url: '${m.name}'
	}
}	
