jar:
	lein ring uberjar

build:
	docker build -t api .

run:
	docker run -d -p 3000:3000 --name api api

logs:
	docker logs -f api

publish:
	docker tag api gcr.io/pinpet/api:latest
	docker push gcr.io/pinpet/api:latest
