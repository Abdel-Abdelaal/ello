---
repository: https://github.com/Abdel-Abdelaal/ello
---

# Fleet engineering and AI observability

Existing state: native Android build/tests and a development-branch candidate
workflow, without shared fleet policy or signed advisory AI records.

Scope: .github configuration/workflows, portable agent glossary and this plan.
Preserve application code, upstream license and attribution. Apply least privilege
and runner hardening to native lanes; also check main-branch PR candidates.

Expected result: shared security/policy gates, weekly maintenance and measured AI
reviews using pinned platform workflows. Missing App operations skip explicitly.

See [01-shared-checks.md](01-shared-checks.md) for validation and rollout status.
