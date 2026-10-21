# 📚 Bookpedia

A **Compose Multiplatform** app for searching books and saving favorites, running on **Android, iOS and Desktop** from a single shared Kotlin codebase. Book data comes from the [Open Library API](https://openlibrary.org/developers/api).


---

## ✨ Features

- **Live search** with debouncing, so requests are sent only after the user stops typing
- **Book details** including description, authors, rating, page count, languages, and publish year, shown over a blurred cover background
- **Favorites** saved locally and available offline
- **Tabs** to switch between search results and favorites
- **Clear error states** for network and connection problems
- Shared UI on every platform, with platform-specific code only where it's needed

---

## 🛠️ Tech Stack

| Area | Library |
|------|---------|
| UI | Compose Multiplatform, Material 3 |
| Navigation | Navigation Compose (type-safe routes with Kotlin Serialization) |
| Networking | Ktor (OkHttp on Android and Desktop, Darwin on iOS) |
| Local storage | Room (KMP) with bundled SQLite |
| Dependency injection | Koin |
| Image loading | Coil 3 |
| Async | Kotlin Coroutines and Flow |
| Serialization | Kotlinx Serialization |

---

## 🏗️ Architecture

The app follows a layered structure with **data**, **domain**, and **presentation** layers, and an **MVI-style** presentation layer where each screen has its own `State`, `Action`, and `ViewModel`.

- **Domain:** models and repository contracts, with no framework dependencies
- **Data:** Ktor remote data source, Room database, DTOs, and mappers
- **Presentation:** Compose screens driven by a single state object and user actions
- **Error handling:** a typed `Result` wrapper with `DataError`, mapped to user-facing messages in the UI

Platform-specific pieces, such as the database builder and HTTP engine, are provided with `expect`/`actual` and Koin platform modules.

```
composeApp/src
├── commonMain      # Shared code: UI, ViewModels, domain, data
│   ├── app         # App entry and navigation routes
│   ├── book
│   │   ├── data        # network, database, dto, mapper, repository
│   │   ├── domain      # Book model, BookRepository
│   │   └── presentation# book_list, book_detail
│   ├── core        # Shared error handling, HTTP client, UI helpers
│   └── di          # Koin modules
├── androidMain     # Android entry point and platform modules
├── iosMain         # iOS entry point and platform modules
└── desktopMain     # Desktop entry point and platform modules
```

---

## 🚀 Getting Started

**Requirements:** Android Studio (latest stable) with the Kotlin Multiplatform plugin, and Xcode for iOS (macOS only).

```bash
git clone https://github.com/sedramerkhan/CMP-Bookpedia.git
```

- **Android:** open the project in Android Studio and run the `composeApp` configuration
- **iOS:** open `iosApp/iosApp.xcodeproj` in Xcode and run, or use the iOS run configuration in Android Studio
- **Desktop:**
  ```bash
  ./gradlew :composeApp:run
  ```

---

## 👩‍💻 Author

**Sedra Merkhan**, Mobile Engineer  
[LinkedIn](https://linkedin.com/in/sedra-merkhan) · [GitHub](https://github.com/sedramerkhan)

-

## 🙏 Acknowledgments

Built while learning Compose Multiplatform, following [Philipp Lackner](https://github.com/philipplackner)'s CMP Crash Course for 2025.
