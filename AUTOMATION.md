# DSA Automation Guide

This repository is equipped with a **Smart Sync System** that automates documentation and Git management. You don't need to manually update trackers or run terminal commands—I handle it for you.

## 🚀 The "Sync" Workflow

When you finish solving a question, simply type **"Sync"** or **"Sync my last question"** in our chat.

### What happens in the background:
1. **Detection:** I scan the workspace for your most recently modified `.java` file.
2. **Analysis:** I read your code to determine:
   - **Approach:** A concise, one-line explanation of your logic.
   - **Pattern:** The technical category (e.g., Two-Pointer, Kadane's).
3. **Execution:** I run the `sync.py` script with these AI-generated inputs.
4. **Documentation:** 
   - `DSA_APPROACHES.md` is updated with the next question number.
   - `DSA_PATTERNS.md` is updated under the correct technical category.
5. **Git Sync:** 
   - I perform a `git pull` to get latest changes.
   - I perform a `git commit` with a clean message.
   - I perform a `git push` to synchronize your remote repository automatically.

## 🛠️ The Sync Script (`sync.py`)

While I run this script for you, it is available in the root directory. It is a Python utility that:
- Manages question numbering.
- Safely appends to Markdown files.
- Handles Git operations.

## 📝 Tips for Best Results
- **File Naming:** Name your files clearly (e.g., `twoSum.java`, `findMissingNumber.java`).
- **One Problem at a Time:** It works best if you sync each question right after you finish it.
- **Manual Overrides:** If you ever want to provide your own specific approach or pattern, just tell me: *"Sync this file with approach: [My Approach] and pattern: [My Pattern]."*

---
**Focus on the logic, let me handle the paperwork!** 🚀
