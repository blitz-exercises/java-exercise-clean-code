# CleanCode - Java Advanced Exercise

This is a Java advanced exercise focused on clean code practices.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── nl/
│           └── blitz/
│               └── cleancode/
│                   ├── CleanCode.java    # Main exercise class
│                   ├── Item.java         # Example domain class
│                   └── ...               # Other classes
└── test/
    └── java/
        └── nl/
            └── blitz/
                └── cleancode/
                    ├── CleanCodeTest.java    # Test class
                    └── TexttestFixture.java # Test fixture
```

## Requirements

See [exercise-requirements.md](src/main/java/nl/blitz/cleancode/exercise-requirements.md) for the exercise specification.

## Running Tests

```bash
mvn test
```

## Decoding Violation Documentation

Each folder contains a `violations.md` file with base64-encoded documentation listing all clean code violations for that folder. To read these violations, you need to decode them first.

### Using Bash (Linux/Mac)

To decode all violation files:
```bash
./decode-violations.sh
```

To decode a specific folder:
```bash
./decode-violations.sh <folder_name>
```

Example:
```bash
./decode-violations.sh cleancode
./decode-violations.sh user
./decode-violations.sh order
```

The decoded files will be created as `violations-decoded.md` in each folder.

### Using PowerShell (Windows)

To decode all violation files:
```powershell
.\decode-violations.ps1
```

To decode a specific folder:
```powershell
.\decode-violations.ps1 <folder_name>
```

Example:
```powershell
.\decode-violations.ps1 cleancode
.\decode-violations.ps1 user
.\decode-violations.ps1 order
```

The decoded files will be created as `violations-decoded.md` in each folder.

## Contributing

Please see [CONTRIBUTING.md](./CONTRIBUTING.md) for more details.
