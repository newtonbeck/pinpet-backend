build:
	docker build -t api .

run:
	docker run -p 3000:3000 api
