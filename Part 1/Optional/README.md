Optional Max
The purpose of this exercise is to train you to work with arrays and optional.

Estimated workload of this exercise is 45 min.

Description
Implement max method of MaxMethod class.

The correct implementation should receive an array of int values and return its maximum value.

Details:

the method returns the result as OptionalInt
if the input array is empty or null, return empty OptionalInt.
Example
int[] vals = new int[]{-2, 0, 10, 5};
OptionalInt result = MaxMethod.max(vals);
System.out.println(result.getAsInt() == 10); // true
