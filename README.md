# Limber

Limber is designed to do the same thing [Timber](https://github.com/JakeWharton/timber) does without
forcing you to rely on Android if you don't want to. Limber has basically the same API as Timber,
but implements the logging API in a pure Java module and adds on the Timber wrapper in a separate
Android module.

My primary reason for doing this is so I can make use of Timber's magic tagging in pure Java
modules.

#### To-do:
1. Convince Jake Wharton to reopen and accept Timber PR
   [#63](https://github.com/JakeWharton/timber/pull/63), which would make this library unnecessary.
2. Implement tests
3. Figure out how to actually publish this as a library
4. Support multiple logging clients at the same time?
5. Implement alternate logging clients? 
