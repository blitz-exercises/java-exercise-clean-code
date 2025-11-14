# Complete List of Clean Code Violations

This document lists all clean code violations found across the project, organized by principle category.

## Naming Violations

### Unclear/Generic Names
- Generic variable names: `items`, `cnt`, `nm`, `n`, `e`, `a`, `v`, `a2`, `c`, `p`, `prod`, `tmp`, `i`, `flag`
- Generic method names: `calc`, `check`, `process`, `doStuff`, `add`, `find`, `flag`, `format`
- Single-letter variables used throughout codebase
- Unclear abbreviations: `cnt` (count), `nm` (name)

### Confusing Boolean Methods
- `isNotInvalid` (double negative - confusing)
- `isThisFalse` (unclear what "this" refers to)
- Methods where it's hard to distinguish between true and false

### Inconsistent Naming
- Inconsistent method naming (camelCase) - `daySimulator` should follow consistent naming convention
- Mixed naming conventions within same class/file

### Magic Numbers and Strings
- Magic numbers: 1, 2, 3, 4, -1, 100, 10, 16, 3, 5, 15, 20, 25, 50, 75, 100, 0.3, 0.1, 0.15, 0.2, 1000, 0.05, 0.9, 200, 0.9
- Magic strings: "STANDARD", "EXPRESS", "OVERNIGHT", "INTERNATIONAL", "IN_TRANSIT", "PROCESSED", "PENDING", "PAYMENT_FAILED", "CONFIRMED", "EMAIL", "SMS", "PUSH", "PREMIUM", "GOLD", "VIP", "ELECTRONICS", "smtp.example.com", "admin@example.com", "password123", ":"
- No named constants for magic values

### Missing Domain-Specific Names
- Generic names instead of domain-specific terminology
- Missing context in variable/method names

## Function Violations

### Large Functions
- `processOrder` is too large (60+ lines)
- `calculateShippingCost` is too large with nested conditionals
- `calc` method is too large with multiple responsibilities

### Too Many Parameters
- `processOrder` has 8 parameters
- `processPayment` method has 5 parameters
- `add` method has 5 parameters
- Functions with 3+ parameters should use objects

### Flag Arguments
- `process` uses flag arguments (`includeDeleted`, `sendEmail`, `updateStats`)
- `processOrder` has flag arguments (`applyDiscount`, `sendConfirmation`, `updateInventory`)
- `generate` method has flag arguments (3 boolean flags)
- `process` has flag argument

### Multiple Responsibilities
- `daySimulator` does multiple things (iteration, type checking, returns)
- `processOrder` does multiple things
- `processAllCustomers` does multiple things (validation, email, updates)
- `processInventory` does multiple things (low stock, expensive items, category checks)
- `send` does multiple things based on type parameter
- `calc` does multiple things (add, subtract, multiply, divide)
- Functions should do one thing only

### Command-Query Separation Violations
- `setBalance` violates command-query separation (returns boolean)
- `processPayment` has side effects (modifies balance, logs, sends receipt)

### Side Effects
- `processPayment` modifies global state (balance)
- Functions that modify state should be separated from queries

### Vague/Unclear Function Names
- `doStuff` is vague
- `process` is vague
- `format` method could be more clear

### Code Duplication
- `calculateTotal` duplicates logic already in `addItem`/`updateQuantity`
- `modifyProduct` duplicates logic from `updatePrice`/`setInStock`
- Massive code duplication across `generateSalesReport`, `generateInventoryReport`, `generateCustomerReport`
- Same code repeated three times in report generation

### Bad Practices
- `removeItem` modifies collection while iterating (bad practice)

## Comment Violations

### Redundant Comments
- "// increment d by 1"
- "// check if d is greater than 10"
- "// print message"
- "// update user"
- "// send email"
- "// update record"
- "// create new account"
- "// update account balance"
- "// validate order"
- "// calculate total"
- "// connection logic"
- "// authentication logic"
- "// logging"
- "// send receipt"
- "// update balance"
- "// database query"
- "// database update"
- "// print label"
- "// create shipment"
- "// process sales data"
- "// log transaction"
- "// get all transactions"
- "// clear transactions"
- Comments explain what code does, not why

### Commented-Out Code
- "// public void oldMethod()" - commented-out code should be removed

### Misleading Comments
- "// this method processes the account" (generic)
- "// similar code duplicated"
- "// same code again"
- Comments that don't match code behavior

### Missing Comments
- Missing comments where intent is unclear
- No explanation of intent for complex logic

### TODO Comments
- "// TODO: implement file loading" - incomplete implementation

### Implementation Comments
- "// call external API directly" - should explain why, not how

## Formatting Violations

### Inconsistent Spacing
- No spacing in method signatures: `addProduct(String n,double p,int q,String c,String s)`
- Inconsistent spacing throughout code
- Missing blank lines between logical sections

### Long Lines--

