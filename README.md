# EssentialCosmeticsUnlocker
**Client-side only** patch that allows you to unlock ALL the cosmetics (+ emojis) in the Essential mod. Works on every version of Essential MC (1.8.9 - 1.19.4).

![](https://img.shields.io/badge/COMPATIBILITY-∞-0?style=for-the-badge)
![](https://img.shields.io/github/downloads/DxxxxY/EssentialCosmeticsUnlocker/total?style=for-the-badge)

## How to use
Grab the .jar you need from the [Releases](https://github.com/DxxxxY/EssentialCosmeticsUnlocker/releases) and place it in your `.minecraft\mods\` folder. Take note of the [Compatibility](#compatibility) table and its [Notes](#notes).

## Features
- Efficient, single class and light-weight thanks to mixin.
- Unlocks ALL cosmetics and emojis (including developer). 
- Universally compatible with any version (view [Compatibility](#compatibility) table).
- Saves equipped cosmetics to config file located in your `LocalAppData`.
- Loads equipped cosmetics from config file when you toggle the `Hide/Show My Cosmetics` button.

## Compatibility
Feel free to contribute to this table with a PR and a convincing screenshot.

| Essential MC Version | Forge          | Fabric*            | Last Checked |
|----------------------|----------------|--------------------|--------------|
| 1.8.9                | `✔️ works^`️   | `⬛ not applicable` | 25/03/2023   |
| 1.12.2               | `✔️ works^`️   | `⬛ not applicable` | 25/03/2023   |
| 1.16.5               | `✔️ works`     | `✔️ works`         | 25/03/2023   |
| 1.17.1               | `🚧 untested`️ | `🚧 untested`      |              |
| 1.18 - 1.18.2        | `🚧 untested`️ | `🚧 untested`      |              |
| 1.19 - 1.19.3        | `🚧 untested`️ | `🚧 untested`      |              |
| 1.19.4               | `✔️ works`     | `✔️ works`         | 25/03/2023   |

### Notes
\* Fabric loads mods differently and requires you to place the hidden essential mod in your mods folder. The one that you usually place in your mods folder is the installer/updater. Instead, the one that you need to place in your mods folder is the big one (40+ mb) which is located in `.minecraft\essential\`.

^ Use the legacy release `-legacy.jar` which has no mod class, but has shaded mixin.
 
## Disclaimer
This is for educational purposes only. I am not responsible for any damage caused by this tool.

## License
GPLv3 © dxxxxy