# EssentialCosmeticsUnlocker
**Client-side only** patch that allows you to unlock ALL the cosmetics in the Essential mod.

![](https://img.shields.io/badge/FORGE-ANY_VERSION-0?style=for-the-badge)
![](https://img.shields.io/badge/ESSENTIAL-ANY_VERSION-0?style=for-the-badge)
![](https://img.shields.io/github/downloads/DxxxxY/EssentialCosmeticsUnlocker/total?style=for-the-badge)

## How to use
Drag the .jar in your mods folder. Forge will still load it as a dependency.

## Features
- Unlocks ALL cosmetics (including developer). 
- Works with ANY version of Essential/Forge.
- Saves equipped cosmetics to config file `(%AppData%/.minecraft/ecu.txt)`.
- Loads equipped cosmetics from config file when you toggle the `Hide/Show My Cosmetics` button.
- Not a mod, injects and modifies a single class thanks to Mixin.

# Compatibility
Feel free to contribute to this table with a PR and a convincing screenshot.

| Essential MC Version | Forge          | Fabric*            | Last Checked |
|----------------------|----------------|--------------------|--------------|
| 1.8.9                | `✔️ works^`️   | `⬛ not applicable` |              |
| 1.12.2               | `✔️ works^`️   | `⬛ not applicable` |              |
| 1.16.5               | `✔️ works`     | `✔️ works`         | 25/03/2023   |
| 1.17.1               | `🚧 untested`️ | `🚧 untested`      |              |
| 1.18 - 1.18.2        | `🚧 untested`️ | `🚧 untested`      |              |
| 1.19 - 1.19.3        | `🚧 untested`️ | `🚧 untested`      |              |
| 1.19.4               | `✔️ works`     | `✔️ works`         | 25/03/2023   |

\* Fabric loads mods differently and requires you to place the hidden essential mod in your mods folder. The one that you usually place in your mods folder is the installer/updater. Instead, the one that you need to place in your mods folder is the big one (40+ mb) which is located in `.minecraft\essential\`.

^ Use the legacy release `.jar` which has no mod class, but has shaded mixin.
 
## Disclaimer
This is for educational purposes only. I am not responsible for any damage caused by this tool.

## License
GPLv3 © dxxxxy