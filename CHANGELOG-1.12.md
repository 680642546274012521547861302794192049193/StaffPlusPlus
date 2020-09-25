# Changelog Staff++ | v1.12

### V1.12.2
#### Features
- Report closing reason support
- Authme integration for supporting staff login
- Trace log feature added

### V1.12.1
#### Features
- New arguments system implemented
- Added strip argument. Example: `/freeze player -S`
- Allow reporting/warning offline users
- Locations implemented
- Added HEALTH argument
- New reporting system implemented
- Implement new reportEvents
- Added Discord Integration for reporting events
- Teleport command 
- Delay argument has been added
- Implemented automatic update for the config file 
- Add clear inventory bypass permission
- BungeeCord support. StaffChat will now be synced over all servers inside the bungee network.
- Update notifier implemented
- Warning discord integration

#### Breaking
- Dropped support for flatfiles
- Implemented Sqlite, Mysql databases
- Added new warning system

#### Bugs
- Resolved issue: https://github.com/garagepoort/StaffPlusPlus/issues/91
Items got removed when inspecting a chest. 