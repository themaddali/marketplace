----------------------------------------------------------------------------------------------------------------------------------------------
Data Points:
----------------------------------------------------------------------------------------------------------------------------------------------

The time the exercise took (after dev environment is set up)
A/	Close to 4.5 Hrs
Exercise Difficulty: Easy, Moderate, Difficult, Very Difficult
A/	Moderate. But long
How did you feel about the exercise itself? (1 lowest, 10 highest—awesome way to assess coding ability)
A/	7.5
How do you feel about coding an exercise as a step in the interview process?  (1 lowest, 10 highest—awesome way to assess coding ability)
A/	Good. Depends on the role. For DevOps, this might not add much value.
What would you change in the exercise and/or process?
A/	I would ask crating few pipelines or PY exercises that is more directly aligned 

----------------------------------------------------------------------------------------------------------------------------------------------
Setup:
----------------------------------------------------------------------------------------------------------------------------------------------

1/ The project is built using Spring Boot
2/ Downlod Spring Tool Suite (Latest Version)
3/ From file meny import the project as a maven project
4/ Navigate to the location
5/ Once imported all the dependencies are downloaded.
6/ For DB: MySQL has been used.
7/ Just create a schema called marketplace
8/ Tables are bootstraped, so dont need to create.
9/ Under src/main/java/ via your Spring Tool Suite IDE,
   9.A/ Right click on com.marketplace.MarketplaceApplication.java
   9.B/ Select Run As -- > Java Application
10/ The application will run on inbuilt tomcat on 8080 by default.
11/ If 8080 is already in use: 
	11.A/ Select application.properties from src/main/resources
	11.B/ Add this line "server.port = 8090". Select any port number that is free.
12/ Using any REST API client (Ex: Postman) Start to use the tool

----------------------------------------------------------------------------------------------------------------------------------------------
REST API Calls:
----------------------------------------------------------------------------------------------------------------------------------------------
Create Project:

URL: http://localhost:8080/api/createProject
Method: Post
Request:
{
"projectName":"Test Project 4",
"projectDescription":"Test for project 4 creation",
"bidExpiryDate":"1519717517",
"projectContactEmail":"test4@test4.com",
"projectContactPhone":"645-789-4565",
"projectBidStatus":"Open"
}

Response:
{"projectId":"4","projectName":"Test Project 4","projectDescription":"Test for project 4 creation","bidExpiryDate":1519717517,"projectContactEmail":"test4@test4.com","projectContactPhone":"645-789-4565","projectBidStatus":"Open"}

----------------------------------------------------------------------------------------------------------------------------------------------

Bid Project:

URL: http://localhost:8080/api/bidProject
Method: POST

Request:
{
	"bidAmount":"5500.00",
	"bidDate":"1519717517",
	"project":{
		"projectId":"4"
	},
	"bidders":{
		"bidderName":"Mr.John",
		"bidderCompany":"ACS Ltd.",
		"bidderEmail":"john@acs.com",
		"bidderPhone":"565-789-9870"
	}
}

Response:
{
    "project": {
        "projectId": "4",
        "projectName": "Test Project 4",
        "projectDescription": "Test for project 4 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test4@test4.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    "bidders": {
        "id": 1,
        "bidderName": "Mr.John",
        "bidderCompany": "ACS Ltd.",
        "bidderEmail": "john@acs.com",
        "bidderPhone": "565-789-9870"
    },
    "bidAmount": 5500,
    "bidDate": 1519717517
}

----------------------------------------------------------------------------------------------------------------------------------------------

Get Lowest Bid
URL: http://localhost:8080/api/getLowestBid
Method: POST
Request:
{
	"projectId":"4"
}
Response:
{
    "project": {
        "projectId": "4",
        "projectName": "Test Project 4",
        "projectDescription": "Test for project 4 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test4@test4.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    "bidders": {
        "id": 3,
        "bidderName": "Mr.John",
        "bidderCompany": "TCS Ltd.",
        "bidderEmail": "john@acs.com",
        "bidderPhone": "565-789-9870"
    },
    "bidAmount": 4500,
    "bidDate": 1519718000
}

----------------------------------------------------------------------------------------------------------------------------------------------

Change Project Bid Status to Close

URL:  http://localhost:8080/api/closeBidStatus
Method: POST

Request:
{
	"projectId":"1"
}

Response:
{
    "projectId": "1",
    "projectName": "Test Project",
    "projectDescription": "Test for project creation",
    "bidExpiryDate": 1519718000,
    "projectContactEmail": "test@test.com",
    "projectContactPhone": "645-789-4565",
    "projectBidStatus": "Close"
}

----------------------------------------------------------------------------------------------------------------------------------------------

Get Open Projects
URL: http://localhost:8080/api/getOpenProjects
Method: GET

Response:
[
    {
        "projectId": "1",
        "projectName": "Test Project",
        "projectDescription": "Test for project creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test@test.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "2",
        "projectName": "Test Project 2",
        "projectDescription": "Test for project 2 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test1@test1.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "3",
        "projectName": "Test Project 3",
        "projectDescription": "Test for project 3 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test3@test3.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "4",
        "projectName": "Test Project 4",
        "projectDescription": "Test for project 4 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test4@test4.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    }
]

----------------------------------------------------------------------------------------------------------------------------------------------

Get All Projects

URL: http://localhost:8080/api/getAllProjects
Method: GET
Response:
[
    {
        "projectId": "1",
        "projectName": "Test Project",
        "projectDescription": "Test for project creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test@test.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "2",
        "projectName": "Test Project 2",
        "projectDescription": "Test for project 2 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test1@test1.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "3",
        "projectName": "Test Project 3",
        "projectDescription": "Test for project 3 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test3@test3.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    },
    {
        "projectId": "4",
        "projectName": "Test Project 4",
        "projectDescription": "Test for project 4 creation",
        "bidExpiryDate": 1519718000,
        "projectContactEmail": "test4@test4.com",
        "projectContactPhone": "645-789-4565",
        "projectBidStatus": "Open"
    }
]

----------------------------------------------------------------------------------------------------------------------------------------------

Get All Bidders

URL: http://localhost:8080/api/getAllBidders
Method: GET

Response:
[
    {
        "id": 1,
        "bidderName": "Mr.John",
        "bidderCompany": "ACS Ltd.",
        "bidderEmail": "john@acs.com",
        "bidderPhone": "565-789-9870"
    },
    {
        "id": 2,
        "bidderName": "Mr.John",
        "bidderCompany": "Sats Ltd.",
        "bidderEmail": "john@acs.com",
        "bidderPhone": "565-789-9870"
    },
    {
        "id": 3,
        "bidderName": "Mr.John",
        "bidderCompany": "TCS Ltd.",
        "bidderEmail": "john@acs.com",
        "bidderPhone": "565-789-9870"
    }
]

----------------------------------------------------------------------------------------------------------------------------------------------

