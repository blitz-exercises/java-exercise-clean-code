#!/bin/bash

# Script to decode base64 encoded violation markdown files
# Usage: ./decode-violations.sh [folder_name]
# If no folder is specified, decodes all violation files

BASE_DIR="src/main/java/nl/blitz/cleancode"

if [ -z "$1" ]; then
    # Decode all violation files
    find "$BASE_DIR" -name "violations.md" -type f | while read -r file; do
        folder=$(dirname "$file")
        folder_name=$(basename "$folder")
        output_file="${folder}/violations-decoded.md"
        
        echo "Decoding violations for folder: $folder_name"
        content=$(cat "$file" | tr -d '\n\r' | sed 's/[[:space:]]*$//')
        echo "$content" | base64 -d > "$output_file" 2>&1
        
        if [ $? -eq 0 ]; then
            echo "  ✓ Decoded to: $output_file"
        else
            echo "  ✗ Failed to decode: $file"
        fi
    done
else
    # Decode specific folder
    folder_path="$BASE_DIR/$1"
    violation_file="$folder_path/violations.md"
    output_file="$folder_path/violations-decoded.md"
    
    if [ -f "$violation_file" ]; then
        echo "Decoding violations for folder: $1"
        content=$(cat "$violation_file" | tr -d '\n\r' | sed 's/[[:space:]]*$//')
        echo "$content" | base64 -d > "$output_file" 2>&1
        
        if [ $? -eq 0 ]; then
            echo "✓ Decoded to: $output_file"
            cat "$output_file"
        else
            echo "✗ Failed to decode: $violation_file"
            exit 1
        fi
    else
        echo "✗ Violation file not found: $violation_file"
        exit 1
    fi
fi

