disable-animations-rule
===============
**JUnit TestRule for Android instrumented tests, which automatically disables and enables animations**

---

Read more here: [One @Rule to disable them all](https://medium.com/@blipinsk/)

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
repositories {
    maven { url 'https://dl.bintray.com/blipinsk/maven/' }
}

dependencies {
    androidTestImplementation 'com.bartoszlipinski:disable-animations-rule:1.0.0'
}
```

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
