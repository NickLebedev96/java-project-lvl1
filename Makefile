install: 
	./gradlew clean install
run-dist: install
	./build/install/app/bin/app
check-updates:
	./gradlew dependencyUpdates
