# Anikoto Custom - Aniyomi Extension Repository

This repo is for **GitHub-hosted distribution** of your custom Aniyomi extensions.

## Add to Aniyomi

In Aniyomi:
**Settings → Browse → Extension repos → +**

Paste:
```
https://raw.githubusercontent.com/scottyboy932/aniyomi-custom-repos/repo/index.min.json
```

## Structure

- `main` branch: Human-editable files (index.json, docs)
- `repo` branch: Clean distribution that Aniyomi reads (index.min.json + apk/ folder)

## Source Code (Development)

All custom extension Kotlin code lives in your fork:
https://github.com/scottyboy932/aniyomi-extensions

Your Anikoto source is at:
`src/en/anikototv/AnikotoTV.kt`

## Workflow (Personal Use + Roku)

1. Develop / edit source in your fork.
2. Build the .apk (using Android Studio + the template).
3. Copy the APK to `apk/` on the `repo` branch of **this** repo.
4. Update `index.json` (main branch of this repo).
5. Run the minify script and push the new `index.min.json` + APK to the `repo` branch.

6. Add the URL above in Aniyomi on your phone.
7. Use while screen mirroring to your Roku 4K Stick.

Everything stays under your control on GitHub. No local server required.