#!/usr/bin/env python3
"""
Script to create empty Python files corresponding to Java files in the 10_trees directory.
Converts Java filenames from CamelCase to snake_case and creates empty .py files.
"""

import os
import re
from pathlib import Path

def camel_to_snake(name):
    """Convert CamelCase to snake_case"""
    # Handle special cases first
    name = name.replace('.java', '')
    
    # Insert underscore before uppercase letters (except at the beginning)
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', name)
    # Insert underscore before uppercase letters that follow lowercase letters or digits
    s2 = re.sub('([a-z0-9])([A-Z])', r'\1_\2', s1)
    
    return s2.lower()

def find_java_files(trees_dir):
    """Find all Java files in the trees directory"""
    java_files = []
    trees_path = Path(trees_dir)
    
    if not trees_path.exists():
        print(f"Error: Directory {trees_dir} does not exist")
        return java_files
    
    # Find all .java files recursively
    for java_file in trees_path.rglob("*.java"):
        java_files.append(java_file)
    
    return java_files

def create_python_file(java_file_path, base_trees_dir):
    """Create corresponding Python file for a Java file"""
    java_path = Path(java_file_path)
    
    # Get the relative path from the trees directory
    rel_path = java_path.relative_to(base_trees_dir)
    
    # Convert the path parts
    path_parts = list(rel_path.parts)
    
    # Replace 'java' with 'python' in the path
    if 'java' in path_parts:
        java_index = path_parts.index('java')
        path_parts[java_index] = 'python'
    
    # Convert filename from CamelCase to snake_case
    java_filename = path_parts[-1]
    python_filename = camel_to_snake(java_filename) + '.py'
    path_parts[-1] = python_filename
    
    # Create the full Python file path
    python_path = base_trees_dir / Path(*path_parts)
    
    # Create directories if they don't exist
    python_path.parent.mkdir(parents=True, exist_ok=True)
    
    # Create empty Python file
    if not python_path.exists():
        python_path.touch()
        return python_path, True  # File created
    else:
        return python_path, False  # File already exists

def main():
    """Main function to process all Java files"""
    # Define the trees directory
    trees_dir = Path("dsa/concepts/10_trees")
    
    print("🌳 Tree Python File Generator")
    print("=" * 50)
    print(f"Scanning directory: {trees_dir}")
    
    # Find all Java files
    java_files = find_java_files(trees_dir)
    
    if not java_files:
        print("No Java files found in the trees directory")
        return
    
    print(f"Found {len(java_files)} Java files")
    print()
    
    # Process each Java file
    created_files = []
    existing_files = []
    
    for java_file in sorted(java_files):
        python_file, was_created = create_python_file(java_file, trees_dir)
        
        if was_created:
            created_files.append(python_file)
            print(f"✅ Created: {python_file}")
        else:
            existing_files.append(python_file)
            print(f"⚠️  Already exists: {python_file}")
    
    # Summary
    print()
    print("📊 Summary")
    print("=" * 50)
    print(f"Total Java files found: {len(java_files)}")
    print(f"Python files created: {len(created_files)}")
    print(f"Python files already existed: {len(existing_files)}")
    
    if created_files:
        print()
        print("📁 Directory breakdown of created files:")
        dir_counts = {}
        for file_path in created_files:
            dir_name = file_path.parent.name
            if dir_name == 'python':
                parent_dir = file_path.parent.parent.name
                dir_key = f"{parent_dir}/python"
            else:
                dir_key = str(file_path.parent.relative_to(trees_dir))
            
            dir_counts[dir_key] = dir_counts.get(dir_key, 0) + 1
        
        for dir_name, count in sorted(dir_counts.items()):
            print(f"  {dir_name}: {count} files")
    
    print()
    print("🎉 Process completed!")

if __name__ == "__main__":
    main()
