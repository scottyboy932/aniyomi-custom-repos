# Building the Anikoto Extension APK (Windows)

This repo contains only the source. You need the full build environment to produce a working .apk.

## Recommended Method (Easiest for most people)

1. Clone the community template:
   ```
   git clone https://github.com/Secozzi/aniyomi-extensions.git
   cd aniyomi-extensions
   ```

2. Copy your source into the correct location:
   - Take `src/en/anikototv/AnikotoTV.kt` from this repo.
   - Paste it into the cloned repo at:
     `src/en/anikototv/AnikotoTV.kt`
   - Make sure the package line stays exactly:
     `package eu.kanade.tachiyomi.animeextension.en.anikototv`

3. Open the project in Android Studio (or use Gradle directly).

4. Build the specific module or the whole project:
   - In Android Studio: Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Or from command line:
     `./gradlew assembleRelease` (or the debug variant)

5. Find the generated APK (usually in `build/outputs/apk/...` or the `repo/apk` folder after their build process).

6. Copy the APK into this repo's `apk/` folder (or directly to the `repo` branch on GitHub).

7. Update `index.json` (on main):
   - Set the correct `apkUrl` (raw GitHub link to the APK on the `repo` branch).
   - Bump `versionCode` and `versionName`.
   - Update the source `id` if needed (the long number must match what the compiled extension reports).

8. Run the minify script:
   ```powershell
   .\scripts\minify-index.ps1
   ```

9. Copy the new `index.min.json` and the APK to the `repo` branch on GitHub and push.

## Alternative: Full Keiyoushi Template

Use https://github.com/keiyoushi/extensions-source if you want the absolute latest upstream.

## Signing

For updates to work cleanly, sign all your extensions with the same keystore.
Generate one and keep it safe. The fingerprint goes into the `signingKey` field in index.json.

## Source ID

The numeric `id` in the index must match the ID the extension declares at runtime.
You can find it by building once and inspecting the extension metadata, or compute it consistently.

After the first successful build + install from your custom repo, future updates should be smooth.