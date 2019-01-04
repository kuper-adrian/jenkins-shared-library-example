# Jenkins Shared Pipeline Example with Unit Tests

This repository contains a example shared library for Jenkins that can be unit tested with JUnit and Mockito. The general idea is:

1. Keep the custom steps inside `vars` as small as possible and without any logic. Instead do everything inside classes (inside `src`).
2. Create an interface `IStepExecutor` which declares methods for all required Jenkins steps (sh, bat, error, etc.). The classes call steps only through this interface.
3. Write unit tests for your classes like you normally would. Use your favorite mocking and dependency framework to mock IStepExecutor.

This way you should be able to:

* Compile and execute your library/unit tests without Jenkins
* Test that your classes work as intended
* Test that Jenkins steps are called with the right parameters
* Test the behaviour of your code when a Jenkins step fails
* Build, test, run metrics and deploy your Jenkins Pipeline Library through Jenkins itself

I suggest the IntelliJ IDEA for the least painful Jenkins Shared Library development experience ;)

## Example Jenkinsfile

```
// add the following line and replace necessary values if you are not loading the library implicitly
// @Library('my-library@master') _

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                ex_msbuild 'test'
            }
        }
    }
}
```

## License

Good ol' WTFPL