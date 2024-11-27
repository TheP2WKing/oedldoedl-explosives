# Changelog

## [4.2.0] - 2024-11-27

### Added

- added extreme farming tnts
- added missing tns from explosives plus plus and crazy bombs
- added jer integration
- added ability to rotate rainbow and lol xd tnt
- added gunpowder block
- added top support for configurable tnt and tnts that are rotatable

### Changed

- updated creative tab implementation
- changed the over 9000 tnt texture to more match the 1.7 aesthetic
- changed fake tnt texture
- moved all remaining tnts from explosives plus plus and crazy bombs over to the new explosion system
- all tnts are now extending default explosions which make them compatible with ftb chunk claiming
- some tnts have been renamed to avoid conflicts with same name like meteor or flat tnt
- the tnt disrupter range limit has been removed (chunks need to be loaded)
- nc nuke now can be ignited by a flint and steel
- intended crashed now show a custom crash message
- now using render helper for living entities
- added proper meteor to the meteor tnt (look up)
- a lot of explosion sizes and their smoothness have been adjusted
- all tnts that previously just placed or replaced blocks in a radius now affect blocks like a proper explosion
- some recipes that should use shapeless recipes now use proper shapeless recipes with oredict support
- some recipes have been adjusted to accommodate new tnts and balance changes

### Fixed

- fixed some tnt that does not have a proper texture
- fixed server crash from arrow and egg tnt
- fixed server crash when affected blocks from explosions exceeded the max packet limit
- fixed server crash of dynamite entities that will stay on the ground before exploding

### Removed

- removed legacy classes
  
## [4.1.0] - 2024-06-09

### Added

- added giant TheP2WKing mob
- added over 10 new tnts with corresponding dynamite (inspired by TooMuchTNT) (e.g. 500x, easter egg, gravity groove, and true flat tnt)
- added a tnt disruptor that removes primed tnt and throws dynamite

### Changed

- overhauled the whole tnt system to properly use sound, damage, particles, and ensure that newly added tnts do not bypass FTB Utilities chunk claiming (remaining tnt will soon change to the new system)
- changed default spawn chance of thep2wking mob
- reduced health of thep2wking mob
- thep2wking tnt now summons a giant version instead of 4 small ones
- moved 5x and 20x tnt over to the new system and use TooMuchTNT texture instead
- tnts and dynamites are now able to be used inside a dispenser
- tnts should now be able to be lit by a bow with flame

## [4.0.0] - 2024-03-03

### 1.12.2 isn't dead, it just took some time

Also check out the other mods that have been updated or released!

### Initial Release

Welcome to a new member to the oedldoedl series. This mod is all about explosives, TNTs and dynamite. A lot of things are inspired by old tnt mods like TooMuchTNT, Explosives++ and Crazybombs. The mod is still new and may contain some bugs.

### Added

- added changelog
- added over 40 different tnts with different effects
- added 7 dynamites and 2 grenades
- added various crafting ingredients
- added tnt wrench
- added thep2wking as a mob
- custom explosions that bypass regular explosion effects can be disabled all together via config

### Changed

- changed license to MIT
- changed jar naming scheme
- updated shields.io badges
- updated curseforge and github page
- updated logo
- updated dependencies
