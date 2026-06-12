# Project Instructions: DSA Questions

This file contains the foundational mandates for any Gemini CLI agent working in this repository. 

## 🔄 The "Sync" Automation Workflow

This repository uses a custom automation workflow to synchronize code changes with documentation.

### **Agent Mandate:**
The agent MUST perform the following steps **ONLY** when the user explicitly issues the directive **"Sync"** or **"Sync my last question"**. The agent MUST NOT initiate this workflow automatically upon detecting new files or changes without this specific command.

1. **Detection:** Identify ALL modified or newly created `.java` files in the workspace (excluding resource files and `tempCodeRunnerFile.java`) since the last sync. Use `git status` or file modification times to find the pending questions.
2. **AI Analysis:** For EACH identified file:
   - Analyze the Java code to infer a **detailed Approach**. While conciseness is preferred, use multiple lines if required to clearly explain the logic, key data structures, and optimization steps (e.g., specific conditions for updating pointers or map values).
   - Identify the correct **Pattern** category (e.g., Two-Pointer, Prefix Sum, Kadane's) by matching it against the headers in `DSA_PATTERNS.md`.
3. **Execution:** For EACH identified file, use the `run_shell_command` to execute the sync script:
   `python sync.py "<file_path>" --approach "<inferred_approach>" --pattern "<inferred_pattern>"`
   *Note: The agent should process files one-by-one or in a loop, providing a brief overview of what is being synced.*
4. **Validation:** Confirm to the user that:
   - `DSA_APPROACHES.md` has been updated.
   - `DSA_PATTERNS.md` has been updated.
   - The changes have been pulled, committed, and pushed to the remote repository.

### **Autonomous Execution:**
- The agent is authorized to execute `run_shell_command` autonomously for the sync workflow and related git operations (status, add, commit, push) once the initial "Sync" directive is given.
- Do not use `ask_user` to request permission for standard project scripts or git commands.
- `sync.py`: The logic for updating Markdown and Git.
- `AUTOMATION.md`: Detailed documentation of this workflow for the user.
- `DSA_PATTERNS.md`: The index of all algorithmic patterns used.
- `DSA_APPROACHES.md`: The index of one-line approaches for all questions.

---
**Adhere to this workflow strictly to maintain the integrity of the repository's tracking system.**
