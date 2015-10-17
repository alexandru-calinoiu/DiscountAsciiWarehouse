# Purpose
One shows the layout (search box, and result grid) and the other showing what each product in the result grid should look like.

You can get search results from the API with a request like this:

> curl http://74.50.59.155:5000/api/search

The API also accepts some parameters:

GET /api/search
Parameters
  ● limit (int) ­ Max number of search results to return
  ● skip (int) ­ Number of results to skip before sending back search results
  ● q (string)  - Search query. Tags separated by spaces.
  ● onlyInStock (bool)  - When flag is set, only return products that are currently in stock.

Response Type: NDJSON

The app should keep loading products from the API until it has enough to fill the screen, and then wait until the user has swiped to the bottom to load more.  The app should cache API requests for 1 hour.

As well as submitting the code, can you also please include:
- any instructions that I'll need to build and run the app (eg. if there's a particular VM I should use)
- notes on technical decisions you made, and the pros / cons of that approach
- recommendations that you would want to see followed up if this were the beginning of a long-term project.  What kinds of things do you look for in the code, technology choices, team practices etc. that can help to make a project successful?

# Notes on the implementation

In order to build and run a simple `./gradlew build` in the project root should do the trick

The overall arhitecture is heavily inspired by http://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html I borrow most of the 
naming from there. 

I've tried to implement this clean architecture in the past on Android but I think that this time around with the help of data binding I am getting really
close.

There a couple of thinks that need to be done if this where a real project:
- split each layer in it's own android module, data (caching?!) and domain project should not need reference to the android framework
- add some more test coverage
- add authorization
- add in app purchase support
