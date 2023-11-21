 **Analysis of requirement and understanding**

It’s a comprehensive set of requirements! Creating a native app for NYC High School information sounds intriguing. Let's break it down step by step.

Firstly, we'll need to retrieve and display the list of NYC High Schools from the provided data source: DOE High School Directory 2017.

We can utilize Kotlin for this task and employ modern asynchronous programming techniques like coroutines for network requests. Considering the MVVM architecture requirement, we'll structure our app with separate layers for data handling, UI, and business logic.

Next, once a school is selected, additional information, including SAT scores (Math, Reading, Writing), should be displayed. For this, we'll fetch data from the SAT Results dataset based on the selected school.

To ensure a well-structured app, I'll incorporate dependency injection to facilitate the separation of concerns. This allows for easier testing and maintenance. Additionally, I'll aim for good UI/UX practices to create an intuitive interface for users.

While demonstrating unit testing might not cover everything, I'll include samples of various types of tests (e.g., unit tests, integration tests) to showcase testing principles.

 **steps to build this native app**

1)	Data Retrieval and Display:
    a)	Fetch the list of NYC High Schools from the DOE High School Directory 2017 API.
    b)	Display the schools in a list format within the app: use Recycler View.
2)	School Details:
    a)	Implement a functionality to show additional information when a school is selected from the list.
    b)	Fetch SAT scores data for the selected school from the SAT Results dataset.Display the SAT scores (Math, Reading, Writing) along with any other relevant information about the school.
3)	Architecture:
   a)	Utilize the MVVM architecture for a clear separation of concerns.
   b)	Implement ViewModel to manage UI-related data.
   c)	Employ LiveData to observe changes in data and update the UI accordingly.
4)	Asynchronous Programming:
    a)	Use Kotlin coroutines for asynchronous operations like network requests to ensure smooth and non-blocking operations.
5)	Dependency Injection:
    a)	Implement Dagger for dependency injection, allowing for easier management of dependencies and better testing.
6)	Testing:
   a)	Include unit tests to cover critical functionalities and classes.
   b)	Utilize Mockito for mocking dependencies in unit tests.
   c)	Perform integration tests to ensure the flow between different components works as expected.
7)	Error Handling and Edge Cases:
   a)	Implement error handling for network failures or data retrieval issues.
   b)	Address edge cases, such as empty responses or missing data, with appropriate handling and user-friendly messages.
8)	UI/UX:
   a)	Design a clean and intuitive user interface with smooth transitions between screens.
   b)	Focus on responsive design for various screen sizes and orientations. : Use Constraint layout, ViewModel
9)	Comments and Code Quality:
    a)	Provide comprehensive comments in the code to explain complex logic, workarounds, or future improvements.
    b)	Ensure adherence to best coding practices and maintainability.

Code 100% Kotlin

 ****Additionally We can implement****

1) Can add search option in the School list page
2) Can include Localization for different language such as Spanish, French etc...
3) can Integrate crashlytics, Analytics and Event logs with Google Analytics
4) Can add remote configurations if required
5) Include Animations and Back ground images.
6) Implement 100% testing
