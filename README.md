<sup>Lorenzo Mirto Bertoldo @climadd</sup>

# Shopping List
## Overview

Shopping List Manager is an efficient command-line-based application for creating and managing multiple shopping lists.  
It allows users to categorize items, track costs, and save/load lists for future use.

## Installation

This project was developed using Java 17, but it should run on any modern Java version. Before running the project, ensure that Java is installed on your system. You can follow this [installation guide](https://www.java.com/en/download/help/download_options.html) to set it up.

### Setup Instructions:
- **Verify Java Installation**: Run `java -version` in the terminal to confirm Java is installed.
- **Clone the Repository** (if applicable): Use `git clone <repo-link>` to download the project.
- **Compile the Source Code**: Navigate to the project directory and use `javac *.java` to compile all Java files.
- **Run the Application**: Execute the `Main` class as a Java application. You can interact with the software via its command-line interface.

## Features

- **Multiple shopping lists** with unique names  
- **Item management**: Add, modify, and remove items (name, quantity, cost, category)  
- **Automatic categorization**: Items default to "Uncategorized" if no category is specified  
- **Search functionality**: Find items within a list by name prefix  
- **Total cost calculation**: Compute the total cost of a list based on item prices and quantities  
- **Category-based filtering**: Retrieve all items in a list belonging to a specific category  
- **File persistence**: Save lists to a file and reload them when needed  

## Structure

- **Object-oriented design**:
  - Follows the **Model-View-Controller (MVC)** design pattern, where the **Model** handles the data and business logic, the **View** presents the information to the user, and the **Controller** processes user input and updates the Model and View accordingly, ensuring a clean separation of concerns and maintainable code. 
  - A **Command-Line Interface (CLI)** is provided.  
  - Encapsulation, modularity, and exception handling ensure robust functionality.  
  - Shopping lists are **iterable** for easy processing.
    
- **Core classes**:
  - `Article`: Represents a product with attributes like name, quantity, category, and cost.  
  - `ShoppingList`: Manages items in a specific list.  
  - `ListManager`: Handles multiple lists and shared categories.  
  - `CommandLineInterface`: Provides a straightforward way to access the functionalities of the project.

## Usage Specifics

The program allows users to create, edit, and manage shopping lists through an intuitive interface.  
All operations are **exception-handled** and **error-handled**, and lists can be **saved and reloaded** for future sessions.
