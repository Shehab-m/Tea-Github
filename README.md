# GitHub OAuth App

This application allows users to authenticate via GitHub OAuth and view a list of their repositories once they are logged in. The app is built using modern Android development practices with **Kotlin**, **Jetpack Compose**, and **MVI** architecture.

## Features

- **OAuth 2.0 Authentication:** Securely log in using GitHub's OAuth system.
- **User Repositories List:** After successful login, the app displays a list of the user's GitHub repositories.
- **Clean Architecture:** The app follows the principles of MVI and Clean Architecture to separate concerns.
- **Jetpack Compose UI:** Built using Jetpack Compose for declarative UI programming in Android.
- **Koin for Dependency Injection:** Manage dependencies with Koin.
- **Coroutines:** Ensure non-blocking API requests and smooth performance.

## Screenshots

![login](https://github.com/user-attachments/assets/a6c42f28-245f-4b46-ad07-88497afd4a68)
![github](https://github.com/user-attachments/assets/7e584e03-f394-47e9-939b-bdd19ac63804)
![repositories](https://github.com/user-attachments/assets/3bc18d24-5434-4b2c-8b6c-471556a9c621)


## Tech Stack

- **Kotlin**: The main programming language for this project.
- **Jetpack Compose**: Used for creating UI components.
- **Coroutines**: For asynchronous operations.
- **Retrofit & OkHttp**: For network operations and API requests.
- **Koin**: For Dependency Injection.
- **GitHub OAuth**: For authentication with GitHub.
- **MVI Pattern**: Clean architecture with MVI pattern.

## Getting Started

### Prerequisites

Before running the project, ensure you have the following setup:

- A **GitHub Developer Application** created for OAuth credentials. You will need:
  - Client ID
  - Client Secret
  - Authorization Callback URL (which must be specified in your GitHub App)

### Setting Up OAuth

1. Go to [GitHub Developer Settings](https://github.com/settings/developers) and create a new OAuth application.
2. Set the **Authorization callback URL** to something like:
3. Copy the **Client ID** and **Client Secret** and replace the placeholders in the project.

### Configuration

In the project, replace the placeholders with your actual credentials in your configuration file or environment variables.

```kotlin
const val CLIENT_ID = "your_github_client_id"
const val CLIENT_SECRET = "your_github_client_secret"
const val REDIRECT_URI = "your_app_scheme://callback"

