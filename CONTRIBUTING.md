Contributing to Exercise Template
======

This is a template repository for creating Java advanced exercises. When using this template to create a new exercise, please follow these guidelines.

## Creating a new exercise from this template

1. Replace all occurrences of `ExerciseName` with your exercise name
2. Replace all occurrences of `exercisename` (package name) with your exercise name in lowercase
3. Update the `groupId` and `artifactId` in `pom.xml` to match your exercise
4. Customize the exercise requirements in `exercise-requirements.md`
5. Implement your exercise solution

## Recommended project structure

The template maintains a standard Java project structure:

- Main exercise class: `ExerciseName.java` (replace with your exercise name)
- Test class: `ExerciseNameTest.java` (replace with your exercise name)
- Test fixture: `TexttestFixture.java` for command-line testing
- Requirements: `exercise-requirements.md` in the main package directory

## Exercise requirements

When creating a new exercise, ensure:

- The starting position includes a basic structure that students can build upon
- Include at least one failing unit test to guide students
- Provide clear requirements in `exercise-requirements.md`
- Keep the initial code simple but functional

## Code style

- Follow Java naming conventions
- Use meaningful variable and method names
- Keep methods small and focused
- Prefer composition over inheritance where appropriate
