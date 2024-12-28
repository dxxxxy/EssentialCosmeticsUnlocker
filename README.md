# THIS REPOSITORY HAS BEEN DISCONTINUED/ARCHIVED
# Up-to-date next-gen implementation can be found [here](https://github.com/prometheusreengineering/essential).

<hr>

# EssentialCosmeticsUnlocker
**Client-side only** patch that allows you to unlock ALL cosmetics (+ emotes) in the Essential mod. Works on every version of Essential MC (1.8.9 - 1.21).

![Compatibility: Infinite](https://img.shields.io/badge/COMPATIBILITY-∞-0?style=for-the-badge)
[![Download Count](https://img.shields.io/github/downloads/DxxxxY/EssentialCosmeticsUnlocker/total?style=for-the-badge)](https://github.com/dxxxxy/EssentialCosmeticsUnlocker/releases/)
[![Discord](https://img.shields.io/discord/1197794960985043034?style=for-the-badge&label=Discord&color=rgb(88%2C%20101%2C%20242)%20)](https://discord.gg/BFDWmPfmXg)

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

| MC Major Version | Forge       | Fabric*            | Last Checked (dd/mm/yyyy) |
|------------------|-------------|--------------------|---------------------------|
| 1.8              | `❌ broken`^ | `⬛ not applicable` | 24/05/2024                |
| 1.12             | `❌ broken`^️ | `⬛ not applicable` |                           |
| 1.16             | `❌ broken`  | `❌ broken`         |                           |
| 1.17             | `❌ broken`️  | `❌ broken`         | 19/11/2024                |
| 1.18             | `❌ broken`️  | `❌ broken`         |                           |
| 1.19             | `❌ broken`️  | `❌ broken`         |                           |
| 1.20             | `❌ broken`  | `❌ broken`         | 19/11/2024                |
| 1.21             | `❌ broken`  | `❌ broken`         | 19/11/2024                |

Last Essential version checked: **`v1.3.5.3`**

### We are aware that ecu doesn't work with the current version of essential. Either downgrade essential to **`v1.3.5.1`** or join the [discord](https://discord.gg/BFDWmPfmXg) for support.

Tested with downloads from [essential website](https://essential.gg/downloads).

### Notes
\* The mod you have downloaded from [essential](https://essential.gg/downloads) or [modrinth](https://modrinth.com/mod/essential/versions) is the installer/updater mod. Instead, the one that you need to place in your mods folder is the one which is located in `.minecraft\essential\`. You need to manually run the game with the installer/updater mod once for it to appear in that folder.

^ Use the legacy release `-legacy.jar` which has no mod class, but has shaded mixin. This is necessary because functionality changes overtime.
 
## Disclaimer
This is for educational purposes only. I am not responsible for any damage caused by this tool.

## License
GPLv3 © dxxxxy
