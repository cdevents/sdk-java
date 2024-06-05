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

## Upgrade SDK to the Latest CDEvents Spec 
The [Java SDK Generator](./generator) is utilized to create events from the CDEvents Spec schemas, 
and the [CDEvents Spec repository](https://github.com/cdevents/spec/) is added as a Git Submodule to this repository which needs to be updated with latest Spec release.
- Steps involved to generate latest SDK
1. Update spec submodule to the latest release
    - Create a private working branch from [cdevents/sdk-java](https://github.com/cdevents/sdk-java)
    - Update submodule by running `git submodule update --init`
    - Checkout the latest release spec version to update the spec repo, from spec root directory
      ````bash
      cd spec
      git checkout main && git pull
      git checkout <latest-release-tag>
      cd ../
      ````
    - Verify the latest Spec is applied and Push the modified spec to your private working branch
2. Generate model classes from CDEvents Spec schemas using maven plugin `jsonschema2pojo`
    - Compare the existing `jsonschema2pojo` plugin configuration in the [generator's pom.xml file](./generator/pom.xml) with the available CDEvents Spec schemas
    - Add/update executions for `jsonschema2pojo` plugin configuration in the [generator's pom.xml file](./generator/pom.xml) as below,
      ````pom
       <execution>
            <id>generate-<subject>-<predicate>-from-schema</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <sourcePaths>
                    <sourcePath>${parent.project.dir}/spec/schemas/<schema-file-name>.json</sourcePath>
                </sourcePaths>
                <targetPackage>dev.cdevents.models.<subject>.<predicate></targetPackage>
            </configuration>
      </execution>
      ````
    - Where, `id`, `sourcePath` needs to be updated with the actual file name and `targetPackage` directory structure needs to be created in [sdk models](./sdk/src/main/java/dev/cdevents/models) for each new schema file if you find in CDEvents Spec schemas

3. The [Schema Preprocessor](./preprocessor) updates the CDEvents Spec schemas to comply with `jsonschema2pojo` for generating model classes.</br>
Currently [PreprocessSchemas.java](./preprocessor/src/main/java/dev/cdevents/preprocessor/PreprocessSchemas.java) updates the schema's ref URL to include `.json` extension for all the spec schemas and will be executed as a Maven module from the parent [pom.xml](./pom.xml)</br>
   Example:
   ````
   from
   "$ref": "links/embeddedlinksarray"
   to
   "$ref": "links/embeddedlinksarray.json"
   ````
4. Generate CDEvent classes using [mustache template](./generator/src/main/resources/template/event-template.mustache)
    - [event-template.mustache](./generator/src/main/resources/template/event-template.mustache) needs an update If there is any change in the `context` or `subject` of a CDEvent
    - All the [CDEvents](./sdk/src/main/java/dev/cdevents/events) generated by using `event-template.mustache`
    - [Java SDK Generator](./generator) will be executed as a Maven module from the parent [pom.xml](./pom.xml)
5. Run `./mvnw verify` and fix if any issues found during the build process.</br>
   Add/Update test cases for the new/updated events to validate that they are generated correctly in [sdk](./sdk) 
6. Create a Code PR into `cdevents:main` from your private working branch and work on releasing the latest version of the SDK once the PR is merged.