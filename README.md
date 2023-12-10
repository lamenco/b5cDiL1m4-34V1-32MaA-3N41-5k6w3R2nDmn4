# Gas Station Microservice

This Spring Boot microservice provides information about gas stations, including fuel prices and location data.

## Requirements

- Java 17 or later
- Spring Boot
- Local database MYSQL
- Restful service

## Installation

1. Clone this repository: `git clone https://github.com/lamenco/B812i2DC4-5aV1-9RdaA-vE41-pi4sVY7DYx1F`
2. Navigate to the project directory: `cd gas-station-microservice`

## Database Setup

1. Create a local database (MySQL) and configure the connection settings in `application.properties`.

## Build and Run

The application will start and listen on http://localhost:8080.

## Available Endpoints

- GET `/diesel-highest-price` - Get gas station with the highest diesel price.
- GET `/e5-highest-price` - Get gas station with the highest E5 price.
- GET `/e10-highest-price` - Get gas station with the highest E10 price.
- GET `/diesel-lowest-price` - Get gas station with the lowest diesel price.
- GET `/e5-lowest-price` - Get gas station with the lowest E5 price.
- GET `/e10-lowest-price` - Get gas station with the lowest E10 price.
- GET `/DieselMiddlePrice` - Get the average price for diesel.
- GET `/E5MiddlePrice` - Get the average price for E5 fuel.
- GET `/E10MiddlePrice` - Get the average price for E10 fuel.
- GET `/searchByName?name={stationName}` - Search gas stations by name.

## Usage

You can access the different endpoints using a web browser or API testing tools like Postman.

