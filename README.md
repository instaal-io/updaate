<h1 align="center"><img src="https://user-images.githubusercontent.com/42619122/155006230-75e7e844-97f6-4cfa-93c1-f0aa20eeaf7f.png" height="30" weight="30" alt="GitHub forks"> <b>MiniUpdateChecker</b></h1>
<h4 align="center">A Minimalist App Update Checker for Android</h4>

<br/>

<p align="center">
<a href="https://www.android.com"><img src="https://img.shields.io/badge/platform-Android-yellow.svg" alt="platform"></a>
 <a href="https://android-arsenal.com/api?level=21"><img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" alt="API"></a> <a href="https://jitpack.io/#instaal-io/MiniUpdateChecker"><img src="https://img.shields.io/jitpack/v/github/instaal-io/MiniUpdateChecker" alt="JitPack"></a> <a href="https://github.com/instaal-io/MiniUpdateChecker/blob/master/LICENSE"><img src="https://img.shields.io/github/license/instaal-io/MiniUpdateChecker" alt="GitHub license"></a>
 </p>
 <p align="center">
 <a href="https://github.com/instaal-io/MiniUpdateChecker/issues"><img src="https://img.shields.io/github/issues/instaal-io/MiniUpdateChecker" alt="GitHub issues"></a> <a href="https://github.com/instaal-io/MiniUpdateChecker/network"><img src="https://img.shields.io/github/forks/instaal-io/MiniUpdateChecker" alt="GitHub forks"></a> <a href="https://github.com/instaal-io/MiniUpdateChecker/stargazers"><img src="https://img.shields.io/github/stars/instaal-io/MiniUpdateChecker" alt="GitHub stars"></a> <a href="https://github.com/instaal-io/MiniUpdateChecker/graphs/contributors"><img src="https://img.shields.io/github/contributors/instaal-io/MiniUpdateChecker" alt="GitHub contributors"></a>
  </p>

## Purpose

<b>Minimalist Update Checker</b> is a Smart Android Library for checking your Android App Updates on <b>Google Play Store</b>. <b>MiniUpdateChecker</b> checks the updates and notifies with beautiful <b>material design dialogs</b>. You can <b>customize</b> the dialog in various ways.

## Demo
Download and Check out the demo app for more

<a href="https://github.com/instaal-io/MiniUpdateChecker/blob/master/MiniUpdateChecker%20Demo.apk"> <img src="https://user-images.githubusercontent.com/42619122/155009169-c92bbebb-7e96-452e-956b-b5905d2cdcdc.png" height="100" width="200" alt="Download"/> </a>


## What's New
Initial release with initial features, everything is new. Check out `Releases` Tab for Info.

## Features
MiniUpdateChecker has these features:
- Checking Update for Your Android App on Google Play Store
- Material Design UI
- 3 Themes
- Highly Customizable

## Screenshot
Here is some screenshots of the library
<p><img src="https://user-images.githubusercontent.com/42619122/155010041-95b0e60d-d296-4c49-96ba-8cc0c154db68.png" width="300" alt="Screenshot_1645468216">
<img src="https://user-images.githubusercontent.com/42619122/155010049-d24a96d3-ec8f-4c89-98a4-81460473d14d.png" width="300" alt="Screenshot_1645468238">
<img src="https://user-images.githubusercontent.com/42619122/155010051-31df497c-b2a7-4f0d-9f4a-61388de02c78.png" width="300" alt="Screenshot_1645468252"></p>

## Prerequisites

### Old
If you're using old gradle versions then follow this.
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### New
If you're using new gradle versions then follow this.
Add this in your `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
       ...
        maven { url 'https://jitpack.io' }

    }
}
```

## Dependencies
Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.instaal-io:MiniUpdateChecker:1.0'
}
```


## Usage
Here the usage for MiniUpdateChecker

### Basic
#### Default Theme

```java
new MiniUpdateChecker(this).check();
```
```java
 new MiniUpdateChecker(this)
                .setTheme(MiniUpdateChecker.DEFAULT_THEME)
                .check();	
```

#### Mini Theme
```java
 new MiniUpdateChecker(this)
                .setTheme(MiniUpdateChecker.MINI_THEME)
                .check();	
```

#### Simple Theme
```java
new MiniUpdateChecker(this)
                .setTheme(MiniUpdateChecker.SIMPLE_THEME)
                .check();	
```


### Customized

## Customizations

## Attributes

## Notes

## Contribute

## License
