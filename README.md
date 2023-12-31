# Library Management System

## Overview

The Library Management System is a console-based application in its initial phase, designed for basic book management. Users can add books, search, and display the collection. Future features may include a history log and a login system.

## Features

- **Add Books:** Add new books with details like Book ID, Name, Title, Price, and Field.

- **Search Books:**
  - Search by Book ID.
  - Search by Book Name.
  - Search by Field (genre or category).

- **Display Books:** View the entire book collection.

## Future Enhancements

- **History Logging:** Track changes and additions to the library.
  
- **Login System:**
  - **Client Login:** Manage books, including additions, removals, and modifications.
  - **User Access:** View, search, and add books without managing privileges.

## Project Structure

The project is organized into three main classes:

1. **Main Class (`Main.java`):**
   - Handles user interaction.
   - Takes user input for desired operations.
   - Calls methods from `LibraryManagement` based on user choices.

2. **LibraryManagement Class (`library/LibraryManagement.java`):**
   - Manages operations related to adding and searching books.
   - Contains methods for adding books to the library and searching for books.

3. **Library Class (`library/Library.java`):**
   - Stores the data related to books.
   - Provides methods for accessing and modifying book data.

## Getting Started

1. Clone the repository.
2. Compile and run `Main.java`.
3. Follow on-screen prompts to interact with the library management system.

## Usage

1. Choose options to add books, search by ID, name, or field, and display the book collection.
2. Follow the instructions provided during runtime.
3. Explore the functionalities to manage and explore the library.
