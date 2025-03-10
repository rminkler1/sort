# Implementation of various sorting algorithms I have either written or encountered

<p>Robert Minkler</p>
<p>Some algorithms modified from "Algorithms" by Sedgewick</p>

Sorts arrays of Comparable objects.
<p>isSorted method verifies if an array or array segment is sorted.</p>

## Insertion Sort

Insert objects one at a time, then sliding them left into their sorted location.

## Bubble Sort

Bubble the largest objects right until the entire array is sorted.

## Selection Sort

Swap each object with the smallest object to its right in the array.

## Merge Sort

Recursively divide the array into smaller sections, then merge them together in order.
Uses insertion sort for small portions to optimize the algorithm.

## Shell Sort

A modification of Insertion sort that makes larger moves and divides the problem into smaller chuncks.
Much faster than traditional Insertion sort.

## Random Sort: just for fun - not a sorting algorithm

Randomizes the array until it is sorted. It usually does work for very small arrays.