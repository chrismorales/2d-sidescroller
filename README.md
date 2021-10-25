# 2D Side Scroller

---

### `Written using the Libgdx API`

# Libgdx AP in a nutshell

**libGDX** is a cross-platform Java game development framework based on OpenGL (ES) that works on Windows, Linux, macOS, Android, your browser and iOS.

- **libGDX** provides a well-tried and robust environment for rapid prototyping and fast iterations. **libGDX** does not force a specific design or coding style on you; it rather gives you the freedom to create a game the way you prefer.\*

# Documentation

The libGDX codebase is documented in two ways:

- In the [Wiki](https://github.com/libgdx/libgdx/wiki)
- In the [Java Docs](https://libgdx.badlogicgames.com/ci/nightlies/docs/api/)

# A simple Starter Class

_Desktop_

```java
package com.badlogic.drop.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.drop.Drop;

public class DesktopLauncher {
   public static void main (String[] arg) {
      LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
      config.title = "Drop";
      config.width = 800;
      config.height = 480;
      new LwjglApplication(new Drop(), config);
   }
}
```
