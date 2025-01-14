# Game Kit Sample Code (Android)
[![Apache-2.0](https://img.shields.io/badge/license-Apache-blue)](http://www.apache.org/licenses/LICENSE-2.0)
[![Open Source Love](https://img.shields.io/static/v1?label=Open%20Source&message=%E2%9D%A4%EF%B8%8F&color=green)](https://developer.hihonor.com/demos/)
[![Java Language](https://img.shields.io/badge/language-java-green.svg)](https://www.java.com/en/)

English | [中文](README_ZH.md)

## Contents

- [Game Kit Sample Code (Android)](#game-kit-sample-code-android)
  - [Contents](#contents)
  - [Introduction](#introduction)
  - [Environment Requirements](#environment-requirements)
  - [Hardware Requirements](#hardware-requirements)
  - [Preparations](#preparations)
  - [Installation](#installation)
  - [Technical Support](#technical-support)
  - [License](#license)

## Introduction

In this sample code, you will use the created demo project to call APIs of Game Kit. Through the demo project, you will:
1.Understand how to use the Game kit.

For more information, please refer to
[Service Introduction](https://developer.honor.com/cn/tg/page/tg2022110110100005?navation=dh51628604092081373194%2F1).

## Environment Requirements

Android targetSdkVersion 29 or later and JDK 1.8.211 or later are recommended.

## Hardware Requirements

A computer (desktop or laptop) running Windows 10 or Windows 7
A Honor phone with a USB data cable, which is used for debugging

## Preparations
1.	Register as a Honor developer.
2.	Create an app and start APIs.
3.	Import your demo project to Android Studio (Chipmunk | 2021.2.1) or later. Download the **mcs-services.json** file of the app from [Honor Developer Site](https://developer.honor.com/cn/docs/11016/guides/intergrate), and add the file to the app-level directory (java language is '/javaapp/', kotlin language is '/KotlinApp/') of your project. Generate a signing certificate fingerprint, add the certificate file to your project, and add the configuration to the *build.gradle* file. For details, please refer to the [integration preparations](https://developer.honor.com/cn/docs/11016/guides/scene-thread).


## Installation
Method 1: Compile and build the APK in Android Studio. Then, install the APK on your phone and debug it.
Method 2: Generate the APK in Android Studio. Use the Android Debug Bridge (ADB) tool to run the **adb install {*YourPath/YourApp.apk*}** command to install the APK on your phone and debug it.

## Technical Support

If you have any questions about the sample code, try the following:
- Visit [Stack Overflow](https://stackoverflow.com/questions/tagged/honor-developer-services?tab=Votes), submit your questions, and tag them with `honor-developer-services`. Honor experts will answer your questions.

If you encounter any issues when using the sample code, submit your [issues](https://github.com/Honor-Developer/gamekit-demo/issues) or submit a [pull request](https://github.com/Honor-Developer/gamekit-demo/pulls).

## License
The sample code is licensed under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).