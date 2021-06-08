# Differences between test and solution for high code coverage

## Number Comparator

Class:

- changed explicit return true/false to one-liner Test:

Tests:

- Asserts were never called
- simply added for all three cases

## Calculator

Class:

- changed direct assignment of value to "displayed" to set via setDisplay(val)
  So it is automatically tested, when displayed is tested: higher code coverage
- changed isPositive(int) to directly return true in case of number >= 0 because of code coverage

Test:

- made mult()-Test correctly use mult() instead of add()
- made mult()-Test use 2 & 3 as params, because 2+2 equals 2*2, which multiplication is mutated to
- changed the assertThrows-Test in div()-Test to use direct values instead of changing displayed variable
- added 2 new assert-clauses to greatestCommonDenominator()-Test to cover bigger/smaller/equals cases
- testPositive() now has all three test cases (again, bigger/smaller/equals) for maximum mutation and line coverage

## Linked List

Class:

- sum() function previously only summed up one element and returned (shown by lacking pit coverage)

Tests:

- Different setUp Method: adding initial values -> easier testing of values in Queue
- testToString() previously not tested, added Test to check printed out string
- remove does not only check root node. Checks when elements are chained as well
- findBiggest() tests root==null as well as root!=null to cover lines containing lists element data comparison mutations

## Coffee Machine

Class:

- makeCoffee now checks for beans and coffe bigger/equals as mutation showed wrong expected mutation
- corrected the mistake, that fillWater used maxBeans instead of maxWater. Typical copy-paste error

Tests:

- SwitchStates()-Test more comprehensive on/off-switch test
- getter/setter-Funktions not tested before, now added with coverage
- positionCup() never correctly tests if cup positioned does not throw (try-catch not correct way to test code)
  resolved in better cupTesting() method
- makecoffe()-Test tested so hard I cannot put it into words -fillBeans()- and fillWater()-Tests now contain
  setBeans/setWater Test and test correctly if filled