# Get Started with Bookzilla

Bookzilla struggles to become a great **Book Renting System**.

## Local Environment setup

- Download and Install [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  - For further details related to the installation process you can refer to [this](https://docs.oracle.com/javase/8/docs/technotes/guides/install/linux_jdk.html) and [this](http://stackoverflow.com/questions/9612941/how-to-set-java-environment-path-in-ubuntu)
- Download and Configure [IntelliJ IDEA - Ultimate Edition](https://www.jetbrains.com/idea/?fromMenu#chooseYourEdition)
  - For installation instructions you can check [this resource](https://www.jetbrains.com/help/idea/2016.2/installing-and-launching.html)
- Download and Unpack [Apache Tomcat](https://tomcat.apache.org/download-80.cgi)
  - Set env variables and update env path
- Create new **Run Configuration** in *IntelliJ IDEA* to point to the Tomcat installation folder
  - Be sure to have configured **http://localhost:8080/** as a launch url, and to have that bookzilla artifact set in the *Before launch* section
- Download and Install [MySql](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-14-04)
- Use [Mysql Client](https://www.tutorialspoint.com/mysql/mysql-administration.htm) to create and configure the db, the user and to set privileges accordingly.
