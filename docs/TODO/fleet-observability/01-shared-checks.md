# Shared checks

Add pinned shared PR, policy, security, Scorecard and advisory AI callers.
Add weekly dependency updates with a fourteen-day version cooldown.
Keep application builds/tests in their existing native workflows. Validate workflow
syntax and policy locally; do not run local Android/web builds or tests.

Hosted CI and the next platform tooling release must prove activation before
Kotlin/TypeScript whole-repo coverage is claimed. Fix/baseline PR automation still
needs an installed automation App. Public evidence must exclude confidential data.

Hosted candidate checks exposed pre-existing Kotlin test compile failures: an xAI
test referenced removed mapper functions and a media-role test called a protected
Responses method directly. Update the tests to exercise the shared thinking
configuration and the existing reflection test seam, preserving production APIs.
The obsolete Android SDK tools package request is replaced with platform-tools.
No local application builds or tests are run; hosted native verification is required.

The next hosted run compiled and executed 1,332 tests, exposing six failures.
Use a scoped JVM logging rule rather than changing Android runtime behavior;
match bridge assertions to the existing versioned declarations and explicit
"not cancelled" message. Fix legacy function-only counter decoding so underscore
names such as FILE_BINDING and UI_CONTROLLER cannot become false provider/model
identities; retain regression coverage for every current function and the removed
legacy name. Preserve the existing unknown-provider decoding path.
