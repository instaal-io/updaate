<h1 align="center"><img src="https://user-images.githubusercontent.com/42619122/155006230-75e7e844-97f6-4cfa-93c1-f0aa20eeaf7f.png" height="30" weight="30" alt="GitHub forks"> <b>MiniUpdateChecker</b></h1>
<p align="center"><b>A Minimalist App Update Checker for Android</b></p>

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
<p><img src="https://user-images.githubusercontent.com/42619122/155010041-95b0e60d-d296-4c49-96ba-8cc0c154db68.png" width="260" alt="Screenshot_1645468216">
<img src="https://user-images.githubusercontent.com/42619122/155010049-d24a96d3-ec8f-4c89-98a4-81460473d14d.png" width="260" alt="Screenshot_1645468238">
<img src="https://user-images.githubusercontent.com/42619122/155010051-31df497c-b2a7-4f0d-9f4a-61388de02c78.png" width="260" alt="Screenshot_1645468252"></p>

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
MiniUpdateChecker has plenty of Options. Use Default theme or you can customize as much as you want. Here the usages for MiniUpdateChecker:

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

```java
  new MiniUpdateChecker(this)
                .setTheme(MiniUpdateChecker.DEFAULT_THEME)
                .setTitle("App Updater")
                .setAppIcon(R.drawable.ic_baseline_10mp_24)
                .setCloseIcon(R.drawable.ic_android_black_24dp)
                .setDescription("New Update For")
                .setAppName("MY APP")
                .setPositiveLabel("Do It")
                .setNegativeLabel("Never")
                .setBackgroundColor(Color.parseColor("#ffffff"))
                .setPositiveButtonColor(Color.parseColor("#00ACC1"))
                .setNegativeButtonColor(Color.parseColor("#DDDDDD"))
                .setPrimaryTextColor(Color.parseColor("#00ACC1"))
                .setSecondaryTextColor(Color.parseColor("#444444"))
                .setPositiveTextColor(Color.parseColor("#FFFFFF"))
                .setNegativeTextColor(Color.parseColor("#444444"))
                .shouldCheckAfterLaunch(1)
                .check();
```


## Customizations

### Themes
There different themese with pre desgined layouts, but you can customize them as well. If no theme defined then `Default Theme` will be used.

#### Default Theme
```Java
.setTheme(MiniUpdateChecker.DEFAULT_THEME)
```

#### Mini Theme
```Java
.setTheme(MiniUpdateChecker.MINI_THEME)
```

#### Simple Theme
```Java
.setTheme(MiniUpdateChecker.SIMPLE_THEME)
```

### Text (Title, Description, App Name, Positive Button Text, Negative Button Text)

Change different text on the layout by using these snippets.

```Java
.setTitle("")
.setDescription("")
.setAppName("")
.setPositiveLabel("")
.setNegativeLabel("")
```


### Image (App Icon, Close Icon)
Change the icons on the layout by using these snippets.

```Java
.setAppIcon(R.drawable.ic_baseline_10mp_24)
.setCloseIcon(R.drawable.ic_android_black_24dp)
```

### Colors (Background, Positive Button BG, Negative Button BG, Primary Text, Secondary Text, Positive Text Color, Negative Text Color)
Change the colors on the layout by using these snippets.
```Java
.setBackgroundColor(Color.parseColor("#ffffff"))
.setPositiveButtonColor(Color.parseColor("#00ACC1"))
.setNegativeButtonColor(Color.parseColor("#DDDDDD"))
.setPrimaryTextColor(Color.parseColor("#00ACC1"))
.setSecondaryTextColor(Color.parseColor("#444444"))
.setPositiveTextColor(Color.parseColor("#FFFFFF"))
.setNegativeTextColor(Color.parseColor("#444444"))
```
### Recheck Again
You can set recheck again for next launches, like after 5 app launch. If nothing set then it will check on Every Launch.
```Java
.shouldCheckAfterLaunch(1)

```

## Attributes

| Keyword | Attribute | Description
|---------------|---------|----------------------|
| `setTheme` | DEFAULT , MINI, SIMPLE | Select From Prebuilt Theme |
| `setTitle` | String | Dialog Title |
| `setAppIcon` | Drawable | Dialog Top Icon |
| `setCloseIcon` | Drawable | Dialog Close Icon |
| `setAppName` | String | Set App Name |
| `setPositiveLabel` | String | Positive Button Text |
| `setNegativeLabel` | String | Negative Button Text |
| `setBackgroundColor` | Int | Dialog Background Color |
| `setPositiveButtonColor` | Int | Positive Button Background Color |
| `setNegativeButtonColor` | Int | Negative Button Background Color |
| `setPrimaryTextColor` | Int | Color for Primary Texts |
| `setSecondaryTextColor` | Int | Color for Secondary Texts |
| `setPositiveTextColor` | Int | Color for Positive Button Text |
| `setNegativeTextColor` | Int | Color For Negative Button Text |
| `shouldCheckAfterLaunch` | Int | Again Check Settings |
| `check` |  | Start Checking for update |


## Notes
Here are some things you should remember:
- Always call `check()` at the end. Library won't work without it.
- If you don't set any them then the Default Theme will be selected automatically.
- If you don't set App name then it will be picked automatically. 
- If `shouldCheckAfterLaunch` is not used then lib will check for update in every launch.
- If the app is not live on store, then it won't show any dialog
- If the app is already latest version, then it won't show any dialog.

## Contribute
Please fork this repository and contribute back using [pull requests](https://github.com/instaal-io/MiniUpdateChecker/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated.

Let me know which features you want in the future in `Request Feature` tab. 

If this project helps you a little bit, then give a to Star ⭐ the Repo. 

## Credits

Created with Love by @Instaal-io & @ahmmedrejowan

## License
* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2022 Instaal Studio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
