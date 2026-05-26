**Anikoto Custom Extension Repository for Aniyomi**

Custom extension repo for Aniyomi / Mihon forks. Designed for personal use (e.g. screen mirroring your phone to a Roku 4K Stick).

## Add This Repo to Aniyomi (Right Now)

In Aniyomi:
**More → Settings → Browse → Extension repos → +**

Paste:
```
https://raw.githubusercontent.com/scottyboy932/aniyomi-custom-repos/repo/index.min.json
```

Restart Aniyomi after adding. Your custom sources will appear under Browse → Anime.

Works great while screen-mirroring to Roku.

## Current Status (as of publish)

- Source code for Anikoto is published on the `main` branch.
- Distribution `repo` branch is ready and serves a valid `index.min.json`.
- **No compiled APK yet** — the `apkUrl` in the index is a placeholder.

You must build the APK yourself (see BUILD.md) before the extension will install.

## Branches

- `main` — Full source, development files, this README.
- `repo` — Clean distribution only (what Aniyomi reads). Add the raw index.min.json URL above.

## Building the APK (Windows)

See [BUILD.md](BUILD.md) for the exact step-by-step process using the official extension template.

Once you have the .apk:
1. Place it in `apk/` on the `repo` branch.
2. Update the `apkUrl` (and versionCode/Name) in `index.json`.
3. Regenerate `index.min.json` and push to the `repo` branch.

## Adding More Sources

Drop new `.kt` files in `src/<lang>/<sourceid>/` following the Keiyoushi layout.

## Notes for Roku + Screen Mirroring

- Do all repo management on your phone while mirroring.
- Once the repo + extension is installed on the phone, it works in the mirrored session on the Roku 4K Stick.
- For better control on the TV, use a Bluetooth mouse/keyboard app from the phone.

---

This gives you full control over your sources when public repos get taken down.