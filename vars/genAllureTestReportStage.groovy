def call(body) {
	node{
	allure includeProperties: false, jdk: '', properties: [[key: 'allure.issues.tracker.pattern', value: 'http://example.com/%s']], report: 'target/allure-report', results: [[path: 'target/allure-results']]
	}
}	
