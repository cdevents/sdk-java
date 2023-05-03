# Developing

## Setting up a development environment

### Setup a GitHub account accessible via SSH

GitHub is used for project Source Code Management (SCM) using the SSH protocol for authentication.

1. Create [a GitHub account](https://github.com/join) if you do not already have one.
1. Setup
[GitHub access via SSH](https://help.github.com/articles/connecting-to-github-with-ssh/)

### Install tools

You must install these tools:

1. [`git`](https://help.github.com/articles/set-up-git/): For source control

1. [`java`](https://www.oracle.com/java/technologies/downloads/): The language this SDK is built in. Java 9 is a minimum requirement to build the project.

1. [`docker`](https://www.docker.com/): Required If Super-Linter needs to run locally



### Setup a fork

The sdk-java project requires that you develop (commit) code changes to branches that belong to a fork of the `cdevents/sdk-java` repository in your GitHub account before submitting them as Pull Requests (PRs) to the actual project repository.

1. [Create a fork](https://help.github.com/articles/fork-a-repo/) of the `cdevents/sdk-java` repository in your GitHub account.

1. Create a clone of your fork on your local machine:

    ```shell
    git clone git@github.com:${YOUR_GITHUB_USERNAME}/sdk-java.git
    ```

1. Configure `git` remote repositories

    Adding `cdevents/sdk-java` as the `upstream` and your fork as the `origin` remote repositories to your `.git/config` sets you up nicely for regularly [syncing your fork](https://help.github.com/articles/syncing-a-fork/) and submitting pull requests.

    1. Change into the project directory

        ```shell
        cd sdk-java
        ```

    1. Configure sdk-java as the `upstream` repository

        ```shell
        git remote add upstream git@github.com:cdevents/sdk-java.git

        # Optional: Prevent accidental pushing of commits by changing the upstream URL to `no_push`
        git remote set-url --push upstream no_push
        ```

    1. Configure your fork as the `origin` repository

        ```shell
        git remote add origin git@github.com:${YOUR_GITHUB_USERNAME}/sdk-java.git
        ```

## Developing, building and testing


To [Run Super-Linter locally](https://github.com/github/super-linter/blob/main/docs/run-linter-locally.md):

```shell
$ docker run -e RUN_LOCAL=true -e USE_FIND_ALGORITHM=true -v /path/to/local/codebase:/tmp/lint github/super-linter:v4
```

To run unit tests:
```shell
$ ./mvnw test
```

To run all targets, before creating a commit:

```shell
./mvnw verify
```
