EVERYTHING BLEEDS ADDON
=======================

Minecraft: 1.20.4 Fabric
Goop: 1.20.x-0.3

This replaces the old Everything Bleeds resource-pack emitter with a tiny Goop API addon.
It registers a red damage emitter for every LivingEntity, including entities added by other mods.

The old resource pack is NOT required.

Build:
  ./gradlew build

Put the resulting JAR from build/libs/ into your mods folder.

The addon expects Goop to be installed. Oooze is optional; this addon does not depend on Oooze.
