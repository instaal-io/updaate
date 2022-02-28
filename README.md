<h1 align="center"><img src="https://user-images.githubusercontent.com/42619122/155006230-75e7e844-97f6-4cfa-93c1-f0aa20eeaf7f.png" height="30" weight="30" alt="GitHub forks"> <b>updaate</b></h1>
<p align="center"><b>A Minimalist App Update Checker for Android</b></p>

<br/>

<p align="center">
<a href="https://www.android.com"><img src="https://img.shields.io/badge/platform-Android-yellow.svg" alt="platform"></a>
 <a href="https://android-arsenal.com/api?level=21"><img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" alt="API"></a> <a href="https://jitpack.io/#instaal-io/updaate"><img src="https://jitpack.io/v/instaal-io/updaate.svg" alt="JitPack"></a> <a href="https://github.com/instaal-io/updaate/blob/master/LICENSE"><img src="https://img.shields.io/github/license/instaal-io/updaate" alt="GitHub license"></a>
 </p>
 <p align="center">
 <a href="https://github.com/instaal-io/updaate/issues"><img src="https://img.shields.io/github/issues/instaal-io/updaate" alt="GitHub issues"></a> <a href="https://github.com/instaal-io/updaate/network"><img src="https://img.shields.io/github/forks/instaal-io/updaate" alt="GitHub forks"></a> <a href="https://github.com/instaal-io/updaate/stargazers"><img src="https://img.shields.io/github/stars/instaal-io/updaate" alt="GitHub stars"></a> <a href="https://github.com/instaal-io/updaate/graphs/contributors"> <img src="https://img.shields.io/github/contributors/instaal-io/updaate" alt="GitHub contributors"></a> <img src="https://img.shields.io/github/languages/code-size/instaal-io/updaate" alt="Code Size"> 
  </p>

## Purpose

<b>updaate</b> is a Smart Android Library for checking your Android App Updates on <b>Google Play Store</b>. <b>updaate</b> checks the updates and notifies with beautiful <b>material design dialogs</b>. You can <b>customize</b> the dialog in various ways.

## Demo
Download and Check out the demo app for more

<a href="https://github.com/instaal-io/updaate/blob/master/app_release.apk"> <img src="https://user-images.githubusercontent.com/42619122/155009169-c92bbebb-7e96-452e-956b-b5905d2cdcdc.png" height="100" width="200" alt="Download"/> </a>


## What's New
It's first release, so everything is new.
Check out `Releases` Tab for Info. 

## Features
updaate has these features:
- Checking Update for Your Android App on Google Play Store
- Material Design UI
- 3 Themes
- Highly Customizable

## Build Info
This library is built by this conifg:
- Compile SDK 32
- Minimum SDK 21
- Target SDK 32
- Built on Java 1.8
- Material Design using Androidx Library
- Jsoup for Parsing
- Lottiefiles for Animations

## Screenshot
Here is some screenshots of the library

