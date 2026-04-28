# Assignment 3: Sorting and Searching Algorithm Analysis

## Overview

This project implements and compares three algorithms: Bubble Sort, Merge Sort, and Binary Search. The goal is to measure their execution time on arrays of different sizes and input types, and see how theoretical complexity matches real performance.

# Algorithms

**Bubble Sort** is the simplest sorting algorithm. It repeatedly compares adjacent elements and swaps them if they are in the wrong order. This continues until the array is fully sorted. Easy to implement but slow on large data — O(n²).

**Merge Sort** uses divide-and-conquer. It recursively splits the array in half until each part has one element, then merges everything back in sorted order. Much faster than Bubble Sort on large arrays — O(n log n).

**Binary Search** finds a value in a sorted array by checking the middle element and discarding the half where the target cannot be. Requires the array to be sorted. Very fast — O(log n).

# Results

On small arrays (10 elements) Bubble Sort was slightly faster than Merge Sort because recursion adds overhead. On large arrays (1000 elements) Merge Sort was about 28 times faster. Binary Search stayed nearly instant regardless of size.

# Reflection

The main takeaway is that algorithm choice matters at scale. Bubble Sort is simple to understand but becomes too slow as data grows. Merge Sort scales well but has extra cost on small inputs. The results also showed that theoretical Big-O complexity generally matched real execution times, though small-scale behavior can differ due to overhead from recursion and memory allocation.
