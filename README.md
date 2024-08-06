# BookJsonTransformer

## Overview

`BookJsonTransformer` is a Java class that transforms JSON data representing book information. It performs the following transformations:
1. Converts the "title" field to uppercase.
2. Adds a new key-value pair: "isNewRelease" which is a boolean indicating if the book was published in the last 10 years.

## Requirements

- Java 17 or higher
- Gson library