# Title

This project does this and that.

## Building

This project uses `sbt` version 1.8.2 and Scala 3.2.1. If you have `sbt` installed, just write

    sbt run

to run the program, or 

    sbt test

to run the tests.

This project uses the assembly plugin, so you can easily generate a standalone
executable jar with 

    sbt assembly

Find the generated `excercise.jar` under `target/scala-3.2.1`.

### Docker

Alternatively, a `Dockerfile` is provided to produce a docker image.

The build will run the tests, generate a stand-alone `jar` file, and finally produce a (smallish) image that can be
executed (without arguments) to run the program.

## Running

    time java -jar target/scala-3.2.1/exercise.jar < src/test/resources/data_big.txt > /dev/null

    ________________________________________________________
    Executed in  787,20 millis    fish           external
    usr time    2,04 secs    394,00 micros    2,04 secs
    sys time    0,25 secs    132,00 micros    0,25 secs
