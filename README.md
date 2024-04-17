# Visitor
### --> MTAA FE project app - assignment

## Splash screen
> author: Mária Matušisková
- Android (instructions): https://developer.android.com/training/wearables/apps/splash-screen
- iOS (instructions): https://medium.com/@jpmtech/how-to-build-a-launch-screen-for-ios-268a6a47b3c3


### Info from Kotlin of generation for cross-platform app:

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…