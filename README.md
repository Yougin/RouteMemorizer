# Route Memorizer

Route Memorizer is a demo application.

The MVP and DI architectural patters are used to make application testable (all dependencies could be mocked easily)

The following 3rd party libraries were used:

* `Dagger` as Dependency Injection library
* `Realm` for data persistence
* `EventBus` from `Greenrobot` as event bus
* `Android Priority Job Queue` for queries/prioritizing/execution of background operations
* `Retrofit` for network interface
* `OkHttp` as network library
* `Gson` for `JSONs` parsing
* `IntelliJ Annotations` to reduce an amount for `null` checks
* `ButterKnife` to reduce amount of boilerplate code for `View` part
* `Timber` for logging
* `JUnit4` for unit tests
* `Harmcrest` for human readable test assertions

# Get Project

`git clone https://github.com/Yougin/RouteMemorizer.git`

# Quick start

1. Builds the project `./gradlew clean assembleDebug`
2. You can run tests from IntellijIDEA / Android Studio or `./gradlew clean testDebug`
