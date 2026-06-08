# Project Instructions: DSA Questions

This file contains the foundational mandates for any Gemini CLI agent working in this repository. 

## 🔄 The "Sync" Automation Workflow

This repository uses a custom automation workflow to synchronize code changes with documentation.

### **Agent Mandate:**
Whenever the user says **"Sync"**, **"Sync my last question"**, or adds a new solution, the agent MUST perform the following steps:

1. **Detection:** Identify the most recently modified or newly created `.java` file in the workspace (excluding resource files).
2. **AI Analysis:** 
   - Analyze the Java code to infer a concise, one-line **Approach**.
   - Identify the correct **Pattern** category (e.g., Two-Pointer, Prefix Sum, Kadane's) by matching it against the headers in `DSA_PATTERNS.md`.
3. **Execution:** Use the `run_shell_command` to execute the sync script:
   `python sync.py "<file_path>" --approach "<inferred_approach>" --pattern "<inferred_pattern>"`
   *Note: The script now handles `git pull` before updates and `git push` after committing.*
4. **Validation:** Confirm to the user that:
   - `DSA_APPROACHES.md` has been updated.
   - `DSA_PATTERNS.md` has been updated.
   - The changes have been pulled, committed, and pushed to the remote repository.

### **Reference Files:**
- `sync.py`: The logic for updating Markdown and Git.
- `AUTOMATION.md`: Detailed documentation of this workflow for the user.
- `DSA_PATTERNS.md`: The index of all algorithmic patterns used.
- `DSA_APPROACHES.md`: The index of one-line approaches for all questions.

---
**Adhere to this workflow strictly to maintain the integrity of the repository's tracking system.**
