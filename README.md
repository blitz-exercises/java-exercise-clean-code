# ExerciseName - Java Advanced Exercise Template

This is a template repository for creating Java advanced exercises. Replace `ExerciseName` with your actual exercise name throughout the codebase.

## How to use this template

1. Create a new repository from this template
2. Replace all occurrences of `ExerciseName` with your exercise name
3. Replace all occurrences of `exercisename` (package name) with your exercise name in lowercase
4. Update the `groupId` and `artifactId` in `pom.xml` to match your exercise
5. Customize the exercise requirements in `exercise-requirements.md`
6. Implement your exercise solution

## Project Structure

```
src/
├── main/
│   └── java/
│       └── nl/
│           └── blitz/
│               └── exercisename/    # Replace with your exercise name
│                   ├── ExerciseName.java    # Main exercise class
│                   ├── Item.java            # Example domain class
│                   └── ...                  # Other classes
└── test/
    └── java/
        └── nl/
            └── blitz/
                └── exercisename/    # Replace with your exercise name
                    ├── ExerciseNameTest.java    # Test class
                    └── TexttestFixture.java     # Test fixture
```

## Requirements

See [exercise-requirements.md](src/main/java/nl/blitz/exercisename/exercise-requirements.md) for the exercise specification.

## Running Tests

```bash
mvn test
```

## Contributing

Please see [CONTRIBUTING.md](./CONTRIBUTING.md) for more details.
