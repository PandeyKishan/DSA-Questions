import os
import sys
import re
import subprocess
import argparse

def get_next_question_number(approaches_file):
    if not os.path.exists(approaches_file):
        return 1
    with open(approaches_file, 'r', encoding='utf-8') as f:
        content = f.read()
    numbers = re.findall(r'^(\d+)\.', content, re.MULTILINE)
    if not numbers:
        return 1
    return int(numbers[-1]) + 1

def extract_metadata(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    approach = re.search(r'Approach:\s*(.*)', content)
    pattern = re.search(r'Pattern:\s*(.*)', content)
    return (
        approach.group(1).strip() if approach else None,
        pattern.group(1).strip() if pattern else None
    )

def update_approaches(file_path, q_num, approach):
    with open(file_path, 'a', encoding='utf-8') as f:
        f.write(f"{q_num}. {approach}\n")

def update_patterns(file_path, q_num, q_name, pattern_name):
    if not os.path.exists(file_path):
        return
    with open(file_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    new_lines = []
    found_section = False
    added = False
    
    for line in lines:
        new_lines.append(line)
        if pattern_name.lower() in line.lower() and line.startswith('##'):
            found_section = True
            continue
        
        if found_section and line.strip() == "" and not added:
            new_lines.append(f"- {q_name} (Q{q_num})\n")
            added = True
            found_section = False
            
    with open(file_path, 'w', encoding='utf-8') as f:
        f.writelines(new_lines)

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("file", help="Path to the Java file")
    parser.add_argument("--approach", help="Manually specify approach")
    parser.add_argument("--pattern", help="Manually specify pattern")
    args = parser.parse_args()

    java_file = args.file
    if not os.path.exists(java_file):
        print(f"Error: File {java_file} not found.")
        return

    q_name = os.path.basename(java_file).replace('.java', '')
    
    # Use provided args or try to extract from comments
    approach = args.approach
    pattern = args.pattern
    
    if not approach or not pattern:
        file_approach, file_pattern = extract_metadata(java_file)
        approach = approach or file_approach
        pattern = pattern or file_pattern

    if not approach:
        print("❌ Error: No approach provided or found in file.")
        return

    approaches_md = "DSA_APPROACHES.md"
    patterns_md = "DSA_PATTERNS.md"

    q_num = get_next_question_number(approaches_md)
    print(f"🚀 Syncing Q{q_num}: {q_name}...")
    
    update_approaches(approaches_md, q_num, approach)
    if pattern:
        update_patterns(patterns_md, q_num, q_name, pattern)
        print(f"📝 Updated Approaches and categorized under '{pattern}'")
    else:
        print(f"📝 Updated Approaches (No pattern specified)")

    # Git automation
    subprocess.run(["git", "add", "."], check=True)
    subprocess.run(["git", "commit", "-m", f"Add solution for Q{q_num}: {q_name}"], check=True)
    print(f"✅ Changes committed to Git.")

if __name__ == "__main__":
    main()
