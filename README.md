# How to Use Maven
## Maven
1. It is a build tool, which automates build process of a java project. 			  
2. Build process is creating from a directory structure to making a project as a deployable      artifact like a .jar or war or ear file.
3. Maven follows convention over configuration. It means if a project follows, maven provided     directory structure then it needs very less configuration.
4. An Important feature of Maven is automatic dependency management.
5. Download Maven zip file from www.eu.apache.org/dist.maven.maven-3/3.5.3/binaries/
6. Extract the downloaded zip file then apache-maven-3.5.3 directory would be created.

## Maven Environment settings

1. Create JAVA_HOME
		NAME: JAVA_HOME
		VALUE: C:\Programs Files\Java\jdk 1.8.0_144

2. Create M2_HOME
                     NAME: M2_HOME
                     VALUE: f:\APACHE-MAVEN-3.5.2

3. CREATE M2
                     NAME: M2
	          VALUE: f:\APACHE-MAVEN-3.5.2\bin

4. Add maven to path
### Note: - to verify the settings

## Open command prompt and type the command mvn –version

## Maven Archetype

1. Maven Archetypes are templates for creating similar type of projects.
2. An Archetype automatically creates a directory structure of maven
3. Choose Maven archetype Maven-archetype-quickStart for creating Standalone java projects.
4. For Web-Development choose Maven-archetype-webapp or webapp-jee5.

## Project Co-ordinates
1. groupId    --------> It is organization/company Id.
2. artifactId --------> It is name of the project
3. Version.  --------> Version of the project SNAPSHOT-----> project is under process
						RELEASE-----> Project is completed.

## POM.xml (pom--------> Project object Model)
	* 
1. It is a main file of a maven project.
2. It is use to configure dependencies and plugins
3. Maven downloads dependencies and plugins from central repository and stores them in local    repository.
4. The main dependency for crating Spring framework project is spring-context and it can be      configure like following
		      
<dependencies>
        <dependency>
		<groupId> org.springframework </groupId>
		<artifactId> spring-context </artifactId>
		<version> 4.3.9.RELEASE </version>
        </dependency> 
</dependencies>		

## MAVEN GOALS

1. File Menu ----> New  ----> Project... ----> open Maven----> Select Maven Project ---->Next    ---->next  ---->Select Maven-archetype-quickstart ----> Next ----> enter groupId as  com.LettuceDream ----> artifactId as maven-spring-app ----> Enter package as com.LettuceDream.bean ---->Finish.

2. Open pom.xml and do the following changes
	* Go to properties tag and add the following tag as a child tag 
     <spring.version> 4.3.9.RELEASE </spring.version>
	* Add the following <dependency> tag under <dependencies>.
		<groupId> org.springframework </groupId>
		<artifactId> spring-context </artifactId>
		<version> ${spring.version} </version>

3. Right Click on com.LettuceDream.bean---->New---->class---->Enter the name---->TestBean
	package com.LettuceDream.bean;
	public class TestBean
	{
		private java.util.Date date;
		public void setDate(java.util.Date date)
		 {
		    this.date=date
		 }
		public void printDate()
		 {
			System.out.println(date);
		 }
	}

Step 4: Open Src---->Rightclick new New folder Enter folder name as resources----> Finish

Step 5 Rightclick resources new ----> file----> Enter filename applicationcontext.xml---->finish
	<bean id = "test" class ="com.LettuceDream.bean.Test">
		<property name = "test" ref = "date"/>
	</bean>
	<bean id = "date" class = "java.util.Date">
	</bean>
	
6. RightClick on src/main/java---->New---->package---->Enter the name as com.LettuceDream.test--->Finish

7. Rightclick on com.LettuceDream.test ----> New----> class----> enter the name as Test and select     main checkbox ---->Finish

public class Test
 {
	public static void main(String[] args) 
	{
        //initialize the spring container
ApplicationContext ctx = new ClassPathXmlApplicationContext ("Application-Context.xml")
		//read the bean object
		Object obj = ctx.getBean("Date");
		LettucePrinter lister = (LettucePrinter) obj;
		// invoke showMessage
		lister. LettucePrinter ();
 	}
 }

8. RightClick on Project---->Run as Maven build...---->Enter package in goals----> Run

9. RightClick on Test.java---->Run as ---->java application 

  ***Local repository of maven : C:\Users\intel\.m2\repository
   C:\Users\intel\.m2\repository\org\springframework\spring-context\4.2.5.RELEASE

