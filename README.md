# SpringbootDemo
SpringBoot demo with H2 database and couple of REST APIs

# About Application
It's a simple java application using SpringBoot. This code was used for internal training and demonstration. It has the following.
- SpringBoot skeleton to implement REST APIs
- Uses H2 database along with JPA
- Currently provides APIs to list and add entity called company
- This code is also containerized and can be run in the docker. The link to directly run in Docker is [here](https://hub.docker.com/r/ajitmahajani/springbootdemo)

```
IMPORTANT:
Please update the docker handle and repository (line #64) in pom.xml before build.
```

# How to build
-    It's a maven project. So just need to run the standard maven commands.
-    For docker build and push use goals dockerfile:build and dockerfile:push in maven
-    Note: Docker needs to be installed on the machine wherer the build is happening.

## Contributors
Thanks to 
-    `Amol Dixit`  for initializing the project and providing basic skeleton
-    `Atul Mahajan`  for extending it to build the REST APIs and H2 database related back-end
-    `Ajit Mahajani` for containerization and documenting
