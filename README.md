Scalariform IntelliJ IDEA plugin
================================

This plugin adds a menu item that allows you to format the current file using Scalariform.

After installing the plugin, go to Preferences -> Scalariform and choose the formatting options
you would like to be pass to scalariform.

When editing a Scala file, you will find "Format with Scalariform" option in the Code menu.

FAQ
---

**1. The plugin is fast! How does it work?**

The plugin uses Scalariform as a library. It does not fork a new JVM to format your code.

**2. Can it use my project Scalariform preferences from SBT?**

Currently it is not able to do it. Pull requests are welcome!

**3. How do I submit bugs / feature requests?**

Please use Github issues for these. Requests for enhancing Scalariform itself should to go the Scalariform project
and not to this project.
