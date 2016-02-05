### Continuous Dependency Updating

[![Dependency Status](https://www.versioneye.com/user/projects/56ad588c314d03000eba7b82/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56ad588c314d03000eba7b82)

### VersionEye Maven Plugin

The [VersionEye Maven Plugin](https://github.com/versioneye/versioneye_maven_plugin) is a Maven Plugin for the [VersionEye API](https://www.versioneye.com/api/). 

The [maven](https://github.com/versioneye/versioneye_maven_plugin) plugin for [VersionEye](https://www.versioneye.com/) helps you to create/update a project at VersionEye, which is a Notification System for Software Libraries. It will help you to keep your projects up-to-date and automatically notify you about outdated dependencies and license violations. You can check it out here: [www.versioneye.com](https://www.versioneye.com/).

This plugin is specially required if you have a reactor build, a big Maven project with parent pom and children. The VersionEye plugin is resolving all dependencies and variables locally and only sends the results to the VersionEye API. 

You can add the plugin to your project by adding this snippet to your
`pom.xml` file.

```
<build>
  <plugins>
    <plugin>
      <groupId>com.versioneye</groupId>
      <artifactId>versioneye-maven-plugin</artifactId>
      <version>3.5.1</version>
      <configuration>
        <apiKey>MY_SECRET_API_KEY</apiKey>
      </configuration>
    </plugin>
  </plugins>
</build>
```

You can use some of the resources at the VersionEye API without an *API KEY*, but for the project resource you need one. If you are [signed up](https://www.versioneye.com/signup) you can find your *API KEY* here: [https://www.versioneye.com/settings/api](https://www.versioneye.com/settings/api).

![VersionEye Dependencies](https://github.com/versioneye/versioneye_maven_plugin/raw/master/src/site/images/VersionEyeApiKey.png)

## mvn versioneye:create

If your *API KEY* is in place you can create a new project at VersionEye based on the dependencies in your `pom.xml` file with this goal:

```
mvn versioneye:create
```

This command will **not** change your local project. It just sends your dependencies to the VersionEye server and creates, based on that, a new project at [www.versioneye.com](http://www.versioneye.com). If everything went right you will see in the output the URL to your new created VersionEye project. Just copy and paste it into you browser to check it out. Here is an example how it could look like:

![VersionEye Dependencies](https://github.com/versioneye/versioneye_maven_plugin/raw/master/src/site/images/VersionEyeDependencies.png)

Besides that, the plugin will add a `project_id` to the `versioneye.properties` file. The `project_id` is the connection between your `pom.xml` and the VersionEye project. If the `versioneye.properties` file doesn't exist yet, it will be created now.

If you don't want that the versioneye maven plugin creates/updates the `versioneye.properties` file you can skip that step with this line in the plugin configuration:

```
<updatePropertiesAfterCreate>false</updatePropertiesAfterCreate>
```

If you do so, you have to add the `project_id` by hand to the plugin configuration for the next step, the `versioneye:update` goal.

## mvn versioneye:update

After you created a new project on VersionEye you can update it with the dependencies from the `pom.xml` file with this goal:

```
mvn versioneye:update
```

That will simply update the existing VersionEye project with the dependencies from your `pom.xml` file. It will **not** change your `pom.xml`. This goal usually gets executed on a Continuous Integration server after each build.

By the way. If you don't like to have a `versioneye.properties` file you can set the project_id explicitly in the pom.xml. Just like this:

```
<build>
  <plugins>
    <plugin>
      <groupId>com.versioneye</groupId>
      <artifactId>versioneye-maven-plugin</artifactId>
      <version>3.5.1</version>
      <configuration>
	    <projectId>_YOUR_VERSIONEYE_PROJECT_ID_</projectId>
	  </configuration>
    </plugin>
  </plugins>
</build>
```

## mvn versioneye:licenseCheck

On VersionEye you can have [License Whitelists](http://blog.versioneye.com/2014/09/15/license-whitelist/). If you
are working with License Whitelists you probably want to break the build if there is a license violation.
The next goal will update your VersionEye project with the current dependencies and check them against a
License Whitelist. If there is a violation of the License Whitelist this goal will break your build:

```
mvn versioneye:licenseCheck
```



