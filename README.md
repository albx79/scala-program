# Title

This project does this and that.

## Building

This project uses `sbt` version 1.8.2 and Scala 3.2.1. If you have `sbt` installed, just write

    sbt run

to run the program, or 

    sbt test

to run the tests.

### Docker

Alternatively, a `Dockerfile` is provided to produce a docker image.

The build will run the tests, generate a stand-alone `jar` file, and finally produce a (smallish) image that can be
executed (without arguments) to run the program.
