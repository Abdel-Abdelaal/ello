# Ello

> **Built on [Operit AI](https://github.com/AAswordman/Operit)** by
> [AAswordman](https://github.com/AAswordman) and the Operit contributors. Almost all
> of the code here is theirs, and their full commit history is kept. Ello's own work
> is the commits after Operit 1.12.2 (`dbf71916`). Thank you to the Operit team.

An AI assistant that runs your Android phone. You tell it what you want, and it
reads the screen, taps, types and moves between apps to get it done. It also has its
own pages.

Ello is a hardened fork of [Operit AI](https://github.com/AAswordman/Operit), an
open-source Android agent platform. Operit already solves phone control, so Ello
starts from it and spends its effort on security, by cutting what a personal
assistant doesn't need and proving what's left.

> **Status:** early. The current build is upstream Operit 1.12.2, renamed and built by
> this repo's CI. The hardening below is planned, not done.

## Plan

1. **Build from source in CI.** Every downloaded build input is pinned by SHA-256
   (`ci/android-deps.sha256`).
2. **Cut attack surface.** Remove the plugin marketplace, remote package installs,
   the LAN web chat and HTTP API, the Linux terminal, root mode, avatars and on-device
   models.
3. **Lock down defaults.** Every phone action asks first. Sending, paying and deleting
   always need a tap. There's a visible stop button. The API key lives in the Android
   Keystore, and the app can reach only the configured model endpoint.
4. **Prove it.** Publish a threat model (prompt injection from on-screen content is the
   main risk), prompt-injection tests, code and APK scans, a network capture, and
   signed build provenance.

## Build

CI builds the debug APK on every pull request. See
[`.github/workflows/android-build.yml`](.github/workflows/android-build.yml). The
workflow run's artifacts include the APK.

The build needs Linux, JDK 21, Android SDK 34/36, NDK 25.1.8937393, CMake 3.22.1,
Node 22, pnpm and Rust. The upstream guide is in
[`docs/doc-src/dev-core/BUILDING.md`](docs/doc-src/dev-core/BUILDING.md).

## Upstream

Upstream is tracked as the `upstream` git remote. The Kotlin package name stays
`com.ai.assistance.operit` so upstream changes still merge. Only the app name and
application ID (`io.github.abdel_abdelaal.ello`) change.

## License

[LGPL-3.0](LICENSE), the same as Operit. Copyright in the upstream code stays with
the Operit authors. Ello's changes are released under the same licence. "Operit" and
its logo belong to their owners and aren't used for Ello's branding.
