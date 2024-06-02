# EssentialCosmeticsUnlocker
**Client-side only** patch that allows you to unlock ALL cosmetics (+ emotes) in the Essential mod. Works on every version of Essential MC (1.8.9 - 1.20.6).

![](https://img.shields.io/badge/COMPATIBILITY-∞-0?style=for-the-badge)
![](https://img.shields.io/github/downloads/DxxxxY/EssentialCosmeticsUnlocker/total?style=for-the-badge)

## How to use
Grab the .jar you need from the [Releases](https://github.com/DxxxxY/EssentialCosmeticsUnlocker/releases) and place it in your `.minecraft\mods\` folder. Take the time to go over the [Compatibility](#compatibility) table and its [Notes](#notes).

## Features
- Efficient, single class and light-weight thanks to mixins.
- Unlock ALL cosmetics and emotes (including developer). 
- Universally compatible with any version (view [Compatibility](#compatibility) table).
- Saves equipped cosmetics to config file located in `AppData/Roaming/ecu`.
- Loads equipped cosmetics from config file when you toggle the `Hide/Show My Cosmetics` button.
- Dumps cosmetic data in `AppData/Roaming/ecu` (texture, geometry) when opening the game. Useful for those looking to replicate the cosmetics in their own projects.

## Compatibility
Feel free to contribute to this table with a PR and a convincing screenshot. Only the major versions are tested as it takes time to do it manually.

| MC Major Version | Forge        | Fabric*            | Last Checked (dd/mm/yyyy) |
|------------------|--------------|--------------------|---------------------------|
| 1.8              | `✔️ works`^  | `⬛ not applicable` | 24/05/2024                |
| 1.12             | `✔️ works`^️ | `⬛ not applicable` |                           |
|                  |              |                    |                           |
| 1.16             | `✔️ works`   | `✔️ works`         |                           |
| 1.17             | `✔️ works`️  | `✔️ works`         |                           |
| 1.18             | `✔️ works`️  | `✔️ works`         |                           |
| 1.19             | `✔️ works`️  | `✔️ works`         |                           |
| 1.20             | `✔️ works`   | `✔️ works`         | 24/05/2024                |

Last Essential version checked: **v1.3.2.4**

Tested with downloads from [essential website](https://essential.gg/downloads).

### Notes
\* The mod you have downloaded from [essential](https://essential.gg/downloads) or [modrinth](https://modrinth.com/mod/essential/versions) is the installer/updater mod. Instead, the one that you need to place in your mods folder is the one which is located in `.minecraft\essential\`. You need to manually run the game with the installer/updater mod once for it to appear in that folder.

^ Use the legacy release `-legacy.jar` which has no mod class, but has shaded mixin. This is necessary because functionality changes overtime.
 
## Disclaimer
This is for educational purposes only. I am not responsible for any damage caused by this tool.

## License
GPLv3 © dxxxxy
