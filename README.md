# trainschedule

#PROJECT TITLE: 
Go Train Schedule

#PROJECT DESCRIPTION
This is a Spring Boot based Web service API that provides a (simplified) train timetable with weekday train 
times leaving from Union Station.
The service additionally provides details about trains running on different lines/routes with along with their departure and arrival times

#Technology used
JRE 1.8
Spring Boot 2.7.11
Maven 4.0.0

#How to install and run
1)Clone the repository from master branch of https://github.com/ryanfernandes93/trainschedule
2)Import the project into IntelliJ
3)Run Maven build to resolve the dependencies
4)Click on run

#routes
1) Get all train schedules
Method Type Get
Route :http://localhost:8080/schedule
Success Response:
[
    {
        "id": 1,
        "line": "Lakeshore",
        "departure": 800,
        "arrival": 900
    },
    {
        "id": 2,
        "line": "Lakeshore",
        "departure": 1000,
        "arrival": 1100
    },
    .
	.
	.
]

2)Get trains on a specific line
Method Type:Get
Route:http://localhost:8080/schedule/{line}
Eg: http://localhost:8080/schedule/Barrie
Response:
[
    {
        "id": 6,
        "line": "Barrie",
        "departure": 730,
        "arrival": 930
    },
    {
        "id": 7,
        "line": "Barrie",
        "departure": 1030,
        "arrival": 1230
    },
    .
	.
	.
]

Error: If line entered is not present in database
Response: 404 Not Found

3)Get trains on a specific line and departing time 
Method Type:Get
Route:http://localhost:8080/schedule/{line}/{time}
Eg: http://localhost:8080/schedule/Barrie/7:30am
Response:
[
    {
        "id": 6,
        "line": "Barrie",
        "departure": 730,
        "arrival": 930
    }
]

Error: If there is no train at specified line or line and time
Response: 404 Not Found

Note: Valid time formats include 12 & 24 hour in formats
12 hour hh:mm am/pm
24 hour HHMM


#Future Scope
API that gives me train details based on my arrival time
Error handling scenarios to handle bad requests
Web security to prevent unauthorized requests
OpenAPI to check on train status and include trains from other stations

 