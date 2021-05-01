![Image](/img/2200x660.png)

[ ![maven-central](https://img.shields.io/maven-central/v/com.bartoszlipinski/disable-animations-rule?label=maven-central) ](https://search.maven.org/search?q=g:com.bartoszlipinski%20AND%20a:disable-animations-rule)

**JUnit TestRule for Android instrumented tests, which automatically disables and enables animations**

---

Read more here: [One @Rule to disable them all](https://medium.com/p/d387da440318/)

Usage
=====
*For a working usage of this library see the `sample/` module.*

 1. Add to your test:

     ```java
     @ClassRule
     public static DisableAnimationsRule animationsRule = new DisableAnimationsRule();
     ```

 2. Enjoy **animation-free** Android instrumented tests

Including In Your Project
-------------------------
Add in your `build.gradle`:
```xml
allprojects {
 repositories {
  ...
  maven { url 'https://jitpack.io' }
 }
}

dependencies {
    androidTestImplementation 'com.bartoszlipinski:disable-animations-rule:2.0.0'
}
```

Compatibility
-------------
This library uses UiAutomator which means it will work correctly only if you perform instrumented tests on devices with Android API 18+. Also it uses executing shell commands which is supported by APIs 21+.

Although this is the case, you can still add this testing library in projects with minSdk>=14. This has been done on purpose, so that you can easily include it in your project without the need for adding a custom AndroidManifest.xml to your test environment (more on that in the [post](https://medium.com/p/d387da440318/)).

Bare in mind that it **does not** mean that it will work on devices `<14; 21)`. Testing device must still be 21+. It's just so you can easily add it to the project.

Developed by
============
 * Bartosz Lipiński

License
=======

    Copyright 2018 Bartosz Lipiński
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
