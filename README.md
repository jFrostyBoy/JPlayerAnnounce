# 📢 JPlayerAnnounce

Simple plugin for player announcements: broadcast, buy/sale<br>
Customize sound and text for each announcement command

---

## 📝 Requirements

- **Server core**: Paper
- **Version**: 1.16.5 - 1.21.10
- **Java**: 16-21

---

## 📜 Commands

- **/broadcast [message] | /bc [message]**
    - **Description**: Send a broadcast message to all players
    - **Permission**: `jplayerannounce.broadcast`

- **/buy [message]**
    - **Description**: Send a buy announcement
    - **Permission**: `jlivestream.buy`

- **/sale [message]**
    - **Description**: Send a sale announcement
    - **Permission**: `jlivestream.sale`


- **/jpareload**
    - **Description**: Reload the plugin configuration
    - **Permission**: `jplayerannoune.reload`

---

## ⚙ Configuration

Full customization and operation of the plugin is configured in the configuration file (`config.yml`).

```yaml

#    ░░░░░██╗██████╗░██╗░░░░░░█████╗░██╗░░░██╗███████╗██████╗░░█████╗░███╗░░██╗███╗░░██╗░█████╗░██╗░░░██╗███╗░░██╗███████╗
#    ░░░░░██║██╔══██╗██║░░░░░██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔══██╗████╗░██║████╗░██║██╔══██╗██║░░░██║████╗░██║██╔════╝
#    ░░░░░██║██████╔╝██║░░░░░███████║░╚████╔╝░█████╗░░██████╔╝███████║██╔██╗██║██╔██╗██║██║░░██║██║░░░██║██╔██╗██║█████╗░░
#    ██╗░░██║██╔═══╝░██║░░░░░██╔══██║░░╚██╔╝░░██╔══╝░░██╔══██╗██╔══██║██║╚████║██║╚████║██║░░██║██║░░░██║██║╚████║██╔══╝░░
#    ╚█████╔╝██║░░░░░███████╗██║░░██║░░░██║░░░███████╗██║░░██║██║░░██║██║░╚███║██║░╚███║╚█████╔╝╚██████╔╝██║░╚███║███████╗
#    ░╚════╝░╚═╝░░░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝░╚════╝░░╚═════╝░╚═╝░░╚══╝╚══════╝

# Prefix for all messages
# Change or leave empty to disable the prefix
prefix: "&b[JPA] "

broadcast:
  # Usage message for the broadcast command
  usage: "&fUsage: &c/broadcast <message> &for &c/bc <message>"
  # Cooldown time in seconds
  cooldown: 300
  # Message displayed when a player is on cooldown
  cooldown-message: "&cYou must wait %cooldown% seconds before using this command again."
  # Sound to play when a broadcast is made
  sound:
    name: "ENTITY_PLAYER_LEVELUP"
    volume: 1.0
    pitch: 2.0
  # Message format for broadcasts
  format:
    - " "
    - "  &b[Broadcast] &fby &b%player%"
    - "  &fHe said: &b%message%"
    - " "

buy:
  # Usage message for the buy command
  usage: "&fUsage: &c/buy <message>"
  # Cooldown time in seconds
  cooldown: 180
  # Message displayed when a player is on cooldown
  cooldown-message: "&cYou must wait %cooldown% seconds before using this command again."
  # Sound to play when a buy announcement is made
  sound:
    name: "ENTITY_VILLAGER_YES"
    volume: 1.0
    pitch: 1.0
  # Message format for buy announcements
  format:
      - " "
      - "  &a[Buy Announcement] &fby &a%player%"
      - "  &fHe said: &a%message%"
      - " "

sale:
  # Usage message for the sale command
  usage: "&fUsage: &c/sale <message>"
  # Cooldown time in seconds
  cooldown: 60
  # Message displayed when a player is on cooldown
  cooldown-message: "&cYou must wait %cooldown% seconds before using this command again."
  # Sound to play when a sale announcement is made
  sound:
    name: "BLOCK_ANVIL_PLACE"
    volume: 1.0
    pitch: 2.0
  # Message format for sale announcements
  format:
    - " "
    - "  &e[Sale Announcement] &fby &e%player%"
    - "  &fHe said: &e%message%"
    - " "

# The basic messages for the plugin
messages:
  only-players: "&cThis command can only be executed by players."
  no-permission: "&cYou do not have permission to execute this command."
  reload: "&aConfiguration reloaded successfully."
  ```

<img width="1002" height="559" alt="image" src="https://github.com/user-attachments/assets/85b398ac-3fe7-424d-a625-35fa5b9f1a25" />
