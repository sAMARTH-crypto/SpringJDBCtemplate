# SpringJDBCtemplate

# Spring JDBC Template Project

This repository contains a Spring JDBC Template project that demonstrates CRUD (Create, Read, Update, Delete) operations on a database. It is a Java application built using JDK-11.

## Project Environment

- JDK: 11 (Please ensure that you have JDK 11 installed on your system)
- IDE: Any Java IDE (Eclipse, IntelliJ IDEA, etc.)

## Project Setup

1. Clone the repository to your local machine.

2. Open the project in your preferred IDE.

3. Update the JDK version in the `pom.xml` file to match your installed JDK version. This will automatically update the project dependencies accordingly.

4. Create a database and update the database properties in the `database.properties` file. Set the appropriate URL, username, password, and schema details to connect to your database.

5. Run the queries provided in the `schema.sql` file on your database to create the required table and insert sample data. This step is necessary before executing the project or making any changes.

## Project Structure

The project has the following structure:

- **src/main/java**: Contains the Java source code for the project.
  - **com.demo**: Root package for the project.
    - **com.demo.config**: Contains the `AppConfig.java` file, which acts as a replacement for the IOC (Inversion of Control) container.
    - **com.demo.dao**: Contains the `PersonDAO.java` file, which implements the CRUD operations on the database.
    - **com.demo.mapper**: Contains the `MapperMaxId.java` file, which binds the max id query to an object.
    - **com.demo.model**: Contains the `Person.java` file, which represents the data model.
    - **com.demo.util**: Contains the `DatabaseUtil.java` file, which handles the database connection and operations.

- **src/main/resources**: Contains the resource files for the project.
  - **database.properties**: Properties file that includes the database connection details.
  - **schema.sql**: SQL file containing the necessary queries to create the database table and insert sample data.

- **pom.xml**: Maven configuration file that manages the project's dependencies.

## Running the Project

1. Ensure that you have completed the project setup steps mentioned earlier.

2. Open the `App.java` file, which contains the main method.

3. Comment out all the operations except for one that you want to execute (e.g., create, read, update, or delete).

4. Run the `App.java` file to execute the selected operation on the database.

5. Uncomment the next operation and repeat step 4 to perform the remaining CRUD operations.

## Contributing

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

This project utilizes the Spring JDBC Template for performing CRUD operations on a database. We acknowledge the Spring framework developers and contributors for their work and support.

Feel free to download the project and modify it according to your needs. Happy coding!
