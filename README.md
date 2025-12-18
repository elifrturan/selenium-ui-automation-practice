# Selenium UI Automation Practice

This repository contains basic UI automation tests developed as part of a test automation learning process.

The project demonstrates fundamental concepts of UI test automation using Java and Selenium WebDriver, focusing on clean test structure, assertions, and synchronization techniques.

---

## 🛠 Technologies Used
- Java
- Selenium WebDriver
- JUnit
- WebDriverManager

---

## 📂 Project Structure
```plaintext
|-- .idea
|-- .mvn
|-- src
|   |
|   |-- main
|   |
|   |-- test
|       |
|       |-- java
|           |
|           |-- PracticeUiTests.java
|           |-- SearchAssertionsTest.java
|
|-- target
|-- .gitignore
|-- pom.xml
```
---

## 🧪 Test Scenarios Covered

### 🔹 Basic UI Tests
- Login with valid credentials
- Handling dynamic elements on exception pages
- Page title verification

### 🔹 Search & Assertion Tests
- Searching products using keyword input
- Verifying search result visibility
- Practicing different assertion strategies

---

## ⏱ Synchronization Strategy
- Explicit waits (`WebDriverWait`) are used instead of `Thread.sleep`
- This approach improves test stability and reduces flaky test behavior

---

## 🧠 Notes
- The project includes documented examples of JUnit features such as test disabling (`@Ignore`) and timeout usage, explained through comments rather than active implementation
- Test names follow readable and descriptive naming conventions to clearly express test intent

---

## 🎯 Purpose
This project was created to practice and demonstrate:
- UI automation fundamentals
- Test lifecycle management
- Assertion strategies
- Clean and readable test code for maintainability

---

## 🚀 Future Improvements
- Page Object Model (POM) implementation
- Test data externalization
- Cross-browser testing support