| Simple | Default | Advanced |
|---------|--------|------|
| ![default](https://user-images.githubusercontent.com/42619122/155828397-f27780c7-db86-42b0-ac2d-e7a439f2ffc7.png) | ![smart](https://user-images.githubusercontent.com/42619122/155828399-deee9cb7-be9e-466a-b34d-1cc5aa693073.png) | ![fancy](https://user-images.githubusercontent.com/42619122/155828401-c3ece947-c03a-444f-a77a-9502961f279f.png) |



## Prerequisites

#### Old
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

#### New
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

(Always use the latest version. Current Latest version is <a href="https://jitpack.io/#instaal-io/updaate"><img src="https://jitpack.io/v/instaal-io/updaate.svg" alt="JitPack"></a> )

```gradle
dependencies {
	...
		implementation 'com.github.instaal-io:updaate:1.0'

}
```


## Usage
updaate has plenty of Options. Use Default theme or you can customize as much as you want. Here the usages for updaate:

### SIMPLE THEME

A Simple Material Design Theme. Basic Functionalities with Basic Customization

#### Basic

``` java

        new updaate(this)
                .setTheme(updaate.SIMPLE_THEME)
                .check());

```

#### Customizations

``` java

        new updaate(this)
                .setTheme(updaate.SIMPLE_THEME)
                .setAppIcon(R.mipmap.ic_launcher)
                .setTitle("An Update Available")
                .setPositiveLabel("Update Now")
                .setNegativeLabel("Maybe Later")
                .setBackgroundColor(Color.parseColor("#FFFFFF"))
                .setNegativeButtonColor(Color.parseColor("#dddddd"))
                .setPrimaryColor(R.color.colorPrimary)
                .setSecondaryColor(Color.parseColor("#666666"))
                .setPositiveTextColor(Color.WHITE)
                .shouldCheckAfterLaunch(1)
                .setCancelable(true)
                .check());

```

### DEFAULT THEME

A well-designed theme with a lot customizations. If no theme is selected then it will be selected automatically.

#### Basic

``` java

        new updaate(this)
                .setTheme(updaate.DEFAULT_THEME)
                .check());

```

#### Customizations

``` java

        new updaate(this)
                .setTheme(updaate.DEFAULT_THEME)
                .setAppIcon(R.mipmap.ic_launcher)
                .setTitle("An Update Available")
                .setPositiveLabel("Update Now")
                .setNegativeLabel("Maybe Later")
                .setIconColor(R.color.colorAccent)
                .setBackgroundColor(Color.parseColor("#FFFFFF"))
                .setNegativeButtonColor(Color.parseColor("#dddddd"))
                .setPrimaryColor(R.color.colorPrimary)
                .setSecondaryColor(Color.parseColor("#666666"))
                .setPositiveTextColor(Color.WHITE)
                .hideNegativeButton(true)
                .setDialogCornerRadius(10)
                .setButtonCornerRadius(10)
                .shouldCheckAfterLaunch(1)
                .setCancelable(true)
                .check());

```

### ADVANCED THEME

#### Basic

``` java

        new updaate(this)
                .setTheme(updaate.ADVANCED_THEME)
                .check());

```

#### Customizations

``` java

        new updaate(this)
                .setTheme(updaate.ADVANCED_THEME)
                .setTitle("An Update Available")
                .setPositiveLabel("Update Now")
                .setNegativeLabel("Maybe Later")
                .setBackgroundColor(Color.parseColor("#FFFFFF"))
                .setPrimaryColor(R.color.colorPrimary)
                .setSecondaryColor(Color.parseColor("#666666"))
                .setPositiveTextColor(Color.WHITE)
                .hideNegativeButton(true)
                .setDialogCornerRadius(10)
                .setButtonCornerRadius(10)
                .useImageInsteadAnim(false)
                .setHeaderAnimation(updaate.ANIMATION_1)
                .setHeaderImage(updaate.IMAGE_3)
                .shouldCheckAfterLaunch(1)
                .setCancelable(true)
                .check());

```


## Customizations

### Global

- `.setTheme()`	- For selecting Theme
- `.setTitle()` -  For Changing the Title
- `.setPositiveLabel()` - For Changing the Positive Button Text
- `.setNegativeLabel()` - For Changing the Negative Button Text
- `.setBackgroundColor()` -  For Changing the Background Color
- `.setPrimaryColor()` -  For Changing the Primary Color (Color of Title, Latest Version and Positive Button Background)
- `.setSecondaryColor()` -  For Changing the Secondary Color (Color of Your Version, Negative Button Text)
- `.setPositiveTextColor()` -  For Changing the Positive Text Color
- `.shouldCheckAfterLaunch()` -  After how many launch, the library will recheck for update. If not set it will check in every launch.
- `.setCancelable()` -  For Setting the dialog to be cancelable if touch outside the dialog
- `.check()` - Start Checking. IT MUST BE CALLED.
		

### Theme Based

#### SIMPLE

#### DEFAULT

#### ADVANCED

## Attributes

| Keyword | Attribute | Description | Used In |
|---------------|---------|---------|----------| 
| `setTheme` | DEFAULT , SMART, FANCY | Select From Prebuilt Theme | All Theme |
| `setAppIcon` | Drawable | Dialog Top Icon | Only SMART Theme |
| `setIconColor` | Int | Color for App Icon (Only use if it's a vector) | Only SMART Theme |
| `setTitle` | String | Dialog Title | All Theme |
| `setPositiveLabel` | String | Positive Button Text | All Theme |
| `setNegativeLabel` | String | Negative Button Text | All Theme |
| `setBackgroundColor` | Int | Dialog Background Color | All Theme |
| `setPrimaryColor` | Int | Color for Primary Objects | All Theme |
| `setSecondaryColor` | Int | Color for Secondary Objects | All Theme |
| `setPositiveTextColor` | Int | Color for Positive Button Text | All Theme |
| `setNegativeButtonColor` | Int | Negative Button Background Color | Default & SMART | 
| `shouldCheckAfterLaunch` | Int | Again Check for Launch | All Theme
| `check` |  | Start Checking for update | |


## Theme Differences
| Topic | Default | Smart | Fancy |
|-------|---------|-------|-------|
| App Icon | No | Yes | No |
| Animation | No | No | Yes |
| Negative Button | Yes | Yes | No |
| Preview | ![Default](https://user-images.githubusercontent.com/42619122/155840252-1ee6e581-22f2-4a70-ae89-51e63884b434.png) | ![Smart](https://user-images.githubusercontent.com/42619122/155840255-4016f6da-3984-4a95-8b80-02e96edc08d6.png) | ![Fancy](https://user-images.githubusercontent.com/42619122/155840256-001cb494-6392-43d0-a4a9-a885d9e9ec8f.png) |


## Notes
Here are some things you should remember:
- **Always call `check()` at the end**. Library won't work without it.
- If you don't set any them then the Default Theme will be selected automatically.
- If `shouldCheckAfterLaunch` is not used then lib will check for update in every launch.
- If the app is not live on store, then it won't show any dialog
- If the app is already latest version, then it won't show any dialog.

## Contribute
Please fork this repository and contribute back using [pull requests](https://github.com/instaal-io/updaate/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated.

Let me know which features you want in the future in `Request Feature` tab. 

If this project helps you a little bit, then give a to Star ⭐ the Repo. 

## Credits

Created with Love by <a href="https://github.com/instaal-io"> Instaal Studio </a> & <a href="https://github.com/ahmmedrejowan"> K M Rejowan Ahmmed </a>

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
