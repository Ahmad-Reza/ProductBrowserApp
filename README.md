# Product Browser App (Kotlin Multiplatform)

A Kotlin Multiplatform (KMP) application built with Compose Multiplatform, targeting Android and iOS. This app consumes product data from the DummyJSON API.

## Business Requirements
- **Product List**: View a list of products with name, price, and thumbnail.
- **Product Details**: Tap a product to view detailed info (title, description, brand, price, rating).
- **Search**: Search products by keyword via API.
- **Cross-Platform**: Consistent UI and logic across Android and iOS.

## Project Architecture
The project follows **Clean Architecture** principles:
- **Data Layer**: Handles API requests using Ktor and data mapping (DTOs to Domain models).
- **Domain Layer**: Contains business logic (Use Cases) and repository interfaces.
- **Presentation Layer**: Shared UI components using Compose Multiplatform and ViewModels with StateFlow.
- **Dependency Injection**: Manual injection via `AppModule`.

## Tech Stack
- **Kotlin Multiplatform** & **Compose Multiplatform**
- **Ktor Client**: Network requests
- **Kotlinx Serialization**: JSON parsing
- **Coil 3**: Image loading (Multiplatform)
- **Coroutines & StateFlow**: Asynchronous logic and state management

## How to Build and Run

### Android
1. Open the project in Android Studio.
2. Select the `composeApp` run configuration.
3. Click **Run**.

### iOS
1. Ensure you are on a macOS machine with Xcode installed.
2. Open the `iosApp/iosApp.xcworkspace` in Xcode or run the `iosApp` configuration from Android Studio.
3. Click **Run**.

## Unit Tests
- A unit test for `GetProductsUseCase` is included in `commonTest`.
- Run tests using: `./gradlew :composeApp:allTests`

## Trade-offs & Assumptions
- **Image Loading**: Used Coil 3 (Alpha/RC) as it is the current standard for Compose Multiplatform image loading.
- **Navigation**: Implemented a simple state-based navigation in `App.kt` to keep the project lightweight without adding external navigation libraries for this first round.
- **Error Handling**: Basic error messages are shown in the UI; a production app would have more robust retry logic.
