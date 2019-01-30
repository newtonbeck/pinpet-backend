jar:
	lein uberjar

build:
	docker build -t consumer .

run:
	docker run -d --name consumer consumer

logs:
	docker logs -f consumer

publish:
	docker tag consumer gcr.io/pinpet/consumer:latest
	docker push gcr.io/pinpet/consumer:latest
