# EssentialCosmeticsUnlocker
**Client-side only** patch that allows you to unlock ALL cosmetics (+ emotes) in the Essential mod. Works on every version of Essential MC (1.8.9 - 1.20).

![](https://img.shields.io/badge/COMPATIBILITY-∞-0?style=for-the-badge)
![](https://img.shields.io/github/downloads/DxxxxY/EssentialCosmeticsUnlocker/total?style=for-the-badge)

## How to use
Grab the .jar you need from the [Releases](https://github.com/DxxxxY/EssentialCosmeticsUnlocker/releases) and place it in your `.minecraft\mods\` folder. Take the time to go over the [Compatibility](#compatibility) table and its [Notes](#notes).

## Features
- Efficient, single class and light-weight thanks to mixins.
- Unlock ALL cosmetics and emotes (including developer). 
- Universally compatible with any version (view [Compatibility](#compatibility) table).
- Saves equipped cosmetics to config file located in your `LocalAppData`.
- Loads equipped cosmetics from config file when you toggle the `Hide/Show My Cosmetics` button.
- Dumps cosmetic data in your `LocalAppData` (texture, geometry) when opening the game. Useful for those looking to replicate the cosmetics in their own projects.

## Compatibility
Feel free to contribute to this table with a PR and a convincing screenshot. Only the major versions are tested as it takes time to do it manually.

| MC Major Version | Forge\*        | Fabric^            | Last Checked (dd/mm/yyyy) |
|------------------|--------------|--------------------|---------------------------|
| 1.8              | `✔️ works`^  | `⬛ not applicable` | 09/07/2023                |
| 1.12             | `✔️ works`^️ | `⬛ not applicable` | 12/06/2023                |
|                  |              |                    |                           |
| 1.16             | `✔️ works`   | `✔️ works`         | 12/06/2023                |
| 1.17             | `✔️ works`️  | `✔️ works`         | 12/06/2023                |
| 1.18             | `✔️ works`️  | `✔️ works`         | 03/02/2024                |
| 1.19             | `✔️ works`️  | `✔️ works`         | 12/06/2023                |
| 1.20             | `✔️ works`   | `✔️ works`         | 03/02/2024                |

Last Essential version checked: **v1.2.1.6**

### Notes
* Use the legacy release `-legacy.jar` which has no mod class, but has shaded mixin. This is necessary because functionality changes overtime.
^ The version of essential from [essential.gg](https://essential.gg/) does not work. Please use the [Modrinth](https://modrinth.com/mod/essential/versions?l=fabric) version instead.
 
## Disclaimer
This is for educational purposes only. I am not responsible for any damage caused by this tool.

## License
GPLv3 © dxxxxy
