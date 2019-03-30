# Pinpet

## API

To run API in your machine export the following environment variables:

```
export DB_URL="jdbc:mysql://localhost:3306/pinpet"
export DB_DRIVER_CLASSNAME="com.mysql.jdbc.Driver"
export DB_USER="root"
export DB_PASSWORD="toor"
export HTTP_PORT="8080"
export JWT_SECRET="f2b51a05-1f2f-4e83-b99e-c5e93214198d"
```

Run the following command to start the database:

```
docker-compose up
```

Enter in `api` folder and run the following command:

```
lein run
```

## Database

## Infrastructure