Anikoto Custom - Aniyomi Extension Repository

This is a simple repository for hosting custom extensions for Aniyomi (and Mihon-based apps).

## How to use

In Aniyomi go to:
Settings → Browse → Extension repos (or Anime extension repos) → Add

Paste this URL:

https://raw.githubusercontent.com/scottyboy932/aniyomi-custom-repos/repo/index.min.json

## Structure

- `main` branch: human-editable files (index.json, any source code you want to keep)
- `repo` branch: clean distribution that Aniyomi reads (index.min.json at root + apk/ folder)

## Adding extensions

1. Build or obtain the .apk
2. Put it in the `apk/` folder on the `repo` branch
3. Update `index.json` on main with the correct metadata
4. Generate `index.min.json` and push it (and the apk) to the `repo` branch

## For Roku 4K Stick

Add the repo URL above in Aniyomi on your phone, then screen mirror. The custom extensions will be available on the TV.

This repo exists so you have full control over your sources.