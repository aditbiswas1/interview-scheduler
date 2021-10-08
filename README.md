# interview project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/interview-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### RESTEasy JSON serialisation using Jackson

This example demonstrate RESTEasy JSON serialisation by letting you list, add and remove quark types from a list. Quarked!

[Related guide section...](https://quarkus.io/guides/rest-json#creating-your-first-json-rest-service)


## What:
	Grofers Recruitment Scheduling

## Why:
	- Maximise number of candidates going through hiring pipeline
	- Minimize Interviewer uncertainty
	- Minimize Time Candidates spend in hiring pipeline
	- Balance out Interviewer team disruptions


## How:
	- Model the problem as a convex optimization problem
	- Write a solver
	- What is the model:
		- X candidates:
			- each candidate has a set of skills which we need to interview them for 
			(eg. SDE 1 - problem solving, SDE 2 - Design, Bar Raiser)
			- each candidate can specify their availability 
			(eg. I can take the interviews on monday 5pm, tuesday 5pm or saturday 10am)

		- Y Interviwers:
			- each interviwer has a set of skills they can take interviews for
			- each interviewer can specify their preferred slots for taking interviews
			- each interviwer belongs to a sub team in grofers

		- Match X,Y to make sure candidates and interviewers match on skillset and slots.
		- Ensure Interviwers are spread across so that a single team is not burdened and everyone has a fair share of the interviews.


## Technology Exploration:
	- OptaPlanner
		- open source solver modelling framework
			- comes with capabilities to model business contraints using rules
			- comes with capabilities to run continuous solver
			- good documentation on lot of different optimization problems

	- Quarkus
		- Lightweight runtime, cloud native deployments and build iterations are rapid
		- Has very good patterns for modelling microservices in java rapidly

	- React Admin
		- needed to push out the ui for this in 1 hour

	
## Results:
	- Solves problem with x candidates, y interviews and a z timeslots to an acceptable level in x seconds
	- Adjusts plan if something changes
		- eg. candidate / interviewer changes slot preference
		- eg. skill set requirement changes.

## What's Next:
	- Allow the Interview Requirement to be broken into multiple pieces (Round 1, Round 2, Round 3) with dependency chain. ( model it like an assembly line )
	- Build the basic functionalities into the ui
		- better forms
		- access control
		- reports
	- Execute schedule by sending out appropriate calendar invites , slack notifications
	- Integrate into workflow to automate feedback collection / associated practice questions

	Future desires:
	- model stochastic processes (i.e: skeptical candidates dont get planned for 3rd rounds automatically etc.)
	- Can be extended for non recruitment use cases:
		- redistribution of manpower in stores to optimize store maintainance activities ( put away, picking, billing)
		- redistribution of manpower across stores to solve for service requirements(x number of fnv orders in location y, incentivize movement manpower from z to y)
		- technology roadmap -> execution planning and redistribution

		

