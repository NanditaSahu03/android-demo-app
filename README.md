## gradleplayground

---

Demo project for [this medium article](https://medium.com/android-dev-corner/gradle-basics-for-android-developers-9d7a3bf062bb)

Barebones android project with two modules named `first` and `second`.
This project demonstrates how we can use gradle to write custom scripts for various utilities.
Clone this app and run the following commands to test out custom scripts.

| Command                                                   | Task                                                                 |
|-----------------------------------------------------------|----------------------------------------------------------------------|
| ./gradlew clean                                           | Deletes all build folders from all modules                           |
| ./gradlew assemble                                        | Creates the apk and the aars                                         |
| ./gradlew mailLatestCommit                                    | Opens the default email app with the latest commit url in the body   |
| ./gradlew mailLatestCommit -PemaildId=rohit.gupta1@usbank.com | Same as above, except the receiver's email id is sent as an argument |
| ./gradlew getDebugApk                                  | Implicitly invoked by assemble task, copies apk to build folder      |
| ./gradlew getOutputsZip                                  | Zips apk and aars to an output.zip file                              |
| ./gradlew -I scripts/my-logger.gradle assemble            | Uses the custom logger                                               |

###### This has not been tested on a Windows machine. Some scripts might not work on Windows.