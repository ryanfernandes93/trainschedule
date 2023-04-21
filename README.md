<b>Trainschedule</b><br />
</br>
<b>PROJECT TITLE: </b><br />
Go Train Schedule<br />
</br>
<b>PROJECT DESCRIPTION</b><br />
This is a Spring Boot based Web service API that provides a (simplified) train timetable with weekday train 
times leaving from Union Station.<br />
The service additionally provides details about trains running on different lines/routes with along with their departure and arrival times<br />
</br>
<b>Technology used</b><br />
JRE 1.8<br />
Spring Boot 2.7.11<br />
Maven 4.0.0<br />
</br>
<b>How to install and run</b><br />
1)Clone the repository from master branch of https://github.com/ryanfernandes93/trainschedule<br />
2)Import the project into IntelliJ<br />
3)Run Maven build to resolve the dependencies<br />
4)Click on run<br />
</br>
<b>Routes</b><br />
1) Get all train schedules<br />
Method Type Get<br />
Route :http://localhost:8080/schedule<br />
Success Response:<br />
```
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
]```
</br>
2)Get trains on a specific line<br />
Method Type:Get<br />
Route:http://localhost:8080/schedule/{line}<br />
Eg: http://localhost:8080/schedule/Barrie<br />
Response:<br />
```[
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
]```

Error: If line entered is not present in database<br />
Response: 404 Not Found<br />
</br>
3)Get trains on a specific line and departing time<br /> 
Method Type:Get<br />
Route:http://localhost:8080/schedule/{line}/{time}<br />
Eg: http://localhost:8080/schedule/Barrie/7:30am<br />
Response:<br />
```[
    {
        "id": 6,
        "line": "Barrie",
        "departure": 730,
        "arrival": 930
    }
]```

Error: If there is no train at specified line or line and time<br />
Response: 404 Not Found<br />
<br />
Note: Valid time formats include 12 & 24 hour in formats<br />
12 hour hh:mm am/pm<br />
24 hour HHMM<br />
</br>
<b>Future Scope</b><br />
1)API that gives me train details based on my arrival time<br />
2)Error handling scenarios to handle bad requests<br />
3)Web security to prevent unauthorized requests<br />
4)OpenAPI to check on train status and include trains from other stations<br />

 