- Long method with deep nesting
- Lines exceed recommended length

### Indentation Issues
- Deep nesting in `calculateShippingCost`
- Indentation doesn't reflect logical structure

### Inconsistent Formatting
- Mixed formatting styles within same file
- Inconsistent brace placement

## Object and Data Structure Violations

### Exposed Public Fields
- `Item` exposes public fields (`name`, `quality`)
- `User` inner class with public fields
- `CartItem` inner class with public fields
- `Customer` inner class with public fields
- `Account` inner class with public fields
- `Product` inner class with public fields (in multiple files)
- `Order` public fields
- `OrderItem` inner class
- Public fields: `items`, `total`, `customerId`, `isCheckedOut`
- `userList` field is public (should be private)

### Exposed Internal Data
- `getAllProducts` exposes internal `Map`
- No encapsulation
- Internal data structures exposed

### Inner Classes Should Be Extracted
- `EmailServiceHelper` inner class should be extracted
- Multiple inner classes that should be separate files

### Immutability
- Mutable objects where immutability would be better
- No use of final for fields that shouldn't change

### Data vs Behavior
- Data classes mixed with behavior
- Should separate data structures from objects with behavior

## Error Handling Violations

### Error Codes Instead of Exceptions
- Returns error codes (-1, -2, -3, -4, -5, -6) instead of exceptions
- Returns -1 for errors instead of exceptions
- Returns false instead of exceptions

### Null Returns
- `getCustomer` returns null
- `find` returns null
- `getOrderItems` returns null
- Methods return null without validation
- Should use Optional or empty collections

### Silent Failures
- `processAllCustomers` silently swallows exceptions (catch and ignore)
- Silently ignores exceptions
- Generic exception handling with empty catch blocks
- "// ignore errors" or "// ignore" comments

### Generic Exceptions
- Uses generic `Exception` instead of specific exception types
- Generic exception handling

### Missing Validation
- No validation of input
- No validation of connection parameters
- No validation of division by zero
- Accesses `item.name` and `item.quality` without null checks
- No null/validation checks

### Missing Error Messages
- No specific error messages
- Returns boolean instead of throwing exceptions for invalid input

### No Fail-Fast
- Missing fail-fast validation
- No early validation

## Boundary Violations

### Direct Third-Party API Calls
- Direct third-party API calls (`HttpURLConnection`)
- Direct third-party API calls (`java.net.URL`, `HttpURLConnection`)
- No abstraction/wrapper
- Hardcoded URLs in code
- No boundary layer

### No Abstraction
- Direct instantiation of services
- No abstraction
- Third-party types exposed in domain code

### Hardcoded Configuration
- Hardcoded URLs
- Hardcoded credentials in constructor
- Hardcoded passwords and server details

## Class Violations

### Multiple Classes in One File
- Multiple classes in one file (`OrderRepository`, `PaymentService`, `InventoryService`, `ReportService`)
- Violates single responsibility
- Should be one class per file

### Single Responsibility Violations
- Classes with multiple responsibilities
- Violates single responsibility principle

### Class Size
- Classes that are too large
- Too many responsibilities per class

### Cohesion
- Low cohesion (unrelated methods together)
- Methods scattered across class

## System Violations

### Construction Mixed with Use
- Construction mixed with use (`new OrderRepository()`, `new PaymentService()`, etc.)
- Hardcoded credentials in constructor
- No dependency injection
- Tight coupling

### No Dependency Injection
- No dependency injection
- Direct instantiation everywhere

### Tight Coupling
- Tight coupling between classes
- No abstraction between layers

### Cross-Cutting Concerns
- Cross-cutting concerns scattered throughout
- No separation of concerns

## Emergent Design Violations

### Code Duplication (DRY Violation)
- Massive code duplication across report generation methods
- Same code repeated three times
- DRY principle violated

### Unclear Intent
- Code that doesn't express programmer's intent clearly
- Hard to understand purpose

### Over-Engineering
- Too many classes/methods for simple tasks (in some cases)
- Unnecessary complexity

### Testability Issues
- Code that's hard to test
- Tight coupling makes testing difficult

## Additional Violations

### Logging Instead of System.out
- Uses `System.out.println` instead of logging (multiple files)
- Should use proper logging framework

### Missing Validation
- No input validation
- No parameter validation
- No state validation

### Incomplete Implementation
- TODO comments indicating incomplete code
- Methods that don't fully implement functionality

---

## Summary by Category

- **Naming**: 20+ violations
- **Functions**: 25+ violations
- **Comments**: 15+ violations
- **Formatting**: 8+ violations
- **Objects**: 15+ violations
- **Error Handling**: 20+ violations
- **Boundaries**: 8+ violations
- **Classes**: 6+ violations
- **Systems**: 6+ violations
- **Emergent Design**: 4+ violations

**Total: 127+ clean code violations across 17 folders**

